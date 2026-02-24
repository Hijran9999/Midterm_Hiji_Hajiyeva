package ca.hijran.midterm_hiji_hajiyeva.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.hijran.midterm_hiji_hajiyeva.data.NobelPrize
import ca.hijran.midterm_hiji_hajiyeva.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NobelViewModel : ViewModel() {

    private val _prizes = MutableStateFlow<List<NobelPrize>>(emptyList())
    val prizes: StateFlow<List<NobelPrize>> = _prizes

    init {
        fetchPrizes()
    }
//
//    private fun fetchPrizes() {
//        viewModelScope.launch {
//            try {
//                val response = RetrofitInstance.api.getNobelPrizes()
//                _prizes.value = response.nobelPrizes
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }

    private fun fetchPrizes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getNobelPrizes()

                // Print the full response to console
                Log.d("NobelAPI", "Response: $response")

                _prizes.value = response.nobelPrizes

            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("NobelAPI", "Error fetching prizes: ${e.message}")
            }
        }
    }
}