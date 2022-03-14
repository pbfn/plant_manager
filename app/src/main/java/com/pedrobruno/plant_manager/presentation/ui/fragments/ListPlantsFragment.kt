package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedrobruno.plant_manager.databinding.FragmentListPlantsBinding
import com.pedrobruno.plant_manager.presentation.adapters.AdapterEnvironment
import com.pedrobruno.plant_manager.presentation.adapters.AdapterPlants
import com.pedrobruno.plant_manager.presentation.viewmodel.ListPlantsViewModel
import com.pedrobruno.plant_manager.util.mocks.Environments
import com.pedrobruno.plant_manager.util.mocks.Plants
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ListPlantsFragment : Fragment() {

    private var _binding: FragmentListPlantsBinding? = null
    private val binding: FragmentListPlantsBinding get() = _binding!!
    private val listPlantsViewModel: ListPlantsViewModel by lazy {
        getViewModel()
    }

    private lateinit var adapterEnvironment: AdapterEnvironment
    private lateinit var adapterPlants: AdapterPlants

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
        setupRecyclerViewEnvironment()
        initListEnvironment()
        setupRecyclerViewPlants()
        initListPlant()
    }

    private fun observeData() {
        listPlantsViewModel.user.observe(viewLifecycleOwner, { username ->
            binding.textViewName.text = username
        })
    }

    private fun setupRecyclerViewEnvironment() {
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapterEnvironment = AdapterEnvironment()
        binding.recyclerViewEnvironments.apply {
            adapter = adapterEnvironment
            layoutManager = layout
        }
    }

    private fun setupRecyclerViewPlants() {
        val layout = GridLayoutManager(requireContext(), 2)
        adapterPlants = AdapterPlants()
        binding.recyclerViewPlants.apply {
            adapter = adapterPlants
            layoutManager = layout
        }
    }

    private fun initListEnvironment() {
        adapterEnvironment.differ.submitList(Environments.listEnvironments)
    }

    private fun initListPlant() {
        adapterPlants.differ.submitList(Plants.listPlants)
    }

}