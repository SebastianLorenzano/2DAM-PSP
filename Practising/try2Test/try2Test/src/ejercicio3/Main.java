package ejercicio3;

public class Main
{
    public static void main(String[] args)
    {

        Jugador j1 = new Jugador("Jugador 1");
        Jugador j2 = new Jugador("Jugador 2");
        Jugador j3 = new Jugador("Jugador 3");

        Object monitor1 = new Object();
        j1.setMonitor(monitor1);
        j2.setMonitor(monitor1);
        j3.setMonitor(monitor1);

        j1.setJugadorSiguiente(j2);
        j2.setJugadorSiguiente(j3);
        j3.setJugadorSiguiente(j1);

        j1.setPelota(new Pelota());

        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        Thread t3 = new Thread(j3);
        t1.start();
        t2.start();
        t3.start();
    }

}
