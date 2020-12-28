package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentSignInBinding
import ng.com.jedun.biakadiet.util.SpannableHelper


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var termsAndPolicy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        termsAndPolicy = binding.frSignInTermsAndPrivacyTv

        SpannableHelper.spannable(
            termsAndPolicy,
            16,
            termsAndPolicy.text.length,
            resources.getColor(R.color.color_primary),
            false
        ) {
            run {
                Toast.makeText(requireActivity(), "Hello", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}