package ng.com.jedun.biakadiet

import android.content.Intent
import android.os.Bundle
import kotlinx.coroutines.*
import ng.com.jedun.biakadiet.databinding.ActivityStartBinding
import ng.com.jedun.biakadiet.ui.BaseActivity
import ng.com.jedun.biakadiet.ui.WelcomeActivity

class StartActivity : BaseActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000L)
            withContext(Dispatchers.Main) {
                val intent = Intent(this@StartActivity, WelcomeActivity::class.java)
                startActivity(
                    intent
                )
            }

            finish()
        }
    }
}