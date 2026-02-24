package ca.hijran.midterm_hiji_hajiyeva.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class NobelResponse(
    @Json(name = "nobelPrizes") val nobelPrizes: List<NobelPrize>
) : Serializable

@JsonClass(generateAdapter = true)
data class NobelPrize(
    val awardYear: String,
    val category: Category,
    val categoryFullName: CategoryFullName,
    val dateAwarded: String,
    val prizeAmount: Int,
    val laureates: List<Laureate>? = null
) : Serializable
//models just stores data we consume from API

@JsonClass(generateAdapter = true)
data class Category(
    val en: String
) : Serializable

@JsonClass(generateAdapter = true)
data class CategoryFullName(
    val en: String
) : Serializable// parsing or processing data from the API

@JsonClass(generateAdapter = true)
data class Laureate(
    val knownName: KnownName? = null,
    val motivation: Motivation? = null
) : Serializable

@JsonClass(generateAdapter = true)
data class KnownName(val en: String) : Serializable

@JsonClass(generateAdapter = true)
data class Motivation(val en: String) : Serializable