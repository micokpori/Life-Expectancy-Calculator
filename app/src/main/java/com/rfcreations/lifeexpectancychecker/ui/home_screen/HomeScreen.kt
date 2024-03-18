package com.rfcreations.lifeexpectancychecker.ui.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rfcreations.lifeexpectancychecker.R
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.AppBar
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.AppThemeDialog
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.BottomSheetLifeExpResult
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.CalculateFabButton
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.CountryCard
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.CountrySelectionDialog
import com.rfcreations.lifeexpectancychecker.ui.home_screen.components.LifeStyleRadioGroup

/**
 * Top level composable
 * entry home_screen of this app
 */
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val homeUiState = homeViewModel.homeUiState.collectAsState().value
    val showAppThemeDialog = homeViewModel.showAppThemeDialog.collectAsState()
    val showResultSheet = homeViewModel.showResultSheet.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(0.5f),
        topBar = {
            AppBar(
                toggleShowAppThemeDialog = { homeViewModel.uiEvent(UiEvent.ToggleShowAppThemeDialog) },
                clearAllSelections = { homeViewModel.clearAllSelectedOptions() })
        },
        floatingActionButton = {
            CalculateFabButton(
                checkAllOptionsAreSelected = { homeViewModel.showReminderToast() },
                showResultSheet = { homeViewModel.uiEvent(UiEvent.ToggleShowResultSheet) }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            LifeStyleSelections(
                homeViewModel,
                modifier = Modifier.fillMaxWidth()
            )
        }
        if (showAppThemeDialog.value) {
            AppThemeDialog(themeUiState = homeViewModel.themeUiState) {
                 homeViewModel.uiEvent(UiEvent.ToggleShowAppThemeDialog)
            }
        }

        if (showResultSheet.value) {
            BottomSheetLifeExpResult(
                selectedCountry = homeUiState.selectedCountry,
                genderSelection = homeUiState.genderSelection,
                smokeSelection = homeUiState.smokeSelection,
                socialClassSelection = homeUiState.socialClassSelection,
                educationSelection = homeUiState.educationSelection,
                relationShipStatus = homeUiState.relationShipStatus,
                diabeticSelection = homeUiState.diabeticSelection,
                jobSelection = homeUiState.jobSelection,
                bmiSelection = homeUiState.bmiSelection,
                exerciseSelection = homeUiState.exerciseSelection,
                modifier = Modifier.fillMaxWidth(),
                toggleShowResultSheet = { homeViewModel.uiEvent(UiEvent.ToggleShowResultSheet) }
            )
        }
    }
}


@Composable
private fun LifeStyleSelections(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val homeUiState = homeViewModel.homeUiState.collectAsState().value
    val showCountrySelectionDialog = homeViewModel.showCountrySelectionDialog.collectAsState()
    val genderOptions = stringArrayResource(id = R.array.gender_options)
    val smokeOptions = stringArrayResource(id = R.array.smoking_options)
    val socialClassOptions = stringArrayResource(id = R.array.social_class_options)
    val educationOptions = stringArrayResource(id = R.array.education_options)
    val relationshipStatusOptions = stringArrayResource(id = R.array.social_class_options)
    val diabeticOptions = stringArrayResource(id = R.array.diabetic_options)
    val jobStatusOptions = stringArrayResource(id = R.array.job_status_options)
    val bmiList = stringArrayResource(id = R.array.bmi_options)
    val exerciseOptions = stringArrayResource(id = R.array.exercise_options)
    if (showCountrySelectionDialog.value) {
        CountrySelectionDialog(
            toggleShowCountrySelectionDialog = { homeViewModel.uiEvent(UiEvent.ToggleShowCountrySelectionDialog) },
            updateSelectedCountry = { newCountry ->
                homeViewModel.uiEvent(
                    UiEvent.UpdateSelectedCountry(
                        newCountry
                    )
                )
            }
        )
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        item {
            CountryCard(
                modifier = modifier,
                selectedCountry = homeUiState.selectedCountry
            ) {
                homeViewModel.uiEvent(UiEvent.ToggleShowCountrySelectionDialog)
            }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.are_you_male_or_female),
            imageDrawable = R.drawable.gender,
            radioButtonOptions = genderOptions,
            selectedOption = homeUiState.genderSelection,
            modifier = modifier
        ) { newGender ->
            homeViewModel.uiEvent(UiEvent.ToggleGenderState(newGender))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.do_you_smoke),
            imageDrawable = R.drawable.smoke,
            radioButtonOptions = smokeOptions,
            selectedOption = homeUiState.smokeSelection,
            modifier = modifier
        ) { newSmokeValue ->
            homeViewModel.uiEvent(UiEvent.ToggleSmokeState(newSmokeValue))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.social_class),
            imageDrawable = R.drawable.class_image,
            radioButtonOptions = socialClassOptions,
            selectedOption = homeUiState.socialClassSelection,
            modifier = modifier
        ) { newSocialClass ->
            homeViewModel.uiEvent(UiEvent.ToggleSocialClassState(newSocialClass))
        }


        LifeStyleRadioGroup(
            title = stringResource(id = R.string.what_is_your_education_level),
            imageDrawable = R.drawable.school,
            radioButtonOptions = educationOptions,
            selectedOption = homeUiState.educationSelection,
            modifier = modifier
        ) { newEdu ->
            homeViewModel.uiEvent(UiEvent.ToggleEducationState(newEdu))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.relationship_status),
            imageDrawable = R.drawable.love,
            radioButtonOptions = relationshipStatusOptions,
            selectedOption = homeUiState.relationShipStatus,
            modifier = modifier
        ) { newRelationShipValue ->
            homeViewModel.uiEvent(UiEvent.ToggleRelationshipState(newRelationShipValue))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.are_you_diabetic),
            imageDrawable = R.drawable.virus,
            radioButtonOptions = diabeticOptions,
            selectedOption = homeUiState.diabeticSelection,
            modifier = modifier
        ) { newDiabeticValue ->
            homeViewModel.uiEvent(UiEvent.ToggleDiabeticState(newDiabeticValue))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.do_you_have_a_job),
            imageDrawable = R.drawable.job,
            radioButtonOptions = jobStatusOptions,
            selectedOption = homeUiState.jobSelection,
            modifier = modifier
        ) { newJobValue ->
            homeViewModel.uiEvent(UiEvent.ToggleJobStatus(newJobValue))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.whats_your_bmi),
            imageDrawable = R.drawable.bmi,
            radioButtonOptions = bmiList,
            selectedOption = homeUiState.bmiSelection,
            modifier = modifier
        ) { newBmi ->
            homeViewModel.uiEvent(UiEvent.ToggleBmiState(newBmi))
        }

        LifeStyleRadioGroup(
            title = stringResource(id = R.string.what_s_your_exercise_level),
            imageDrawable = R.drawable.exercise,
            radioButtonOptions = exerciseOptions,
            selectedOption = homeUiState.exerciseSelection,
            modifier = modifier
        ) { newExerciseValue ->
            homeViewModel.uiEvent(UiEvent.ToggleExerciseState(newExerciseValue))
        }
    }
}
}

