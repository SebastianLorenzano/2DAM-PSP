import java.util.Random;

public class Productor implements Runnable
{
    Random r = new Random();

    public String nombreCafe = "";
    public int intensidadCafe;
    public Contenedor contenedor;
    public boolean isRunning = true;

    public Productor(String nombre, int intensidad, Contenedor contenedor)
    {
        nombreCafe = nombre;
        intensidadCafe = intensidad;
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
            try
            {
                Thread.sleep(r.nextInt(500, 1000));
                synchronized (contenedor) {
                    contenedor.add();
                    System.out.println(Thread.currentThread().getName() +
                            ": Se ha fabricado una capsula. Total en el contenedor: "
                            + contenedor.getNum());
                    contenedor.notifyAll();
                }

            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
