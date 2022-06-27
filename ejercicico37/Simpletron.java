import java.util.Scanner;

public class Simpletron
{
    private int acumulador;
    private int [] memoria;
    private int registrar;
    private int contar;
    private int codigOperacion;
    private int operador;

    public Simpletron()
    {
        mensajeBienvenida();
        inicializarVariable();
    }

    public void mensajeBienvenida()
    {
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s %s\n%s %s\n",
                "*** Bienvenido a Simpletron! ***",
                "*** Por favor, introduzca en su programa una instruccion    ***",
                "*** (o palabra de datos) a la vez. Yo le mostrare           ***",
                "*** el numero de ubicacion y un signo de interrogacion (?)  ***",
                "*** Entonces usted escribira la palabra para esa ubicacion. ***",
                "*** Teclee -9999 para dejar de introducir su programa       ***",
                " Loc", "Inst", "****", "****");
    }

    public void runSimulador()
    {
        int instruccionEnviada =0;
        int punteroMemoria =0;

        Scanner input= new Scanner( System.in );

        do
        {
            System.out.printf ("%d %s ", punteroMemoria, "?");
            instruccionEnviada = input.nextInt();
            if( instruccionEnviada != -9999 )
                    memoria [ punteroMemoria ] = instruccionEnviada;
                    punteroMemoria++;

        }while ( instruccionEnviada != -9999);

            System.out.printf ("\n%s%s", "*** Se completo la carga del programa ***\n",
                                     "*** Empieza la ejecucion del programa ***\n");

        for ( int codigo : memoria )
        {
            if ( codigo != 0 )
            {
                carga();
                ejecutar( operador, codigOperacion );
            }
        }          
    }

    public void inicializarVariable()
    {
        memoria = new int[100];
        contar = 0;
    }
    public void carga()
    {
        codigOperacion = memoria [ contar ]/100;
        operador = memoria [ contar ]%100;

    }

    public void ejecutar(int operadores, int operacion)
    {
        switch ( operacion )
        {
            case 10:
                    Scanner input = new Scanner( System.in );
                    System.out.print("Ingrese un numero entero (positivo o negativo): ");
                    memoria[ operadores ] = input.nextInt();
                    break;
            case 11:
                    System.out.println("El resultado de la operacion es"+memoria [operadores]);
                    break;
            case 20:
                    acumulador = memoria[operadores];
                    break;
            case 21: 
                    memoria [operadores] = acumulador;
                    break;
            case 30:
                    acumulador += memoria[operadores];
                    break;
            case 31: 
                    acumulador -= memoria[operadores];
                    break;
            case 32:
                    acumulador /= memoria[operadores];
                    break;
            case 33:
                    acumulador *= memoria[operadores];
                    break;
            case 40:
                    contar = operadores;
                    break;
            case 41:
                    if (acumulador < 0)
                    contar = operadores;
                    break;
            case 42: 
                    if (acumulador == 0)
                    contar = operadores;
                    break;
            case 43: 
                    dumpTheCore ();
                    System.out.printf ("\n%s\n","El programa a terminado...");
                    System.exit(0);
                    break;
        }
        contar++;
    }

    public void dumpTheCore()
    {
        System.out.printf("\n%30s\n%30s\t%s%4d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n\n%30s\n", "REGISTROS:",
        "acumulador", "+",acumulador,"Contador de instrucciones ",contar,"Registro de instrucciones",contar,
        "codigo de operacion", codigOperacion,"operando", operador, "MEMORIA:" );

        for(int i=0; i<10; i++)
        {
            System.out.printf("%6d",i);
        }
        System.out.println();
        int counter = 0;

        for(int i=0; i<10; i++ )
        {
            if (counter %10 == 0)
                System.out.printf("%2d ",counter);
            for ( int j=0; j<10; j++)
            {
                if (memoria[counter] == 0)
                    System.out.printf("%s%s","+","0000 ");
                else
                    System.out.printf("%s%4d ", "+", memoria[counter]);    
                    counter++;
            }    
            System.out.println();
        }
    }
}