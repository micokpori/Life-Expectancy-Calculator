package com.rfcreations.lifeexpectancychecker.ui.home_screen

data class HomeUiState(
    var selectedCountry: String = "",
    var genderSelection: String = "",
    var relationShipStatus: String = "",
    var smokeSelection: String = "",
    var socialClassSelection: String = "",
    var educationSelection: String = "",
    var diabeticSelection: String = "",
    var jobSelection: String = "",
    var bmiSelection: String = "",
    var exerciseSelection: String = ""
)