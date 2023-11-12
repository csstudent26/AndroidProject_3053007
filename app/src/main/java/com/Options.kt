package com



import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oct24provisional.FindSensors
import com.ui.theme.OCT24ProvisionalTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Switch
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.oct24provisional.R

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import com.example.oct24provisional.MainActivity


class Options : ComponentActivity() {
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
                            text = "Game Options",
                            style = TextStyle(
                                fontSize = 20.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        // Instructions
                        Text(
                            text = "Game Rules",
                            style = TextStyle(
                                fontSize = 16.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        Text(
                            text = "In this dice game, you'll compete against the house. Here are the rules:",
                            style = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = "1. Each player receives a throw consisting of two dice.",
                            style = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = "2. The sum of each throw determines the winner of that round.",
                            style = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = "3. If you roll a 'six,' you have the option to re-roll the lower die.",
                            style = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.padding(8.dp)
                        )

                        Text(
                            text = "4. The house can take a second throw once in a game.",
                            style = TextStyle(fontSize = 14.sp),
                            modifier = Modifier.padding(8.dp)
                        )

                        // Game Settings
                        Text(
                            text = "Game Settings",
                            style = TextStyle(
                                fontSize = 16.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        // Include options for users to configure game settings, such as sound, visuals, difficulty, and theme.
                        // Include options for users to configure game settings

                        //Below is the Composable to find which Sensors are on the Device
                          //  FindSensors()

                            CustomRadioGroup(modifier = Modifier.background(Color.LightGray).border(1.dp, Color.Black) // Add a 1 dp black border
                            )

                            SoundPlayer()

                            // Button to navigate to  Home
                            Button(
                                onClick = {
                                    // Create an Intent to navigate to Home
                                    val intent = Intent(this@Options, MainActivity::class.java)
                                    startActivity(intent)
                                }
                            ) {
                                Text("Go to Home")
                            }

                            // Button to navigate to  Options
                            Button(
                                onClick = {
                                    // Create an Intent to navigate to Home
                                    val intent = Intent(this@Options, Play::class.java)
                                    startActivity(intent)
                                }
                            ) {
                                Text("Go to Play")
                            }

                    }
                }
            }
        }
    }
}




@Composable
fun SoundPlayer2() {
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.point_being_go_by_ocean_ryan_mccaffrey) }

    Button(
        onClick = {
            mediaPlayer.start()
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Play Sound")
    }
}

@Composable
fun SoundPlayer() {
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.point_being_go_by_ocean_ryan_mccaffrey) }
    var isSoundOn by remember { mutableStateOf(true) }

    Button(
        onClick = {
            if (isSoundOn) {
                mediaPlayer.start() // Play the sound
            } else {
                mediaPlayer.pause() // Pause the sound (or stop, depending on your preference)
            }
            isSoundOn = !isSoundOn // Toggle the sound state
        },
        colors = ButtonDefaults.buttonColors( Color(0xFF006400)), // Set the background color to green

        modifier = Modifier.padding(16.dp)
    ) {
        Text(if (isSoundOn) "Turn Off Sound" else "Turn On Sound",color = Color.White)
    }
}



@Composable
fun CustomRadioGroup2(modifier: Modifier = Modifier) {
    val levels = listOf("Beginner", "Intermediate", "Expert")
    var selectedLevel by remember { mutableStateOf(levels[0]) }

    Column(
        modifier = modifier
    ) {
        levels.forEach { level ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (level == selectedLevel),
                        onClick = { selectedLevel = level }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (level == selectedLevel),
                    onClick = { selectedLevel = level },
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = level,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
@Composable
fun CustomRadioGroup(modifier: Modifier = Modifier) {
    val levels = listOf("Beginner", "Intermediate", "Expert")
    var selectedLevel by remember { mutableStateOf(levels[0]) }

    Column(
        modifier = modifier
    ) {
        levels.forEach { level ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (level == selectedLevel),
                        onClick = { selectedLevel = level }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (level == selectedLevel),
                    onClick = { selectedLevel = level },
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .scale(2f) // Adjust the scale (f) as needed (2f is twice the default size)
                )
                Text(
                    text = level,
                    style = TextStyle(
                        fontSize = 22.sp, // Adjust the font size as needed
                        fontWeight = FontWeight.Normal // Adjust the font weight as needed
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

