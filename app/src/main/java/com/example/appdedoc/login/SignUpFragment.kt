package com.example.appdedoc.login

import android.os.Bundle
import android.text.BoringLayout
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appdedoc.R
import com.example.appdedoc.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var _mBinding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mBinding = FragmentSignUpBinding.inflate(inflater)
        return _mBinding.root
    }

    private fun setupSingUpButton(){
        _mBinding.signUpButton.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val email = _mBinding.emailEdit.text.toString()
        if(!isValidEmail(email)){
            _mBinding.emailInput.error = getString(R.string.invalid_email_error)
            return
        }
        val password = _mBinding.passwordEdit.text.toString()
        if(password.isEmpty()){
            _mBinding.passwordInput.error = getString(R.string.null_password_error)
            return
        }
        
    }

    private fun isValidEmail(email: String): Boolean{
        return !email.isNullOrEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}