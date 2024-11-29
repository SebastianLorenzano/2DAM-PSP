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
        life = 100;//r.nextInt(10,100);
    }
}
