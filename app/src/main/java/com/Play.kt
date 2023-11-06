package com

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oct24provisional.HomeScreen
import com.example.oct24provisional.MainActivity
import com.ui.theme.OCT24ProvisionalTheme

class Play : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.example.oct24provisional.ui.theme.OCT24ProvisionalTheme {
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
                        // Greeting("Android")
                        //   HomeScreen()
                        Spacer(modifier = Modifier.height(16.dp))
                        // Button to navigate to Options
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Options
                                val intent = Intent(this@Play, MainActivity::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Go to Home")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // Button to navigate to Options
                        Button(
                            onClick = {
                                // Create an Intent to navigate to Options
                                val intent = Intent(this@Play, Options::class.java)
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
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello  This is $name!",
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