package com.ipsoft.packtrack.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipsoft.packtrack.presentation.Screen
import com.ipsoft.packtrack.presentation.pack_detail.PackDetailScreen
import com.ipsoft.packtrack.presentation.packs_list.PackListScreen
import com.ipsoft.packtrack.presentation.ui.theme.PackTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PackTrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PackListScreen.route
                    ) {
                        composable(
                            route = Screen.PackListScreen.route
                        ) {
                            PackListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.PackDetailScreen.route + "/{packId}"
                        ) {
                            PackDetailScreen()
                        }
                    }
                }
            }
        }
    }
}