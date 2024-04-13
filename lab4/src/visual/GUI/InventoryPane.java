package visual.GUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class InventoryPane extends HBox {
    private Text t;
    private HBox hb;

    public InventoryPane() {
        super();
        addText();
        hb = new HBox();
        super.getChildren().add(hb);
    }

    public void addText(){
        t = new Text("Inventory: ");
        StackPane sp = new StackPane();
        Rectangle r = new Rectangle(BlockPane.DIM_SQUARE,BlockPane.DIM_SQUARE);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.TRANSPARENT);
        sp.getChildren().add(r);
        sp.getChildren().add(t);
        super.getChildren().add(sp);
    }
}