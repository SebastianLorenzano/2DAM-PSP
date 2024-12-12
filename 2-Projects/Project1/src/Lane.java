import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Lane
{
    private final int _id;
    private HashMap<Runner, Integer> _runners = new HashMap<Runner, Integer>();


    public Lane(int id)
    {
        this._id = id;
    }

    public int getId()
    {
        return _id;
    }

    public boolean addRunner(Runner runner, int position)
    {
        if (runner != null && position >= 0)
        {
            _runners.put(runner, position);
            return true;
        }
        return false;
    }

    public void advanceRunner(int id)
    {
        Map.Entry runner;
        for (Map.Entry r: _runners.entrySet())
        {
            Runner r1 = (Runner) r.getKey();
            if (id == r1.getId())
            {
                runner = r;
                break;
            }
        }
        if (runner != null)



    }


}
