package com.example.signum.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onLogoutClick: () -> Unit) {
    val tabTitles = listOf("Home", "Translator")
    val selectedTabIndex = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTabIndex.value) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex.value == index,
                    onClick = { selectedTabIndex.value = index }
                )
            }
        }

        when (selectedTabIndex.value) {
            0 -> HomeContent(onLogoutClick)
            1 -> TranslationScreen()
        }
    }
}

@Composable
fun HomeContent(onLogoutClick: () -> Unit) {
    val gloveText = remember { mutableStateOf("") }

    // Simulated glove input (replace with actual glove data parsing)
    val simulatedGloveInput = "Hello, world!"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome to SIGNUM",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2),
            modifier = Modifier.padding(bottom = 32.dp)
        )

        GloveInputDisplay(gloveText = gloveText.value)

        Button(
            onClick = {
                // Update the glove text with the simulated input
                gloveText.value = simulatedGloveInput
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Simulate Glove Input")
        }

        Button(
            onClick = onLogoutClick,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Logout")
        }
    }
}

@Composable
fun GloveInputDisplay(gloveText: String) {
    Text(
        text = "Glove Input: $gloveText",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(top = 16.dp)
    )
}