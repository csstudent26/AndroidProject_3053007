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

import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.oct24provisional.R

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import com.example.oct24provisional.MainActivity
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.text.font.Font

class Options : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OCT24ProvisionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                    // Using Modifier to Enable Scrolling on the page
                )  { Column(
                        modifier = Modifier
                            .padding(16.dp) //
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize(),
                             horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Title
                        Text(
                            text = "Game Options",
                            style = TextStyle(
                                fontSize = 24.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        // Instructions


                        Text(
                            text = "Game Rules",
                            style = TextStyle(
                                fontSize = 22.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        // Using a LazyColumn to get flexibility dealing with the 'Rules'
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                              //  .verticalScroll(rememberScrollState())

                        ) {
                            item {
                                Text(
                                    text = "Each player receives a throw consisting of two dice.",
                                    style = TextStyle(fontSize = 18.sp),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                            item {
                                Text(
                                    text = "The sum of each throw determines the winner of that round.",
                                    style = TextStyle(fontSize = 18.sp),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                            item {
                                Text(
                                    text = "If you roll a 'six,' you have the option to re-roll the lower die.",
                                    style = TextStyle(fontSize = 18.sp),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                            item {
                                Text(
                                    text = "The house can take a second throw once in a game, if it has more than 1 Round.",
                                    style = TextStyle(fontSize = 18.sp),
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                        // Game Settings
                        Text(
                            text = "Game Settings",
                            style = TextStyle(
                                fontSize = 22.sp, // Adjust the font size as needed
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(16.dp)
                        )




                        //Below is the Composable to find which Sensors are on the Device
                        //  FindSensors()

                        //A Composable which explains to the user about settings for 'Skill Level'
                        GameSettingsInfo()
                        //Composable explains to user about choosing number of 'Rounds' in Game

                      //  OptionsScreen()
                        //Composable to place 'Radio Buttons'
                        CustomRadioGroup(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .border(1.dp, Color.Black) // Add a 1 dp black border
                        )
                        //Spacer
                        Spacer(modifier = Modifier.height(30.dp)) // Adjust height as neede
                        // Button to play 'Sound'( Music)
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













//Composable for our 'Sound' and sound button
@Composable
fun SoundPlayer() {
    val context = LocalContext.current

    // Music Download from You Tube( Allowed)
    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.point_being_go_by_ocean_ryan_mccaffrey) }
    var isSoundOn by remember { mutableStateOf(true) }

    // Sound Button with Toggle
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
        modifier = Modifier
            .fillMaxWidth() // Make the button fill the entire width of the screen
            .padding(16.dp)
    ) {
        Text(if (isSoundOn) "Turn Off Sound" else "Turn On Sound",color = Color.White)
    }
}



// Composable for Radio Buttons
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

//Composable for Checkbox for number of rounds
@Composable
fun RoundsCheckbox(
    selectedRounds: Int,
    onRoundsSelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color(0xFFADD8E6)) // Set the background color to light blue

            .border(1.dp, Color.Black) // Add a 1 dp black border around the entire column

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RoundsCheckboxItem(3, selectedRounds, onRoundsSelected)
            RoundsCheckboxItem(5, selectedRounds, onRoundsSelected)
            RoundsCheckboxItem(10, selectedRounds, onRoundsSelected)
        }
    }
}

//Working with checkboxes selection
@Composable
fun RoundsCheckboxItem(
    rounds: Int,
    selectedRounds: Int,
    onRoundsSelected: (Int) -> Unit
) {
    val isSelected = rememberUpdatedState(selectedRounds == rounds)


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onRoundsSelected(rounds) }
            .background(if (isSelected.value) Color.Red else Color.Transparent)

    ) {
        Checkbox(
            checked = rounds == selectedRounds,
            onCheckedChange = null // We handle the click in the Row
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "$rounds Rounds",
        color = if (isSelected.value) Color.White else Color.Black)

    }
}
//Composable for setting checkboxes
@Composable
fun OptionsScreen() {
    var selectedRounds by remember { mutableStateOf(5) }

    Column {
        // ... (other components)

        RoundsCheckbox(selectedRounds = selectedRounds) { newRounds ->
            selectedRounds = newRounds
        }

        // ... (other components)
    }
}

//Composable to Instruct users on need to choose Playing Level
@Composable
fun GameSettingsInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Choose the Number of Rounds Per Game",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            "The House will react to your chosen level by either playing Random, employing a Strategy, or if Expert, using AI.",
            fontSize = 18.sp
        )
    }
}

