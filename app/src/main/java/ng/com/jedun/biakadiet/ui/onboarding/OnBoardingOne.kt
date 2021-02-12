package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ng.com.jedun.biakadiet.databinding.FragmentOnboardingOneBinding
import ng.com.jedun.biakadiet.ui.BaseFragment


class OnBoardingOne : BaseFragment() {

    private var _binding: FragmentOnboardingOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnboardingOneBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}