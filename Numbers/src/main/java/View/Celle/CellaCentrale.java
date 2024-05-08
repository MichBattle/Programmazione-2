package View.Celle;

import Controller.MainGUI;
import View.Cella;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Random;

public abstract class CellaCentrale extends Cella {

    public CellaCentrale(Color r) {
        super(r);
        impostaNumero();
    }

    @Override
    public void impostaNumero(){
        if(super.getChildren().getLast() instanceof Text){
            super.getChildren().removeLast();
            super.getChildren().add(new Text(String.valueOf(super.getValore())));
        }else{
            Random r = new Random();
            int n = r.nextInt(4);

            super.setValore(n);

            Text t = new Text(String.valueOf(n));
            super.getChildren().add(t);
        }

    }
}
