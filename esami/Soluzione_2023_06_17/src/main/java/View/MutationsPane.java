package View;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class MutationsPane extends VBox {
    private Text slotFisici;
    private Text slotMagie;
    private Text slotTol;
    private Text slotLibero;

    public MutationsPane(Geralt geralt) {
        super();
        creaTesti(geralt);
    }

    public void creaTesti(Geralt geralt){
        super.getChildren().clear();
        ArrayList<Mutation> al = geralt.getMutations();

        slotFisici = new Text(al.get(0).toString());
        slotFisici.setFill(Color.CRIMSON);

        slotMagie = new Text(al.get(1).toString());
        slotMagie.setFill(Color.CADETBLUE);

        slotTol = new Text(al.get(2).toString());
        slotTol.setFill(Color.CHARTREUSE);

        slotLibero = new Text(al.get(3).toString());
        slotLibero.setFill(Color.ORANGE);
        aggiungiMutazioni();
    }

    private void aggiungiMutazioni(){
        super.getChildren().add(new Text("Mutations: "));
        super.getChildren().add(slotFisici);
        super.getChildren().add(slotMagie);
        super.getChildren().add(slotTol);
        super.getChildren().add(slotLibero);
    }
}