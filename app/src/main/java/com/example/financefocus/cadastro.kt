package com.example.financefocus

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CadastroScreen(navController: NavController) {
    var username by remember { mutableStateOf("") } //campos vazios
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0052CC))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo Finance Focus",
            modifier = Modifier
                .height(200.dp)
                .padding(bottom = 32.dp)
        )

        // Título
        Text(
            text = "Criar Nova Conta",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo Usuário
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuário") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = textFieldColors()
        )

        // Campo Senha
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = textFieldColors()
        )

        // Campo E-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = textFieldColors()
        )

        // Campo Salário
        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text("Salário (R$)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = textFieldColors()
        )

        // Campo Telefone
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Telefone") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .background(Color.White, RoundedCornerShape(8.dp)),
            colors = textFieldColors()
        )

        // Botão Criar Conta
        Button(
            onClick = {
                // Lógica de cadastro
                navController.navigate(Routes.HOME) // Navega após cadastro
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF000000)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Criar Conta", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Composable
private fun textFieldColors() = TextFieldDefaults.colors(
    focusedContainerColor = Color.White,
    unfocusedContainerColor = Color.White,
    focusedTextColor = Color.Black,
    unfocusedTextColor = Color.Black,
    focusedLabelColor = Color.Gray,
    unfocusedLabelColor = Color.Gray,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    cursorColor = Color.Black
)

@Preview(showBackground = true)
@Composable
fun CadastroScreenPreview() {
    CadastroScreen(navController = rememberNavController())
}