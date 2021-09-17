package com.ipsoft.packtrack.presentation.packs_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ipsoft.packtrack.presentation.Screen
import com.ipsoft.packtrack.presentation.ui.theme.*

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
                        currentColor = red

                        text = it
                    } else {
                        currentColor = green
                    }
                },
                label = { Text("Código") },
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
                Text(text = "Pesquisar", style = TextStyle(color = DarkGray,fontSize = 16.sp,fontWeight = FontWeight.W800))
            }
        }

    }


}



