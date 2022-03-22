package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pedrobruno.plant_manager.R
import com.pedrobruno.plant_manager.databinding.FragmentIntroductionBinding
import com.pedrobruno.plant_manager.presentation.viewmodel.IntroductionViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class IntroductionFragment : Fragment() {

    private var _binding: FragmentIntroductionBinding? = null
    private val binding: FragmentIntroductionBinding get() = _binding!!
    private val introductionViewModel: IntroductionViewModel by lazy {
        getViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentIntroductionBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        setupListenres()
    }

    private fun setupListenres() {
        binding.editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                input: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (input.isNullOrBlank() || input.isNullOrEmpty()) {
                    binding.apply {
                        buttonConfirm.isEnabled = false
                        imageViewIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_introduction_no_text))
                    }
                } else {
                    binding.apply {
                        buttonConfirm.isEnabled = true
                        imageViewIcon.setImageDrawable(resources.getDrawable(R.drawable.ic_introduction_text))
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.buttonConfirm.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser() {
        introductionViewModel.saveUser(
            binding.editTextName.text.toString()
        )
    }

    private fun observeData() {
        introductionViewModel.user.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(context, "Salvo com sucesso", Toast.LENGTH_LONG).show()
//                findNavController().navigate(
//                    IntroductionFragmentDirections.actionIntroductionFragmentToMidFragment()
//                )
            } else {
                Toast.makeText(context, "Houve algum problema", Toast.LENGTH_LONG).show()
            }
        }
    }

}