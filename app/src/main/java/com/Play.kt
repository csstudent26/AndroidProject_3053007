package com

import android.content.Intent
import android.widget.Toast

import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.ui.theme.OCT24ProvisionalTheme
import androidx.compose.foundation.layout.fillMaxSize


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.runtime.remember


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlinx.coroutines.delay

import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.foundation.layout.Box

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.foundation.layout.Box



import androidx.compose.ui.unit.dp // Import for the padding modifier

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.platform.LocalConfiguration
import com.example.oct24provisional.MainActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size


import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource




class Play : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a NavController


        setContent {
            OCT24ProvisionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Ready To Play ?", style = TextStyle(
                                fontSize = 28.sp, fontWeight = FontWeight.Bold
                            ), modifier = Modifier.padding(16.dp)
                        )


                        //Composable to display animated Giff
                        PlayScreen3()
                        Spacer(modifier = Modifier.height(30.dp)) // Adjust height as needed

                        UserNameSelection2()

                        StartGameButton()
                        // Button to navigate to  Home
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Home
                                val intent = Intent(this@Play, MainActivity::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Go to Home")
                        }

                        // Button to navigate to  Options
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Home
                                val intent = Intent(this@Play, Options::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Go to Options")
                        }

                    }
                    }


                }
            }
        }
    }





//Composable for funtionality in game (not yet in use)
@Composable
fun DieResultScreen() {
    // Simulate the result of a die throw
    val die1 = (1..6).random()
    val die2 = (1..6).random()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Die 1: $die1", style = TextStyle(
                    fontSize = 24.sp, fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Die 2: $die2", style = TextStyle(
                    fontSize = 24.sp, fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(16.dp)
            )
        }
    }
  }
 



var isChecked =  mutableStateOf(false)

@Composable
fun CheckBox(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked = isChecked,
        onCheckedChange = onCheckedChange
    )
}
@Composable
fun UserNameSelection(modifier: Modifier = Modifier
    .fillMaxWidth()

    ) {
    // List of available usernames
    val userNames = listOf("Alice", "Bob", "Charlie")

    // State to track selected usernames
    var selectedUserNames by remember { mutableStateOf(setOf<String>()) }

    // Display the list of usernames with checkboxes
    Column {
        userNames.forEach { userName ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                CheckBox(
                    isChecked = selectedUserNames.contains(userName),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedUserNames = selectedUserNames + userName
                        } else {
                            selectedUserNames = selectedUserNames - userName
                        }
                    }
                )
                Text(text = userName, modifier = Modifier.padding(16.dp))
            }
        }
    }
}


// Composable to choose User Name
@Composable
fun UserNameSelection2(modifier: Modifier = Modifier.fillMaxWidth()) {
    // List of available usernames
    val userNames = listOf("Aviator", "Hope", "Gambler")


    // State to track the selected username
    var selectedUserName by remember { mutableStateOf<String?>(null) }

    // Display the list of usernames with checkboxes
    Column {

        // Text prompting the user to choose a username

        Text(
            text = "Please choose a User Name",
            style = MaterialTheme.typography.bodyLarge,color = Color.Red,fontSize = 24.sp,
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 16.dp) // Adjust padding as needed
        )
        // List of usernames with checkboxes
        userNames.forEach { userName ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedUserName == userName,
                    onCheckedChange = { isChecked ->
                        selectedUserName = if (isChecked) userName else null
                    },
                    modifier = Modifier.padding(start = 16.dp)
                )
               /* Text(text = userName, modifier = Modifier.padding(16.dp))
                    .style(MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)) */
                Text(
                    text = userName,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
                )

            }
        }
    }
}


//Composable to create and display Giff
@Composable
fun PlayScreen3(modifier: Modifier = Modifier
    .fillMaxWidth()
    .heightIn(max = (LocalConfiguration.current.screenHeightDp / 2).dp)
) {
    val gifUrl = "https://media.tenor.com/5En-9o6PM6UAAAAC/dice.gif" // Replace with your GIF URL
    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = (LocalConfiguration.current.screenHeightDp / 4).dp)
    ) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    loadUrl(gifUrl)

                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                }
            }
        )


        }
    }

//Composable to start Game (not yet functional
@Composable
fun StartGameButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors( Color(0xFF006400)) // Set the background color to green

    ) {
        Text(text = "Start Game")
    }
}


