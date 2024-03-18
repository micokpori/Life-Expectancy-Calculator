package com.rfcreations.lifeexpectancychecker.ui.home_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rfcreations.lifeexpectancychecker.R


@Composable
fun CountryCard(
    modifier: Modifier = Modifier,
    selectedCountry: String,
    toggleShowCountrySelectionDialog: ()-> Unit,
) {
    val changeSelectedCountryText = stringResource(id = R.string.change_selected_country)
    val selectCountryText = stringResource(id = R.string.select_country)
    val title = if (selectedCountry.isEmpty())
        selectCountryText else changeSelectedCountryText
    Card(
        onClick = { toggleShowCountrySelectionDialog() },
        modifier.padding(horizontal = 6.dp, vertical = 8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier,
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Icon(
                Icons.Default.ArrowDropDown,
                null,
            )
            AnimatedVisibility(visible = selectedCountry.isNotEmpty()) {
                Text(
                    selectedCountry,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier.height(16.dp))
    }
}

