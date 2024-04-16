package model;

import model.enums.Accessorio;
import model.enums.Motore;

import java.util.ArrayList;
import java.util.Comparator;

public class Concessionario {
    private final ArrayList<Auto> automobili;
    private boolean idSort;
    private boolean monthSort;

    public Concessionario() {
        automobili = new ArrayList<>();

        aggiungiAutomobile(new Berlina("B1", 2000, Motore.Benzina, "2016", 20000, 2));
        aggiungiAutomobile(new Berlina("B2", 2000, Motore.Diesel, "2018", 30000, 6));
        aggiungiAutomobile(new Berlina("B3", 2000, Motore.Ibrido, "2017", 35000, 4));
        aggiungiAutomobile(new Utilitaria("U1", 1000, Motore.Benzina, "2018", 10000, 1));
        aggiungiAutomobile(new Utilitaria("U2", 1300, Motore.Ibrido, "2014", 28000, 2));
        aggiungiAutomobile(new Utilitaria("U3", 1200, Motore.Diesel, "2016", 12000, 6));
        aggiungiAutomobile(new Sportiva("S1", 3000, Motore.Benzina, "2015", 50000, 3));
        aggiungiAutomobile(new Sportiva("S2", 2800, Motore.Benzina, "2018", 30000, 6));
        aggiungiAutomobile(new Sportiva("S3", 3000, Motore.Benzina, "2013", 65000, 5));

        getElement(6).addAccessorio(Accessorio.Spoiler);
        getElement(6).addAccessorio(Accessorio.Cambio_Automatico);

        getElement(7).addAccessorio(Accessorio.Tetto_A_Scomparsa);
        getElement(7).addAccessorio(Accessorio.Sedili_In_Pelle);

        getElement(8).addAccessorio(Accessorio.Cromature);
        getElement(8).addAccessorio(Accessorio.Volante_Ergonomico);

        sortById();

        idSort = true;
        monthSort = false;
    }

    private void aggiungiAutomobile(Auto as) {
        automobili.add(as);
    }

    private Sportiva getElement(int index) {
        return (Sportiva) automobili.get(index);
    }

    private void sortById(){
        automobili.sort(Comparator.comparingInt(Auto::getId));
    }

    private void sortByMonth() {
        automobili.sort(Comparator.comparingInt(Auto::getMeseEsposizione)
                .thenComparing(Auto::getAnno)
                .thenComparingInt(Auto::getId));
    }

    public Auto getAutoAtIndex(int index){
        return automobili.get(index);
    }

    public void changeSort(){
        if(idSort){
            sortByMonth();
            idSort = false;
            monthSort = true;
        }else{
            sortById();
            idSort = true;
            monthSort = false;
        }
    }
}