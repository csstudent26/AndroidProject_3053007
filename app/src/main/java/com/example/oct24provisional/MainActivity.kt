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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Options
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

import com.example.oct24provisional.ui.theme.OCT24ProvisionalTheme




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

                        // Add Spacer if needed
                        Spacer(modifier = Modifier.height(16.dp))


                        // Button to navigate to Options
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Options
                                val intent = Intent(this@MainActivity, Options::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Go to Options")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // Button to navigate to Options
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Options
                                val intent = Intent(this@MainActivity, Options::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Go to Play")
                        }
                           HomeScreen()

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
   /* val context = LocalContext.current
    val sensorManager: SensorManager =
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
    println(deviceSensors)*/
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OCT24ProvisionalTheme {
        Greeting("Android")
    }
}

@Composable
fun HomeScreen2() {
    val imagePainter: Painter = painterResource(id = R.drawable.dicegame)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the image
        Image(
            painter = imagePainter,
            contentDescription = "Dice Game Image",
          //  modifier = Modifier.size(200.dp) // Adjust the size as needed
        )
        // Add more content, buttons, or text below the image if desired
    }
}
@Composable
fun HomeScreen() {
    val imagePainter: Painter = painterResource(id = R.drawable.dicegame)

    Image(
        painter = imagePainter,
        contentDescription = "Dice Game Image",
        modifier = Modifier.fillMaxSize()
    )
}






