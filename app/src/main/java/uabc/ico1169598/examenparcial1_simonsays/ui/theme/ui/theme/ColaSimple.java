package uabc.ico1169598.examenparcial1_simonsays.ui.theme.ui.theme;

public class ColaSimple<T>{

    int inicio;
    int fin;
    int max;
    T[] cola;

    public ColaSimple(int max)
    {
        inicio =-1;
        fin =-1;
        this.max=max;
        cola = (T[]) new Object[max];
    }

    public void add(T dato)
    {
        if(fin<max-1)
        {
            fin++;
            cola[fin]=dato;
            if(fin==0)
                inicio=0;
        }
        else
            System.out.print("Desbordamiento");
    }

    public T erase()
    {
        T dato = null;
        if(inicio!=-1)
        {
            dato = cola[inicio];
            if(inicio==fin)
            {
                inicio=-1;
                fin=-1;
            }
            else
                inicio++;
        }
        else
            System.out.print("Subdesbordamiento");
        return dato;
    }

    public T peek()
    {
        T dato = cola[fin];
        return dato;
    }

    public boolean isFull()
    {
        return !(fin<max-1);
    }

    public boolean isEmpty()
    {
        return inicio==-1;
    }

    public int size()
    {
        return cola.length;
    }

    public ColaSimple<T> clone()
    {
        ColaSimple<T> colaClon = new ColaSimple<T>(max);
        colaClon.inicio = inicio;
        colaClon.fin = fin;
        colaClon.cola = cola;
        return colaClon;
    }

}