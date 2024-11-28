import java.util.Random;

public class Consumidor implements Runnable
{
    Random r = new Random();
    private  Contenedor contenedor;
    private boolean isRunning = true;

    public Consumidor(Contenedor contenedor)
    {
        this.contenedor = contenedor;
    }

    public void stopIsRunning()
    {
        isRunning = false;
        contenedor.notifyAll();

    }

    @Override
    public void run() {
        while (isRunning)
        {
            while (contenedor.getNum() <= 5)
            {
                synchronized (contenedor) {
                    try
                    {
                        contenedor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() +
                    ": Se ha creado una caja de capsulas.");
            contenedor.remove6();
            try {
                Thread.sleep(r.nextInt(1000, 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}