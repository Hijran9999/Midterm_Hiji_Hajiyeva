package ca.hijran.midterm_hiji_hajiyeva.data
import retrofit2.http.GET

interface NobelApiService {

    @GET("nobelPrizes?limit=25&sort=desc")
    suspend fun getNobelPrizes(): NobelResponse
}