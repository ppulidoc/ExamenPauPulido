package com.paudam.examenpaupulido.insertFirebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentInsertFirebaseBinding
import com.paudam.examenpaupulido.databinding.FragmentPantallaHolaLoginBinding

class PantallaHolaLoginFragment : Fragment() {
    private lateinit var binding: FragmentPantallaHolaLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pantalla_hola_login, container, false
        )

        return  binding.root
}
}