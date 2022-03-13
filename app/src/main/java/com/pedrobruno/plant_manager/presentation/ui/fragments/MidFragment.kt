package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.pedrobruno.plant_manager.R
import com.pedrobruno.plant_manager.databinding.FragmentMidBinding

class MidFragment : Fragment() {

    private var _binding: FragmentMidBinding? = null
    private val binding: FragmentMidBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMidBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonStart.setOnClickListener {
            findNavController().navigate(
                MidFragmentDirections.actionMidFragmentToListPlantsFragment()
            )
        }
    }

}