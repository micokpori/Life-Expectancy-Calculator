package com.rfcreations.lifeexpectancychecker.ui.home_screen

import androidx.lifecycle.ViewModel
import com.rfcreations.lifeexpectancychecker.util.ThemeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val themeUiState: ThemeUiState) : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    private val _showAppThemeDialog = MutableStateFlow(false)
    val showAppThemeDialog = _showAppThemeDialog.asStateFlow()

    private val _showResultSheet = MutableStateFlow(false)
    val showResultSheet = _showResultSheet.asStateFlow()

    private val _showCountrySelectionDialog = MutableStateFlow(false)
    val showCountrySelectionDialog = _showCountrySelectionDialog.asStateFlow()

    fun uiEvent(event: UiEvent) {
        when (event) {
            is UiEvent.UpdateSelectedCountry -> {
                _homeUiState.update {
                    it.copy(selectedCountry = event.newValue)
                }
            }

            is UiEvent.ToggleGenderState -> {
                _homeUiState.update {
                    it.copy(genderSelection = event.newValue)
                }
            }

            is UiEvent.ToggleSmokeState -> {
                _homeUiState.update {
                    it.copy(smokeSelection = event.newValue)
                }
            }

            is UiEvent.ToggleSocialClassState -> {
                _homeUiState.update {
                    it.copy(socialClassSelection = event.newClass)
                }
            }

            is UiEvent.ToggleRelationshipState -> {
                _homeUiState.update {
                    it.copy(relationShipStatus = event.newValue)
                }
            }

            is UiEvent.ToggleEducationState -> {
                _homeUiState.update {
                    it.copy(educationSelection = event.newValue)
                }
            }

            is UiEvent.ToggleBmiState -> {
                _homeUiState.update {
                    it.copy(bmiSelection = event.newValue)
                }
            }

            is UiEvent.ToggleJobStatus -> {
                    _homeUiState.update {
                        it.copy(jobSelection = event.newValue)
                    }
            }

            is UiEvent.ToggleDiabeticState -> {
                _homeUiState.update {
                    it.copy(diabeticSelection = event.newValue)
                }
            }

            is UiEvent.ToggleExerciseState -> {
                _homeUiState.update {
                    it.copy(exerciseSelection = event.newValue)
                }
            }

            is UiEvent.ToggleShowAppThemeDialog -> {
                _showAppThemeDialog.value = !_showAppThemeDialog.value
            }

            is UiEvent.ToggleShowResultSheet -> {
                _showResultSheet.value = !_showResultSheet.value
            }

            is UiEvent.ToggleShowCountrySelectionDialog -> {
                _showCountrySelectionDialog.value = !_showCountrySelectionDialog.value
            }
        }
    }

    fun clearAllSelectedOptions() {
        _homeUiState.value = HomeUiState()
    }

    //check if all radio groups or a radio group is unselected
    //if true show a toast that asks the user to select all options

    fun showReminderToast(): Boolean {
        return _homeUiState.value.selectedCountry.isEmpty() ||
                _homeUiState.value. genderSelection.isEmpty() ||
                _homeUiState.value.smokeSelection.isEmpty() ||
                _homeUiState.value.socialClassSelection.isEmpty() ||
                _homeUiState.value.educationSelection.isEmpty() ||
                _homeUiState.value.relationShipStatus.isEmpty() ||
                _homeUiState.value.diabeticSelection.isEmpty() ||
                _homeUiState.value.jobSelection.isEmpty() ||
                _homeUiState.value.bmiSelection.isEmpty() ||
                _homeUiState.value. exerciseSelection.isEmpty()
    }
}