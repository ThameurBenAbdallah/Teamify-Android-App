package com.example.teamify.uiTeamify.uiComponents

import android.app.ActivityManager
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamify.models.Task
import com.example.teamify.models.User

@OptIn(ExperimentalMaterialApi::class)
@Composable
@ExperimentalComposeApi
fun UserCard(user: User

) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        /* onClick = {
            navigateToUpdateUserScreen(user.id)
        }*/
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = user.fullName,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = user.email,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = user.role.name,
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )

            }
        }
    }
}


