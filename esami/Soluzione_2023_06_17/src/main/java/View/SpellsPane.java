package View;

import Model.geralt.Geralt;
import Model.geralt.Spell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashSet;

public class SpellsPane extends VBox {

    public SpellsPane(Geralt geralt) {
        super();
        aggiornaStatistiche(geralt);
    }

    public void aggiornaStatistiche(Geralt geralt){
        super.getChildren().clear();
        super.getChildren().add(new Text("Spells: "));
        HashSet<Spell> spells = geralt.getSpells();
        for(Spell s: spells){
            Text t = new Text(s.toString());
            super.getChildren().add(t);
        }
    }
}
