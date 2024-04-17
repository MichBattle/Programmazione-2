package Model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Mazzo extends Stack<Carta>{

    public Mazzo() {
        super();
        for (Seme seme : Seme.values()) {
            if(seme != Seme.J)
                for (int valore = 1; valore <= 4; valore++) {
                    add(new Carta(valore, seme));
                }
        }
        add(new Carta(0, Seme.J));
    }

    public void sortMazzo(){
        sort(Comparator.comparingInt(Carta::getValore)
                .thenComparing(Carta::getSeme));
    }

    public void mescolaMazzo(){
        Collections.shuffle(this);
    }
}
