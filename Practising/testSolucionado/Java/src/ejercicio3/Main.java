package ejercicio3;

public class Main {

    public static void main(String[] args) {


        Object monitor1 = new Object();
        Object monitor2 = new Object();
        Object monitor3 = new Object();

        Jugador j1 = new Jugador("Jugador 1");
        j1.setMonitorAnterior(monitor3);
        j1.setMonitorSiguiente(monitor1);
        Jugador j2 = new Jugador("Jugador 2");
        j2.setMonitorAnterior(monitor1);
        j2.setMonitorSiguiente(monitor2);
        Jugador j3 = new Jugador("Jugador 3");
        j3.setMonitorAnterior(monitor2);
        j3.setMonitorSiguiente(monitor3);


        Pelota p = new Pelota();

        j1.setSiguienteJugador(j2);
        j2.setSiguienteJugador(j3);
        j3.setSiguienteJugador(j1);

        j1.recibePelota(p);

        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        Thread t3 = new Thread(j3);

        t1.start();
        t2.start();
        t3.start();

    }
}
