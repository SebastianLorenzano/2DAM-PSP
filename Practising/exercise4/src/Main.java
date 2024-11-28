import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random r = new Random();
        int x = r.nextInt(10, 15);

        System.out.println("Pulsa enter cuando llegues al numero " + x);

        var c = new Runnable() {
            int value = 0;
            boolean isRunning = true;

            public int getValue()
            {
                return value;
            }

            public void stopIsRunning()
            {
                isRunning = false;
            }

            @Override
            public void run() {
                try
                {
                    while (isRunning)
                    {
                        value++;
                        System.out.println(value);
                        Thread.sleep(1000);
                    }
                }
                catch (InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        };

        Thread t = new Thread(c);
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        try
        {
            c.stopIsRunning();
            t.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        if (c.getValue() == x)
            System.out.println("¡Lo has conseguido!");
        else
        {
            System.out.println("Has fallado! Intentalo devuelta.");
            main(null);
        }

    }


}