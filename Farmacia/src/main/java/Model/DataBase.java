package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
    private ArrayList<RicettaUtente> ricette;
    private ArrayList<Medicina> medicine;

    public DataBase() {
        ricette = new ArrayList<>();
        medicine = new ArrayList<>();

        Date d = new Date();
        Date domani = new Date(d.getTime() + 100000000);
        Date ieri = new Date(d.getTime() - 100000000);

        //creo medicine
        Medicina Brufen800 = new ConRicetta("Brufen800", 20, domani, 0);
        Medicina Brufen200 = new DaBanco("Brufen200", 8, domani);
        Medicina Benagol = new DaBanco("Benagol", 10, domani);
        Medicina Oki = new ConRicetta("Oki", 12, domani, 4);
        Medicina Fluifort = new ConRicetta("Fluifort", 18, ieri, 2);
        Medicina Tachipirina1000 = new ConRicetta("Tachipirina1000", 6, domani, 3);

        //creo ricette
        RicettaUtente ricBrufen800 = new RicettaUtente(Brufen800, ieri);
        RicettaUtente ricTachipirina1000 = new RicettaUtente(Tachipirina1000, domani);
        RicettaUtente ricFluifort = new RicettaUtente(Fluifort, domani);

        //inserisco medicine
        medicine.add(Benagol);
        medicine.add(Brufen200);
        medicine.add(Brufen800);
        medicine.add(Oki);
        medicine.add(Fluifort);
        medicine.add(Tachipirina1000);

        //inserisco ricette
        ricette.add(ricBrufen800);
        ricette.add(ricFluifort);
        ricette.add(ricTachipirina1000);
    }

    public ArrayList<RicettaUtente> getRicette() {
        return ricette;
    }

    public ArrayList<Medicina> getMedicine() {
        return medicine;
    }
}