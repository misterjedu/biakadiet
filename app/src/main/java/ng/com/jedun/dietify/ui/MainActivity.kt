package ng.com.jedun.dietify.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import ng.com.jedun.dietify.databinding.ActivityMainBinding
import ng.com.jedun.dietify.request.ServiceGenerator
import ng.com.jedun.dietify.viewmodels.PostViewModel


class MainActivity : BaseActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)

        binding.button.setOnClickListener {
            queryPostApi()
        }

        subscribeObservers()
 
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