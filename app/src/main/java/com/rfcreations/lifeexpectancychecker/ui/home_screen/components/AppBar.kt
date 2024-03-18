package com.rfcreations.lifeexpectancychecker.ui.home_screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.rfcreations.lifeexpectancychecker.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    toggleShowAppThemeDialog: () -> Unit,
    clearAllSelections: () -> Unit
) {
    var expandAppBarDropDownMenu by rememberSaveable { mutableStateOf(false) }

    TopAppBar(
        {
            Text(
                text = stringResource(id = R.string.app_name),
            )
        }, actions = {

            IconButton(
                onClick = toggleShowAppThemeDialog
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.night),
                    stringResource(R.string.content_desc_clear_all_selection),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = { expandAppBarDropDownMenu = true }) {
                Icon(Icons.Filled.MoreVert, null)

            }

            DropdownMenu(
                expanded = expandAppBarDropDownMenu,
                onDismissRequest = { expandAppBarDropDownMenu = false }
                // offset = DpOffset((-102).dp, (-64).dp),
            ) {
                DropdownMenuItem(text = { Text(text = stringResource(R.string.clear_all_selections)) }, leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.clear_all), null
                    )
                }, onClick = {
                    clearAllSelections()
                    expandAppBarDropDownMenu = false
                })
            }
        }

    )


}