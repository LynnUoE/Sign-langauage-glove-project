package com.example.signum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.signum.ui.LoginScreen
import com.example.signum.ui.TranslationScreen
import com.example.signum.ui.theme.SignumTheme

@Composable
fun MainScreen() {
    var loggedIn by remember { mutableStateOf(false) }

    if (loggedIn) {
        TranslationScreen()
    } else {
        LoginScreen(onLoginClick = { username, password ->
            // Perform login validation and authentication
            // If successful, set loggedIn to true
            loggedIn = true
        })
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignumTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}