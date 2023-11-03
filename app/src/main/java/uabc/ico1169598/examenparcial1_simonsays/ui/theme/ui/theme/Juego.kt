package uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme

import android.util.Log
import java.util.Random

class Juego(ijugador: String, icantidadBotones: Boolean) {

    var jugador: String = ""
    val noSecuencia: Int = 1
    var secuenciaActual: ColaSimple<Int>
    val cantidadBotones: Boolean
    //Rojo Verde Azul Rosa - Cafe Amarillo

    init {
        jugador = ijugador
        cantidadBotones = icantidadBotones
        secuenciaActual = ColaSimple(1)
    }

    fun darSecuenciaSegunLaRonda(ronda: Int): ColaSimple<Int> {
        val secuencia = ColaSimple<Int>(ronda)
        secuenciaActual = secuencia
        for (i in 0..ronda) {
            secuencia.add((1 until 4).random())
        }
        return secuencia
    }

    fun compararInput(input: Int): Boolean {
        val cierto: Boolean = secuenciaActual.erase() == input

        if (secuenciaActual.isEmpty) {
            Log.d("Juego", "Secuencia vacia")
        }

        return cierto
    }

}