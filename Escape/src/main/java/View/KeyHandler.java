package View;

import Control.MainGUI;
import Main.Enemy;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class KeyHandler {
    private Scene scene;
    private MainGUI mg;

    public KeyHandler(Scene scene, MainGUI mg) {
        this.scene = scene;
        this.mg = mg;
    }

    /**
     * gestisce la pressione dei tasti
     * aumenta l'ITERATION_INDEX
     * spawna un nemico ogni 10 iterazioni
     * sposta l'user in base al tasto
     * muove tutti gli enemies
     * aumenta il punteggio
     * riposiziona le entita che escono dalla scena
     * controlla se si perde e in caso imposta a rosso i colori e mostra GAME OVER nella seconda scena
     */
    public void handleKeyPressed(){
        scene.setOnKeyPressed(event -> {
            if(!mg.getStatsPane().isLoose()){ //se la partita non è finita
                //posizione centro user
                double posX = mg.getU().getCenterX();
                double posY = mg.getU().getCenterY();

                MainGUI.ITERATION_INDEX++; //incremento l'indice denerale

                if(MainGUI.ITERATION_INDEX%10 == 0)
                    mg.createNewEnemy(); //spawno un nemico ogni 10 iterate

                //muovo user
                if(event.getCode() == KeyCode.UP){
                    mg.getU().setCenterY(posY-10);
                }else if(event.getCode() == KeyCode.DOWN){
                    mg.getU().setCenterY(posY+10);
                }else if(event.getCode() == KeyCode.RIGHT){
                    mg.getU().setCenterX(posX+10);
                }else if(event.getCode() == KeyCode.LEFT){
                    mg.getU().setCenterX(posX-10);
                }

                //muovo enemies
                mg.moveStrikers();
                mg.moveWanderers();
                mg.moveBubblers();

                mg.getStatsPane().aumentaPunteggio(); //aumento punteggio
                mg.repositionOutOfSceneEntities(); //sposto entita uscite dalla scena

                Enemy e = mg.checkLoose();
                if(e != null){ //se ci sono collisioni
                    mg.getStatsPane().addGameOverText(); //imposto il GAME OVER text
                    e.setFill(Color.RED); //imposto rosso il nemico colpito
                    mg.getU().setFill(Color.RED); //imposto rosso l'user
                    mg.getStatsPane().setLoose(true); //imposto partita finita
                }
            }
        });
    }
}
