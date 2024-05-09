package View;

import java.util.ArrayList;

public class DataBase {
    private ArrayList<Piastrella> piastrelle;

    public DataBase() {
        piastrelle = new ArrayList<>();

        piastrelle.add(new Piastrella("P1", "ceramica", 50.0, false, 50.0));
        piastrelle.add(new Piastrella("P2", "laminato", 20.0, true, 80.0));
        piastrelle.add(new Piastrella("P3", "terracotta", 50.0, true, 40.0));
        piastrelle.add(new PiastrellaQuadrato("B1", "laminato", 100.0, false, 40.0));
        piastrelle.add(new PiastrellaCerchio("B2", "ceramica", 120.0, true, 90.0));
        piastrelle.add(new PiastrellaQuadrato("B3", "terracotta", 140.0, true, 50.0));
    }

    public ArrayList<Piastrella> getPiastrelle() {
        return piastrelle;
    }
}
