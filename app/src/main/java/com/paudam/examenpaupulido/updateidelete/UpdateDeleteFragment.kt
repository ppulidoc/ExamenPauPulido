package com.paudam.examenpaupulido.updateidelete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentUpdateDeleteBinding
import com.paudam.examenpaupulido.home.ProductesAdapter


class updateDeleteFragment : Fragment() {

    private lateinit var binding: FragmentUpdateDeleteBinding
    private lateinit var UpdateideleteVM: updateideleteVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update_delete, container, false
        )
        UpdateideleteVM = ViewModelProvider(this).get(updateideleteVM::class.java)


        binding.buttonDelete.setOnClickListener{
            val nom = binding.editTextNom.text.toString()
            val preu = binding.editTextPreu.text.toString().toIntOrNull()

            if (preu != null) {
                UpdateideleteVM.deleteProducte(requireContext(),nom,preu)
            }

            findNavController().navigate(R.id.action_updateDeleteFragment_to_homeFragment)


        }


        return binding.root
    }

}