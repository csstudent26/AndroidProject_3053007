package com

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
import androidx.compose.ui.graphics.Color
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
                                fontSize = 24.sp, fontWeight = FontWeight.Bold
                            ), modifier = Modifier.padding(16.dp)
                        )

                    //    UserNameSelection()

                        PlayScreen()

                            UserNameSelection()

                    }


                }
            }
        }
    }
}


@Composable
fun PlayScreen(modifier: Modifier = Modifier
    .fillMaxWidth()
    .heightIn(max = (LocalConfiguration.current.screenHeightDp / 2).dp))
     {
    val gifUrl =
        "https://media.tenor.com/5En-9o6PM6UAAAAC/dice.gif" // Replace with your GIF URL
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        AndroidView(

            modifier = Modifier.fillMaxSize(), factory = { context ->
                WebView(context).apply {
                    loadUrl(gifUrl)

                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                }
            })
        // Button to start the game and navigate to the DieResultScreen
        Button(
            onClick = {


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
        ) {
            Text(text = "Start Game")
        }

    }



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



