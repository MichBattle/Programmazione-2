package Controller;

import Controller.Titoli.Anime;
import Controller.Titoli.Film;
import Controller.Titoli.Serie;

import java.util.ArrayList;

public class ArchivioTitoli {
    private ArrayList<Titolo> archivio;

    public ArchivioTitoli() {
        archivio = new ArrayList<>();

        archivio.add(new Serie("Boris", "2010", "Italiano", 10, 4));
        archivio.add(new Anime("Attack on titan", "2013", "Giapponese", 10, "inglese"));
        archivio.add(new Film("Parasite", "2019", "Inglese", 20));
        archivio.add(new Anime("Pokemon", "2010", "Inglese", 10, ""));
        archivio.add(new Film("The Irishman", "2019", "Inglese", 5));
        archivio.add(new Serie("1994", "2019", "Italiano", 10, 3));
        archivio.add(new Film("Her", "2013", "Inglese", 20));
    }

    public ArrayList<Titolo> getArchivio() {
        return archivio;
    }
}