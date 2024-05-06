package Control;

import Main.Coordinate;
import Main.Enemy;
import Main.Palla;
import Main.Utente;
import Main.enemy.Bubbler;
import Main.enemy.Striker;
import Main.enemy.Wanderer;
import View.StatsPane;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class MainGUI extends Pane {
    public static int ITERATION_INDEX = 0;

    private Utente u;
    private StatsPane statsPane;

    private ArrayList<Striker> strikers;
    private ArrayList<Wanderer> wanderers;
    private ArrayList<Bubbler> bubblers;

    public MainGUI() {
        super();
        u = new Utente();
        statsPane = new StatsPane();
        strikers = new ArrayList<>();
        wanderers = new ArrayList<>();
        bubblers = new ArrayList<>();

        Stage stage = new Stage();
        Scene scene = new Scene(statsPane, 200, 100);
        stage.setTitle("PUNTEGGIO");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        super.getChildren().add(u);
        u.setCenterX(250);
        u.setCenterY(250);

        addEnemy(new Striker());
        addEnemy(new Wanderer());
        addEnemy(new Bubbler());
    }

    public Utente getU() {
        return u;
    }

    public StatsPane getStatsPane() {
        return statsPane;
    }

    /**
     * fa muovere tutti gli strikers
     */
    public void moveStrikers() {
        for(Striker s : strikers){
            s.move();
        }
    }

    /**
     * fa muovere tutti i wanderers
     * ogni 5 iter fa cambiare la direzione
     */
    public void moveWanderers() {
        for(Wanderer w : wanderers){
            w.move();

            if(ITERATION_INDEX%5 == 0)
                w.cambiaDirezione();
        }
    }

    /**
     * fa muovere tutti i bubblers
     * ogni 5 iter fa cambiare la posizione
     * ogni iter fa aumentare il raggio con 10% di probabilita
     */
    public void moveBubblers() {
        for(Bubbler b: bubblers){
            b.move();

            if(ITERATION_INDEX%5 == 0)
                b.cambiaDirezione();

            b.aumentaRaggio();
        }
    }

    /**
     * crea un nemico casuale
     */
    public void createNewEnemy(){
        Random random = new Random();
        Enemy e;

        e = switch (random.nextInt(3)) {
            case 0 -> new Striker();
            case 1 -> new Wanderer();
            default -> new Bubbler();
        };

        addEnemy(e);
    }

    /**
     * aggiunge un nuovo nemico alla scena
     */
    private void addEnemy(Enemy e) {
        Coordinate c = createEnemyCoords();
        super.getChildren().add(e);

        if(e instanceof Bubbler b)
            bubblers.add(b);
        else if(e instanceof Wanderer w)
            wanderers.add(w);
        else if(e instanceof Striker s)
            strikers.add(s);

        e.setCenterX(c.getX());
        e.setCenterY(c.getY());
    }

    /**
     * crea un oggetto Coordinate che contiene le coordinate dove verrà spawnato un nuovo nemico
     * le coordinate sono fatte in modo da non collidere con l'user allo spawn
     */
    private Coordinate createEnemyCoords(){
        Random random = new Random();
        double spawnX;
        double spawnY;

        do{
            spawnX = random.nextDouble(480);
            spawnY = random.nextDouble(480);
        }while(Math.sqrt(Math.pow(spawnX - u.getCenterX(), 2) + Math.pow(spawnY - u.getCenterY(), 2)) <= u.getRadius() + 5);

        return new Coordinate(spawnX, spawnY);
    }

    /**
     * riposiziona nel lato opposto le entita uscite dalla scena
     */
    public void repositionOutOfSceneEntities(){
        ArrayList<Palla> p = new ArrayList<>();
        p.add(u);
        p.addAll(strikers);
        p.addAll(wanderers);
        p.addAll(bubblers);

        for(Palla palla : p){
            if(palla.getCenterX() + palla.getRadius() < 0)
                palla.setCenterX(MainFX.SCENE_DIMENSION + palla.getRadius());
            else if(palla.getCenterX() - palla.getRadius() > MainFX.SCENE_DIMENSION)
                palla.setCenterX(-palla.getRadius());

            if(palla.getCenterY() + palla.getRadius() < 0)
                palla.setCenterY(MainFX.SCENE_DIMENSION + palla.getRadius());
            else if(palla.getCenterY() - palla.getRadius() > MainFX.SCENE_DIMENSION)
                palla.setCenterY(-palla.getRadius());
        }
    }

    /**
     * ritorna il nemico con cui è avvenuta la collisione
     */
    public Enemy checkLoose(){
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.addAll(strikers);
        enemies.addAll(wanderers);
        enemies.addAll(bubblers);

        for(Enemy nemico : enemies){
            double distance = Math.sqrt(Math.pow(u.getCenterX() - nemico.getCenterX(), 2) + Math.pow(u.getCenterY() - nemico.getCenterY(), 2));
            if(distance < u.getRadius() + nemico.getRadius()){
                return nemico;
            }
        }
        return null;
    }
}
