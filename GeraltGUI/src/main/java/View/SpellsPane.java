package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.geralt.Geralt;
import model.geralt.Spell;
import java.util.HashSet;

public class SpellsPane extends VBox {
    private Geralt g;

    public SpellsPane(Geralt k) {
        super();

        this.g = k;

        update_stats();
    }

    /**
     * aggiorna le stats del VBox
     * pulisce i figli
     * crea HBox per ogni spell e li aggiunge a super
     */
    public void update_stats(){
        super.getChildren().clear();
        HashSet<Spell> hs = g.getSpells();
        for(Spell s: hs){
            HBox hb = createHBox(s);
            super.getChildren().add(hb);
        }
    }

    /**
     * crea l'HBox che ha come figlio la stringa contenente il nome della spell
     * @param s
     * @return
     */
    private HBox createHBox(Spell s){
        Text t = new Text(s.toString());
        return new HBox(t);
    }
}
