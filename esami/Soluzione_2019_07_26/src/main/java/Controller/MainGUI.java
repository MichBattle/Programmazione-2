package Controller;

import Model.Coordinate;
import Model.Palline.Enemy;
import Model.Palline.Nemici.Bubbler;
import Model.Palline.Nemici.Striker;
import Model.Palline.Nemici.Wanderer;
import Model.Palline.User;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class MainGUI extends Pane {
    private User user;
    private ArrayList<Bubbler> bubblers;
    private ArrayList<Wanderer> wanderers;
    private ArrayList<Striker> strikers;
    private static boolean loose;

    public MainGUI() {
        super();
        loose = false;

        bubblers = new ArrayList<>();
        wanderers = new ArrayList<>();
        strikers = new ArrayList<>();

        Coordinate coordinateUserIniziali = creaCoordinateSpawn();

        user = new User();
        user.setCenterX(coordinateUserIniziali.getX());
        user.setCenterY(coordinateUserIniziali.getX());

        super.getChildren().add(user);
        aggiungiNemico(new Bubbler());
        aggiungiNemico(new Wanderer());
        aggiungiNemico(new Striker());
    }

    private Enemy creaNemicoCasuale(){
        Random r = new Random();
        return switch (r.nextInt(3)) {
            case 0 -> new Striker();
            case 1 -> new Wanderer();
            case 2 -> new Bubbler();
            default -> null;
        };
    }

    private void aggiungiNemico(Enemy nemico){
        if(nemico instanceof Striker s)
            strikers.add(s);
        if(nemico instanceof Bubbler b)
            bubblers.add(b);
        if(nemico instanceof Wanderer w)
            wanderers.add(w);

        Coordinate c = creaCoordinateSpawn();

        nemico.setCenterX(c.getX());
        nemico.setCenterY(c.getY());

        super.getChildren().add(nemico);
    }

    private Coordinate creaCoordinateSpawn(){
        Random r = new Random();
        double spawnX, spawnY;

        do{
            spawnX = r.nextDouble(481); //481 cosi spawnano all'interno della mappa e non metà fuori
            spawnY = r.nextDouble(481);
        } while(spawnX < user.getCenterX() + 45 && spawnY < user.getCenterY() + 45); //45 considerando raggioUser+raggioEnemy+5 di distacco iniziale

        return new Coordinate(spawnX, spawnY);
    }

    public static boolean isLoose() {
        return loose;
    }

    public void checkLoose(){
        //controllo collisioni
    }

    //ciao
}
