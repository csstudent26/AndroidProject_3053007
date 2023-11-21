package com.example.oct24provisional

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle

import androidx.navigation.NavController
import androidx.compose.runtime.Composable





import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.Options
import com.Play


import com.example.oct24provisional.ui.theme.OCT24ProvisionalTheme


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            OCT24ProvisionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Title
                        Text(
                            text = "Welcome to the Lucky Dice Game",
                            style = TextStyle(
                                fontSize = 24.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )
                        // A Spacer between the Animated Text and 'Welcoming Message'
                        Spacer(modifier = Modifier.height(16.dp))
                        AnimatedText()
                        // Add Spacer if needed
                        ButtonSelect()
                        Spacer(modifier = Modifier.height(16.dp))
                        // Displays main image on home page
                        HomeScreen()

                    }// End of Column Scope

                }// End of Surface
            }
        }// End of setContent
    }
}// End of Class


@Composable
fun ButtonSelect(){
        val context = LocalContext.current
                // Modifier must be commented out as it will take too much space
        Column( //modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){

            // Button to navigate to Options
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
// Composable to display our main image
@Composable
fun HomeScreen() {
    val imagePainter: Painter = painterResource(id = R.drawable.dicegame)

    Image(
        painter = imagePainter,
        contentDescription = "Dice Game Image",
        modifier = Modifier.fillMaxSize()
    )
}
// Composable which allows us to find which sensors are on a device
@Composable
fun FindSensors() {

    val context = LocalContext.current
    val sensorManager: SensorManager =
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)


    LazyColumn {
        items<Sensor>(deviceSensors) { sensor ->
            Text(text = sensor.name)
        }
    }
}




// A Composable that gives Animated Text ('Lucky Dice Game')
@Composable
fun AnimatedText() {
    var visibleText by remember { mutableStateOf("Please") }

    LaunchedEffect(Unit) {
        val words = listOf( "Lucky", "Dice", "Game")
        var index = 1

        while (true) {
            delay(1000) // Change text every 1000 milliseconds
            visibleText = words[index]
            index = (index + 1) % words.size
        }
    }

    Text(
        modifier = Modifier
            .padding(16.dp),
        text = visibleText,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Green
        )
    )
}