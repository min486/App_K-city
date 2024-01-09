package desktop.k_city

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import desktop.k_city.ui.screens.KCityNavGraph
import desktop.k_city.ui.theme.KcityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KcityTheme {
                kCityApp()
            }
        }
    }

    @Composable
    fun kCityApp() {
        KCityNavGraph()
    }

}

