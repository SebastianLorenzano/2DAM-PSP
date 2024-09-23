import java.awt.desktop.SystemEventListener;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de hilos a crear: ");
        int a = scanner.nextInt();
        if (a < 1)
        {
            System.out.println("El numero de hilos debe ser mayor o igual a 1.");
            main(null);
            return;
        }
        for (int x = 1; x <= a; x++)
        {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run()
                {
                    int max = r.nextInt(1, 100);
                    printPrimesUntil(max);
                }
                private void printPrimesUntil(int max)
                {
                    System.out.println(Thread.currentThread().getName() + ": Mostrando primos hasta el " + max);
                    try
                    {
                        for (int y = 2; y <= max; y++)
                        {
                            if (isPrime(y))
                            {
                                System.out.println(Thread.currentThread().getName() + ": " + y);
                                Thread.sleep(r.nextInt(500, 1000));
                            }
                        }
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            });
            t.setName("Hilo " + x);
            t.start();
        }
    }

    private static boolean isPrime(int a)
    {
        if (a % 2 == 0 || a % 3 == 0 || a % 5 == 0 && a != 5 || a % 7 == 0 && a != 7)
            return false;
        for (int x = 11; x < a; x++)
        {
            if (a % x == 0)
                return false;
        }
        return true;
    }


}