package ng.com.jedun.biakadiet.request

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ng.com.jedun.biakadiet.AppExecutors
import ng.com.jedun.biakadiet.util.Constants.NETWORK_TIMEOUT
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

class DietifyApiClient {

    private var posts: MutableLiveData<List<Post>> = MutableLiveData()
    private var retrievePostRunnable: RetrievePostRunnable? = null

    companion object {

        private var instance: DietifyApiClient? = null

        fun getInstance(): DietifyApiClient {
            if (instance == null) {
                instance = DietifyApiClient()
            }
            return instance as DietifyApiClient
        }
    }

    fun getPostList(): LiveData<List<Post>> {
        return posts
    }

    fun queryPostApi() {

        if (retrievePostRunnable != null) {
            retrievePostRunnable = null
        }

        retrievePostRunnable = RetrievePostRunnable()

        val handler = AppExecutors.getInstance().networkIO().submit(retrievePostRunnable)

        AppExecutors.getInstance().networkIO().schedule(object : Runnable {
            override fun run() {
                //Let user know it's timed out.
                handler.cancel(true)
            }

        }, NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }


    inner class RetrievePostRunnable : Runnable {

        private var cancelRequest: Boolean = false

        override fun run() {
            try {
                val response: Response<List<Post>> = getPosts().execute()

                if (cancelRequest) {
                    return
                }

                if (response.code() == 200) {
                    val postList: List<Post> = ArrayList(response.body() as List<Post>)
                    posts.postValue(postList)
                } else {
                    val error: String = response.errorBody().toString()
                    Log.e("Post Retrieve Error", error)
                    posts.postValue(null)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                posts.postValue(null)
            }

        }


        private fun getPosts(): Call<List<Post>> {
            return ServiceGenerator.getDietifyApi().getAllPosts()
        }

        private fun cancelRequest() {
            cancelRequest = true
        }

    }
}