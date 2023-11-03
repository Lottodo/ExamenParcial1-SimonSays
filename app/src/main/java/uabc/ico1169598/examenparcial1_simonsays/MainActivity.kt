package uabc.ico1169598.examenparcial1_simonsays

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raywenderlich.android.favenimate.AnimatedFavButton
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.ExamenParcial1SimonSaysTheme
import uabc.ico1169598.examenparcial1_simonsays.ui.theme.GameActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.MODE_NIGHT_NO

        setContent {
            ExamenParcial1SimonSaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuUI(
                        navigateToSecondActivity = {
                                executeExplicitIntent()
                        }
                    )
                }
            }
        }
    }

    fun executeExplicitIntent() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

}

@Preview(showBackground = true)
@Composable
fun MenuUI(
    navigateToSecondActivity: () -> Unit = {}
) {
    val activity = (LocalContext.current as? Activity)

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Top
    ) { SwitchTheme() }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.simon_logo),
                contentDescription = stringResource(id = R.string.logo)
            )

            //Jugar
            NavigateToSecondActivityButton(
                navigateToSecondActivity = navigateToSecondActivity
            )
            /*OutlinedButton(onClick = {
                /*TODO*/
            }) {
                Text("PLAY", fontSize = 40.sp)
            }*/
            Spacer(modifier = Modifier.height(10.dp))
            //Puntuaciones
            ElevatedButton(
                onClick = { /*TODO*/ }
            ) {
                Text("SCORES", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            //Salir
            ElevatedButton(
                onClick = {
                    activity?.finish();
                    System.exit(0);
                }
            ) {
                Text("EXIT", fontSize = 30.sp)

            }
        }

        Spacer(modifier = Modifier.height(0.dp))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchTheme() {
    /*var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
            if (checked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        },
        thumbContent = if (checked) {
            {
                Icon(
                    painter = painterResource(id = R.drawable.dark_mode_black_24dp),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            {
                Icon(
                    painter = painterResource(id = R.drawable.light_mode_black_24dp),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )*/

    var isDarkTheme by remember { mutableStateOf(true) }

    MyAppTheme(isDarkTheme = isDarkTheme) {
        Scaffold {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 10.dp
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("☀️")
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = {
                        isDarkTheme = it
                    }
                )
                Text("🌘")
            }
        }
    }


}


@Composable
fun SwitchMusic() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}

@Composable
fun OutlinedButtonExample(
    textDisplay: String,
    onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text(textDisplay)
    }
}


@Composable
fun MyAppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme,
        // shapes = ...,
        // typography = ...,
        content = content
    )
}

@Composable
fun NavigateToSecondActivityButton(
    navigateToSecondActivity: () -> Unit = {}
) {
    OutlinedButton(onClick = navigateToSecondActivity) {
        Text("PLAY", fontSize = 40.sp)
    }
}


@Composable
fun HomePage(controller: NavController) {
    val activity = (LocalContext.current as? Activity)
    Button(onClick = {
        activity?.finish()
    }) {
        Text("Exit")
    }
}