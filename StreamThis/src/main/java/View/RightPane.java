package View;

import Controller.ArchivioTitoli;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class RightPane extends VBox {
    private MainGUI mg;
    private ArchivioTitoli archivio;

    private Button nome;
    private Button anno;
    private Button tipo;

    public RightPane(MainGUI mg, ArchivioTitoli archivio) {
        super();
        this.mg = mg;
        this.archivio = archivio;

        nome = new Button("Nome");
        anno = new Button("Anno");
        tipo = new Button("Tipo");

        attivaAnno();
        attivaNome();
        attivaTipo();

        super.getChildren().addAll(new Text("Ordina per:"), nome, anno, tipo);
        super.setSpacing(5);
    }

    private void attivaNome(){
        nome.setOnAction(actionEvent -> {
            archivio.sortByName();
            mg.resetAll();
        });
    }

    private void attivaAnno(){
        anno.setOnAction(actionEvent -> {
            archivio.sortByAnno();
            mg.resetAll();
        });
    }

    private void attivaTipo(){
        tipo.setOnAction(actionEvent -> {
            archivio.sortByType();
            mg.resetAll();
        });
    }
}
