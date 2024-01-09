package desktop.k_city.data

// 두 필드 값을 갖고있는 상태 데이터 클래스
data class UserInputScreenState(
    var nameEntered: String =  "",
    var citySelected: String = ""
)
