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
        stage.setScene(scene);
        stage.show();

        super.getChildren().add(u);
        u.setCenterX(250);
        u.setCenterY(250);

        addEnemy(new Striker());
        addEnemy(new Wanderer());
        addEnemy(new Bubbler());
    }

    public void moveStrikers() {
        for(Striker s : strikers){
            s.move();
        }
    }

    public void moveWanderers() {
        for(Wanderer w : wanderers){
            w.move();

            if(ITERATION_INDEX%5 == 0)
                w.cambiaDirezione();
        }
    }

    public void moveBubblers() {
        for(Bubbler b: bubblers){
            b.move();

            if(ITERATION_INDEX%5 == 0)
                b.cambiaDirezione();

            b.aumentaRaggio();
        }
    }

    public Utente getU() {
        return u;
    }

    public void spawnNewEnemy(){
        Random random = new Random();
        Enemy e;

        e = switch (random.nextInt(3)) {
            case 0 -> new Striker();
            case 1 -> new Wanderer();
            default -> new Bubbler();
        };

        addEnemy(e);
    }

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

    private Coordinate createEnemyCoords(){
        Random random = new Random();
        double spawnX;
        double spawnY;

        do{
            spawnX = random.nextDouble(480);
            spawnY = random.nextDouble(480);
        }while(Math.sqrt(Math.pow(spawnX - u.getCenterX(), 2) + Math.pow(spawnY - u.getCenterY(), 2)) <= u.getRadius());

        return new Coordinate(spawnX, spawnY);
    }
}
