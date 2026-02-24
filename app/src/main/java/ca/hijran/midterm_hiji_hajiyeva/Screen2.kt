package ca.hijran.midterm_hiji_hajiyeva

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ca.hijran.midterm_hiji_hajiyeva.data.NobelApiService
import ca.hijran.midterm_hiji_hajiyeva.data.NobelPrize

@Composable
fun Screen2(navController: NavController) {

    val prize =
        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.get<NobelPrize>("prize")

    prize?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text("Award Year: ${it.awardYear}")
            Text("Category: ${it.category.en}")
            Text("Full Name: ${it.categoryFullName.en}")
            Text("Date Awarded: ${it.dateAwarded}")
            Text("Prize Amount: ${it.prizeAmount}")

            Spacer(modifier = Modifier.height(16.dp))

            Text("Laureates:")

            it.laureates?.forEach { laureate ->
                Spacer(modifier = Modifier.height(8.dp))
                Text("• ${laureate.knownName?.en}")
                Text("Motivation: ${laureate.motivation?.en}")
            }
        }
    }
}