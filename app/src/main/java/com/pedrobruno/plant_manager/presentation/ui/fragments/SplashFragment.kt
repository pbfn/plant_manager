package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.pedrobruno.plant_manager.databinding.FragmentSplashBinding
import com.pedrobruno.plant_manager.presentation.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding get() = _binding!!
    private val splashViewModel: SplashViewModel by lazy {
        getViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSplashBinding.inflate(inflater, container, false).apply {
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

    private fun nextPage(directions: NavDirections) {
        val splashScreenTimeOut = 2000L
        Handler().postDelayed({
            findNavController().navigate(
                directions
            )
        }, splashScreenTimeOut)
    }


    private fun observeData() {
        splashViewModel.user.observe(viewLifecycleOwner, { user ->
            nextPage(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
//            if (user.equals("") || user.isNullOrEmpty()) {
//                nextPage(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
//            } else {
//                nextPage(SplashFragmentDirections.actionSplashFragmentToListPlantsFragment())
//            }
        })
    }

}