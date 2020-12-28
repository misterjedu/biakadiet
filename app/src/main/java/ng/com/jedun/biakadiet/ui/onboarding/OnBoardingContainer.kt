package ng.com.jedun.biakadiet.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ng.com.jedun.biakadiet.adapters.ViewPagerAdapter
import ng.com.jedun.biakadiet.databinding.FragmentOnboardingContainerBinding
import ng.com.jedun.biakadiet.ui.auth.AuthActivity
import ng.com.jedun.biakadiet.util.ZoomOutPageTransformer

class OnBoardingContainer : Fragment() {

    private var _binding: FragmentOnboardingContainerBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var nextButton: Button
    private lateinit var skip: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingContainerBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager = binding.fragmentOnboardingVp
        viewPager.setPageTransformer(ZoomOutPageTransformer())
        tabLayout = binding.fragmentOnboardingTl
        nextButton = binding.fragmentOnBoardingContainerNextButton
        skip = binding.fragmentOnBoardingContainerSkipButton

        val fragmentList: ArrayList<Fragment> = arrayListOf(
            OnBoardingScreenOne(),
            OnBoardingScreenTwo(),
            OnBoardingScreenThree()
        )

        val adapter = activity?.supportFragmentManager?.let {
            ViewPagerAdapter(
                fragmentList,
                it,
                lifecycle
            )
        }

        binding.fragmentOnboardingVp.adapter = adapter

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tabLayout, viewPager ->
        }.attach()


        skip.setOnClickListener {
            val intent = Intent(requireActivity(), AuthActivity::class.java)
            startActivity(
                intent
            )
        }

        nextButton.setOnClickListener {
            var viewPagerCurrentPosition: Int = viewPager.currentItem
            if (viewPagerCurrentPosition < 2) {
                viewPagerCurrentPosition++
                viewPager.currentItem = viewPagerCurrentPosition
            } else {
                val intent = Intent(requireActivity(), AuthActivity::class.java)
                startActivity(
                    intent
                )
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}