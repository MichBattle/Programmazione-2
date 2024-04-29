package View;

import Controller.MainFX;
import Model.DataBase;
import Model.RicettaUtente;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainGUI extends VBox {
    private DataBase db;

    private UserPane up;
    private AnchorPane hb;
    private MedicinePane mp;
    private RicettePane rp;
    private SelectPane sp;

    public MainGUI() {
        super();
        db = new DataBase();

        up = new UserPane();

        hb = new AnchorPane();
        mp = new MedicinePane(db);
        rp = new RicettePane(this, db);
        sp = new SelectPane(this);

        hb.getChildren().addAll(mp, sp, rp);

        AnchorPane.setRightAnchor(rp, 0.0);
        AnchorPane.setTopAnchor(rp, 0.0);
        AnchorPane.setLeftAnchor(mp, 0.0);
        AnchorPane.setTopAnchor(mp, 0.0);

        AnchorPane.setTopAnchor(sp, 500.0 / 2);
        AnchorPane.setLeftAnchor(sp, 250.0);

        super.getChildren().addAll(hb, up);
    }

    public void updateSelectPaneText(RicettaUtente ric){
        sp.updateLabel(ric);
    }

    public int getSoldi(){
        return up.getSoldi();
    }

    public void setSoldi(int soldi) {
        up.setSoldi(soldi);
    }

    public void updateSoldiLabel(){
        up.updateSoldiLabel();
    }

    public void updateMedicinsLable(){
        mp.updateLabel();
    }
}