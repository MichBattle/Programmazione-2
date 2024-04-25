package view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import org.example.run.HelloApplication;
import view.ostacoli.Block;
import view.ostacoli.Ostacolo;
import view.ostacoli.Penalty;

import java.util.Random;

public class MainGUI extends Pane {
    private GiocatorePane gp;
    private Traguardo t;
    private StatsPane sp;
    private boolean end;

    public MainGUI() {
        super();

        gp = new GiocatorePane();
        t = new Traguardo();
        sp = new StatsPane();
        end = false;

        super.getChildren().addAll(gp, t, sp);

        //player position
        double centerY = ((double) HelloApplication.HEIGTH/2);
        gp.setLayoutY(centerY);
        gp.setLayoutX(20);

        //finish line position
        double traguardoX = HelloApplication.WIDTH - Traguardo.LARGHEZZA;
        t.setLayoutX(traguardoX);

        //obstacles spawn
        spawnRandomObstacle();

        //stats position
        sp.setLayoutY(10);
        sp.setLayoutX((double)HelloApplication.WIDTH/3);
        sp.setSpacing(10);
    }

    /**
     * muove il giocatore verso il basso e in avanti facendolo restare nella scena
     */
    public void movePlayerDown(){
        double h = gp.getLayoutY()+10;
        if(h < HelloApplication.HEIGTH-20){ //se non va troppo in basso
            gp.setLayoutY(h); //muove in basso
            movePlayerForward(); //muove in avanti
        }
    }

    /**
     * muove il giocatore verso l'alto e in avanti facendolo restare nella scena
     */
    public void movePlayerUp(){
        double h = gp.getLayoutY()-10;
        if(h > 0){ //se non va troppo in alto
            gp.setLayoutY(h); //muove in alto
            movePlayerForward(); //muove in avanti
        }
    }

    /**
     * sposta tutte le cose a schermo tranne il giocatore a sinistra
     * incrementa il punteggio
     * controlla e gestisce impatti con ostacoli
     */
    public void movePlayerForward(){
        t.setLayoutX(t.getLayoutX()-10); //sposta traguardo a sinistra
        moveObstaclesLeft(); //sposta ostacoli a sinistra
        addPunteggio();
        checkObstacleImpact();
    }

    /**
     * controlla impatto col traguardo
     * manda un alert di fine partita
     * @return
     */
    public boolean checkWin() {
        boolean w = false;

        double playerX = gp.getLayoutX();
        double playerY = gp.getLayoutY();
        double finishLineX = t.getLayoutX();
        double finishLineY = t.getLayoutY();

        if (playerX >= finishLineX && playerY >= finishLineY && playerY <= finishLineY + Traguardo.ALTEZZA) {
            displayAlert();
            w = true;
        }

        return w;
    }

    /**
     * controlla impatti con ostacoli
     * attiva conseguenze impatto con ostacolo
     * manda un alert se finisce il gioco
     */
    public void checkObstacleImpact() {
        for (Node child : getChildren()) {
            if (child instanceof Ostacolo obstacle) {
                if (gp.getBoundsInParent().intersects(obstacle.getBoundsInParent())) {
                    if(obstacle instanceof Block){
                        ((Block) obstacle).azione();
                        if(sp.getVite() == 0){
                            displayAlert();
                            end = true;
                            break;
                        }
                    }
                    else if(obstacle instanceof Penalty)
                        ((Penalty) obstacle).azione();
                }
            }
        }

    }

    /**
     * sposta tutti gli ostacoli a sinistra
     */
    private void moveObstaclesLeft() {
        for (Node child : getChildren()) {
            if (child instanceof Ostacolo obstacle) {
                double newX = obstacle.getLayoutX() - 10;
                obstacle.setLayoutX(newX);
            }
        }
    }

    /**
     * crea alert
     */
    private void displayAlert(){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("Run!");
        win.setHeaderText("GAME OVER");
        win.setContentText("Hai totalizzato " + sp.getPunteggio() + " punti");
        win.showAndWait();
    }

    /**
     * incrementa il punteggio di 100
     */
    private void addPunteggio(){
        sp.setPunteggioLabel(100);
    }

    /**
     * spawna 3 ostacoli per tipo
     */
    private void spawnRandomObstacle(){
        for(int i = 0; i < 3; i++)
            createObstacle(new Penalty(sp));

        for(int i = 0; i < 3; i++)
            createObstacle(new Block(sp));
    }

    /**
     * crea un ostacolo nella posizione random e aggiunge al super
     * @param obstacle
     */
    private void createObstacle(Ostacolo obstacle){
        Random random = new Random();

        //genero posizione dell'ostacolo nel Pane
        double obstacleX = random.nextDouble() * (480 - 50) + 50;
        double obstacleY = random.nextDouble() * (180 - 10) + 10;

        //imposta la posizione dell'ostacolo
        obstacle.setLayoutX(obstacleX);
        obstacle.setLayoutY(obstacleY);

        getChildren().add(obstacle);
    }

    public boolean isEnd() {
        return end;
    }
}
