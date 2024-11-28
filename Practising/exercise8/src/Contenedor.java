public class Contenedor
{
    private int num = 0;


    public synchronized int getNum() {
        return num;
    }

    public synchronized void add() {
        num++;
    }

    public synchronized void remove6() {
        num -= 6;
    }
}
