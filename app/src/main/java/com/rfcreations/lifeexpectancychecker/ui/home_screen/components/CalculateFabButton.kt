package com.rfcreations.lifeexpectancychecker.ui.home_screen.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.rfcreations.lifeexpectancychecker.R


@Composable
fun CalculateFabButton(
    modifier: Modifier = Modifier,
    checkAllOptionsAreSelected: () -> Boolean,
    showResultSheet: () -> Unit
) {
    val toastMessage = stringResource(id = R.string.reminder_toast)
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            if (checkAllOptionsAreSelected()) {
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            } else {
                showResultSheet()
            }
        },
        modifier.fillMaxWidth(0.4f)
    ) {
        Text(text = stringResource(R.string.calculate))
    }
}
