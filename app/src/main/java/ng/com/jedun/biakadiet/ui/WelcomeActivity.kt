package ng.com.jedun.biakadiet.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import ng.com.jedun.biakadiet.viewmodels.PostViewModel
import ng.com.jedun.biakadiet.databinding.ActivityWelcomeBinding
import ng.com.jedun.biakadiet.util.makeToast


class WelcomeActivity : BaseActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var binding: ActivityWelcomeBinding

    private var mode = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)

//        binding.button.setOnClickListener {
////            AppCompatDelegate.MODE_NIGHT_NO
////            AppCompatDelegate.MODE_NIGHT_YES
////            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
//
//            if (mode == 0) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//                mode = 1
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//                mode = 0
//            }
////            queryPostApi()
//        }

//        subscribeObservers()
    }


    private fun toast() {
        makeToast("Hello")
    }

    private fun subscribeObservers() {
        postViewModel.getPostList.observe(this, { posts ->
            if (posts != null) {
                for (post in posts) {
                    Log.i("Post List", post.body!!)
                }
            }
        })
    }

    private fun queryPostApi() {
        postViewModel.queryPostApi()
    }

}