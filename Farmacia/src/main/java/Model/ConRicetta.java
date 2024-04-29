package Model;

import java.util.Date;

public class ConRicetta extends Medicina{
    private int ripetibili;

    public ConRicetta(String name, int price, Date expiryDate, int ripetibili) {
        super(name, price, expiryDate);
        this.ripetibili = ripetibili;
        super.calcolaPrezzoScontato(calcolaSconto());
    }

    public int getRipetibili() {
        return ripetibili;
    }

    public void setRipetibili(int ripetibili) {
        this.ripetibili = ripetibili;
    }

    private boolean isRipetibili(){
        return ripetibili > 0;
    }

    private int calcolaSconto(){
        if(isRipetibili())
            return  5;
        else
            return 10;
    }

    private String ripetibileString(){
        return (isRipetibili())? "Ripetibile fino a " + ripetibili + " volte" : "Non ripetibile";
    }

    public String toString(){
        return super.toString() + "con ricetta: " + ripetibileString() + "\n";
    }
}
