package View;

import Model.Giocatore;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ManoPane extends HBox {
    private Giocatore g;

    public ManoPane(Giocatore g) {
        super();
        this.g = g;
        creaMano();
    }

    private StackPane creaBox(String s){
        Rectangle r = new Rectangle(50, 50);
        r.setStroke(Color.BLACK);
        r.setFill(Color.ORANGE);
        Text t = new Text(s);
        return new StackPane(r, t);
    }

    public void creaMano(){
        super.getChildren().clear();
        for(int i = 0; i < g.getMano().size(); i++){
            super.getChildren().add(creaBox(g.getMano().getElementAt(i).toString()));
        }
    }
}
