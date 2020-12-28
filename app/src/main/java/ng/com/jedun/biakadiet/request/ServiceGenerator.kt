package ng.com.jedun.biakadiet.request

import ng.com.jedun.biakadiet.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {

    companion object {
        private var retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        private var retrofit: Retrofit = retrofitBuilder.build()

        private var dietifyApi: DietifyApi = retrofit.create(DietifyApi::class.java)

        fun getDietifyApi(): DietifyApi {
            return dietifyApi
        }
    }

}