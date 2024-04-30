package Controller;

import Controller.Ventilators.Piantana;
import Controller.Ventilators.Ventilatore;

import java.util.ArrayList;
import java.util.Comparator;

public class Fans {
    private ArrayList<Ventilatore> ventilatori;
    private boolean sort;

    public Fans() {
        sort = true;

        ventilatori = new ArrayList<>();

        ventilatori.add(new Piantana("Ariete", Alimentazione.Batteria));
        ventilatori.add(new Piantana("Bosch", Alimentazione.Presa));
        ventilatori.add(new Piantana("Bosch", Alimentazione.Meccanico));
        ventilatori.add(new Piantana("Bosch", Alimentazione.Batteria));
        ventilatori.add(new Piantana("Parkside", Alimentazione.Presa));

        changeSortingMethod();
    }

    public ArrayList<Ventilatore> getVentilatori() {
        return ventilatori;
    }

    public void changeSortingMethod(){
        if(sort){
            sortByName();
            changeSort();
        }else{
            sortByPrice();
            changeSort();
        }
    }

    private void changeSort(){
        sort = !sort;
    }

    private void sortByName(){
        ventilatori.sort(Comparator.comparing(Ventilatore :: getMarca).thenComparing(Ventilatore :: getCosto));
    }

    private void sortByPrice(){
        ventilatori.sort(Comparator.comparing(Ventilatore :: getCosto).thenComparing(Ventilatore :: getMarca));
    }
}
