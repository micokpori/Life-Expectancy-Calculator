package com.rfcreations.lifeexpectancychecker.ui.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun LifeStyleRadioGroup(
    title: String,
    imageDrawable: Int,
    radioButtonOptions: Array<String>,
    selectedOption: String,
    modifier: Modifier =  Modifier,
    onRadioButtonClicked: (String) -> Unit,
) {
    Card(modifier.padding(horizontal = 6.dp, vertical = 8.dp)) {
        Row(
            modifier.padding(horizontal = 6.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                painter = painterResource(id = imageDrawable),
                null,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        }
        radioButtonOptions.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(role = Role.RadioButton) { onRadioButtonClicked(option) }
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { onRadioButtonClicked(option) }
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}