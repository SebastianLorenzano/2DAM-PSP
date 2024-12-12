public class Runner implements Runnable
{

    private final Lane lane;
    private final int id;

    public int getId()
    {
        return id;
    }

    public Lane getRunner()
    {
        return lane;
    }


    public Runner(int id, Lane lane)
    {
        this.id = id;
        this.lane = lane;
    }


    @Override
    public void run()
    {

    }


}
