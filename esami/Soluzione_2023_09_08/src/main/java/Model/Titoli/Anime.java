package Model.Titoli;

import Model.Titolo;

public class Anime extends Titolo {
    private String sottotitoli;

    public Anime(String titolo, String anno, String lingua, double prezzoBase, String sottotitoli) {
        super(titolo, anno, lingua, prezzoBase);
        this.sottotitoli = sottotitoli;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   Sottotitoli: " + sottotitoli;
    }
}