package main;

import java.util.ArrayList;
import java.util.Comparator;

public class Palestra {
    private ArrayList<Persona> abbonati;

    public Palestra() {
        abbonati = new ArrayList<>();
        abbonati.add(new Studente("Bianchi", "Anna", "1990", "4", "UNIPD", false));
        abbonati.add(new Studente("Bianchi", "Giovanni", "1995", "3", "UNITN", true));
        abbonati.add(new AtletaStudente("Ferrari", "Alberto", "1993", "7", "UNITN", false, "atletica", true));
        abbonati.add(new AtletaStudente("Ferrari", "Vincenzo", "1997", "8", "UNIVR", true, "atletica", false));
        abbonati.add(new Persona("Rossi", "Carla", "1990", "2"));
        abbonati.add(new Persona("Rossi", "Mario", "1950", "1"));
        abbonati.add(new Atleta("Verdi", "Alice", "1967", "6", "curling", true));
        abbonati.add(new Atleta("Verdi", "Giacomo", "1991", "5", "nuoto", false));

        sortByNome(abbonati);
    }

    public ArrayList<Persona> getAbbonati() {
        return abbonati;
    }

    public void sortByNome(ArrayList<Persona> a){
        a.sort(Comparator.comparing(Persona :: getCognome).thenComparing(Persona :: getNome));
    }

    public void sortByEta(ArrayList<Persona> a){
        a.sort(Comparator.comparing(Persona :: getAnnoNascita));
    }

    public ArrayList<Persona> getOnlyStudents(){
        ArrayList<Persona> a = new ArrayList<>();
        for(Persona p : abbonati){
            if(p instanceof Studente || p instanceof AtletaStudente){
                a.add(p);
            }
        }
        return a;
    }

    public ArrayList<Persona> getOnlyAtlets(){
        ArrayList<Persona> a = new ArrayList<>();
        for(Persona p : abbonati){
            if(p instanceof Atleta || p instanceof AtletaStudente){
                a.add(p);
            }
        }
        return a;
    }
}