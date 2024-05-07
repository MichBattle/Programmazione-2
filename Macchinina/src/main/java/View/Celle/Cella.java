package View.Celle;

import View.GrigliaPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Cella extends StackPane {

    /**
     * crea uno StackPane che contiene un quadrato lato 30 del colore passato da parametro
     */
    public Cella(Color c) {
        super();
        Rectangle r = new Rectangle(30, 30);
        r.setFill(c);
        r.setStroke(Color.GRAY);

        super.getChildren().add(r);
    }

    /**
     * imposta l'azione della cella quando viene cliccata
     */
    protected abstract void setCellaClicked(GrigliaPane gp, ArrayList<Button> bottoni);

    /**
     * crea un alert
     */
    protected abstract void displayAlert();

    /**
     * trova il bottone disabilitato tra quelli della lista passata
     */
    public Button getBottoneDisabilitato(ArrayList<Button> bottoni){
        for(Button b : bottoni){
            if(b.isDisabled())
                return b;
        }
        return null;
    }
}
