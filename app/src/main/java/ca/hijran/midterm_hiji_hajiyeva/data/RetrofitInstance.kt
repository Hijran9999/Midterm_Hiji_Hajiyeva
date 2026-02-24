package ca.hijran.midterm_hiji_hajiyeva.data
//

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://api.nobelprize.org/2.1/"

    val api: NobelApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(NobelApiService::class.java)
    }
}