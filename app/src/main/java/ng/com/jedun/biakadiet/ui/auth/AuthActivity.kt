package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.AuthActivityBinding


class AuthActivity : AppCompatActivity() {
    private lateinit var binding: AuthActivityBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AuthActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.activity_auth_nav_fragment)

        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        setSupportActionBar(binding.toolbar)

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)


    }
}