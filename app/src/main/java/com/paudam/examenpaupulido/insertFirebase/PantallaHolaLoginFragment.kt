package com.paudam.examenpaupulido.insertFirebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.adapter.UserAdapter
import androidx.navigation.fragment.findNavController
import com.paudam.examenpaupulido.databinding.FragmentPantallaHolaLoginBinding
import com.paudam.examenpaupulido.model.User

class PantallaHolaLoginFragment : Fragment() {
    private lateinit var binding: FragmentPantallaHolaLoginBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var userAdapter: UserAdapter
    private var userList = mutableListOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pantalla_hola_login, container, false
        )

        // Inicializar Firebase Auth y Firestore
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Configurar RecyclerView
        userAdapter = UserAdapter(userList) { user ->
            // Clic en un item: pasar los datos del usuario al siguiente fragmento
            mostrarDetalleUsuario(user)
        }
        binding.recyclerViewUsers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        // Obtener usuarios de Firestore
        binding.button.setOnClickListener {
            obtenerUsuarios()
        }

        // Actualizar la edad del usuario autenticado
        binding.buttonActualizarEdad.setOnClickListener {
            actualizarEdadUsuario()
        }

        return binding.root
    }

    private fun obtenerUsuarios() {
        db.collection("Users")
            .get()
            .addOnSuccessListener { documents ->
                userList.clear()
                for (document in documents) {
                    val user = document.toObject(User::class.java)
                    userList.add(user)
                }
                userAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Error obteniendo lista de usuarios", e)
            }
    }

    private fun actualizarEdadUsuario() {
        val user = auth.currentUser

        if (user == null) {
            Toast.makeText(requireContext(), "No hay usuario autenticado", Toast.LENGTH_SHORT).show()
            Log.e("Firebase", "Usuario no autenticado")
            return
        }

        val nuevaEdadTexto = binding.editTextEdad.text.toString().trim()
        val nuevaEdad = nuevaEdadTexto.toIntOrNull()

        if (nuevaEdad == null) {
            Toast.makeText(requireContext(), "Ingrese una edad válida", Toast.LENGTH_SHORT).show()
            Log.e("Firebase", "Edad inválida ingresada")
            return
        }

        val userRef = db.collection("Users").document(user.uid)

        val updatedData = hashMapOf("edad" to nuevaEdad)

        userRef.set(updatedData, SetOptions.merge())
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Edad actualizada en Firestore", Toast.LENGTH_SHORT).show()
                Log.d("Firebase", "Edad actualizada correctamente para UID: ${user.uid}")

                // Obtener la lista de usuarios nuevamente después de actualizar
                obtenerUsuarios()
            }
            .addOnFailureListener { e ->
                Toast.makeText(requireContext(), "Error al actualizar en Firestore", Toast.LENGTH_SHORT).show()
                Log.e("Firebase", "Error al actualizar edad", e)
            }
    }

    private fun mostrarDetalleUsuario(user: User) {
        // Crear el bundle correctamente
        val bundle = Bundle().apply {
            putString("nombre", user.name)
            putString("correo", user.email)
            putInt("edad", user.age ?: 0)  // Asigna un valor predeterminado para edad si es null
        }

        // Navegar usando el bundle
        findNavController().navigate(R.id.action_pantallaHolaLoginFragment_to_detalleUsuarioFragment, bundle)
    }

}
