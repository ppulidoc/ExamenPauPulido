package com.paudam.examenpaupulido.updateidelete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paudam.examenpaupulido.R
import com.paudam.examenpaupulido.databinding.FragmentUpdateDeleteBinding


class updateDeleteFragment : Fragment() {

    private lateinit var binding: FragmentUpdateDeleteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_delete, container, false)
    }

}