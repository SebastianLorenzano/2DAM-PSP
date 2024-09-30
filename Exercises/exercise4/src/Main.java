import java.util.Random;
        import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    static Random r = new Random();
    public static void main(String[] args)
    {
        int result = r.nextInt(10, 20);
        var counter = new Runnable()
        {
            int count = 0;
            private boolean isRunning = true;

            public int getCount()
            {
                return count;
            }
            public void stopExecution()
            {
                isRunning = false;
            }
            @Override
            public void run()
            {
                while (isRunning)
                {
                    try
                    {
                        Thread.sleep(1000);
                        if (isRunning)
                        {
                            System.out.println(count);
                            count++;
                        }
                    }
                    catch (InterruptedException ie)
                    {
                        System.err.println(ie.getMessage());
                    }
                }
            }
        };
        System.out.println("Pulsa enter cuando creas que el contador ha llegado a " + result);
        Thread t = new Thread(counter);
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        counter.stopExecution();
        try
        {
            t.join();
        }
        catch (InterruptedException ie)
        {
            ie.getMessage();
        }
        int count = counter.getCount();
        if (count == result)
            System.out.println("¡Lo has conseguido!");
        else
        {
            System.out.println("Vuelve a intentarlo, has detenido el contador en " + count + "...");
            main(null);
        }
    }
}