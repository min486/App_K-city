package desktop.k_city.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import desktop.k_city.R
import desktop.k_city.ui.theme.LightYellow

@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp
        )
        // Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}

@Composable
fun TextComponent(textValue: String, textSize: TextUnit, colorValue: Color = Color.White) {
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "test", textSize = 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged: (name: String) -> Unit  // 사용자가 입력한 이름 전달
) {
    // 로컬에서 값을 업데이트하기 위해 사용
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            // 값이 변경될 때마다
            onTextChanged(it)

            currentValue = it
        },
        placeholder = {
            Text(text = "이름을 입력하세요", fontSize = 18.sp, color = Color.LightGray)
        },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp, color = Color.White),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()  // 포커스 지우고 키보드 숨겨짐
        }
    )
}

@Composable
fun CityCard(
    image: Int, selected: Boolean,
    citySelected: (cityName: String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 4.dp,
                    color = if (selected) Color.Yellow else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val cityName = if (image == R.drawable.seoul) "Seoul" else "Busan"
                        citySelected(cityName)  // 이미지 클릭하면 값 전달

                        localFocusManager.clearFocus()  // 이미지 클릭하면 키보드 내리기
                    },
                painter = painterResource(id = image),
                contentDescription = "seoul image"
            )
        }
    }
}

@Preview
@Composable
fun CityCardPreview() {
    CityCard(R.drawable.seoul, false, { "Seoul" })
}

@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {

        },
        colors = ButtonDefaults.buttonColors(containerColor = LightYellow)
    ) {
        TextComponent(
            textValue = "다음 페이지로 이동",
            textSize = 18.sp,
            colorValue = Color.DarkGray
        )
    }
}