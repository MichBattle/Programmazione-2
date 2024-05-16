package Model;

import Model.Records.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaRecord extends ArrayList<Record> {
    public ListaRecord() {
        super();
    }

    public void mescolaLista(){
        Collections.shuffle(this);
    }

    public void ordinaLista(){
        super.sort(Comparator.comparing(Record :: getField2));
    }

    public void ordinaListaPerTerzoField(){
        super.sort(Comparator.comparingInt(Record :: getField3));
    }

    public boolean isPresente(Record r){
        for (Record record : this){
            if(record.equals(r))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Record r : this){
            str.append(r.toString()).append("\n");
        }
        return str.toString();
    }
}
