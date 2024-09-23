import java.util.Random;
import java.util.Scanner;

public class Main
{
    static Random r = new Random();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el n1: ");
        int a = scanner.nextInt();
        System.out.println("Introduce el n2: ");
        int b = scanner.nextInt();
        main1(a, b);
        //main2(a, b);
        //main3(a, b);
    }


    public static void main1(int a, int b)
    {
        Thread t = new Thread(new NumberDiffPrinter(a, b));
        t.start();
    }

    public static void main2(int a, int b)
    {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run()
            {
                printNumbersBetween(a, b);
            }
        });
        System.out.println("El hilo se ha lanzado");
        t.start();
    }

    public static void main3(int a, int b)
    {

        Thread t = new Thread(() -> printNumbersBetween(a, b));
        System.out.println("El hilo se ha lanzado");
        t.start();
    }

    private static void printNumbersBetween(int a, int b)
    {
        int value1 = Math.min(a, b);
        int value2 = Math.max(a, b);

        try
        {
            for (; value1 <= value2; ++value1)
            {
                System.out.println(value1);
                Thread.sleep(r.nextInt(1, 1000));

            }
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

    }
}




