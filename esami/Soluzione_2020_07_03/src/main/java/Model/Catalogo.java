package Model;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Piastrella> piastrelle;

    public Catalogo() {
        piastrelle = new ArrayList<>();

        piastrelle.add(new Piastrella           ("P1", "ceramica",   50.0,  50.0, false));
        piastrelle.add(new Piastrella           ("P2", "laminato",   20.0,  80.0, true));
        piastrelle.add(new Piastrella           ("P3", "terracotta", 50.0,  40.0, true));
        piastrelle.add(new PiastrellaConQuadrato("B1", "laminato",   100.0, 40.0, false));
        piastrelle.add(new PiastrellaConCerchio ("B2", "ceramica",   120.0, 90.0, true));
        piastrelle.add(new PiastrellaConQuadrato("B3", "terracotta", 140.0, 50.0, true));
    }

    public ArrayList<Piastrella> getPiastrelle() {
        return piastrelle;
    }
}
