package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class Mano {
    private String giocatore;
    private ArrayList<Carta> carte;

    public Mano(String giocatore, ArrayList<Carta> carte) {
        this.giocatore = giocatore;
        this.carte = new ArrayList<>(carte);
        sortMano();
    }

    public ArrayList<Carta> getCarte() {
        return carte;
    }

    public void sortMano(){
        carte.sort(Comparator.comparingInt(Carta :: getValore).thenComparing(Carta :: getSeme));
    }

    public void aggiungiCarta(Carta c){
        carte.add(c);
        sortMano();
    }

    public void rimuoviCarta(int index){
        carte.remove(index);
        sortMano();
    }

    @Override
    public String toString() {
        return giocatore + ": " + carte.toString();
    }
}
