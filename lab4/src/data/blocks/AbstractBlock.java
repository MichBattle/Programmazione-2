package data.blocks;

import data.blocks.interfaces.Block;

public class AbstractBlock implements Block {
    protected char contenuto;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockName;
    protected boolean pickable;

    /**
     * Imposta il contenuto di default
     */
    public AbstractBlock() {
        this.contenuto = '.';
        this.pickable = false;
    }

    /**
     * Ritorna il contenuto del blocco
     * @return contenuto del blocco
     */
    public char display_in_inventory() {
        return contenuto;
    }

    /**
     * Imposta il contenuto del blocco con il valore passato da parametro
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

    /**
     * Stampa gli attributi
     * @return
     */
    @Override
    public String toString(){
        String print = "";

        print = blockName + "\n" +
                "falls_with_gravity: " + falls_with_gravity + "\n" +
                "fall_through: " + fall_through + "\n" +
                "contenuto: " + contenuto +"\n";

        return print;
    }

    @Override
    public boolean isPickable() {
        return pickable;
    }
}