package Controller.Titoli;

import Controller.Titolo;

public class Anime extends Titolo {
    private String linguaSottotitoli;

    public Anime(String nome, String anno, String lingua, double prezzo, String linguaSottotitoli) {
        super(nome, anno, lingua, prezzo);
        this.linguaSottotitoli = linguaSottotitoli;
    }
}
