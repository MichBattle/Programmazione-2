package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BottoniSorting extends VBox {
    private Button nome;
    private Button anno;
    private Button tipo;

    public BottoniSorting(MainGUI mg) {
        super();
        nome = new Button("Nome");
        anno = new Button("Anno");
        tipo = new Button("Tipo");

        setNomeAction(mg);
        setAnnoAction(mg);
        setTipoAction(mg);

        getChildren().addAll(new Text("Ordina Per:"), nome, anno, tipo);
        setSpacing(10);
    }

    private void setTipoAction(MainGUI mg) {
        tipo.setOnAction(event -> {
            mg.getTitoliDB().sortByType();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    private void setAnnoAction(MainGUI mg) {
        anno.setOnAction(event -> {
            mg.getTitoliDB().sortByAnno();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }

    private void setNomeAction(MainGUI mg) {
        nome.setOnAction(event -> {
            mg.getTitoliDB().sortByName();
            MainGUI.resetGeneralIndex();
            mg.getTitoliPane().aggiornaTitoliPane();
        });
    }
}
