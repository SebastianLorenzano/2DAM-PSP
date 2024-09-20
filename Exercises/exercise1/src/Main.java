import java.util.Random;

public class Main
{
    static Random r = new Random();


    public static void main1(String[] args)
    {

    }
    public static void main2(String[] args)
    {
        int a = 2;
        int b = 5;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run()
            {
                PrintNumbersBetween(a, b);
            }
        });
        System.out.println("El hilo se ha lanzado");
    }

    public static void main3(String[] args)
    {
        int a = 2;
        int b = 5;
        Thread t = new Thread(() -> PrintNumbersBetween(a, b));
        System.out.println("El hilo se ha lanzado");
    }

    private static void PrintNumbersBetween(int a, int b)
    {
        int value1 = Math.min(a, b);
        int value2 = Math.max(a, b);

        try
        {
            for (; value1 < value2; ++value1)
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




