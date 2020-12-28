package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
//            findNavController().navigate(R.id.signInFragment, null, customNavAnimation().build())
            findNavController().navigate(R.id.signInFragment, )
        }
    }

    private fun openSignUpFragment() {
        Toast.makeText(requireActivity(), "Next fragment opens", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}