package sockets.ejemplo8;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {

    public static void main(String[] args) {
        System.out.println("---CLIENTE---");

        try
        {
            Socket cliente = new Socket("localhost", 1234);
            Thread t1 = new Thread(new HiloLectura(cliente));
            Thread t2 = new Thread(new HiloEscritura(cliente));
            t1.start();
            t2.start();
        }
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
