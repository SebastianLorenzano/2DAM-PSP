package ejercicio3;

public class Jugador implements Runnable
{

    Pelota pelota;
    String nombre;
    Object monitor;
    Jugador jugadorSiguiente;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
    }

    public void setMonitor(Object obj)
    {
        monitor = obj;
    }

    public void setJugadorSiguiente(Jugador jugador)
    {
        jugadorSiguiente = jugador;
    }

    public void setPelota(Pelota pelota)
    {
        this.pelota = pelota;
    }

    public Pelota getPelota()
    {
        return pelota;
    }
    @Override
    public void run()
    {
        while(true) {
            while (pelota == null)
            {
                synchronized (monitor) {
                    try
                    {

                        monitor.wait(); // cambiar monitor


                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println(nombre + ": " + pelota.toString());
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            synchronized (monitor)
            {
                System.out.println("Pepe");
                jugadorSiguiente.setPelota(pelota);
                setPelota(null);
                monitor.notify();
            }
        }
    }
}
