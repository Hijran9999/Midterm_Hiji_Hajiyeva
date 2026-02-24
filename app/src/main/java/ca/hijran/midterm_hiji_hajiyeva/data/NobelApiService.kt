package ca.hijran.midterm_hiji_hajiyeva.data
import retrofit2.http.GET

interface NobelApiService {

    @GET("nobelPrizes?limit=25&sort=desc")// we are giving the API correct endpoint to get the data
    suspend fun getNobelPrizes(): NobelResponse
}