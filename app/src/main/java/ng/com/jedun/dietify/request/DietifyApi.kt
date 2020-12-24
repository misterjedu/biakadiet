package ng.com.jedun.dietify.request

import retrofit2.Call
import retrofit2.http.GET

interface DietifyApi {
    @GET("posts")
    fun getAllPosts(): Call<List<Post>>
}