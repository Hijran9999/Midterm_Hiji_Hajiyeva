package ca.hijran.midterm_hiji_hajiyeva

import Screen1
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import ca.hijran.midterm_hiji_hajiyeva.viewmodel.NobelViewModel

@Composable
fun NavGraph(viewModel: NobelViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            Screen1(navController, viewModel)
        }

        composable("detail") {
            Screen2(navController)
        }
    }
}
