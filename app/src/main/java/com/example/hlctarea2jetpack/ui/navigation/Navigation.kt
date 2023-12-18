package com.example.hlctarea2jetpack.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmarinf.mycosplayer.ui.navigation.NavArgs
import com.cmarinf.mycosplayer.ui.navigation.NavItem
import com.example.hlctarea2jetpack.ui.screens.detail.DetailScreen
import com.example.hlctarea2jetpack.ui.screens.main.MainScreen

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.MainNavItem.route
    ) {
        composable(NavItem.MainNavItem) {
            MainScreen(onNavigate = {
                navController.navigate(NavItem.DetailNavItem.createRoute(it))
            })
        }
        composable(NavItem.DetailNavItem) { backStackEntry ->
            DetailScreen(
                mediaId = backStackEntry.findArg(NavArgs.MediaId.key),
                onUpClick = { navController.popBackStack() }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(key: String): T {
    val value = arguments?.get(key)
    requireNotNull(value)
    return value as T
}