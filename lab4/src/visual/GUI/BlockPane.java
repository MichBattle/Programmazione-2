package visual.GUI;

import data.blocks.interfaces.Block;
import data.blocks.utils.BlockComparator;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BlockPane extends StackPane {
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;

    private Block b;
    private Rectangle sfondo;
    private Text testo;

    public BlockPane(Block b) {
        super();
        this.b = b;
        inizializza();
    }

    public void inizializza(){
        sfondo = new Rectangle(DIM_SQUARE,DIM_SQUARE);
        sfondo.setFill(this.chooseColorFromBlock(b));
        sfondo.setStroke(BLOCK_BORDER);
        testo = new Text(""+b.display_in_inventory());
        testo.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
        testo.setFill(FONT_FILL);
        testo.setStroke(FONT_BORDER);
        super.getChildren().addAll(sfondo,testo);
        super.setAlignment(Pos.CENTER);
        Tooltip t = new Tooltip(b.toString());
        Tooltip.install(this,t);
    }

    private Color chooseColorFromBlock(Block b){
        int int_of_block = BlockComparator.get_value_of_block(b);
        Color c = switch (int_of_block) {
            case 0 -> Color.BLACK;
            case 1 -> Color.WHITE;
            case 2 -> Color.AQUA;
            case 3 -> Color.GREEN;
            case 4 -> Color.BEIGE;
            case 5 -> Color.AZURE;
            case 6 -> Color.DARKGRAY;
            case 7 -> Color.SILVER;
            default -> null;
        };
        return c;
    }

    public void changeBlock(Block a){
        this.b = a;
        inizializza();
    }
}
