package View;

import Model.Cella;
import Model.Gioco;
import Model.celle.CellaBoom;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TabPane extends GridPane {
    private final static int DIM_CELLS = 50;

    private Gioco g;
    private MainGUI mg;

    public TabPane(Gioco g, MainGUI mg) {
        super();

        this.g = g;
        this.mg = mg;

        Cella[][] matrix = g.getTabellone();
        for(int i = 0; i < Gioco.DIM_TABELLONE; i++){
            for(int k = 0; k < Gioco.DIM_TABELLONE; k++){
                StackPane sp = creaCella(matrix[i][k], i, k);
                add(sp, i, k);
            }
        }
    }

    private StackPane creaCella(Cella c, int row, int col){
        Rectangle r = new Rectangle(DIM_CELLS, DIM_CELLS);
        r.setStroke(Color.BLACK);
        r.setFill(Color.YELLOW);
        Button b = new Button();
        b.setPrefSize(DIM_CELLS, DIM_CELLS);
        b.setBackground(Background.fill(Color.TRANSPARENT));
        setAction(b, c, r, row, col);
        return new StackPane(r, b);
    }

    private void setAction(Button b, Cella c, Rectangle r, int row, int col){
        b.setOnAction(actionEvent -> {
            if(g.getTentativi() > 0){
                if(c.isCoperta()){
                    g.setTentativi(g.getTentativi() - 1);
                    attivaCella(b, c, r, row, col);
                }
            }
        });
    }

    private void attivaCella(Button b, Cella c, Rectangle r, int row, int col){
        if(g.getTentativi() >= 0){
            if(c.isCoperta()) {
                scopriCella(b, c, r);
                c.azione();
                if(c instanceof CellaBoom)
                    attiva_boom(row, col);
                else
                    scopriCella(b, c, r);
            }
        }
        mg.updatePunteggio();
    }

    private void scopriCella(Button b, Cella c, Rectangle r){
        r.setFill(c.getColore());
        b.setText(c.content());
    }

    public void attiva_boom(int row, int col){
        Cella[][] matrice = g.getTabellone();

        //attivo quelle sulla colonna
        for(int i = 0; i < Gioco.DIM_TABELLONE; i++){
            if(matrice[i][col].isCoperta()) {
                if (i != row){
                    StackPane sp = getElementAtCoords(this, i, col);
                    Rectangle r = getRectangle(sp);
                    Button b = getButton(sp);
                    attivaCella(b, matrice[i][col], r, i, col);
                }
            }
        }

        //attivo quelle sulla riga
        for(int i = 0; i < Gioco.DIM_TABELLONE; i++){
            if(matrice[row][i].isCoperta()){
                if(i != col){
                    StackPane sp = getElementAtCoords(this, row, i);
                    Rectangle r = getRectangle(sp);
                    Button b = getButton(sp);

                    attivaCella(b, matrice[row][i], r, row, i);
                }
            }
        }
    }

    private static StackPane getElementAtCoords(GridPane gridPane, int x, int y) {
        StackPane stackPane = null;
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x && node instanceof StackPane) {
                stackPane = (StackPane) node;
                break;
            }
        }
        return stackPane;
    }

    private static Rectangle getRectangle(StackPane stackPane) {
        Rectangle rectangle = null;
        for (Node node : stackPane.getChildren()) {
            if (node instanceof Rectangle) {
                rectangle = (Rectangle) node;
                break;
            }
        }
        return rectangle;
    }

    private static Button getButton(StackPane stackPane) {
        Button button = null;
        for (Node node : stackPane.getChildren()) {
            if (node instanceof Button) {
                button = (Button) node;
                break;
            }
        }
        return button;
    }
}