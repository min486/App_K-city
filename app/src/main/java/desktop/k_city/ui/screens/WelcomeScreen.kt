package desktop.k_city.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import desktop.k_city.R
import desktop.k_city.ui.FactCard
import desktop.k_city.ui.FactsViewModel
import desktop.k_city.ui.TextComponent
import desktop.k_city.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, citySelected: String?) {
    // println("=====WelcomeScreen")
    // println("=====$username and $citySelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg2),
            contentDescription = "image background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            TopBar(value = "${username}님\n환영합니다! \uD83D\uDE4C\uD83C\uDFFB")

            Spacer(modifier = Modifier.size(120.dp))

            val finalText = if(citySelected == "서울") "서울에 대한 정보" else "부산에 대한 정보"

            TextComponent(textValue = finalText, textSize = 24.sp)

            val factsViewModel: FactsViewModel = viewModel()
            FactCard(
                value = factsViewModel.generateRandomFact(citySelected!!)
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "citySelected")
}