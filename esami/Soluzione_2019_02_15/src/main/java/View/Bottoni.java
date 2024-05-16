package View;

import Model.AlertDisplayer;
import Model.Record;
import Model.Records.Automobile;
import Model.Records.Persona;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bottoni {
    private Button mescola;
    private Button ordina;
    private Button conta;
    private Button ordinaPer;
    private Button aggiungi;

    private String soutString;

    public Bottoni(ListaRecordPane listaRecordPane, boolean isAutoList) {
        mescola = new Button("Mescola");
        ordina = new Button("Ordina");
        conta = new Button("Conta");

        soutString = soutHelper(isAutoList);

        if(!isAutoList){
            ordinaPer = new Button("Ordina per anno");
            aggiungi = new Button("New Person'");
        }else{
            ordinaPer = new Button("Ordina per prezzo");
            aggiungi = new Button("New Auto'");
        }

        setMescolaAction(listaRecordPane);
        setOrdinaAction(listaRecordPane);
        setContaAction(listaRecordPane);
        setOrdinaPerAction(listaRecordPane);
        setAggiungiAction(listaRecordPane);
    }

    public Button getMescola() {
        return mescola;
    }

    public Button getOrdina() {
        return ordina;
    }

    public Button getConta() {
        return conta;
    }

    public Button getOrdinaPer() {
        return ordinaPer;
    }

    public Button getAggiungi() {
        return aggiungi;
    }

    private void setMescolaAction(ListaRecordPane listaRecordPane){
        mescola.setOnAction(event -> {
            listaRecordPane.getListaRecord().mescolaLista();
            listaRecordPane.aggiornaTestoLista();
            System.out.println("MESCOLO " + soutString);
        });
    }

    private void setOrdinaAction(ListaRecordPane listaRecordPane){
        ordina.setOnAction(event -> {
            listaRecordPane.getListaRecord().ordinaLista();
            listaRecordPane.aggiornaTestoLista();
            System.out.println("ORDINO " + soutString);
        });
    }

    private void setContaAction(ListaRecordPane listaRecordPane){
        conta.setOnAction(event -> {
            System.out.println("CI SONO " + listaRecordPane.getListaRecord().size() + soutString);
        });
    }

    private void setOrdinaPerAction(ListaRecordPane listaRecordPane){
        ordinaPer.setOnAction(event -> {
            listaRecordPane.getListaRecord().ordinaListaPerTerzoField();
            listaRecordPane.aggiornaTestoLista();
            System.out.println("ORDINO PER TERZO FIELD " + soutString);
        });
    }

    private void setAggiungiAction(ListaRecordPane listaRecordPane){
        aggiungi.setOnAction(event -> {
            Stage s = new Stage();
            s.setTitle("Inserisci Record");
            Scene k;

            if(listaRecordPane.isAutoList())
                k = creaScena(s, "Marca", "Modello", "Prezzo", listaRecordPane);
            else
                k = creaScena(s, "Nome", "Cognome", "Anno", listaRecordPane);

            s.setScene(k);
            s.showAndWait();
        });
    }

    private Scene creaScena(Stage s, String field1, String field2, String field3, ListaRecordPane listaRecordPane){
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();

        VBox v1 = new VBox(new Text(field1), new Text(field2), new Text(field3));
        v1.setSpacing(18);
        VBox v2 = new VBox(t1, t2, t3);
        v2.setSpacing(5);

        HBox h1 = new HBox(v1, v2);
        h1.setSpacing(10);
        Button b = new Button("controlla e inserisci");

        AnchorPane ap = new AnchorPane(h1, b);

        AnchorPane.setBottomAnchor(b, 0.0);
        AnchorPane.setLeftAnchor(b, 0.0);

        AnchorPane.setTopAnchor(h1, 0.0);
        AnchorPane.setLeftAnchor(h1, 85.0);

        setInserisciAction(s, b, t1, t2, t3, listaRecordPane);

        return new Scene(ap, 400, 325);
    }

    private void setInserisciAction(Stage s, Button b, TextField t1, TextField t2, TextField t3, ListaRecordPane listaRecordPane){
        b.setOnAction(actionEvent -> {
            //no campi vuoti
            if(!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty()){
                //terzo campo rappresentabile come intero
                if(t3.getText().matches("\\d+")){
                    Record r;
                    String str;
                    if(listaRecordPane.isAutoList()){
                        r = new Automobile(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                        str = "AGGIUNGO AUTO: ";
                    } else {
                        r = new Persona(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                        str = "AGGIUNGO PERSONA: ";
                    }

                    //no record uguali
                    if(!listaRecordPane.getListaRecord().isPresente(r)) {
                        //per non uscire dal rettangolo faccio inserire al massimo 12 record
                        if(listaRecordPane.getListaRecord().size() < 12){
                            listaRecordPane.getListaRecord().add(r);
                            listaRecordPane.aggiornaTestoLista();
                            System.out.println(str + t1.getText() + " " + t2.getText() + " " + t3.getText());
                            s.close();
                        }else
                            AlertDisplayer.display_ERROR_alert("Numero massimo di record raggiunto");
                    }else
                        AlertDisplayer.display_ERROR_alert("Record gia presente");
                }else
                    AlertDisplayer.display_ERROR_alert("Il terzo parametro deve essere un numero decimale");
            }else
                AlertDisplayer.display_ERROR_alert("Non ci possono essere campi vuoti");
        });
    }

    private String soutHelper(boolean isAutoList){
        return (isAutoList)? "AUTO" : "PERSONE";
    }
}
