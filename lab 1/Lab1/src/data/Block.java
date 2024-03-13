package data;

public class Block {
    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    /**
     * costruttore di default
     * imposta i valori di default
     * il blocco non cade con la gravita e cade attraverso
     */
    public Block() {
        this.contenuto = '*';
        falls_with_gravity = false;
        fall_through = true;
    }

    /**
     * costruttore che imposta il contenuto
     * il blocco cade con la gravita e non cade attraverso
     * @param contenuto
     */
    public Block(char contenuto) {
        this.contenuto = contenuto;
        falls_with_gravity = true;
        fall_through = false;
    }

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
}
