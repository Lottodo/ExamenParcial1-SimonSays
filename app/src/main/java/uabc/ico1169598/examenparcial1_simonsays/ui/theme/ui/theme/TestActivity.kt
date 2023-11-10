package uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import uabc.ico1169598.examenparcial1_simonsays.R
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme.ui.theme.ExamenParcial1SimonSaysTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenParcial1SimonSaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExamenParcial1SimonSaysTheme {
        Greeting("Android")
    }
}

@Composable
fun MediaDevice() {
    val context = LocalContext.current
    val mediaPlayer = MediaPlayer.create(context, R.raw.button1sfx)


}