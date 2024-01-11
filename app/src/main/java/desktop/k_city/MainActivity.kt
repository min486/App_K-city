package desktop.k_city

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import desktop.k_city.ui.screens.KCityNavGraph
import desktop.k_city.ui.theme.KcityTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Thread.sleep(1000)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                !viewModel.isReady.value
            }
        }

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