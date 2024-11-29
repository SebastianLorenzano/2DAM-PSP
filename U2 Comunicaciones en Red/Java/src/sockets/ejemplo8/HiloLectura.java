package sockets.ejemplo8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiloLectura implements Runnable {

    private Socket conexionCliente;

    public HiloLectura(Socket socket) {
        this.conexionCliente = socket;
    }

    @Override
    public void run() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexionCliente.getInputStream())))
        {
            // Leemos líneas y las mostramos hasta que recibimos fin
            Scanner sc = new Scanner(System.in);
            String lineaRecibida = "";

            while (!lineaRecibida.equals("fin")) {
                // Recibimos mensaje
                lineaRecibida = bufferedReader.readLine();
                if (!lineaRecibida.equals("fin"))
                    System.out.println("El mensaje recibido es: " + lineaRecibida);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}