package com.example.sign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignLanguageAppTheme {
               // AppNavigation()
                EmojiListScreen()
            }
        }
    }
}

@Composable
fun SignLanguageAppTheme(content: @Composable () -> Unit) {
    // Define your Material3 theme here
    MaterialTheme {
        content()
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
    }
}

@Composable
fun LoginScreen(navController: androidx.navigation.NavController) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 16.dp)
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.blue), // Replace 'background' with your actual image name without the extension
//            contentDescription = "Background Image",
//            modifier = Modifier
//                .fillMaxSize()
//                .align(Alignment.Center)
//        )
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Arrangement from the top
    ) {
        Spacer(modifier = Modifier.height(60.dp)) // This space can be adjusted based on your UI needs

        Image(
            painter = painterResource(id = R.drawable.log), // Replace 'logo' with your actual image name without the extension
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp) // This is the size of the logo, you can adjust it based on your UI needs
                .align(Alignment.CenterHorizontally) // To align the image in the center horizontally
        )

        Spacer(modifier = Modifier.height(32.dp)) // Space between logo and text fields

        Text(
            "Sign Language Translator",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Handle login */ })
        {
            Text(text = "Log In")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { navController.navigate("signup") }) {
            Text(text = "Don't have an account? Sign Up")
        }
    }
}
@Composable
fun SignUpScreen(navController: androidx.navigation.NavController) {
    // Implement sign-up UI similar to the login screen, adjusted for sign-up details
}
//write me a top bar battery and time
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Sign Language Translator",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Handle search icon click */ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmojiListScreen() {
    // List of emoji and image resource IDs (replace with your drawable resource IDs)
    val emojiList = listOf(
        "demo"
//        "👍", "👍", "👍",
//        // Use R.drawable.your_image_name for actual images
//        R.drawable.log, "👍", "👍",
//        "👍", "👍", "👍"
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("Control holographic output of Glove") }) },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                TabView()
                EmojiListView(emojiList)
            }
        }
    )
}
@Composable
fun FontSizeAdjuster() {
    // Remember the current font size and set a default value
    var fontSize by remember { mutableStateOf(16.dp) }

    // UI for adjusting the font size
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        // Button to decrease the font size
        Button(onClick = { if (fontSize.value > 12) fontSize -= 2.dp }) {
            Text(text = "-", fontSize = MaterialTheme.typography.headlineLarge.fontSize)
        }

        // Display the current font size
        Text(
            text = "${fontSize.value.toInt()}",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = MaterialTheme.typography.headlineSmall.fontSize
        )

        // Button to increase the font size
        Button(onClick = { if (fontSize.value < 60) fontSize += 2.dp }) {
            Text(text = "+", fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        }
    }

    // Display a sample text with the adjustable font size
    Text(
        text = "Sample Text",
        textAlign = TextAlign.Center,
        //modifier = Modifier.align(Alignment.CenterHorizontally),
        fontSize = fontSize.value.sp
    )
}
@Composable
fun ColorAdjuster() {
    // Remember the current text color and set a default value
    var textColor by remember { mutableStateOf(Color.Black) }

    // Define a list of colors for the user to choose from
    val colors = listOf(Color.Black, Color.Red, Color.Green, Color.Blue, Color.Magenta)

    // UI for displaying color options
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        for (color in colors) {
            ColorSwatch(color = color) {
                textColor = it
            }
        }
    }

    // Display a sample text with the adjustable text color
    Text(
        text = "Sample Text",
        color = textColor,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        //modifier = Modifier.align(Alignment.CenterHorizontally)
    )
}

@Composable
fun ColorSwatch(color: Color, onColorSelected: (Color) -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .padding(4.dp)
            .background(color)
            .clickable { onColorSelected(color) }
    )
}

@Composable
fun FontChangeAdjuster(onFontChange: (FontFamily) -> Unit) {
    // This is a sample font change function that cycles through a few predefined font styles
    var selectedFontIndex by remember { mutableStateOf(0) }
    val fontFamilies = listOf(FontFamily.Default, FontFamily.Serif, FontFamily.SansSerif, FontFamily.Monospace)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Choose your font:", style = MaterialTheme.typography.displayLarge)
        Row {
            Button(onClick = {
                selectedFontIndex = (selectedFontIndex - 1).coerceAtLeast(0)
                onFontChange(fontFamilies[selectedFontIndex])
            }) {
                Text("<")
            }
            Text(
                text = fontFamilies[selectedFontIndex].toString(),
                style = MaterialTheme.typography.headlineLarge
            )
            Button(onClick = {
                selectedFontIndex = (selectedFontIndex + 1).coerceAtMost(fontFamilies.size - 1)
                onFontChange(fontFamilies[selectedFontIndex])
            }) {
                Text(">")
            }
        }
    }
}
//@Composable
//fun TabView() {
//    // Assuming we have 5 tabs
//    val tabs = listOf("Change Size", "Change Font", "Change Colour", "Preference")
//    var selectedTabIndex by remember { mutableStateOf(0) }
//
//    ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
//        tabs.forEachIndexed { index, text ->
//            Tab(
//                text = { Text(text) },
//                selected = selectedTabIndex == index,
//                onClick = { selectedTabIndex = index }
//            )
//        }
//    }
//    when (tabs[selectedTabIndex]){
//        "Change Size" -> FontSizeAdjuster()
//        "Change Colour" -> ColorAdjuster()
//        "Change Font" -> FontChangeAdjuster(onFontChange = {})
//    }
//}
@Composable
fun TabView() {
    val tabs = listOf("Change Size", "Change Font", "Change Colour", "Preference")
    var selectedTabIndex by remember { mutableStateOf(0) }

    // Define the current font family and color to be used in the text sample.
    var currentFontFamily by remember { mutableStateOf(FontFamily.Default) }
    var currentColor by remember { mutableStateOf(Color.Black) }

    ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
        tabs.forEachIndexed { index, text ->
            Tab(
                text = { Text(text) },
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index }
            )
        }
    }
    // Display the corresponding adjuster composable based on the selected tab.
    when (tabs[selectedTabIndex]) {
        "Change Size" -> FontSizeAdjuster()
        "Change Font" -> FontChangeAdjuster { fontFamily -> currentFontFamily =
            fontFamily as SystemFontFamily
        }
        "Change Colour" ->  ColorAdjuster()//ColorAdjuster { color -> currentColor = color }
    }
    // Display a sample text which will reflect the changes from the adjusters.
    if (tabs[selectedTabIndex] == "Change Font" || tabs[selectedTabIndex] == "Change Colour") {
        Text(
            text = "Sample Text",
            fontSize = 20.sp,
            color = currentColor,
            fontFamily = currentFontFamily
        )
    }
}

@Composable
fun EmojiListView(emojiList: List<Any>) {
    LazyColumn {
        items(emojiList) { item ->
            if (item is Int) { // Assuming it's an image resource ID
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null,
                    modifier = Modifier.padding(16.dp)
                )
            } else if (item is String) {
                Text(
                    text = item,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmojiListScreen()
}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SignLanguageAppTheme {
//        LoginScreen(rememberNavController())
//        TopBar()
//    }
//}


