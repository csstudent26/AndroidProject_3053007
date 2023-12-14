package com

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
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
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.oct24provisional.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

import kotlin.math.sqrt
import kotlin.random.Random

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.delay




class Play : ComponentActivity() {

    private  lateinit var navController: NavController

  //  var checkBoxCompleted = false
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        setContent {
            OCT24ProvisionalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                  //  PlayScreenCX() // Replace the existing content with PlayScreenCX
                    GameScreen2()
                }


                }
            }//End of setContent
        }//End of Create
    }//End of Class

@Composable
fun PlayScreenCX() {
    //Creating a Boolean to control screen(if GameInProgress we will have a 'free' screen)
    var isStartAction by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Using the WelcomeScreen to trigger StartAction
        /*   WelcomeScreen(playerName = "John", chosenOption = "Option A") {
            // This lambda is called when the player is ready to play
            // Implement the game start logic here
            isStartAction = true // Set the flag to trigger StartAction

        */
    }
        if (isStartAction) {
            // Show StartAction() when in progress
                StartAction()
        } else
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally



            ) {
                //Welcoming Text
                Text(
                    text = "Ready To Play ?", style = TextStyle(
                        fontSize = 28.sp, fontWeight = FontWeight.Bold
                    ), modifier = Modifier.padding(16.dp)
                )


                //Composable to display animated Giff
                PlayScreen3()

                Spacer(modifier = Modifier.height(30.dp)) // Adjust height as needed


                GameScreen2()

                // Buttons to navigate to  Home and Options inside this Composable
                ButtonSelect()
            }
    }
//Composable to create a CheckBox
// for users choice of Number of Rounds
@Composable
fun CheckBox1(){

    var isChecked by remember {mutableStateOf(false)}
    Column() {
        Text(text = "Inside CheckBox!")
        Checkbox(checked = isChecked,
            onCheckedChange = { isChecked = it })
        var checkBoxCompletedX = isChecked
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen2X() {
    var playerName by remember { mutableStateOf("") }
    var isLoggingIn by remember { mutableStateOf(false) }
    var gameStarted by remember { mutableStateOf(false) } // New flag to track game start


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoggingIn) {
            var enteredName by remember { mutableStateOf("") }

            TextField(
                value = enteredName,
                onValueChange = { enteredName = it },
                label = { Text("Enter your name") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    if (enteredName.isNotBlank()) {
                        playerName = enteredName
                        // Trigger the game start with entered name
                        // Call a function here to start the game with playerName
                        // onGameStart(playerName)
                    }
                    isLoggingIn = false
                })
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (enteredName.isNotBlank()) {
                    playerName = enteredName
                    // Trigger the game start with entered name
                    // Call a function here to start the game with playerName
                    // onGameStart(playerName), or some such function
                }
                isLoggingIn = false
            }) {
                Text("Submit")
            }
        } else {
            Text("Choose a name to play:")
            Spacer(modifier = Modifier.height(8.dp))

            //List of Names (predefined).Can always be changed
            listOf("Player 1", "Player 2", "Player 3").forEach { name ->
                Button(
                    onClick = {
                        playerName = name
                        // Start the game with the selected name
                        // Call a function here to start the game with playerName
                        // onGameStart(playerName), or whichever function starts ganme
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(name)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            //Log in Button(needs to be already in data base when program finished)
            // Temporally(when program is been developed) need not be in data base
            Button(onClick = { isLoggingIn = true }) {
                Text("Log in with a custom name")
            }

            if (playerName.isNotEmpty()) {
                // Display the WelcomeScreen if playerName is not empty

                    // This lambda is called when the player is ready to play
                    // Add logic here to start the game
                    // For example: navigate to the game screen or trigger game start function
                    gameStarted = true

            }
            // Conditionally display StartAction based on gameStarted flag
          //  if (gameStarted) {
                StartAction()
          //  }
        }
    }
}

@Composable
fun WelcomeScreenRes(playerName: String, chosenOption: String , onReadyToPlay: () -> Unit // Additional callback parameter
,) {

    val context = LocalContext.current // Obtain the context

    var gameStarted by remember { mutableStateOf(false) }

    if (!gameStarted) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome, $playerName!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text("You chose: $chosenOption", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(32.dp))
            Text("Are you ready to play?", fontSize = 20.sp)

            // Button to start the game
            Button(
                onClick = {
                    // Trigger the game start here
                    // For example, navigate to the game screen or start the game logic
                    // For simplicity, let's navigate to the Play screen
                    // val intent = Intent(context, Play::class.java)
                    // context.startActivity(intent0)
                    onReadyToPlay()
                     // Notify the activity to start the game
                },
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text("Let's Play!")
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
//@Composable
fun throwForHouse(): Int {
    val randomNumber = (1..6).random() // Simulate a random number between 1 and 6
    println("House throws: $randomNumber") // Print the result to the screen
    return randomNumber
}

//@Composable
fun establishUserThrow(context: Context): Int {
    var userThrow = 0

    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    val sensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Not used
        }

        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                // Calculate magnitude of acceleration
                val acceleration = sqrt(x * x + y * y + z * z)

                // Set a threshold value for movement detection
                val threshold = 10 // Adjust this threshold if we want or as needed

                // Explaining the Condition
                if (acceleration > threshold) {
                    // Movement detected, simulate dice throw
                    userThrow = (1..6).random() // Generate a random number between 1 and 6

                    //We must turn off the listener device when finished
                    sensorManager.unregisterListener(this) // Stop listening for further sensor changes
                }
            }
        }
    }

    sensorManager.registerListener(sensorListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)

    return userThrow
}
@Composable
fun GameInProgress(context: Context) {
    //Variable to store House Throw
    var dealerThrow by remember { mutableStateOf(0) }
    //Variable  to store User Throw
    var userThrow by remember { mutableStateOf(0) }
    //Boolean for User Throw(establish if user Ready)
    var readyForUserThrow by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Display dealer's throw
        Text("Dealer's throw:")
        ImageForDice(dealerThrow)

        // Simulate dealer's throw when user is ready
        if (readyForUserThrow && dealerThrow == 0) {
            dealerThrow = throwForHouse() // Simulate dealer's throw
            ImageForDice(dealerThrow)
        }

        // Ask user if they are ready
        if (!readyForUserThrow) {
            Text("Are you ready?")
            Button(onClick = { readyForUserThrow = true }) {
                Text("Yes")
            }
        }

        // Display user's throw after they're ready
        if (readyForUserThrow) {
            Text("Your throw:")
            Button(onClick = { userThrow = establishUserThrow(context) }) {
                Text("Throw Dice")
            }
            //Display User Throw Dice
            ImageForDice(userThrow)
        }
    }
}

@Composable
fun StartAction(){

    val backgroundColor = Color.LightGray
    var houseThrow by remember { mutableStateOf(0) } // State to hold the house's throw result
    var userThrow by remember { mutableStateOf(0) } // State to hold the user's throw result
    var context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        // Your content for the dice game can go here
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "House's Throw: $houseThrow",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "User's Throw: $userThrow",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = {

                    // Simulate throws for both house and user
                    houseThrow = throwForHouse()
                    userThrow = establishUserThrow(context)
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Throw Dice")
            }
        }
    }

}
//Adding an additional for the main method. This is an Important Start Composable(Tested inExp Prog)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen2() {
    // A variable to store name of user( it is a 'var' and hence can change )
    var playerName by remember { mutableStateOf("") }

    // Two booleans with which we can control the 'if' conditions
    // By controlling the 'if' conditions we can control program flow
    var isLoggingIn by remember { mutableStateOf(false) }
    var shouldRunLooking by remember { mutableStateOf(false) } // Condition to run Looking()
    var roundsSelected by remember { mutableStateOf(false) } // Condition to run Looking()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // This is condition (1)
        // When this condition becomes 'true', the 'UserDiceThrows()' runs, and the game has started
        if (shouldRunLooking) {
            //  DiceGameVG()
            UserDiceThrows()

        // This is the condition (2). Only after a name has been chosen , is it 'true'
        } else {
            //After a name is chosen, the name is used to welcome the Player
            if (playerName.isNotEmpty()) {
                // Display the WelcomeScreen if playerName is not empty ( name is chosen).
                WelcomeScreen(
                    playerName = playerName,
                    onRoundsSelected = {  roundsSelected = true },
                    onReadyToPlay = { shouldRunLooking = true }
                ) /*{
                    // This lambda sets the 'shouldRunLooking() to 'true'


                }*/
          // This is condition (3) . It is where we start interaction ( and action)
            // After 'isLoggingIn' is set to 'true' the names chosen will be remembered.
            // Clicking on any button ( Player1, Player2, Player3, or 'Log in with a Custom name',
            // will set 'isLogginIn' to 'true'
        } else {

                // Login UI
                if (isLoggingIn) {
                    var enteredName by remember { mutableStateOf("") }

                    TextField(
                        value = enteredName,
                        onValueChange = { enteredName = it },
                        label = { Text("Enter your name") },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            if (enteredName.isNotBlank()) {
                                playerName = enteredName
                                isLoggingIn = false
                            }
                        })
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        if (enteredName.isNotBlank()) {
                            playerName = enteredName
                            isLoggingIn = false
                        }
                    }) {
                        Text("Submit")
                    }
                } else {
                    Text("Choose a name to play:")
                    Spacer(modifier = Modifier.height(8.dp))

                    // Sets 'isLogginIn' to 'true; when clicked
                    listOf("Player 1", "Player 2", "Player 3").forEach { name ->
                        Button(
                            onClick = {
                                playerName = name
                            },
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            Text(name)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Button  Sets 'isLogginIn' to true when clicked
                    Button(onClick = { isLoggingIn = true }) {
                        Text("Log in with a custom name")
                    }
                }
            }
        }
    }
}


@Composable
fun WelcomeScreen(
    playerName: String,
    onRoundsSelected: () -> Unit,// Additional callback parameter, in place of old 'String' parameter
    onReadyToPlay: () -> Unit,

) {

    val context = LocalContext.current // Obtain the context
    var shouldRunLooking by remember { mutableStateOf(false) }
    var roundsSelected by remember { mutableStateOf(true) }







    var gameStarted by remember { mutableStateOf(false) }
    var checkBoxCompleted  by remember { mutableStateOf(false) }


    if (!gameStarted) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Has coma only at end of sequence
            //Setting Text Alignment(Horizontal), Arrangement(Vertical)
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome, $playerName!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))


                if (!checkBoxCompleted){

                    var isChecked by remember {mutableStateOf(false)}

                    Checkbox(checked = isChecked,
                        onCheckedChange = { isChecked = it })
                    checkBoxCompleted = isChecked
                }
                    else {
                     // Setting Inner Column01
                    Column( modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        //Setting Text Alignment(Horizontal), Arrangement(Vertical)
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

                        Text("Are you ready to play?", fontSize = 20.sp)

                        // Button to start the game
                        Button(
                            onClick = {
                                // Trigger the game start here ( by enabling 'UserDiceThrows() )

                                onReadyToPlay()//PlaceHolder for 'UserDiceThrows()

                                // Notify the activity to start the game
                            },
                            modifier = Modifier.padding(vertical = 16.dp)
                        ) {
                            Text("Let's Play!")
                        }
                    }//End of inner Column01
                }





        }
    }
}



//Composable added from auxillary(Nov02) Test Project
@Composable
fun UserDiceThrows() {
      //SoundPlayer01()
          var context = LocalContext.current

    val navController : NavHostController = rememberNavController()

    var alpha by remember { mutableStateOf(false) }
    var beta by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(true) }
    var alternator by remember { mutableStateOf(true) }
    var alternator2 by remember { mutableStateOf(false) }
    var alternator3 by remember { mutableStateOf(false) }




    var userDiceValue1 by remember { mutableStateOf(1) }
    var userDiceValue2 by remember { mutableStateOf(1) }
    var userScore by remember { mutableStateOf(0) }
    var isPlayerScoreFinal by remember { mutableStateOf(false) } // Flag to indicate if the score is final

    var dealerDiceValue1 by remember { mutableStateOf(1) }
    var dealerDiceValue2 by remember { mutableStateOf(1) }
    var dealerScore by remember { mutableStateOf(0) }
    var isDealerScoreFinal by remember { mutableStateOf(false) } // Flag to indicate if the score is final

    //Boolean to control Dealers Throw
    var isDealersTurn by remember { mutableStateOf(false) }


    // Function to determine the winner based on scores
    fun determineWinner(): String {

          //  userScore = userDiceValue1 + userDiceValue2
          //  dealerScore = dealerDiceValue1 + dealerDiceValue2

        return when{

            userScore > dealerScore -> " You Win!"
            dealerScore > userScore  -> " Dealer Wins!"
            else -> " Its a Tie"
        }

    }





    var isUserFirstDiceThrow by remember { mutableStateOf(false) }
    var isUserSecondDiceThrow by remember { mutableStateOf(false) }

    var isDealerFirstDiceThrow by remember { mutableStateOf(false) }
    var isDealerSecondDiceThrow by remember { mutableStateOf(false) }

    fun isGameFinished(): Boolean{

        return isUserFirstDiceThrow && isUserSecondDiceThrow && isDealerSecondDiceThrow && isDealerFirstDiceThrow

    }

    //Function that we put inside ' DiceThrowOnMovement(-p-) ' to use the Accelerometer
    val onUserDiceThrown: () -> Unit = {

        //if the score of the Player is still not final, we can continue using this function
        if (!isPlayerScoreFinal) {
            //If the user has not already thrown, we now throw the first dice
            if (!isUserFirstDiceThrow) {
                // we now assign a value to the first user Dice
                userDiceValue1 = (1..6).random()

                //The user has now had first throw, so we change value of boolean
                isUserFirstDiceThrow = true
                //If the user has not already thrown second dice, we now throw the second dice
                // NOTE: we need alpha set to true after the first dealer throw
            } else if (!isUserSecondDiceThrow && alpha) {
                //We assign value to users second dice
                userDiceValue2 = (1..6).random()
                //change value of boolean, as user has thrown second dice
                isUserSecondDiceThrow = true
                //Add the value of the two die(dice) together to get users score
                userScore = userDiceValue1 + userDiceValue2
            }

        }
    }

    //Function for the Dealers Throws
    val onDealerDiceThrown: () -> Unit = {
        //Declare a variable to store the random value(employs the 'Ramdom Class' each time)
        val random = Random.nextInt(1, 7)

        //If the dealers score is not yet final, we can use this funcction every time dealer has a turn
        if (!isDealerScoreFinal) {

            // If dealer has not yet thrown
            if (!isDealerFirstDiceThrow) {
                //Assign valye to dealers first dice
                dealerDiceValue1 = random
                isDealerFirstDiceThrow =
                    true // change value of boolean( as dealer has had first throw)
                // If the dealer has not thrown a second time (we now can)
            } else if (!isDealerSecondDiceThrow) {
                // assign a value to dealers second dice
                dealerDiceValue2 = random
                isDealerSecondDiceThrow = true// change value of boolean
                //Adding the dealers throws
                dealerScore = dealerDiceValue1 + dealerDiceValue2
            }

        }
    }


// Composable to detect movement and trigger dice throw for the user

    DiceThrowOnMovement(onDiceThrown = onUserDiceThrown)


    // (MAIN COLUMN: divides Page in sections )  UI elements for displaying All Dice Images and Text ( score etc.)
    Column(
        modifier = Modifier
            .fillMaxSize()
            // verticalArrangement = Arrangement.Center,
            // horizontalAlignment = Alignment.CenterHorizontally
            .background(color = androidx.compose.ui.graphics.Color.Green) // Setting the light green background
            .border(1.dp, androidx.compose.ui.graphics.Color.Red) // Applying a red border
    ) {
        //Column 01 For Image Display
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = Color.Green) // Setting the light green background
                .border(1.dp, Color.Red), // Applying a red border
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color = Color.Green)
                    .border(1.dp, Color.Red),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                //At Left/Centre of Top of Page
                // STEP 01 : User's Dice 1 is Displayed before any Dice are Thrown
                if (!isUserFirstDiceThrow) {
                    ImageForDice(value = 1)//Image of Dice displayed

                    // STEP 02: User Dice 1 is Thrown and Result Displayed
                } else if (isUserFirstDiceThrow) {
                    ImageForDice(value = userDiceValue1)// Image is updated to reflect value of throw

                    alternator2 = true
                    // A Time delay to avoid two actions on UI Simultaneously
                    GlobalScope.launch {
                        delay(1000) // Delay for 1 second

                        // Boolean to Control dealer's Throw is set to 'true'
                        isDealersTurn = true
                    }


                    //User must wait until alpha is set to 'true'( happens after dealers first throw)
                    if (isUserSecondDiceThrow && alpha) {

                     //   SoundPlayer022(R.raw.rool_dice)


                        ImageForDice(value = userDiceValue2)
                        beta = true
                    }


                }

            }
        }//End of Column 01

        // Space between user's and dealer's dice
        Spacer(modifier = Modifier
            .height(24.dp)
            .fillMaxWidth()
            .background(Color.White))

        // Column 02 :
        // Column for Dealer's Dice Display
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = Color.Blue)
                .border(1.dp, Color.Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Dealer's dice
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color = Color.Blue)
                    .border(1.dp, Color.Yellow),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // ImageForDice(value = dealerDiceValue1)
                if (!isDealerFirstDiceThrow) {

                    ImageForDice(value = 1)
                    Spacer(modifier = Modifier.width(16.dp))
                    //  ImageForDice(value = dealerDiceValue2)
                } else {
                    ImageForDice(value = dealerDiceValue1)

                }
                if (isDealerSecondDiceThrow && beta) {

                    ImageForDice(value = dealerDiceValue2)
                }


            }//End of  Dealer  Row Scope
        }
            //Column 03 : For Text Display
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    // verticalArrangement = Arrangement.Center,
                    // horizontalAlignment = Alignment.CenterHorizontally
                    .background(color = Color.White) // Setting the light green background
                    .border(1.dp, Color.Red) // Applying a red border
            ) {
                // Prompt for the user to roll the dice
                //  Text("Roll Die Please!", fontSize = 24.sp,)
                //  if (!isDealersTurn) {
                // Text("Roll Die Please!", fontSize = 24.sp)
                //  }
                if (alternator) {
                    Text("Roll Die Please!", fontSize = 24.sp,)
                    SoundPlayer022(R.raw.shake_phone)
                    alternator = false
                  //  alternator2 = true
                } else {
                    // Column TX
                    Column{




                        if(isGameFinished()){



                            Text(" Your Score $userScore",
                                fontSize = 24.sp, )

                            Text(" Dealer's $dealerScore",
                                fontSize = 24.sp )
                            val winner = determineWinner()
                            Text(" $winner")

                            if(winner == " You Win!"){
                                SoundPlayer022(R.raw.you_won)
                            }else if(winner == " Dealer Wins!"){
                                SoundPlayer022(R.raw.the_dealer)
                            }else if(winner == " Its a Tie" ) {
                                SoundPlayer022(R.raw.tie)

                            }
                            }
                         /*   Button(onClick = {

                                navController.navigate(" WelcomeScreen ")
                                alternator2 = false
                                alpha = true

                            },
                                modifier = Modifier.padding(16.dp)


                            )    {Text(" ReplayX")

                            }*/// End of Button Content

                            Button(
                                onClick = {
                                    val intent = Intent( context,MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                                    context.startActivity(intent)
                                }
                            ) {
                                Text("Replay")
                            }
                        }


                    }// End of Column TX

                 }//End of else statement
                if(alternator2){

                    SoundPlayer022(R.raw.dealer_and_playergit diff)

                    Button(onClick = {

                        onDealerDiceThrown()
                        alternator2 = false
                        alpha = true


                    },
                       modifier = Modifier.padding(16.dp)


                    )    {Text(" LetDealerThrow")

                    }// End of Button Content



                }//End of if statement
                if(isDealerSecondDiceThrow){
                    alternator2 = false
                }


    }// End of  Column 03 For Text Display

    }// End of Maim Column
//End of Metho

//Composable to Detect Movement From Auxillary Project. ( almost exact same as existing Composable to detect movement
@Composable
fun DiceThrowOnMovement(onDiceThrown: () -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val sensorManager =
        remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val accelerometer = remember { sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) }

    val sensorListener = remember {
        object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Not used
            }

            override fun onSensorChanged(event: SensorEvent?) {
                if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
                    val x = event.values[0]
                    val y = event.values[1]
                    val z = event.values[2]

                    // Calculate magnitude of acceleration
                    val acceleration = sqrt(x * x + y * y + z * z)

                    // Set a threshold value for movement detection
                    val threshold = 16 // Adjust this threshold as needed

                    if (acceleration > threshold) {
                        // Movement detected, trigger the action (simulate dice throw)
                        //NOTE:if we comment out this line, our UI will remain Static
                        onDiceThrown.invoke()

                    }
                }
            }
        }
    }

    // Register the sensor listener when the composable is active
    androidx.compose.runtime.SideEffect {
        sensorManager.registerListener(
            sensorListener,
            accelerometer,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    // Unregister the sensor listener when the composable is removed or inactive
    androidx.compose.runtime.SideEffect {
        val lifecycleObserver = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_DESTROY) {
                sensorManager.unregisterListener(sensorListener)
            }
        }
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
    }
}



@Composable
fun SoundPlayer022(soundId: Int) {
    val context = LocalContext.current

    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, soundId)
        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
        }

        onDispose {
            mediaPlayer.release()
        }
    }
}

