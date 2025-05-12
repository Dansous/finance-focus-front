package com.seuapp.financefocus

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.financefocus.Routes
import com.example.financefocus.screens.CadastroScreen
import com.seuapp.financefocus.screens.ForgotPasswordScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "start") {

        composable("start") {
            StartScreen(
                onLoginClick = { navController.navigate("login") },
                onRegisterClick = {navController.navigate("cadastro") }
            )
        }

        composable("login") {
            LoginScreen(
                onLoginClick = {},
                onForgotPasswordClick = { navController.navigate("forgotPassword") },
                navController = TODO()
            )
        }
    }

    @Composable
    fun AppNavigation(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = Routes.START
        ) {
            composable(Routes.START) {}
            composable(Routes.LOGIN) {}
            composable(Routes.CADASTRO) {
                CadastroScreen(navController = navController)
            }

            composable(Routes.FORGOT_PASSWORD) {
                ForgotPasswordScreen(
                    onContinueClick = {navController.popBackStack() },
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }

}

