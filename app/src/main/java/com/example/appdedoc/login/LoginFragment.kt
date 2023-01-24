package com.example.appdedoc.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appdedoc.databinding.FragmentLoginBinding
import kotlin.ClassCastException

class LoginFragment : Fragment() {

    private lateinit var _mBinding: FragmentLoginBinding
    /**Utilizamos una interface para indicar que cuando de cliclk en el activity navege al sing up fragment**/
    interface LoginFragmentActions{
        fun onRegisterButtonClick()
    }

    private lateinit var loginFragmentAction: LoginFragmentActions

    /**Lo que hace es cuando el fragment se une al activity, el activity le pasa un contexto al fragment y
     * ese contexto lo podemos utilizar como si fuera la interface que creamos en el frgament, de tal manera qque en cualquier
     * punto l app podemos llamar al objeto loginFragemntAtions y llamr los metodos de la interface **/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginFragmentAction = try{
            context as LoginFragmentActions
        }catch(e: ClassCastException){
            throw ClassCastException("$context debes iplementar la interface LoginFragmentActions")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _mBinding = FragmentLoginBinding.inflate(inflater)
        _mBinding.loginRegisterButton.setOnClickListener {
            loginFragmentAction.onRegisterButtonClick()
        }
        return _mBinding.root
    }

}