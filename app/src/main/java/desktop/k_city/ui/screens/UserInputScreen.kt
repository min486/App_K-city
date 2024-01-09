package desktop.k_city.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.k_city.R
import desktop.k_city.data.UserDataUiEvents
import desktop.k_city.ui.ButtonComponent
import desktop.k_city.ui.CityCard
import desktop.k_city.ui.TextComponent
import desktop.k_city.ui.TextFieldComponent
import desktop.k_city.ui.TopBar
import desktop.k_city.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        // color = Color.Black
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
                .padding(20.dp),
        ) {
            TopBar("한국의 멋진 도시에 대해\n자세히 알아봐요️")

            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(
                textValue = "입력한 내용에 맞게\n안내 페이지를 보여드릴게요",
                textSize = 18.sp,
                colorValue = Color.LightGray
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "이름", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.NameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(40.dp))

            TextComponent(textValue = "어떤 도시를 좋아하나요?", textSize = 18.sp)

            Spacer(modifier = Modifier.size(20.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "서울", color = Color.White, fontSize = 16.sp)

                    CityCard(
                        image = R.drawable.seoul,
                        citySelected = {
                            userInputViewModel.onEvent(
                                UserDataUiEvents.CitySelected(it)
                            )
                        },
                        selected = userInputViewModel.uiState.value.citySelected == "Seoul"
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "부산", color = Color.White, fontSize = 16.sp)

                    CityCard(
                        image = R.drawable.busan,
                        citySelected = {
                            userInputViewModel.onEvent(
                                UserDataUiEvents.CitySelected(it)
                            )
                        },
                        selected = userInputViewModel.uiState.value.citySelected == "Busan"
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // 이름과 도시 들어가있으면 버튼 띄우기
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {

                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}