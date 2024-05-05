package View;

import Controller.DataBase;
import Controller.Recordd;
import Controller.Records.Automobile;
import Controller.Records.Persona;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Pannello extends VBox {
    private MainGUI mg;
    private Stage s;

    private Rectangle r;
    private StackPane stackPane;
    private VBox vBox;

    private Button mescola;
    private Button ordina;
    private Button conta;
    private Button ordinaPer;
    private Button aggiungi;
    private Button pulisci;

    public Pannello(MainGUI mg, Recordd rec){
        super();
        this.mg = mg;
        vBox = new VBox();
        String ordine = (rec instanceof Automobile)? "prezzo" : "anno"; //stringa per il bottone ordina per ...
        String tipologia = (rec instanceof Automobile)? "auto" : "persona"; //stringa per il bottone aggiungi ...

        r = new Rectangle(300, 25);
        r.setStroke(Color.BLACK);
        r.setFill(Color.WHITE);
        stackPane = new StackPane(r, vBox);

        mescola = new Button("mescola");
        ordina = new Button("ordina");
        conta = new Button("conta");
        ordinaPer = new Button("ordina per " + ordine);
        aggiungi = new Button("new " + tipologia);
        pulisci = new Button("pulisci");

        boolean isAuto = rec instanceof Automobile;

        setAggiungi(isAuto);
        setContaAction(isAuto);
        setMescolaAction(isAuto);
        setOrdinaAction(isAuto);
        setOrdinaPerAction(isAuto);
        setPulisciAction(isAuto);

        super.getChildren().addAll(stackPane, mescola, ordina, conta, ordinaPer, aggiungi, pulisci);
    }

    public Rectangle getR() {
        return r;
    }

    /**
     * crea il testo con dentro i field del record
     */
    public Text creaTesto(Recordd r){
        return new Text(r.toString());
    }

    /**
     * imposta la dimensione del rettangolo aumentando l'altezza in base al numero massimo di record contenuti dai 2 arraylist
     * viene usato nel MainGUI
     */
    public void setRectangleSize(Rectangle r){
        r.setHeight((mg.getDb().getSize()+1)*25);
    }

    /**
     * imposta l'azione del bottone aggiungi
     * fa apparire una scena nuova per inserire i campi
     */
    private void setAggiungi(boolean isAuto){
        aggiungi.setOnAction(actionEvent -> {
            s = new Stage();
            s.setTitle("Inserisci Record");
            Scene k;
            if(isAuto){
                k = creaScena("Marca", "Modello", "Prezzo", true);
            }else{
                k = creaScena("Nome", "Cognome", "Anno", false);
            }

            s.setScene(k);
            s.showAndWait();

            mg.setRectangleSize();
        });
    }

    /**
     * crea la scena da far apparire
     */
    private Scene creaScena(String field1, String field2, String field3, boolean isAuto){
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();

        HBox h1 = new HBox(new Text(field1), t1);
        HBox h2 = new HBox(new Text(field2), t2);
        HBox h3 = new HBox(new Text(field3), t3);
        Button b = new Button("controlla e inserisci");
        setInserisciAction(b, t1, t2, t3, isAuto);

        h1.setSpacing(5);
        h2.setSpacing(5);
        h3.setSpacing(5);

        VBox vb = new VBox(h1, h2, h3, b);
        vb.setSpacing(5);

        return new Scene(vb, 500, 500);
    }

    /**
     * imposta l'azione del bottone di inserimento della scena nuova
     * controlla che non ci siano campi vuoti
     * controlla che il terzo campo sia un numero
     * controlla se il record che si vuole inserire sia unico
     * in caso contrario manda un alert dedicato ad ogni caso
     * altrimenti inserisce il record
     */
    private void setInserisciAction(Button b, TextField t1, TextField t2, TextField t3, boolean isAuto){
        b.setOnAction(actionEvent -> {
            DataBase db = mg.getDb();
            //no campi vuoti
            if(!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty()){
                //terzo campo rappresentabile come intero
                if(t3.getText().matches("\\d+")){
                    if(isAuto){
                        Automobile a = new Automobile(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                        //no record uguali
                        if(!db.isPresente(a)){
                            db.addAuto(a);
                            vBox.getChildren().add(creaTesto(a));
                            System.out.println("NUOVA AUTO: " + a);
                            s.close();
                        }else
                            displayAlert("Record gia presente");
                    } else {
                        Persona p = new Persona(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()));
                        //no record uguali
                        if(!db.isPresente(p)){
                            db.addPersona(p);
                            vBox.getChildren().add(creaTesto(p));
                            System.out.println("NUOVA PERSONA: " + p);
                            s.close();
                        }else
                            displayAlert("Record gia presente");
                    }
                }else{
                    displayAlert("Il terzo parametro deve essere un numero decimale");
                }
            }else{
                displayAlert("Non ci possono essere campi vuoti");
            }

            mg.setRectangleSize();
        });
    }

    /**
     * mostra un WARNING alert con la stringa desiderata
     */
    private void displayAlert(String s){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("ATTENZIONE");
        a.setContentText(s);
        a.showAndWait();
    }

    /**
     * imposta l'azione del bottone conta
     * stampa su console il numero di auto o persone
     */
    private void setContaAction(boolean isAuto){
        DataBase db = mg.getDb();
        if(isAuto)
            conta.setOnAction(actionEvent -> System.out.println("SONO PRESENTI " + db.getAutomobili().size() + " AUTO NEL DB"));
        else
            conta.setOnAction(actionEvent -> System.out.println("SONO PRESENTI " + db.getPersone().size() + " PERSONE NEL DB"));
    }

    /**
     * imposta l'azione del bottone mescola
     * mescola l'arraylist di auto o di persone e aggiorna la GUI
     */
    private void setMescolaAction(boolean isAuto){
        DataBase db = mg.getDb();
        if(isAuto){
            mescola.setOnAction(actionEvent -> {
                db.shuffle(db.getAutomobili());
                ricreaStackPane(db.getAutomobili());
            });
        }else{
            mescola.setOnAction(actionEvent -> {
                db.shuffle(db.getPersone());
                ricreaStackPane(db.getPersone());
            });
        }
    }

    /**
     * ricrea il VBox dello stackpane
     * usato in caso di modifiche agli arraylist come shuffle, sort o clear
     */
    private void ricreaStackPane(ArrayList<?> a){
        vBox.getChildren().clear();
        for(Object o : a){
            vBox.getChildren().add(creaTesto((Recordd) o));
        }
    }

    /**
     * imposta l'azione del bottone ordina
     * ordina l'arraylist di auto o persone in base al field2
     */
    private void setOrdinaAction(boolean isAuto){
        DataBase db = mg.getDb();
        ordina.setOnAction(actionEvent -> {
            db.sortBySurname(isAuto);
            if(isAuto)
                ricreaStackPane(db.getAutomobili());
            else
                ricreaStackPane(db.getPersone());
        });
    }

    /**
     * imposta l'azione del bottone ordina
     * ordina l'arraylist di auto o persone in base al field3
     */
    private void setOrdinaPerAction(boolean isAuto){
        DataBase db = mg.getDb();
        ordinaPer.setOnAction(actionEvent -> {
            db.sortBy(isAuto);
            if(isAuto)
                ricreaStackPane(db.getAutomobili());
            else
                ricreaStackPane(db.getPersone());
        });
    }

    /**
     * imposta l'azione del bottone pulisci
     * elimina tutti i record di persone o auto e aggiorna la GUI
     */
    private void setPulisciAction(boolean isAuto){
        DataBase db = mg.getDb();
        pulisci.setOnAction(actionEvent -> {
            if(isAuto)
                db.getAutomobili().clear();
            else
                db.getPersone().clear();

            mg.setRectangleSize();
            vBox.getChildren().clear();
        });
    }
}