package uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme

class Juego(ijugador: String, icantidadBotones: Boolean) {

    var jugador: String = ""
    val noSecuencia: Int = 1
    val secuenciaActual: ColaSimple<Int>
    val cantidadBotones: Boolean
    //Rojo Verde Azul Rosa - Cafe Amarillo

    init {
        jugador = ijugador
        cantidadBotones = icantidadBotones
        secuenciaActual = ColaSimple(1)
    }

    fun IniciarJuego() {

    }


}