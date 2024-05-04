package View;

import Model.Gioco;
import Model.Tessera;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonPane extends HBox {
    private MainGUI mg;

    private Button reset;
    private Button cheat;

    public ButtonPane(MainGUI mg) {
        super();
        this.mg = mg;

        reset = new Button("reset");
        cheat = new Button("cheat");

        attivaReset();
        attivaCheat();

        super.getChildren().addAll(reset, cheat);
    }

    private void attivaReset(){
        reset.setOnAction(actionEvent -> mg.resetAll());
    }

    private GridPane createCheatTable(){
        Gioco g = mg.getGioco();
        Tessera[][] grid = g.getScacchiera();

        Rectangle r;
        GridPane gp = new GridPane();

        for(int i = 0; i < g.getN(); i++){
            for(int k = 0; k < g.getN(); k++){
                r = new Rectangle(50, 50);
                r.setFill(Color.YELLOW);
                r.setStroke(Color.BLACK);
                Text text = new Text(grid[i][k].getValore());
                gp.add(new StackPane(r, text), k, i);
            }
        }

        return gp;
    }

    private void attivaCheat(){
        cheat.setOnAction(actionEvent -> {
            Stage s = new Stage();
            s.setTitle("CHEAT");
            Scene k = new Scene(createCheatTable(), mg.getGioco().getN()*50, mg.getGioco().getN()*50);
            s.setScene(k);
            s.show();
        });
    }
}