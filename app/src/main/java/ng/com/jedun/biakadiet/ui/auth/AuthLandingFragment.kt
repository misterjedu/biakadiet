package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentAuthLandingBinding
import ng.com.jedun.biakadiet.util.SpannableHelper
import ng.com.jedun.biakadiet.util.customNavAnimation


class AuthLandingFragment : Fragment() {

    private var _binding: FragmentAuthLandingBinding? = null
    private val binding get() = _binding!!
    private lateinit var alreadyHaveAnAccountTextView: TextView
    private lateinit var signUpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAuthLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        alreadyHaveAnAccountTextView = binding.frAuthLandingAlreadyHaveAccountTv
        signUpButton = binding.frAuthLandingSignUpWithEmailButton


        SpannableHelper.spannable(
            alreadyHaveAnAccountTextView,
            25,
            alreadyHaveAnAccountTextView.text.length,
            resources.getColor(R.color.color_primary),
            false
        ) { openSignUpFragment() }


        signUpButton.setOnClickListener {
            findNavController().navigate(
                R.id.signUpFragment,
                null,
                customNavAnimation().build()
            )
        }
    }

    private fun openSignUpFragment() {
        findNavController().navigate(
            R.id.signInFragment,
            null,
            customNavAnimation().build()
        )
    }

    override fun onStop() {
        super.onStop()
        requireActivity().actionBar?.show()
    }

}