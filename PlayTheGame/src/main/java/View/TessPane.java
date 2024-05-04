package View;

import Model.Gioco;
import Model.Tessera;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TessPane extends GridPane {
    private Gioco gioco;
    MainGUI mg;
    private Tessera[][] grid;

    public TessPane(MainGUI mg) {
        super();
        this.mg = mg;
        gioco = mg.getGioco();
        grid = gioco.getScacchiera();

        resetAll();
    }

    private StackPane creaCella(Tessera t){
        Rectangle r = new Rectangle(50, 50);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);

        Text text = new Text("");
        StackPane sp = new StackPane();

        sp.getChildren().addAll(r, text);
        attivaStackPane(sp, t, text);

        return sp;
    }

    private void attivaStackPane(StackPane sp, Tessera t, Text text){
        sp.setOnMouseClicked(mouseEvent -> {
            if(!t.isScoperta()){
                text.setText(t.getValore());
                t.scopri();
                t.setScoperta(true);
            }else{
                text.setText("");
                t.nascondi();
                t.setScoperta(false);
            }

            mg.updatePunteggio();
        });
    }

    public void resetAll(){
        for(int i = 0; i < gioco.getN(); i++){
            for(int k = 0; k < gioco.getN(); k++){
                super.add(creaCella(grid[i][k]), k, i);
            }
        }
    }
}
