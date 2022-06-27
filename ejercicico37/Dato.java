public class Dato
{
    private int dato;

    public Dato()
    {
        this ( 0 );
    }

    public Dato (int valor)
    {
        setDato(valor);
    }

    public void setDato(int item)
    {
        dato = ( item >= 0 ) ? item: 0;
    }

    public int getDato ( )
    {
        return dato;
    }
}