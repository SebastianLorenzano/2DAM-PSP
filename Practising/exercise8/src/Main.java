public class Main
{
    public static void main(String[] args)
    {
        Contenedor c = new Contenedor();
        Productor p = new Productor("Colombiano", 3, c);
        Consumidor co = new Consumidor(c);

        Thread tp = new Thread(p);
        Thread tc = new Thread(co);

        tp.setName("Hilo Productor");
        tc.setName("Hilo Consumidor");
        tp.start();
        tc.start();


    }
}