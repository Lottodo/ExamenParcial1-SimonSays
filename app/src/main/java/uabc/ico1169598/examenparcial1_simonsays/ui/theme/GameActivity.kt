package uabc.ico1169598.examenparcial1_simonsays.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uabc.ico1169598.examenparcial1_simonsays.R
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
        }

        GameButtons4()//true)

        Spacer(modifier = Modifier.height(0.dp))
    }
}

@Composable
fun GameButtons4(){//playing4or6: Boolean) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = R.drawable.red),
            contentDescription = stringResource(id = R.string.button1),
            modifier = Modifier.clickable {
                /* TODO */
            }
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.blue),
                contentDescription = stringResource(id = R.string.button2),
                modifier = Modifier.clickable {
                    /* TODO */
                }
            )
            Image(
                painter = painterResource(id = R.drawable.green),
                contentDescription = stringResource(id = R.string.button3),
                modifier = Modifier.clickable {
                    /* TODO */
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.pink),
            contentDescription = stringResource(id = R.string.button4),
            modifier = Modifier.clickable {
                /* TODO */
            }
        )
    }
}