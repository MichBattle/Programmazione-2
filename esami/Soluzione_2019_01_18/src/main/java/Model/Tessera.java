package Model;

import Controller.MainGUI;
import Model.Tessere.TesseraInterface;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Tessera extends StackPane implements TesseraInterface {
    MainGUI mg;
    private String contenuto;
    private boolean isCoperta;

    public Tessera(MainGUI mg) {
        super();
        this.mg = mg;
        isCoperta = true;
        impostaContenuto();

        setAction();

        super.getChildren().add(creaRettangolo());
    }

    public boolean isCoperta() {
        return isCoperta;
    }

    public MainGUI getMg() {
        return mg;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public abstract void impostaContenuto();

    public void scopri(){
        isCoperta = false;
        Text t = new Text(contenuto);
        super.getChildren().add(t);
    }

    public void nascondi(){
        isCoperta = true;
        super.getChildren().clear();
        super.getChildren().add(creaRettangolo());
    }

    private void setAction(){
        setOnMouseClicked(event -> {
            if(isCoperta)
                scopri();
            else
                nascondi();
        });
    }

    public Rectangle creaRettangolo(){
        Rectangle r = new Rectangle(40, 40);
        r.setFill(Color.YELLOW);
        r.setStroke(Color.BLACK);
        return r;
    }

    @Override
    public String toString() {
        return getContenuto();
    }
}
