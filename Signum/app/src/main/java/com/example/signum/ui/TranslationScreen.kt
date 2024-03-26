package com.example.signum.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslationScreen() {
    var sourceLanguage by remember { mutableStateOf("") }
    var targetLanguage by remember { mutableStateOf("") }
    var textToTranslate by remember { mutableStateOf("") }
    var translatedText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Translation Tool",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = sourceLanguage,
            onValueChange = { sourceLanguage = it },
            label = { Text("Source Language") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = targetLanguage,
            onValueChange = { targetLanguage = it },
            label = { Text("Target Language") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        OutlinedTextField(
            value = textToTranslate,
            onValueChange = { textToTranslate = it },
            label = { Text("Text to Translate") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Button(
            onClick = { /* TODO: Implement translation logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            Text("Translate", fontSize = 18.sp)
        }

        Text(
            text = translatedText,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}