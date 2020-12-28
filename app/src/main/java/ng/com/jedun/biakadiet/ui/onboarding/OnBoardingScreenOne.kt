package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentOnBoardingScreenOneBinding
import ng.com.jedun.biakadiet.util.SpannableHelper

class OnBoardingScreenOne : Fragment() {

    private var _binding: FragmentOnBoardingScreenOneBinding? = null
    private val binding get() = _binding!!
    private lateinit var welcomeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoardingScreenOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        welcomeTextView = binding.fragmentOnboardingScreenOneWelcomeTv


        SpannableHelper.spannable(
            welcomeTextView,
            11,
            welcomeTextView.text.length,
            resources.getColor(R.color.color_primary)
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}