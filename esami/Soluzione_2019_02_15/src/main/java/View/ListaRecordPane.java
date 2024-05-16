package View;

import Model.ListaRecord;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ListaRecordPane extends StackPane {
    private ListaRecord listaRecord;
    private boolean isAutoList;

    private Rectangle rectangle;
    private Text testo;

    public ListaRecordPane(ListaRecord listaRecord, boolean isAutoList) {
        super();
        this.listaRecord = listaRecord;
        this.isAutoList = isAutoList;

        rectangle = new Rectangle(400, 200);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.GREY);
        testo = new Text();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(testo);
        vBox.setAlignment(Pos.TOP_LEFT);

        super.getChildren().addAll(rectangle, vBox);
    }

    public boolean isAutoList() {
        return isAutoList;
    }

    public ListaRecord getListaRecord() {
        return listaRecord;
    }

    public void aggiornaTestoLista(){
        testo.setText(listaRecord.toString());
    }
}
