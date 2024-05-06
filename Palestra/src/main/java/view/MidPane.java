package view;

import controller.MainGUI;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.Persona;

import java.util.ArrayList;

public class MidPane extends VBox {

    public MidPane(MainGUI mg) {
        super();

        ArrayList<Persona> abbonati = mg.getPalestra().getAbbonati();
        createVBox(abbonati);
    }

    public void createVBox(ArrayList<Persona> a){
        super.getChildren().clear();
        for(Persona persona : a){
            super.getChildren().add(creaTesto(persona));
        }
    }

    private Text creaTesto(Persona p){
        return new Text(p.toString());
    }
}
