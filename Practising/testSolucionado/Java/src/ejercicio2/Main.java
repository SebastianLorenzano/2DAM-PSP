package ejercicio2;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {

        TeamData td = new TeamData();
        Scenario sc = new Scenario();

        // Creamos 100 jugadores
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(()->{
                td.addPlayer(new Player(Thread.currentThread().getName()));
                for(int j = 0; j < 1000; j++){
                    Enemy e = sc.checkImpact(); //Esta línea simula que el jugador dispara. checkImpact nos dice si se ha impactado a un enemigo.
                    if(e != null) // Si es diferente a nulo, significa que se ha impactado contra un enemigo.
                        td.scoreEnemyKilled(e); // Puntuamos al enemigo
                }
            });
            t.start();
            threads.add(t);
        }

        // SOLUCION: Esperamos la finalización de todos los hilos antes de mostrar la puntuación
        // Para ello recorremos todos los hilos y llamamos a su método join.
        for(Thread h: threads){
            try {
                h.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Al finalizar la partida muestro los puntos por jugador
        System.out.println("Puntuación por jugador : " + td.getScorePerPlayer());
    }

}
