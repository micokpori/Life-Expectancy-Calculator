package com.rfcreations.lifeexpectancychecker.ui.home_screen

sealed class UiEvent {
    data class UpdateSelectedCountry(val newValue:String): UiEvent()
    data class ToggleGenderState(val newValue: String) : UiEvent()
    data class ToggleSmokeState(val newValue: String) : UiEvent()
    data class ToggleSocialClassState(val newClass: String) : UiEvent()
    data class ToggleRelationshipState(val newValue: String) : UiEvent()
    data class ToggleEducationState(val newValue: String) : UiEvent()
    data class ToggleBmiState(val newValue: String) : UiEvent()
    data class ToggleJobStatus(val newValue: String) : UiEvent()
    data class ToggleDiabeticState(val newValue: String) : UiEvent()
    data class ToggleExerciseState(val newValue: String) : UiEvent()
    data object ToggleShowAppThemeDialog : UiEvent()
    data object ToggleShowResultSheet: UiEvent()
    data object ToggleShowCountrySelectionDialog : UiEvent()
}