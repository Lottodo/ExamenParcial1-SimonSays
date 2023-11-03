package uabc.ico1169598.examenparcial1_simonsays.ui.theme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.ExamenParcial1SimonSaysTheme
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.Juego
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.ColaSimple


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
                    GameUI(juego,
                        onLoose = {
                            //game over
                            this.finish()
                        })
                }
            }
        }
    }
}

fun ColaSimpleALista(cola: ColaSimple<Int>): IntArray {
    val lista = IntArray(cola.size())
    for (i in 0..cola.size()) {
        if (cola.isEmpty) break
        lista[i] = cola.erase()!!
    }
    return lista
}


fun ImprimirListaEnLog (lista: IntArray){
    for (i in 0 until lista.size){
        Log.d("Lista",lista[i].toString())
    }
}

suspend fun DelayFun(timeL: Long) {
    delay(timeL)
}


@Composable
fun GameUI(juego: Juego, onLoose: () -> Unit){//juego: Juego) {

    val openAlertDialog = remember { mutableStateOf(true) }

    val cola: ColaSimple<Int> by remember { mutableStateOf(juego.darSecuenciaSegunLaRonda(4)) }
    var sequenceStarted by remember { mutableStateOf(false) }
    var sequence: IntArray by remember { mutableStateOf(intArrayOf(1, 2, 3, 4)) }
    //val sequence = ColaSimpleALista(cola) // Your sequence
    //ImprimirListaEnLog(sequence)

    val buttonTime = 1000L // Time to wait between each button



    val paddingList = List(5) { mutableStateOf(50.dp) } // Initial padding for all buttons
    val coroutineScope = rememberCoroutineScope()
    var currentButton by remember { mutableStateOf(0) }

    sequence.forEach { index ->
        val transition = updateTransition(targetState = currentButton == index, label = "")
        val padding by transition.animateDp(
            transitionSpec = { tween(durationMillis = 250) },
            label = ""
        ) { if (it) 30.dp else 50.dp }
        paddingList[index - 1].value = padding
    }

    /*var timeLeft by remember { mutableStateOf(5) }
    LaunchedEffect(key1 = timeLeft) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
    }*/

    /*if(timeLeft==0){
        //game over
        timeLeft-1
        AlertDialogExample(
            onDismissRequest = { openAlertDialog.value = false },
            onConfirmation = {
                openAlertDialog.value = false
                onLoose
            },
            dialogTitle = "Title",
            dialogText = "Text",
            icon = Icons.Default.Clear
        )
    }*/

    if (!sequenceStarted) {

        sequence = ColaSimpleALista(cola)
        Log.d("Cola",cola.toString())
        val sequenceAux = ColaSimpleALista(cola)
        sequenceStarted = !sequenceStarted
        MinimalDialog(onDismissRequest = {
            openAlertDialog.value = false
            coroutineScope.launch {
                sequence.forEach { index ->
                    currentButton = index
                    delay(buttonTime)
                }
                currentButton = -1 // Reset the state after the sequence
            }
                                         },
            texto = "Level "+juego.noSecuencia.toString())

//        LaunchedEffect(key1 = coroutineScope) {
//            sequenceAux.forEach { index ->
//                currentButton = index
//                DelayFun(buttonTime)
//            }
//            currentButton = -1 // Reset the state after the sequence
//        }
    }
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
            /*Text(text = timeLeft.toString())*/
        }

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ){
            Button(
                onClick = {
                    /*coroutineScope.launch {
                        sequence.forEach { index ->
                            currentButton = index
                            delay(buttonTime)
                        }
                        currentButton = -1 // Reset the state after the sequence
                    }*/
                    Log.d("Cola", "Pressed :1. Cola:"+juego.secuenciaActual.toString()+". Peek:"+cola.peek())
                          if (!juego.compararInput(1)) {

                              onLoose()
                          }
                          },
                modifier= Modifier
                    .size(paddingList[0].value)
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
                    onClick = {
                        Log.d("Cola", "Pressed :2. Cola:"+juego.secuenciaActual.toString()+". Peek:"+juego.secuenciaActual.peek())
                        if (!juego.compararInput(2)) {

                            onLoose()
                        }
                    },
                    modifier= Modifier
                        .size(paddingList[1].value)
                        .bounceClick(),
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Blue)
                ) {

                }
                Button(
                    onClick = {
                        Log.d("Cola", "Pressed :3. Cola:"+juego.secuenciaActual.toString()+". Peek:"+juego.secuenciaActual.peek())
                        if (!juego.compararInput(3)) {

                            onLoose()
                        }
                    },
                    modifier= Modifier
                        .size(paddingList[2].value)
                        .bounceClick(),
                    shape = CircleShape,
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
                ) {

                }

            }
            Button(
                onClick = {
                    Log.d("Cola", "Pressed :4. Cola:"+juego.secuenciaActual.toString()+". Peek:"+juego.secuenciaActual.peek())
                    if (!juego.compararInput(4)) {

                        onLoose()
                    }
                },
                modifier= Modifier
                    .size(paddingList[3].value)
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
fun MinimalDialog(onDismissRequest: () -> Unit,
                  texto: String) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = texto,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}