package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrobruno.plant_manager.R
import com.pedrobruno.plant_manager.databinding.FragmentListPlantsBinding
import com.pedrobruno.plant_manager.presentation.viewmodel.ListPlantsViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ListPlantsFragment : Fragment() {

    private var _binding: FragmentListPlantsBinding? = null
    private val binding: FragmentListPlantsBinding get() = _binding!!
    private val listPlantsViewModel: ListPlantsViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListPlantsBinding.inflate(layoutInflater, container, false).apply {
        _binding = this
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        listPlantsViewModel.user.observe(viewLifecycleOwner, { username ->
            binding.textViewName.text = username
        })
    }

}