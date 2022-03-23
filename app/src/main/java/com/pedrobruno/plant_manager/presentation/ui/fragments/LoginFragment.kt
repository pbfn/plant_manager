package com.pedrobruno.plant_manager.presentation.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.pedrobruno.plant_manager.R
import com.pedrobruno.plant_manager.databinding.FragmentLoginBinding
import com.pedrobruno.plant_manager.presentation.viewmodel.AuthGoogleViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private val authGoogleViewModel: AuthGoogleViewModel by lazy {
        getViewModel()
    }


    private lateinit var googleSingInClient: GoogleSignInClient

    private companion object {
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false).apply {
        _binding = this
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGoogleSignInClient()
        observeData()
        setupListeners()
    }

    private fun setupListeners() {
        binding.apply {
            buttonGoogleLogin.setOnClickListener {
                signIn()
            }

            buttonLogin.setOnClickListener {
                nextPage(LoginFragmentDirections.actionLoginFragmentToIntroductionFragment())
            }

        }
    }

    private fun initGoogleSignInClient() {
        val googleSignInOptions = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSingInClient = GoogleSignIn.getClient(requireActivity(), googleSignInOptions)
        checkUser()
    }

    private fun checkUser() {
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            nextPage(LoginFragmentDirections.actionLoginFragmentToListPlantsFragment())
        }
    }

    private fun signIn() {
        val signInIntent = googleSingInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = accountTask.getResult(ApiException::class.java)
                getGoogleAuthCredential(account)
            } catch (e: Exception) {
                Log.d(TAG, "onActivityResult:${e.message}")
            }
        }

    }

    private fun getGoogleAuthCredential(account: GoogleSignInAccount) {
        val googleTokenId = account.idToken
        val googleAuthCredential = GoogleAuthProvider.getCredential(googleTokenId, null)
        signInWithGoogleAuthCredential(googleAuthCredential)
    }

    private fun signInWithGoogleAuthCredential(googleAuthCredential: AuthCredential) {
        authGoogleViewModel.loginWithGoogle(googleAuthCredential)
    }

    private fun observeData() {
        authGoogleViewModel.user.observe(viewLifecycleOwner) { user->
            Toast.makeText(context, "Bem vindo ${user.name}", Toast.LENGTH_LONG).show()
            if(user.isNewUser){
                nextPage(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }else{
                nextPage(LoginFragmentDirections.actionLoginFragmentToListPlantsFragment())
            }
        }
    }

    private fun nextPage(directions: NavDirections) {
        findNavController().navigate(directions)
    }

}