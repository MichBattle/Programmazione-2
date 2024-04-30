package View;

import Controller.Fans;
import Controller.Ventilators.Ventilatore;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class CenterPane extends VBox {
    private ArrayList<Ventilatore> fans;
    private MainGUI mg;

    private int spesaNextMonth;

    public CenterPane(MainGUI mg, Fans f) {
        super();
        this.mg = mg;
        spesaNextMonth = 0;
        fans = new ArrayList<>();
        fans = f.getVentilatori();

        for(Ventilatore v : fans){
            HBox hb = crea_cerchio_testo(crea_cerchio(v), crea_testo(v.toString()));
            super.getChildren().add(hb);
        }
    }

    private StackPane crea_cerchio(Ventilatore v){
        Button b = new Button();
        b.setOpacity(0);

        Circle c = new Circle(25.0);
        c.setFill(Color.BLUE);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(4);

        StackPane sp = new StackPane(c, b);

        setAction(b, c, v, sp);

        b.setMinSize(c.getRadius() * 2, c.getRadius() * 2);
        b.setMaxSize(c.getRadius() * 2, c.getRadius() * 2);

        return sp;
    }

    private Text crea_testo(String s){
        return new Text(s);
    }

    private HBox crea_cerchio_testo(StackPane cerchio, Text testo){
        HBox hb = new HBox();
        hb.getChildren().addAll(cerchio, testo);
        return hb;
    }

    private void setAction(Button b, Circle c, Ventilatore v, StackPane sp){
        b.setOnAction(actionEvent -> {
            if(!v.isAbbonato()){
                int spesa = spesaNextMonth + v.getCosto();
                if(spesa <= mg.getSoldi()){
                    spesaNextMonth = spesa;
                    c.setFill(Color.RED);
                    v.setAbbonato(true);
                    impostaCostosi();
                }else{
                    displayAlert();
                }
            }else{
                c.setFill(Color.BLUE);
                v.setAbbonato(false);
                spesaNextMonth -= v.getCosto();
            }
        });
    }

    private void displayAlert(){
        Alert win = new Alert(Alert.AlertType.INFORMATION);
        win.setTitle("ATTENZIONE!");
        win.setHeaderText("$$$");
        win.setContentText("non hai abbastanza soldi per abbonarti");
        win.showAndWait();
    }

    private void impostaCostosi(StackPane sp){
        for(Node n : sp.getChildren()){
            if(n instanceof Button){

            }
        }
    }
}
