package com.paudam.examenpaupulido.insertFirebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentDetalleUsuarioBinding

class DetalleUsuarioFragment : Fragment() {
    private lateinit var binding: FragmentDetalleUsuarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detalle_usuario, container, false
        )

        // Obtener los datos del Bundle
        val nombre = arguments?.getString("nombre")
        val correo = arguments?.getString("correo")
        val edad = arguments?.getInt("edad")

        // Mostrar los datos en los TextViews
        binding.textViewNombre.text = nombre
        binding.textViewCorreo.text = correo
        binding.textViewEdad.text = edad.toString()

        return binding.root
    }
}
