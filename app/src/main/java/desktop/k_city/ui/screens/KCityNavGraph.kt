package desktop.k_city.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import desktop.k_city.ui.UserInputViewModel

@Composable
fun KCityNavGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {

        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel, showWelcomeScreen = {
                navController.navigate(Routes.WELCOME_SCREEN + "/${it.first}/${it.second}")
            })
        }

        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.CITY_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.CITY_SELECTED) { type = NavType.StringType }
            )
        ) {
            val username = it.arguments?.getString(Routes.USER_NAME)
            val citySelected = it.arguments?.getString(Routes.CITY_SELECTED)
            WelcomeScreen(username, citySelected)
        }

    }
}