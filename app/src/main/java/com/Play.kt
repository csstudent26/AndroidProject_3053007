package com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ui.theme.OCT24ProvisionalTheme
import androidx.compose.foundation.layout.fillMaxSize


import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient

class Play : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OCT24ProvisionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    OCT24ProvisionalTheme {
        Greeting3("Android")
    }
}
@Composable
fun PlayScreen() {
    val gifUrl = "https://media.tenor.com/5En-9o6PM6UAAAAC/dice.gif" // Replace with your GIF URL

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