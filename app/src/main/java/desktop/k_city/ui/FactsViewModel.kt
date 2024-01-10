package desktop.k_city.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFact(citySelected: String): String {
        return if (citySelected == "서울") {
            getSeoulFacts().random()
        } else {
            getBusanFacts().random()
        }
    }

    fun getSeoulFacts(): List<String> {
        val seoulFacts = listOf(
            "대한민국의 수도이자, 한반도 중앙에 있다",
            "서울특별시의 인구는 약 939만 명이다",
            "서울에는 버스터미널이 5곳 있다"
        )
        return seoulFacts
    }

    fun getBusanFacts(): List<String> {
        val busanFacts = listOf(
            "대한민국 제2의 도시이자, 제1의 무역항이다",
            "부산광역시의 인구는 약 329만 명이다",
            "부산광역시 강서구 대저2동에 김해국제공항이 있다"
        )
        return busanFacts
    }

}