package com.rfcreations.lifeexpectancychecker.ui.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.rfcreations.lifeexpectancychecker.R
import com.rfcreations.lifeexpectancychecker.util.LifeExpectancyCalculator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetLifeExpResult(
    selectedCountry: String,
    genderSelection: String,
    smokeSelection: String,
    socialClassSelection: String,
    educationSelection: String,
    relationShipStatus: String,
    diabeticSelection: String,
    jobSelection: String,
    bmiSelection: String,
    exerciseSelection: String,
    modifier: Modifier = Modifier,
    toggleShowResultSheet: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val lifeExpectancy =
        LifeExpectancyCalculator.calculateLifeExpectancy(
            context,
            selectedCountry,
            genderSelection,
            smokeSelection,
            socialClassSelection,
            educationSelection,
            relationShipStatus,
            diabeticSelection,
            jobSelection,
            bmiSelection,
            exerciseSelection
        )

    ModalBottomSheet(
        onDismissRequest = toggleShowResultSheet,
        modifier = Modifier.fillMaxSize(),
        sheetState = sheetState,
        dragHandle = {}
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier.height(20.dp))
            Row(
                modifier,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { toggleShowResultSheet() },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.inverseSurface.copy(
                            0.3f
                        )
                    ),
                    modifier = Modifier
                        .padding(end = 20.dp)
                ) {
                    Icon(Icons.Outlined.Close, contentDescription = null, modifier.size(72.dp))
                }
            }

            Column(modifier = modifier.padding(horizontal = 8.dp)) {

                Text(
                    text = stringResource(R.string.results),
                    style = MaterialTheme.typography.titleLarge
                )
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                Spacer(modifier = modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.your_country, selectedCountry),
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = stringResource(
                        R.string.average_life_expectancy_years,
                        lifeExpectancy.second
                    ),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(R.string.life_expectancy_years, lifeExpectancy.first),
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.how_to_improve_life_expectancy),
                    modifier,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )

                Spacer(modifier.height(8.dp))

                Text(
                    text = stringResource(id = R.string.step_to_improve_life_exp),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}