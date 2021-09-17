package com.ipsoft.packtrack.presentation

sealed class Screen(val route : String) {
object PackListScreen : Screen("pack_list_screen")
object PackDetailScreen : Screen("pack_detail_screen")
}
