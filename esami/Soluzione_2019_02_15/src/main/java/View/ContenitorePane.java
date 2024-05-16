package View;

import Model.ListaRecord;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ContenitorePane extends AnchorPane {
    private ListaRecordPane listaRecordPane;
    private ButtonPane buttonPane;
    private Button aggiungi;
    private Bottoni bottoni;

    public ContenitorePane(ListaRecord listaRecord, boolean isAutoList) {
        super();
        listaRecordPane = new ListaRecordPane(listaRecord, isAutoList);
        bottoni = new Bottoni(listaRecordPane, isAutoList);
        buttonPane = new ButtonPane(bottoni, isAutoList);
        aggiungi = bottoni.getAggiungi();

        super.getChildren().addAll(listaRecordPane, buttonPane, aggiungi);

        AnchorPane.setTopAnchor(listaRecordPane, 0.0);
        AnchorPane.setLeftAnchor(listaRecordPane, 0.0);

        AnchorPane.setTopAnchor(buttonPane, 200.0);

        AnchorPane.setBottomAnchor(aggiungi, 0.0);

        if(isAutoList){
            AnchorPane.setLeftAnchor(aggiungi, 0.0);
            AnchorPane.setLeftAnchor(buttonPane, 0.0);
        }else{
            AnchorPane.setRightAnchor(aggiungi, 0.0);
            AnchorPane.setRightAnchor(buttonPane, 0.0);
        }
    }
}
