package ng.com.jedun.dietify.repository

import androidx.lifecycle.LiveData
import ng.com.jedun.dietify.request.DietifyApiClient
import ng.com.jedun.dietify.request.Post


class PostRepository {

    private var dietifyApiClient: DietifyApiClient = DietifyApiClient.getInstance()

    companion object {
        private var instance: PostRepository? = null
        fun getInstance(): PostRepository {
            if (instance == null) {
                instance = PostRepository()
            }
            return instance as PostRepository
        }
    }

    fun getPostList(): LiveData<List<Post>> {
        return dietifyApiClient.getPostList()
    }

    fun queryPostApi() {
        dietifyApiClient.queryPostApi()
    }

}