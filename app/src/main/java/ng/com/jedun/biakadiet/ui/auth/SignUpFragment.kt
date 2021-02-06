package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentSignUpBinding
import ng.com.jedun.biakadiet.util.*


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var registerButton: Button
    private lateinit var termsAndPrivacy: TextView
    private lateinit var emailEt: EditText
    private lateinit var emailTil: TextInputLayout
    private lateinit var passWordTil: TextInputLayout
    private lateinit var passwordEt: EditText
    private lateinit var reTypePasswordTIl: TextInputLayout
    private lateinit var reTypePasswordEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        registerButton = binding.registerButton
        termsAndPrivacy = binding.termsAndPrivaccy
        emailEt = binding.emailEt
        passwordEt = binding.passwordEt
        reTypePasswordEt = binding.retypePasswordEt
        emailTil = binding.emailTil
        passWordTil = binding.passwordTil
        reTypePasswordTIl = binding.retypePasswordTil

        SpannableHelper.spannable(
            termsAndPrivacy,
            16,
            termsAndPrivacy.text.length,
            resources.getColor(R.color.color_primary),
            false
        ) {
            run {
                requireActivity().makeToast("Hello from Sign Up Fragment")
            }
        }

        validateFields()

    }


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
            ),
            JDataClass(
                editText = reTypePasswordEt,
                editTextInputLayout = reTypePasswordTIl,
                errorMessage = JDErrorConstants.PASSWORD_DOES_NOT_MATCH,
                validator = { it.jdValidateConfirmPassword(passwordEt, reTypePasswordEt) }
            )
        )

        JDFormValidator.Builder()
            .addFieldsToValidate(fields)
            .removeErrorIcon(true)
            .viewsToEnable(mutableListOf(registerButton))
            .watchWhileTyping(true)
            .build()
    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}