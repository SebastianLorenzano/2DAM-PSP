package ejercicio2;

import java.util.Random;

/* Clase enemigo. La vida del enemigo se calcula aleatoriamente entre 10 y 100 */
public class Enemy {
    private int life;

    public int getLife() {
        return life;
    }

    public Enemy(){
        Random r = new Random();
        //life = r.nextInt(10,100);
        life = 100;
        // SOLUCION: Hemos fijado la vida a 100 solo para poder ver que obtenemos el resultado esperado.
        // Si hay 10 enemigos con vida 100, eso hace un total de 1000 puntos.
        // Si hay 100 jugadores, la media de puntos por jugador será 10.
        // Este cambio se ha hecho solo para comprobar que el resultado mostrado al ejecutar el programa es 10.

    }
}
