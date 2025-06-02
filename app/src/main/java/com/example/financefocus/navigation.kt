package com.example.financefocus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.START
    ) {
        composable(Routes.START) {
            StartScreen(
                navController = navController
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(Routes.CADASTRO) {
            CadastroScreen(navController = navController)
        }
    }
}
