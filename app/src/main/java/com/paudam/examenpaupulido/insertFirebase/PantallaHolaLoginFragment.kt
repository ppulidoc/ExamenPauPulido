package com.paudam.examenpaupulido.insertFirebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.adapter.UserAdapter
import com.paudam.examenpaupulido.databinding.FragmentPantallaHolaLoginBinding
import com.paudam.examenpaupulido.model.User

class PantallaHolaLoginFragment : Fragment() {
    private lateinit var binding: FragmentPantallaHolaLoginBinding
    private lateinit var db: FirebaseFirestore
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

        // Inicializar Firestore
        db = FirebaseFirestore.getInstance()

        // Configurar RecyclerView
        userAdapter = UserAdapter(userList)
        binding.recyclerViewUsers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }

        binding.button.setOnClickListener(){
            obtenerUsuarios()
        }


        return binding.root
    }

    private fun obtenerUsuarios() {
        db.collection("Users")
            .get()
            .addOnSuccessListener { documents ->
                val tempList = mutableListOf<User>()
                for (document in documents) {
                    val user = document.toObject(User::class.java)
                    tempList.add(user)
                }
                userAdapter.updateList(tempList)
            }
            .addOnFailureListener { e ->
                Log.e("Firebase", "Error obteniendo lista de usuarios", e)
            }
    }
}
