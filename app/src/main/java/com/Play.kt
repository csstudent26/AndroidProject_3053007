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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll


import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.myapp.R
import com.example.oct24provisional.R


class Play : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize(),
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


                        GameScreen()

                        StartGameButton()

                        // Buttons to navigate to  Home and Options inside this Composable
                        ButtonSelect()
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
@Composable
fun ButtonSelect(){

    val context = LocalContext.current

    // Column seetings allow the Alignment of the contents (Buttons)
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){


        Button(
            onClick = {
                // Create an Intent to navigate to Options
                val intent = Intent(context, Options::class.java)
                context.startActivity(intent)
            }
        ) {
            Text("Go to Options")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Button to navigate to Play
        Button(
            onClick = {
                // Create an Intent to navigate to Options
                val intent = Intent(context,Play::class.java)
                context.startActivity(intent)
            }
        ) {
            Text("Go to Play")
        }

    }
    }
@Composable
fun DropdownMenu5(

    items: List<String>,
    onItemSelected:(String) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box {
        Text(text = "Select",

            modifier = Modifier.clickable { expanded = !expanded })

        if (expanded) {
            Column(
                modifier = Modifier
                    .background(Color.Blue)
                    .border(1.dp, Color.LightGray)
                    .width(200.dp)
            ) {
                items.forEach { item ->
                    Box(
                        modifier = Modifier
                            .clickable {
                                onItemSelected(item)
                                expanded = false // Close the menu after selection
                            }
                            .padding(8.dp)
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
 }

// Composable to give user a choice of Log In or Just  as Guest
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen() {

    //Variables to store 'Player Name' value
    var playerName by remember { mutableStateOf("") }
    var isLoggingIn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoggingIn) {
            TextField(
                value = playerName,
                onValueChange = { playerName = it },
                label = { Text("Enter your name") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { isLoggingIn = false })
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { isLoggingIn = false }) {
                Text("Play as Guest")
            }
        } else {
            Text("Choose a name to play:")
            Spacer(modifier = Modifier.height(8.dp))
            // List of predefined names
            listOf("Player 1", "Player 2", "Player 3").forEach { name ->

                Button(
                    onClick = {

                        playerName = name
                        // Start the game with selected name
                        // Will Put the logic here to initiate the game with the chosen name
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    //Setting the name on the
                    Text(name)
                }
            }
            //Spacer Between Buttons
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { isLoggingIn = true }) {
                Text("Log in with a custom name")
            }
        }
    }
}

@Composable
fun ImageForDice(value: Int) {

    //We make a List for our images( to display as results)
    val diceImages = listOf(
        R.drawable.dice_one_,
        R.drawable.dice_two_,
        R.drawable.dice_three_,
        R.drawable.dice_four_,
        R.drawable.dice_5_,
        R.drawable.dice_six_
    )


    //Variable to store the corresponding image
    val diceImage: Painter? = if (value in 1..6) {
        painterResource(diceImages[value - 1])
    } else null


    //Aligning Image and Throw
    diceImage?.let {
        Image(
            painter = it,
            contentDescription = "Dice Image",
            modifier = Modifier.size(100.dp)
        )
    }
}
//Composable for Dealer(House) Throw
@Composable
fun throwForHouse(): Int {
    val randomNumber = (1..6).random() // Simulate a random number between 1 and 6
    println("House throws: $randomNumber") // Print the result to the screen
    return randomNumber
}
