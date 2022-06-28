package com.ipsoft.packtrack.presentation.packs_list

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ipsoft.packtrack.R
import com.ipsoft.packtrack.common.utils.validator.CorreiosCodeValidator
import com.ipsoft.packtrack.presentation.Screen
import com.ipsoft.packtrack.presentation.ui.theme.DarkGray
import com.ipsoft.packtrack.presentation.ui.theme.green
import com.ipsoft.packtrack.presentation.ui.theme.red

@Composable
fun AddPackScreen(navController: NavHostController) {

    var text by remember { mutableStateOf("") }
    var currentColor by remember { mutableStateOf(red) }
    val mContext = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it.uppercase()
                    val codeValidator = CorreiosCodeValidator(text).validate()
                    if (codeValidator.isSuccess) {
                        currentColor = if (codeValidator.isSuccess) {
                            green

                        } else {
                            red
                        }
                    }

                },
                label = { Text(stringResource(id = R.string.code), color = currentColor) },
                colors = TextFieldDefaults.outlinedTextFieldColors(

                    focusedBorderColor = currentColor,
                    unfocusedBorderColor = currentColor
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = currentColor),
                onClick = {
                    val codeValidator = CorreiosCodeValidator(text).validate()
                    if (codeValidator.isSuccess) {
                        navController.navigate(
                            Screen.PackDetailScreen.route + "/${text}"
                        )
                    } else {
                        mToast(mContext, codeValidator.message)
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

private fun mToast(context: Context, @StringRes message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}





