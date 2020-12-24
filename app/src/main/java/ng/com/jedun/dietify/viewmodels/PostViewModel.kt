package ng.com.jedun.dietify.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ng.com.jedun.dietify.repository.PostRepository
import ng.com.jedun.dietify.request.Post

class PostViewModel : ViewModel() {
    private var postRepository: PostRepository = PostRepository.getInstance()

    var getPostList: LiveData<List<Post>> = postRepository.getPostList()

    fun queryPostApi() {
        postRepository.queryPostApi()
    }

}