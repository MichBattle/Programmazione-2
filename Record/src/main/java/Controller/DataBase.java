package Controller;

import Controller.Records.Automobile;
import Controller.Records.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataBase {
    private ArrayList<Persona> persone;
    private ArrayList<Automobile> automobili;

    public DataBase() {
        persone = new ArrayList<>();
        automobili = new ArrayList<>();
    }

    public ArrayList<Persona> getPersone() {
        return persone;
    }

    public ArrayList<Automobile> getAutomobili() {
        return automobili;
    }

    public void addPersona(Persona p){
        persone.add(p);
    }

    public void addAuto(Automobile a){
        automobili.add(a);
    }

    public int getSize(){
        return Math.max(automobili.size(), persone.size());
    }

    public boolean isPresente(Recordd r){
        if(r instanceof Automobile a) {
            for(Automobile auto : automobili){
                if(a.toString().equals(auto.toString()))
                    return true;
            }
            return false;
        }
        else if(r instanceof Persona p){
            for(Persona pers : persone){
                if(pers.toString().equals(p.toString()))
                    return true;
            }
            return false;
        }
        return false;

    }

    public void shuffle(ArrayList<?> a){
        Collections.shuffle(a);
    }

    public void sortBySurname(boolean isAuto){
        if(isAuto){
            automobili.sort(Comparator.comparing(Recordd :: getField2));
        }else
            persone.sort(Comparator.comparing(Recordd :: getField2));
    }

    public void sortBy(boolean isAuto){
        if(isAuto){
            automobili.sort(Comparator.comparing(Recordd :: getField3));
        }else
            persone.sort(Comparator.comparing(Recordd :: getField3));
    }
}
