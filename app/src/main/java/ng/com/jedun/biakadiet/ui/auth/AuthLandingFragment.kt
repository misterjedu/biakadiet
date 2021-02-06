package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentAuthLandingBinding
import ng.com.jedun.biakadiet.util.ZoomOutPageTransformer
import ng.com.jedun.biakadiet.util.customNavAnimation

class AuthLandingFragment : Fragment() {

    private var _binding: FragmentAuthLandingBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthLandingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getStarted.setOnClickListener {
            findNavController().navigate(
                R.id.signUpFragment,
                null,
                customNavAnimation().build()
            )
        }


        binding.signInTv.setOnClickListener {
            findNavController().navigate(
                R.id.signInFragment,
                null,
                customNavAnimation().build()
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager = binding.fragmentOnboardingVp
        viewPager.setPageTransformer(ZoomOutPageTransformer())

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}