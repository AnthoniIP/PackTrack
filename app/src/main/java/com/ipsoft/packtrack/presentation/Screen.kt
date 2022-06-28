package com.ipsoft.packtrack.presentation

sealed class Screen(val route: String) {
    object AddPackScreen : Screen("add_pack_screen")
    object PackDetailScreen : Screen("pack_detail_screen")
}
