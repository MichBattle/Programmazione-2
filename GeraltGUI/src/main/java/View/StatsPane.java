package View;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.geralt.Geralt;

public class StatsPane extends VBox {
    private Geralt g;

    public StatsPane(Geralt k) {
        super();

        this.g = k;

        update_stats();
    }

    /**
     * aggiorna il VBox
     * pulisce tutti i figli (li elimina)
     * e li ricrea come HBox contenente le stringhe
     */
    public void update_stats(){
        super.getChildren().clear();
        String[] texts = crea_stringa(); //mi permette di fare un for each per ogni attributo senza dover passare ogni volta un oggetto Geralt per parametro ai metodi
        for (String text : texts) { //creo un hBox per attributo e lo aggiungo a MainGUI
            HBox hb = createHBox(text);
            getChildren().add(hb);
        }
    }

    /**
     * crea l'HBox con il figlio text
     * @param text
     * @return
     */
    private HBox createHBox(String text) {
        Text t = new Text(text);
        return new HBox(t);
    }

    /**
     * crea un array di stringhe composte da attributo: valore
     * @return
     */
    private String[] crea_stringa(){
        return new String[]{"Forza: " + g.getForza(),
                "Velocita: " + g.getVelocita(),
                "Tolleranza: " + g.getTolleranza(),
                "Livello: " + g.getLivello()
        };
    }

}