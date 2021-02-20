package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentOnBoardingThreeBinding
import ng.com.jedun.biakadiet.databinding.FragmentOnboardingOneBinding


class OnBoardingThree : Fragment() {

    private var _binding: FragmentOnBoardingThreeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnBoardingThreeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}