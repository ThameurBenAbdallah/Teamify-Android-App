package com.example.teamify.uiTeamify.uiComponents

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.teamify.R

@Composable
fun UsersTopBar () {
    TopAppBar(
        title = {
            Text(
                text = buildString {
                    append(stringResource(R.string.teamify))
                }
            )
        }
    )
}