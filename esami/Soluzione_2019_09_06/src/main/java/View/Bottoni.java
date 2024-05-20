package View;

import Model.Cerchio;
import Model.EmptyFigure;
import Model.Triangolo;
import com.soluzione_2019_09_06.MainFX;
import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

import java.util.Random;

public class Bottoni {
    private Button cancella;
    private Button cerchio;
    private Button triangolo;
    private Button random;
    private Button clearAll;
    private Button check;

    public Bottoni(Casella c) {
        cancella = new Button("C");
        cerchio = new Button("O");
        triangolo = new Button("T");
        random = new Button("R");

        clearAll = new Button("Clear All");
        check = new Button("Check");

        setCancellaAction(c);
        setCerchioAction(c);
        setTriangoloAction(c);
        setRandomAction(c);
    }

    private void setCancellaAction(Casella c){
        cancella.setOnAction(event -> {
            c.setForma(new EmptyFigure(MainFX.getLATO_EMPTY_FIGURE()));
        });
    }

    private void setCerchioAction(Casella c){
        cerchio.setOnAction(event -> {
            c.setForma(new Cerchio(MainFX.getRAGGIO_CERCHIO()));
        });
    }

    private void setTriangoloAction(Casella c){
        triangolo.setOnAction(event -> {
            c.setForma(new Triangolo(MainFX.getLATO_TRIANGOLO()));
        });
    }

    private void setRandomAction(Casella c){
        random.setOnAction(event -> {
            Random r = new Random();
            Shape forma;
            if(r.nextBoolean())
                forma = new Triangolo(MainFX.getLATO_TRIANGOLO());
            else
                forma = new Cerchio(MainFX.getRAGGIO_CERCHIO());
            c.setForma(forma);
        });
    }

    public Button getCancella() {
        return cancella;
    }

    public Button getCerchio() {
        return cerchio;
    }

    public Button getTriangolo() {
        return triangolo;
    }

    public Button getRandom() {
        return random;
    }

    public Button getClearAll() {
        return clearAll;
    }

    public Button getCheck() {
        return check;
    }
}
