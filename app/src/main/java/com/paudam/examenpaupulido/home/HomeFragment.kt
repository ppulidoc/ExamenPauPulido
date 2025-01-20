package com.paudam.examenpaupulido.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeFragmentVM: HomeFragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )


        homeFragmentVM = ViewModelProvider(this).get(HomeFragmentVM::class.java)
        homeFragmentVM.llistar_productes(requireContext())

        binding.recyclerViewProductes.layoutManager = LinearLayoutManager(requireContext())

        homeFragmentVM.llistat_productes?.observe(viewLifecycleOwner, Observer {productesLlistat ->
            binding.recyclerViewProductes.adapter = ProductesAdapter(productesLlistat)
        })

        binding.buttonInsert.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_insertFragment)
        }


        return binding.root
    }

}