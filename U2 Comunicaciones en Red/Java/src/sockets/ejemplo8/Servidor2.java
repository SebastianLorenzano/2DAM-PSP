package sockets.ejemplo8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor2 {

    public static void main(String[] args) throws IOException {
        System.out.println("---SERVIDOR---");
        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                try
                {
                    Socket conexionCliente = server.accept();
                    System.out.println("¡Cliente conectado!");
                    Thread te = new Thread(new HiloEscritura(conexionCliente));
                    Thread tl = new Thread(new HiloLectura(conexionCliente));
                    te.start();
                    tl.start();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            }

        }
    }
}
