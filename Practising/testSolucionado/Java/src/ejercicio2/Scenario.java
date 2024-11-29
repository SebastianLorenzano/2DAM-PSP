package ejercicio2;

import java.util.ArrayList;
import java.util.Random;

/* Clase escenario. Contiene una lista de enemigos.
* Al crear la instancia del escenario se crean 10 enemigos.
* Dispone de un método que permite saber si un jugador impacta con un enemigo
* al dispararle. */
public class Scenario {
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Scenario(){
        for (int i = 0; i < 10; i++) {
            Enemy e = new Enemy();
            enemies.add(e);
        }
    }

    // SOLUCION: Necesitamos que checkImpact sea un método sincronizado,
    // esto se debe a que manipula (elimina elementos) de la variable
    // compartida enemies. Sin la sincronización varios hilos pueden
    // llamar a este método concurrentemente, tratando de eliminar
    // enemigos a la vez y produciéndose los errores de acceso a los elementos.
    public synchronized Enemy checkImpact(){
        Enemy e = null;
        // Si hay enemigos siempre se impacta contra uno (elegido aleatoriamente).
        // Este enemigo se elimina del escenario.
        if(!enemies.isEmpty()){
            Random r = new Random();
            int pos = r.nextInt(0,enemies.size());
            e = enemies.remove(pos);
        }
        // Si no hay enemigos se devuelve null.
        return e;
    }
}
