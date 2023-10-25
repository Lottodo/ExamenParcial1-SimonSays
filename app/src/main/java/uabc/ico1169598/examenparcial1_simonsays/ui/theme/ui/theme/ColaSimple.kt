package uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme
/**
 *
 * @author carlo
 */
class ColaSimple<T>(max: Int) {
    var inicio: Int
    var fin: Int
    var max: Int
    var cola: Array<T?>

    init {
        inicio = -1
        fin = -1
        this.max = max
        cola = arrayOfNulls<Any>(max) as Array<T?>
    }

    fun add(dato: T) {
        if (fin < max - 1) {
            fin++
            cola[fin] = dato
            if (fin == 0) inicio = 0
        } else print("Desbordamiento")
    }

    fun erase(): T? {
        var dato: T? = null
        if (inicio != -1) {
            dato = cola[inicio]
            if (inicio == fin) {
                inicio = -1
                fin = -1
            } else inicio++
        } else print("Subdesbordamiento")
        return dato
    }

    fun peek(): T? {
        return cola[fin]
    }

    val isFull: Boolean
        get() = fin >= max - 1
    val isEmpty: Boolean
        get() = inicio == -1

    fun size(): Int {
        return cola.size
    }
}