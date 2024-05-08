package View.Celle;

import Controller.MainGUI;
import View.Cella;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;

public abstract class CellaCentrale extends Cella {

    public CellaCentrale(MainGUI mg, Color r) {
        super(r);
        impostaNumero();
    }

    @Override
    public void impostaNumero(){
        Random r = new Random();
        int n = r.nextInt(3)+1;
        super.setValore(n);
        Text t = new Text(String.valueOf(n));
        super.getChildren().add(t);
    }
}
