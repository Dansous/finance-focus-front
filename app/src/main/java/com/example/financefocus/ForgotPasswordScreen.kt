package com.seuapp.financefocus.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financefocus.R
import androidx.compose.ui.draw.shadow

@Composable
fun ForgotPasswordScreen(
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit
) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }

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
                .height(300.dp)
                .padding(bottom = 32.dp)
        )

        // Título
        Text(
            text = "Esqueceu sua senha?",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

// Campo Usuário
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuário") },  // Remove color = White
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .shadow(2.dp, RoundedCornerShape(8.dp)),  // Fundo branco sólido
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,  // Branco sólido
                unfocusedContainerColor = Color.White,  // Branco sólido
                focusedTextColor = Color.Black,  // Texto preto
                unfocusedTextColor = Color.Black,  // Texto preto
                focusedLabelColor = Color.Gray,  // Label cinza
                unfocusedLabelColor = Color.Gray,  // Label cinza
                focusedIndicatorColor = Color.Transparent,  // Remove borda
                unfocusedIndicatorColor = Color.Transparent,  // Remove borda
                cursorColor = Color.Black  // Cursor preto
            )
        )

// Campo E-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .shadow(2.dp, RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
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
        )

        // Botão Continuar
        Button(
            onClick = onContinueClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF0052CC)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Continuar", fontSize = 18.sp)
        }

        // Botão Voltar
        TextButton(onClick = onBackClick) {
            Text("Voltar", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen(
        onContinueClick = {},
        onBackClick = {}
    )
}