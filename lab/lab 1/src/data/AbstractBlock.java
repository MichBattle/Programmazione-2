package data;

public class AbstractBlock implements Block{
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockName;

    /**
     * ritorna il contenuto del blocco
     * @return contenuto del blocco
     */
    public char display() {
        return contenuto;
    }

    /**
     * imposta il contenuto del blocco con il valore passato da parametro
     * @param contenuto
     */
    public void setContenuto(char contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return se il blocco cade con la gravita
     */
    public boolean isFalls_with_gravity() {
        return falls_with_gravity;
    }

    /**
     * @return se il valore cade attraverso
     */
    public boolean isFall_through() {
        return fall_through;
    }

    @Override
    public String toString(){
        String print = "";

        print = blockName + "\n" +
                "falls_with_gravity: " + falls_with_gravity + "\n" +
                "fall_through: " + fall_through + "\n" +
                "contenuto: " + contenuto +"\n";

        return print;
    }
}