package ca.hijran.midterm_hiji_hajiyeva

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.hijran.midterm_hiji_hajiyeva.ui.theme.Midterm_Hiji_HajiyevaTheme
import ca.hijran.midterm_hiji_hajiyeva.viewmodel.NobelViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Midterm_Hiji_HajiyevaTheme {

                // Create ViewModel
                val viewModel: NobelViewModel = viewModel()

                // Start Navigation
                NavGraph(viewModel)
            }
        }
    }
}