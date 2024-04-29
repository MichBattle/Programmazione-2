package View;

import Model.DataBase;
import Model.Medicina;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MedicinePane extends VBox {
    private ArrayList<Medicina> medicine;

    public MedicinePane(DataBase db) {
        super();
        medicine = db.getMedicine();

        updateLabel();
    }

    public void updateLabel(){
        super.getChildren().clear();
        for(Medicina meds : medicine){
            super.getChildren().add(createMedText(meds));
        }

        super.setSpacing(5);
    }

    private Text createMedText(Medicina m){
        return new Text(m.toString());
    }
}
