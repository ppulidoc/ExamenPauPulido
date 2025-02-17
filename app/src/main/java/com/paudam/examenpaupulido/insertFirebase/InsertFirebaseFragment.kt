package com.paudam.examenpaupulido.insertFirebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.paudam.examenpaupulido.databinding.FragmentInsertFirebaseBinding
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.paudam.examenpaupulido.R

class InsertFirebaseFragment : Fragment() {
    private lateinit var binding: FragmentInsertFirebaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert_firebase, container, false
        )

        binding.buttonInsert.setOnClickListener() {
            if (binding.editTextEmail.text.isNotEmpty() && binding.editTextPasswd.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPasswd.text.toString()
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showMssg("Ha funcionado")
                    } else {
                        // Si ocurre un error, mostrar un mensaje
                        showAlert("Error al registrar el usuario")
                    }
                }
            } else {
                showAlert("Por favor, ingresa un correo y una contraseña válidos")
            }
        }

        binding.buttonLogin.setOnClickListener(){
            findNavController().navigate(R.id.action_insertFirebaseFragment_to_loginFragment)
        }

        return binding.root


    }



    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showMssg(message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("mensaje succesfullll")
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
