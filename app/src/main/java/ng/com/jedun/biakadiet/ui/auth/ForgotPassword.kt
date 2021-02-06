package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import ng.com.jedun.biakadiet.databinding.FragmentForgotPasswordBinding
import ng.com.jedun.biakadiet.util.*

class ForgotPassword : Fragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    private lateinit var emailTil: TextInputLayout
    private lateinit var emailEt: EditText
    private lateinit var resendPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEt = binding.emailEt
        emailTil = binding.emailTil
        resendPasswordButton = binding.resendPasswordButton



        validateFields()

    }

    private fun validateFields() {

        val fields: MutableList<JDataClass> = mutableListOf(
            JDataClass(
                editText = emailEt,
                editTextInputLayout = emailTil,
                errorMessage = JDErrorConstants.INVALID_EMAIL_ERROR,
                validator = { it.jdValidateEmail(it.text.toString()) }
            )
        )

        JDFormValidator.Builder()
            .addFieldsToValidate(fields)
            .removeErrorIcon(true)
            .viewsToEnable(mutableListOf(resendPasswordButton))
            .watchWhileTyping(true)
            .build()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}