import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ca.hijran.midterm_hiji_hajiyeva.viewmodel.NobelViewModel

@Composable
fun Screen1(
    navController: NavController,
    viewModel: NobelViewModel
) {

//    Button(
//        onClick = { navController.navigate("detail") },
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Text("Go To Detail Screen")
//    }
//
//    Spacer(modifier = Modifier.height(16.dp))
//
    val prizes by viewModel.prizes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Hiji Hajiyeva - 123456789",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(prizes) { prize ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.currentBackStackEntry
                                ?.savedStateHandle
                                ?.set("prize", prize)

                            navController.navigate("detail")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${prize.awardYear} - ${prize.category.en}")
                    }
                }
            }
        }
    }
}