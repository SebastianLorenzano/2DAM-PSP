import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        NumPrinter(1, 12);
    }


    public static void NumPrinter(int num1, int num2)
    {
        Random r = new Random();



        Thread thread = new Thread(() -> {
            try {
                int value1 = Math.min(num1, num2);
                int value2 = Math.max(num1, num2);

                while (value1 < value2)
                {
                    System.out.println(value1++);
                    Thread.sleep(r.nextInt(1, 1000));
                }
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }

        });
        thread.start();
        System.out.println("El hilo se ha lanzado");

    }
}