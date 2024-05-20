package View.Bottoni;

import Model.Figure.Cerchio;
import Model.Coordinate;
import Model.Figure.EmptyFigure;
import Model.Figure.Triangolo;
import View.Casella;
import View.ScacchieraPane;
import com.soluzione_2019_09_06.MainFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BottoniPerGestire extends HBox {
    private Button clearAll;
    private Button check;

    public BottoniPerGestire(ScacchieraPane scacchieraPane) {
        super();
        clearAll = new Button("clear All");
        check = new Button("Check");

        setClearAllAction(scacchieraPane);
        setCheckAction(scacchieraPane);

        super.getChildren().addAll(clearAll, check);
        super.setSpacing(25);
    }

    public void clearAllAction(ScacchieraPane sp){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ((Casella)sp.getElementAt(i, j)).setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE()));
            }
        }
    }

    public void checkAction(ScacchieraPane sp){
        int countTriangolo;
        int countCerchio;

        // Controllo colonne
        for (int i = 0; i < 3; i++) {
            countTriangolo = 0;
            countCerchio = 0;
            for (int j = 0; j < 3; j++) {
                Casella cell = (Casella) sp.getElementAt(i, j);
                if (cell.getForma() instanceof Triangolo) {
                    countTriangolo++;
                } else if (cell.getForma() instanceof Cerchio) {
                    countCerchio++;
                }
            }
            if (countTriangolo == 3 || countCerchio == 3) {
                displayAlert(new Coordinate(false, i + 1));
                return;
            }
        }

        // Controllo righe
        for (int i = 0; i < 3; i++) {
            countTriangolo = 0;
            countCerchio = 0;
            for (int j = 0; j < 3; j++) {
                Casella cell = (Casella) sp.getElementAt(j, i);
                if (cell.getForma() instanceof Triangolo) {
                    countTriangolo++;
                } else if (cell.getForma() instanceof Cerchio) {
                    countCerchio++;
                }
            }
            if (countTriangolo == 3 || countCerchio == 3) {
                displayAlert(new Coordinate(true, i + 1));
                return;
            }
        }
    }

    private void setClearAllAction(ScacchieraPane sp){
        clearAll.setOnAction(event -> {
            clearAllAction(sp);
        });
    }

    private void setCheckAction(ScacchieraPane sp){
        check.setOnAction(event -> {
            checkAction(sp);
        });
    }

    private void displayAlert(Coordinate c){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("CHECK");
        a.setContentText("Tre uguali in " + ((c.isRiga())? "riga " : "colonna ") + c.getCoordinata());
        a.setHeaderText("TRE!");
        a.showAndWait();
    }
}
