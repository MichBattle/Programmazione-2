package Model.utils;

import Model.Gioco;
import Model.celle.CellaBase;
import Model.celle.CellaBoom;
import Model.celle.CellaDiv;
import Model.celle.CellaMolt;

public class CellaFactory {
    private Gioco g;

    public CellaFactory(Gioco g) {
        this.g = g;
    }

    public CellaBase cellaBase(){
        return new CellaBase(g);
    }

    public CellaMolt cellaMolt(){
        return new CellaMolt(g);
    }

    public CellaDiv cellaDiv(){
        return new CellaDiv(g);
    }

    public CellaBoom cellaBoom(){
        return new CellaBoom(g);
    }
}