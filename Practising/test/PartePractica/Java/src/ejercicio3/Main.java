package ejercicio3;

import java.util.ArrayList;

public class Main
{
    private static ArrayList<Thread> threads = new ArrayList<>();


    public static void main(String[] args)
    {

        Object monitor1 = new Object();
        Object monitor2 = new Object();
        Object monitor3 = new Object();

        Jugador j1 = new Jugador();
        j1.setMonitorAnterior(monitor3);
        j1.setMonitorPosterior(monitor1);
        Jugador j2 = new Jugador();
        j2.setMonitorAnterior(monitor1);
        j2.setMonitorPosterior(monitor2);
        Jugador j3 = new Jugador();
        j3.setMonitorAnterior(monitor2);
        j3.setMonitorPosterior(monitor3);

        j1.addNextPlayer(j2);
        j2.addNextPlayer(j3);
        j3.addNextPlayer(j1);

        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        Thread t3 = new Thread(j3);

        t1.setName("Jugador 1");
        t2.setName("Jugador 2");
        t3.setName("Jugador 3");

        j1.addPelota(new Pelota());
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        for (Thread t : threads)
            t.start();
    }

}
