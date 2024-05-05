package View;

import Controller.DataBase;
import Controller.Records.Automobile;
import Controller.Records.Persona;
import javafx.scene.layout.HBox;

public class MainGUI extends HBox {
    private DataBase db;

    private Pannello pannelloPersone;
    private Pannello pannelloAuto;

    public MainGUI() {
        super();
        db = new DataBase();

        pannelloPersone = new Pannello(this, new Persona("", "", 0));
        pannelloAuto = new Pannello(this, new Automobile("", "", 0));

        super.getChildren().addAll(pannelloPersone, pannelloAuto);
    }

    public DataBase getDb() {
        return db;
    }

    public void setRectangleSize(){
        pannelloPersone.setRectangleSize(pannelloPersone.getR());
        pannelloAuto.setRectangleSize(pannelloAuto.getR());
    }
}
