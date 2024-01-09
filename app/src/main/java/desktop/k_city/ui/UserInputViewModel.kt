package desktop.k_city.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import desktop.k_city.data.UserDataUiEvents
import desktop.k_city.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    // 이름 입력하거나 동물 선택하면 함수 트리거됨
    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.NameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.CitySelected -> {
                uiState.value = uiState.value.copy(
                    citySelected = event.animalValue
                )
            }
        }
    }

    // 이름과 도시 들어가있는지 확인
    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.citySelected.isNullOrEmpty()
    }

}




