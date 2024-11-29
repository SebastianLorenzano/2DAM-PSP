package ejercicio3;


public class Jugador implements Runnable
{

    private Pelota pelota;
    private boolean isRunning = true;
    private Jugador nextPlayer;
    private Object monitorAnterior;
    private Object monitorPosterior;

    public void setMonitorAnterior(Object object) {
        monitorAnterior = object;
    }

    public void setMonitorPosterior(Object object) {
        monitorPosterior = object;
    }

    public void addNextPlayer(Jugador p) {
        nextPlayer = p;
    }


    public synchronized void addPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    public synchronized Pelota takePelota() {
        Pelota result = this.pelota;
        this.pelota = null;
        return result;
    }

    public void stopPlaying() {
        isRunning = false;
    }


    @Override
    public void run()
    {
        while (isRunning) {
            synchronized (monitorAnterior) {
                while (pelota == null) {
                    try {
                        monitorAnterior.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + pelota.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            nextPlayer.addPelota(this.takePelota());
            synchronized (monitorPosterior) {
                monitorPosterior.notifyAll();
            }
        }
    }
}
