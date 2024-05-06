package view;

import controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SortButtons extends HBox {
    private MainGUI mg;

    private Button tutti;
    private Button studenti;
    private Button atleti;

    private int situazione;

    public SortButtons(MainGUI mg) {
        super();
        this.mg = mg;
        situazione = 0;

        tutti = new Button("Tutti");
        studenti = new Button("Studenti");
        atleti = new Button("Atleti");

        tutti.setDisable(true);

        setTuttiAction();
        setAtletiAction();
        setStudentiAction();

        super.getChildren().addAll(tutti, studenti, atleti);
        super.setSpacing(5);
    }

    //0 = tutti, 1 = studenti, 2 = atleti
    public int getSituazione() {
        return situazione;
    }

    private void setTuttiAction(){
        tutti.setOnAction(actionEvent -> {
            studenti.setDisable(false);
            atleti.setDisable(false);

            mg.getMidPane().createVBox(mg.getPalestra().getAbbonati());
            situazione = 0;

            tutti.setDisable(true);
        });
    }

    private void setStudentiAction(){
        studenti.setOnAction(actionEvent -> {
            tutti.setDisable(false);
            atleti.setDisable(false);

            mg.getMidPane().createVBox(mg.getPalestra().getOnlyStudents());
            situazione = 1;

            studenti.setDisable(true);
        });
    }

    private void setAtletiAction(){
        atleti.setOnAction(actionEvent -> {
            studenti.setDisable(false);
            tutti.setDisable(false);

            mg.getMidPane().createVBox(mg.getPalestra().getOnlyAtlets());
            situazione = 2;

            atleti.setDisable(true);
        });
    }
}
