package com.seuapp.financefocus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.financefocus.R
import com.seuapp.financefocus.ui.theme.FinanceFocusTheme
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinanceFocusTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF0052CC)

                ) {
                    MainActivity()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    navController: NavHostController
) {
    // Fundo azul
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0052CC)), // tom de azul igual da tela 1
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo), // substitua pelo nome da sua logo
                contentDescription = "Logo Finance Focus",
                modifier = Modifier
                    .height(300.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Usuário
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Usuário") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))

            )

            // Campo Senha
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                visualTransformation = PasswordVisualTransformation()
            )

            // Botão Entrar
            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Entrar", color = Color.Black)
            }

            TextButton(
                onClick = {
                    onForgotPasswordClick()
                }
            ) {
                Text("Esqueceu sua senha?", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview2() {
    FinanceFocusTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0, 74, 173, 170)
        ) {
            // Solução para preview - não use NavController real
            LoginScreen(
                onLoginClick = {},
                onForgotPasswordClick = {},
                navController = rememberNavController()
            )
        }
    }
}
