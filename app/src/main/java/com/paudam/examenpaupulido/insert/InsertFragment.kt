package com.paudam.examenpaupulido.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentInsertBinding

class InsertFragment : Fragment() {
    private lateinit var binding: FragmentInsertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert, container, false
        )


        return binding.root
    }

}