package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentAuthLandingBinding
import ng.com.jedun.biakadiet.util.DataUtil
import ng.com.jedun.biakadiet.util.ZoomOutPageTransformer
import ng.com.jedun.biakadiet.util.autoScroll
import ng.com.jedun.biakadiet.util.customFragmentAnimation

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
                customFragmentAnimation().build()
            )
        }

        binding.signInTv.setOnClickListener {
            findNavController().navigate(
                R.id.signInFragment,
                null,
                customFragmentAnimation().build()
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewPagerData: Pair<List<Int>, List<String>> =
            Pair(DataUtil.onBoardingImages(), DataUtil.onBoardingDescriptions(this))

        val adapter = AuthViewPagerAdapter(viewPagerData)

        viewPager = binding.fragmentOnboardingVp

        viewPager.adapter = adapter

        viewPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(binding.intoTabLayout, binding.fragmentOnboardingVp)
        { tab, position -> }.attach()

        binding.fragmentOnboardingVp.autoScroll(3000)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}