package View.Celle;

import View.Celle.Strade.StradaEst;
import View.Celle.Strade.StradaNord;
import View.Celle.Strade.StradaOvest;
import View.Celle.Strade.StradaSud;
import View.Coordinate;
import View.GrigliaPane;
import View.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Prato extends Cella{
    private Coordinate c;
    private MainGUI mg;

    public Prato(MainGUI mg, GrigliaPane gp, Coordinate c) {
        super(Color.GREEN);
        this.c = c;
        this.mg = mg;
        setCellaClicked(gp, mg.getIndicationButtons().getButtons());
    }

    protected void setCellaClicked(GrigliaPane gp, ArrayList<Button> bottoni) {
        this.setOnMouseClicked(event -> {
            Button b = getBottoneDisabilitato(bottoni);

            if(b != null){
                if(b.getText().equals("Nord")){
                    gp.setGridCell(new StradaNord(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Sud")) {
                    gp.setGridCell(new StradaSud(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Est")) {
                    gp.setGridCell(new StradaEst(mg, gp, c), c.getX(), c.getY());
                }else if(b.getText().equals("Ovest")) {
                    gp.setGridCell(new StradaOvest(mg, gp, c), c.getX(), c.getY());
                }
                b.setDisable(true);
            }
        });
    }

    private Button getBottoneDisabilitato(ArrayList<Button> bottoni){
        for(Button b : bottoni){
            if(b.isDisabled())
                return b;
        }
        return null;
    }
}
