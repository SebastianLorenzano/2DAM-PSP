package sockets.ejemplo8;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscritura implements Runnable {

    private Socket conexionCliente;

    public HiloEscritura(Socket socket)
    {
        this.conexionCliente = socket;
    }

    @Override
    public void run() {

        try (OutputStream outputStream = conexionCliente.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream, true);) {

            // Leemos líneas y las mostramos hasta que recibimos fin
            Scanner sc = new Scanner(System.in);
            String mensajeAEnviar = "";
            while(!mensajeAEnviar.equals("fin")) {
                // Enviamos mensaje
                System.out.print("Escribe el mensaje a enviar: ");
                mensajeAEnviar = sc.nextLine();
                printWriter.println(mensajeAEnviar);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}

