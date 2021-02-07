package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.ActivityOnbaordingBinding
import ng.com.jedun.biakadiet.databinding.AuthActivityBinding
import ng.com.jedun.biakadiet.ui.BaseActivity

class OnBoardingActivity : BaseActivity() {

    private lateinit var binding: ActivityOnbaordingBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnbaordingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.activity_auth_nav_fragment)

        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        setSupportActionBar(binding.onBoardingToolbar)

        NavigationUI.setupWithNavController(
            binding.onBoardingToolbar,
            navController,
            appBarConfiguration
        )


    }
}