package ejercicio3;

public class Jugador implements Runnable {

    private String nombre;
    private Pelota p = null;
    private Jugador siguienteJugador;

    private Object monitorAnterior;
    private Object monitorSiguiente;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public void setMonitorAnterior(Object m1){
        monitorAnterior  = m1;
    }

    public void setMonitorSiguiente(Object m2){
        monitorSiguiente = m2;
    }

    public void setSiguienteJugador(Jugador siguienteJugador){
        this.siguienteJugador = siguienteJugador;
    }
    public void recibePelota(Pelota p){
        this.p = p;
    }

    private void pierdePelota(){
        this.p = null;
    }

    @Override
    public void run() {
        while(true){

            synchronized (monitorAnterior) {
                while (p == null) {
                    try {
                        monitorAnterior.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(nombre+ ": " + p);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (siguienteJugador != null) {
                siguienteJugador.recibePelota(p);
                pierdePelota();
                synchronized (monitorSiguiente) {
                    monitorSiguiente.notify();
                }
            }

        }
    }
}
