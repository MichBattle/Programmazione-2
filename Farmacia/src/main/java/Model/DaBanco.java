package Model;

import java.util.Date;

public class DaBanco extends Medicina{
    public DaBanco(String name, int price, Date expiryDate) {
        super(name, price, expiryDate);
    }

    public String toString(){
        return super.toString() + "Medicinale da banco\n";
    }
}
