package com


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
import androidx.compose.ui.Modifier
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


                          //  FindSensors()
                            RadioGroup()



                        // Visual and Sound Settings
                        /* Add options for themes, music, sound effects, etc. */

                        // Advanced Settings
                        /* Add advanced options if needed */
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    OCT24ProvisionalTheme {
        Greeting4("Android")
    }
}

@Composable
fun RadioGroup2() {
    val levels = listOf("Easy", "Medium", "Hard")
    var selectedLevel = levels[0]

    Column {
        levels.forEach { level ->
            Row(
                Modifier
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

            }
        }
    }
}
@Composable
fun RadioGroup() {
    val levels = listOf("Beginner", "Intermediate", "Expert")
    var selectedLevel = levels[0]

    Column {
        levels.forEach { level ->
            Row(
                Modifier
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
fun SoundSettingsContent() {
    var soundEnabled by remember { mutableStateOf(true) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Sound Settings",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            Switch(
                checked = soundEnabled,
                onCheckedChange = { newValue -> soundEnabled = newValue },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Enable Sound",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoundSettingsPreview() {
    FeatherAndroidTasksTheme {
        SoundSettingsContent()
    }
}

