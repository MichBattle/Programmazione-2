package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.geralt.Geralt;
import model.geralt.Mutation;
import java.util.ArrayList;

public class MutationsPane extends VBox {
    private Geralt g;

    HBox slot_fisici;
    HBox slot_magie;
    HBox slot_tol;
    HBox slot_libero;

    public MutationsPane(Geralt k) {
        super();

        this.g = k;

        create_all_HBox();
        aggiungi_slot();
    }

    /**
     * aggiorna tutto
     * pulisce i figli, crea gli HBox e li aggiunge a super
     */
    public void update_mutations(){
        super.getChildren().clear();
        create_all_HBox();
        aggiungi_slot();
    }

    /**
     * crea gli HBox contenenti le varie mutazioni presenti nell'ArrayList di Geralt con il colore scelto
     */
    private void create_all_HBox(){
        ArrayList<Mutation> al = g.getMutations();

        slot_fisici = createHBox(al.get(0), Color.RED);
        slot_magie = createHBox(al.get(1), Color.CYAN);
        slot_tol = createHBox(al.get(2), Color.GREEN);
        slot_libero = createHBox(al.get(3), Color.ORANGE);
    }

    /**
     * crea l'HBox con nome mutazione e colore
     * @param m
     * @param c
     * @return
     */
    private HBox createHBox(Mutation m, Color c){
        Text t = new Text(m.toString());
        t.setFill(c);
        return new HBox(t);
    }

    /**
     * aggiunge tutti i figli a super
     */
    private void aggiungi_slot(){
        super.getChildren().add(slot_fisici);
        super.getChildren().add(slot_magie);
        super.getChildren().add(slot_tol);
        super.getChildren().add(slot_libero);
    }
}