package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Mano{
    private ArrayList<Carta> mano;
    public Mano() {
        mano = new ArrayList<>();
    }

    public void aggiungiCarta(Carta c) {
        mano.add(c);
        ordinaMano();
    }

    public void ordinaMano() {
        mano.sort(Comparator.comparingInt(Carta::getValore).thenComparing(Carta::getSeme));
    }

    public Carta getRandomCard() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(mano.size());
        return mano.get(randomIndex);
    }

    public void remove(Carta c){
        mano.remove(c);
    }

    public boolean rimuoviDoppie() {
        boolean ret = false;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        for (Carta carta : mano) {
            switch (carta.getValore()) {
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
            }
        }

        if(c1 > 1){
            removeAllElementsWithValue(1);
            ret = true;
        }
        if(c2 > 1){
            removeAllElementsWithValue(2);
            ret = true;
        }
        if(c3 > 1){
            removeAllElementsWithValue(3);
            ret = true;
        }
        if(c4 > 1){
            removeAllElementsWithValue(4);
            ret = true;
        }

        return ret;
    }

    private void removeAllElementsWithValue(int value){
        mano.removeIf(carta -> carta.getValore() == value);
    }

    public void add(Carta first) {
        mano.add(first);
    }

    public boolean isEmpty() {
        return mano.isEmpty();
    }

    public int size(){
        return mano.size();
    }

    public Carta getElementAt(int index){
        return mano.get(index);
    }

    @Override
    public String toString() {
        return mano.toString();
    }
}