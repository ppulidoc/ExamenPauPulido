package com.paudam.examenpaupulido.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentInsertBinding

class InsertFragment : Fragment() {
    private lateinit var binding: FragmentInsertBinding
    private lateinit var insertFragmentVM: InsertFragmentVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert, container, false
        )
        insertFragmentVM = ViewModelProvider(this).get(InsertFragmentVM::class.java)


        binding.buttonInsert.setOnClickListener{

            var nom = binding.editTextNom.text.toString()
            var preu = binding.editTextPreu.text.toString().toIntOrNull()

            if (nom != null) {
                if (preu != null) {
                    insertFragmentVM.nouProducte(requireContext(),nom,preu)
                }
            }
            findNavController().navigate(R.id.action_insertFragment_to_homeFragment)




        }



        return binding.root
    }

}