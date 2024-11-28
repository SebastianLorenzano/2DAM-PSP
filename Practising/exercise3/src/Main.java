import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        ThreadPrimePrinter(3);
    }

    public static void ThreadPrimePrinter(int threadNum)
    {
        Random r = new Random();

        ArrayList<Thread> threads = new ArrayList<Thread>();

        for (int y = 0; threadNum > y; y++)
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
            t.setName("Thread " + y);
            t.start();
            threads.add(t);
        }

        for (boolean isRunning = true; isRunning;)
        {
            try
            {
                Thread.sleep(1000);
                printAllThreadsState(threads);
                if (areAllThreadsFinished(threads))
                    isRunning = false;

            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("All threads have been terminated.");
    }

    private static void printAllThreadsState(ArrayList<Thread> threads)
    {
        for (Thread th : threads)
            System.out.println(th.getName() + ": "  + th.getState());
    }


    private static boolean areAllThreadsFinished(ArrayList<Thread> threads)
    {
        for (Thread th : threads)
        {
            if (th.getState() != Thread.State.TERMINATED)
                return false;
        }
        return true;
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