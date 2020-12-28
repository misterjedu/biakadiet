package ng.com.jedun.biakadiet.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ng.com.jedun.biakadiet.repository.PostRepository
import ng.com.jedun.biakadiet.request.Post

class PostViewModel : ViewModel() {
    private var postRepository: PostRepository = PostRepository.getInstance()

    var getPostList: LiveData<List<Post>> = postRepository.getPostList()

    fun queryPostApi() {
        postRepository.queryPostApi()
    }

}