package desktop.k_city.data

// 두가지 이벤트 클래스 정의
// ui 상태(UserInputScreenState)를 업데이트하는데 사용됨
sealed class UserDataUiEvents {
    data class NameEntered(val name: String) : UserDataUiEvents()
    data class CitySelected(val animalValue: String) : UserDataUiEvents()
}
