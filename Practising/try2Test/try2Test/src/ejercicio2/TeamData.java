package ejercicio2;

import java.util.ArrayList;


/* Clase TeamData. Guarda la puntuación total del equipo y la puntuación por jugador.
* La puntuación por jugador se calcula como la puntuación total dividida entre
* todos los jugadores. */
public class TeamData {
    private int score;
    private int scorePerPlayer;
    public int getScorePerPlayer() {
        return scorePerPlayer;
    }

    private ArrayList<Player> players = new ArrayList<>();

    // Este método permite puntuar un enemigo eliminado
    public synchronized void scoreEnemyKilled(Enemy e){
        score += e.getLife(); // Los puntos obtenidos para el equipo equivalen a la vida del enemigo
        updateScorePerPlayer();
    }

    public synchronized void addPlayer(Player p){
        players.add(p);
        updateScorePerPlayer();

    }
    // Método para calcular la puntuación por jugador
    private void updateScorePerPlayer(){
        scorePerPlayer = score / players.size();
    }

}
