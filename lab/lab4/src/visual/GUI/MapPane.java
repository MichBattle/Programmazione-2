package visual.GUI;

import data.blocks.AirBlock;
import data.blocks.interfaces.Block;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import utils.WrongCoordinatesException;
import visual.textual.Mappa;

public class MapPane extends GridPane {
    public MapPane() {
        super();
        initialise_air();
    }

    public void initialise_air(){
        for(int i = 0; i < Mappa.ROWS; i++){
            for(int k = 0; k < Mappa.COLUMNS; k++){
                BlockPane bp = new BlockPane(new AirBlock());
                super.add(bp, k, i);
            }
        }
    }

    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }

    public BlockPane get_block_at_coord(int x, int y) throws WrongCoordinatesException {
        checkCoords(x, y);
        return (BlockPane)getElementAt(this, y, x);
    }

    public void checkCoords(int x, int y) throws WrongCoordinatesException {
        if(x > Mappa.ROWS-1 || y > Mappa.COLUMNS-1 || y < 0 || x < 0)
            throw new WrongCoordinatesException("Errore nelle coordinate inserite");
    }

    public void setCell(Block b, int x, int y) throws WrongCoordinatesException {
        if(this.get_block_at_coord(x, y) == null){
            super.add(new BlockPane(b), y, x);
        }else{
            this.get_block_at_coord(x, y).changeBlock(b);
        }
    }
}