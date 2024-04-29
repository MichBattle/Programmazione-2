package View;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserPane extends HBox {
    private int soldi;
    private Date oggi;

    private Text soldiText;
    private Text oggiText;

    public UserPane() {
        super();
        soldi = 29;
        oggi = new Date();
        soldiText = new Text();
        oggiText = new Text();

        updateSoldiLabel();
        updateOggiLabel();

        super.getChildren().addAll(soldiText, oggiText);
        super.setSpacing(5);
    }

    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int soldi) {
        this.soldi = soldi;
    }

    public void updateSoldiLabel(){
        soldiText.setText("$totali: " + soldi);
        updateOggiLabel();
    }

    private void updateOggiLabel(){
        oggiText.setText(oggi.toString());
    }
}
