package View;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.geralt.Geralt;

public class MainGUI extends AnchorPane {
    private Geralt g;

    private StatsPane stats_pane;
    private SpellsPane spells_pane;
    private MutationsPane mutation_pane;
    private ButtonPane button_pane;

    public MainGUI(Geralt g) {
        super();
        this.g = g;

        //VBOX LEFT
        stats_pane = new StatsPane(g);
        spells_pane = new SpellsPane(g);

        Text spells_label = new Text("Spells: ");
        VBox spells = new VBox(spells_label, spells_pane);

        VBox left = new VBox(stats_pane, spells);
        left.setSpacing(10); //spazio tra i vbox

        super.getChildren().add(left);
        AnchorPane.setTopAnchor(left, 0.0);
        AnchorPane.setLeftAnchor(left, 0.0);

        //VBOX RIGHT
        Text mutation_text = new Text("Mutations: ");
        mutation_pane = new MutationsPane(g);

        VBox vb = new VBox(mutation_text, mutation_pane);

        super.getChildren().add(vb);
        AnchorPane.setTopAnchor(vb, 0.0);
        AnchorPane.setRightAnchor(vb, 0.0);

        //BOTTONI BOTTOM
        Text button_text = new Text("Mutazioni possibili: ");
        button_pane = new ButtonPane(g, this);

        VBox va = new VBox(button_text, button_pane);
        super.getChildren().add(va);
        AnchorPane.setBottomAnchor(va,0.0);
    }

    /**
     * aggiorna il VBox RIGHT
     */
    public void update_mutation_lable(){
        mutation_pane.update_mutations();
    }

    /**
     * aggiorna il VBox LEFT - stats
     */
    public void update_stats_lable(){
        stats_pane.update_stats();
    }

    /**
     * aggiorna il VBox LEFT - spells
     */
    public void update_spells_lable(){
        spells_pane.update_stats();
    }
}
