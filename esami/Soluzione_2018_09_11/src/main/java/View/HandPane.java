package View;

import Model.Carta;
import Model.Mano;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class HandPane extends HBox {

    public HandPane(Mano giocatoreCorrente) {
        super();

        creaMano(giocatoreCorrente.getCarte());
    }

    public void creaMano(ArrayList<Carta> mano){
        getChildren().clear();
        for(Carta c : mano){
            getChildren().add(creaStackPane(c));
        }
    }

    private StackPane creaStackPane(Carta c){
        Rectangle r = new Rectangle(40, 40);
        r.setFill(Color.CYAN);
        r.setStroke(Color.BLACK);
        Text t = new Text(c.toString());
        return new StackPane(r, t);
    }
}
