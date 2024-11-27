import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        ThreadPrimePrinter(2);
    }

    public static void ThreadPrimePrinter(int threadNum)
    {
        Random r = new Random();


        for (; threadNum > 0; threadNum--)
        {
            Thread t = new Thread(() -> {
                int fnlValue = r.nextInt(1, 100);
                String name = Thread.currentThread().getName();
                System.out.println(name + ": Printing prime numbers between 1 and " + fnlValue);
                try
                {
                    for (int x = 1; x < fnlValue; x++)
                    {
                        if (isPrime(x))
                            System.out.println(name + ": " + x);
                        Thread.sleep(r.nextInt(500, 1000));
                    }

                }
                catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            });
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