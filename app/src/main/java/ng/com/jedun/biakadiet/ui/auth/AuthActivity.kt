package ng.com.jedun.biakadiet.ui.auth

import android.os.Bundle
import ng.com.jedun.biakadiet.databinding.AuthActivityBinding
import ng.com.jedun.biakadiet.ui.BaseActivity


class AuthActivity : BaseActivity() {
    private lateinit var binding: AuthActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AuthActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}