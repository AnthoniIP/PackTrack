package com.ipsoft.packtrack.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipsoft.packtrack.common.Constants.PARAM_PACK_TRACK_CODE
import com.ipsoft.packtrack.presentation.Screen
import com.ipsoft.packtrack.presentation.pack_detail.PackDetailScreen
import com.ipsoft.packtrack.presentation.pack_detail.PackDetailViewModel
import com.ipsoft.packtrack.presentation.packs_list.AddPackScreen
import com.ipsoft.packtrack.presentation.ui.theme.PackTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PackDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            PackTrackTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AddPackScreen.route
                    ) {
                        composable(
                            route = Screen.AddPackScreen.route
                        ) {
                            AddPackScreen(navController = navController)
                        }
                        composable(
                            route = Screen.PackDetailScreen.route + "/{${PARAM_PACK_TRACK_CODE}}"
                        ) {
                            PackDetailScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}

