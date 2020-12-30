package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentSignInBinding
import ng.com.jedun.biakadiet.util.*


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var forgotPassword: TextView
    private lateinit var emailTil: TextInputLayout
    private lateinit var emailEt: EditText
    private lateinit var passWordTil: TextInputLayout
    private lateinit var passwordEt: EditText
    private lateinit var signInButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        forgotPassword = binding.frSignInForgotPasswordTv
        emailEt = binding.frSignInEmailEt
        passwordEt = binding.frSignInPasswordEt
        emailTil = binding.frSignInEmailTil
        passWordTil = binding.frSignInPasswordTil
        signInButton = binding.frSignInSignInButton

        SpannableHelper.spannable(
            forgotPassword,
            22,
            forgotPassword.text.length,
            resources.getColor(R.color.color_primary),
            false
        ) { sayHello() }

        validateFields()
    }

    private fun sayHello() {
        Toast.makeText(requireActivity(), "Hello", Toast.LENGTH_SHORT).show()
    }

    /** Validate form fields **/
    private fun validateFields() {

        val fields: MutableList<JDataClass> = mutableListOf(
            JDataClass(
                editText = emailEt,
                editTextInputLayout = emailTil,
                errorMessage = JDErrorConstants.INVALID_EMAIL_ERROR,
                validator = { it.jdValidateEmail(it.text.toString()) }
            ),
            JDataClass(
                editText = passwordEt,
                editTextInputLayout = passWordTil,
                errorMessage = JDErrorConstants.INVALID_PASSWORD_ERROR,
                validator = { it.jdValidatePassword(it.text.toString()) }
            )
        )

        JDFormValidator.Builder()
            .addFieldsToValidate(fields)
            .removeErrorIcon(true)
            .viewsToEnable(mutableListOf(signInButton))
            .watchWhileTyping(true)
            .build()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}