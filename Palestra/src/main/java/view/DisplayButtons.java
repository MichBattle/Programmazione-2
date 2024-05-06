package view;

import controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import main.Persona;

import java.util.ArrayList;

public class DisplayButtons extends HBox {
    private MainGUI mg;

    private Button perNome;
    private Button perEta;

    public DisplayButtons(MainGUI mg) {
        super();
        this.mg = mg;

        perNome = new Button("Per nome");
        perEta = new Button("Per eta");

        perNome.setDisable(true);
        setPerEtaAction();
        setPerNomeAction();

        super.getChildren().addAll(perNome, perEta);
        super.setSpacing(5);
    }

    private void setPerNomeAction(){
        perNome.setOnAction(actionEvent -> {
            perEta.setDisable(false);

            int situazione = mg.getTopPane().getSortButtons().getSituazione();

            switch (situazione){
                case 0:
                    mg.getPalestra().sortByNome(mg.getPalestra().getAbbonati());
                    mg.getMidPane().createVBox(mg.getPalestra().getAbbonati());
                    break;
                case 1:
                    ArrayList<Persona> a = mg.getPalestra().getOnlyStudents();
                    mg.getPalestra().sortByNome(a);
                    mg.getMidPane().createVBox(a);
                    break;
                case 2:
                    ArrayList<Persona> b = mg.getPalestra().getOnlyAtlets();
                    mg.getPalestra().sortByNome(b);
                    mg.getMidPane().createVBox(b);
                    break;
            }

            perNome.setDisable(true);
        });
    }

    private void setPerEtaAction(){
        perEta.setOnAction(actionEvent -> {
            perNome.setDisable(false);

            int situazione = mg.getTopPane().getSortButtons().getSituazione();

            switch (situazione){
                case 0:
                    mg.getPalestra().sortByEta(mg.getPalestra().getAbbonati());
                    mg.getMidPane().createVBox(mg.getPalestra().getAbbonati());
                    break;
                case 1:
                    ArrayList<Persona> a = mg.getPalestra().getOnlyStudents();
                    mg.getPalestra().sortByEta(a);
                    mg.getMidPane().createVBox(a);
                    break;
                case 2:
                    ArrayList<Persona> b = mg.getPalestra().getOnlyAtlets();
                    mg.getPalestra().sortByEta(b);
                    mg.getMidPane().createVBox(b);
                    break;
            }

            perEta.setDisable(true);
        });
    }
}