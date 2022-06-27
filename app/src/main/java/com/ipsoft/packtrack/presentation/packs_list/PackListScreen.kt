package com.ipsoft.packtrack.presentation.packs_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ipsoft.packtrack.R
import com.ipsoft.packtrack.presentation.Screen
import com.ipsoft.packtrack.presentation.ui.theme.DarkGray
import com.ipsoft.packtrack.presentation.ui.theme.green
import com.ipsoft.packtrack.presentation.ui.theme.red

@Composable
fun PackListScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by remember { mutableStateOf("") }
            var currentColor by remember { mutableStateOf(red) }

            OutlinedTextField(
                value = text,
                onValueChange = {
                    if (it.length <= 13) {
                        text = it
                        currentColor = if (it.length != 13) {
                            red

                        } else {
                            green
                        }
                    }

                },
                label = { Text(stringResource(id = R.string.code)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(

                    focusedBorderColor = currentColor,
                    unfocusedBorderColor = currentColor
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = currentColor),
                onClick = {
                    if (text.length == 13) {
                        navController.navigate(
                            Screen.PackDetailScreen.route + "/${text}"
                        )
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.add),
                    style = TextStyle(
                        color = DarkGray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W800
                    )
                )

            }
        }

    }

}




