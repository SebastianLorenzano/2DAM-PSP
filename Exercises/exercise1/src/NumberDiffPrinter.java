import java.util.Random;

public class NumberDiffPrinter implements Runnable
{
    private int a;
    private int b;
    static Random r = new Random();

    public NumberDiffPrinter(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    public void run()
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
