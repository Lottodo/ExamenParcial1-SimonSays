package uabc.ico1169598.examenparcial1_simonsays.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.ExamenParcial1SimonSaysTheme
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.Juego


class GameActivity : ComponentActivity() {

//waos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val juego = Juego("Test",false)

        setContent {
            ExamenParcial1SimonSaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameUI()//juego)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameUI(){//juego: Juego) {

    var timeLeft by remember { mutableStateOf(60) }
    LaunchedEffect(key1 = timeLeft) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }

    val array = intArrayOf(1, 2, 3, 4, 1)


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(10.dp))
            Text("Test",fontSize=20.sp)//juego.jugador)
            Text("LEVEL 1",fontSize=30.sp)//+juego.noSecuencia)
            Text(text = timeLeft.toString())
        }

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier= Modifier
                    .size(100.dp)
                    .bounceClick(),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Red)
            ) {

            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxHeight()

            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier= Modifier
                        .size(100.dp)
                        .bounceClick(),
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue)
                ) {

                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier= Modifier
                        .size(100.dp)
                        .bounceClick(),
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
                ) {

                }

            }
            Button(
                onClick = { /*TODO*/ },
                modifier= Modifier
                    .size(100.dp)
                    .bounceClick(),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Cyan)
            ) {

            }
        }

        Spacer(modifier = Modifier.height(0.dp))

    }
}

@Composable
fun GameButtons4(){//playing4or6: Boolean) {
    var switch by remember {
        mutableStateOf(false)
    }
    val bgColor1: Color by animateColorAsState(
        if (switch) Color.Red else Color(0xFFFF7D7D),
        animationSpec = tween(200, easing = LinearEasing)
    )
    val bgColor2: Color by animateColorAsState(
        if (switch) Color.Blue else Color(0xFF7D7DFF),
        animationSpec = tween(200, easing = LinearEasing)
    )




}

enum class ButtonState { Pressed, Idle }
fun Modifier.bounceClick() = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(if (buttonState == ButtonState.Pressed) 0.70f else 1f)

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { }
        )
        .pointerInput(buttonState) {
            awaitPointerEventScope {
                buttonState = if (buttonState == ButtonState.Pressed) {
                    waitForUpOrCancellation()
                    ButtonState.Idle
                } else {
                    awaitFirstDown(false)
                    ButtonState.Pressed
                }
            }
        }
}

@Composable
fun showSequence(array: IntArray) {
    for (n in array) {
        //waos
    }
    var timeLeft by remember { mutableStateOf(60) }
    LaunchedEffect(key1 = timeLeft) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }
}