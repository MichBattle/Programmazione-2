package model.geralt;

import java.util.ArrayList;
import java.util.HashSet;

public class Geralt {
    public static final int MAX_MUTATIONS = 4;

    private int forza = 10;
    private int velocita = 10;
    private int tolleranza = 2;
    private int livello = 0;

    private HashSet<Spell> spells;
    private ArrayList<Mutation> mutations;

    /**
     * inizializza le 4 possibili mutazioni a Empty
     */
    public Geralt(){
        spells = new HashSet<>();
        mutations = new ArrayList<>();

        for(int i = 0; i < MAX_MUTATIONS; i++)
            mutations.add(Mutation.Empty);
    }

    public HashSet<Spell> getSpells() {
        return spells;
    }

    public ArrayList<Mutation> getMutations() {
        return mutations;
    }

    public int getForza() {
        return forza;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getTolleranza() {
        return tolleranza;
    }

    public int getLivello() {
        return livello;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    public void setTolleranza(int tolleranza) {
        this.tolleranza = tolleranza;
    }

    /**
     * aggiunge la spell all'HashSet
     * @param s
     */
    public void addSpell(Spell s){
        spells.add(s);
    }

    /**
     * rimuove la spell dall'HashSet
     * @param s
     */
    public void removeSpell(Spell s){
        spells.remove(s);
    }

    /**
     * aggiunge la mutazione all'ArrayList nella posizione corrispondente
     * 0 Str, Vel
     * 1 Igni, Quen
     * 2 Tol
     * 3 Slot libero
     * quando aggiunge, rimuove l'elemento Empty dallo slot e inserisce la mutazione
     * @param m
     */
    public void addMutation(Mutation m) throws Exception {
        int index = 4;

        if(m == Mutation.Str || m == Mutation.Vel && check_mutation_position_empty(0))
            index = 0;
        else if(m == Mutation.Igni || m == Mutation.Quen && check_mutation_position_empty(1))
            index = 1;
        else if(m == Mutation.Tol && check_mutation_position_empty(2))
            index = 2;
        else if(check_mutation_position_empty(3))
            index = 3;

        if(index == 4)
            throw new Exception("Max mutations reached!\n");

        mutations.remove(index);
        mutations.add(index, m);
        //System.out.println(mutations);
    }

    /**
     * rimuove la mutazione dall'ArrayList
     * inserisce al suo posto un elemento Empty
     * @param m
     */
    public void removeMutation(Mutation m){
        int index = position_of(m);
        mutations.add(index, Mutation.Empty);
        mutations.remove(m);
    }

    /**
     * controlla se alla posizione index c'è un elemento Empty
     * @param index
     * @return
     */
    private boolean check_mutation_position_empty(int index){
        return mutations.get(index) == Mutation.Empty;
    }

    /**
     * se la mutazione è presente nell'ArrayList ritorna + altrimenti -
     * @param m
     * @return
     */
    public String isPresent(Mutation m){
        for(Mutation k: mutations){
            if(k == m)
                return "-";
        }
        return "+";
    }

    /**
     * trova la posizione nell'ArrayList di m
     * @param m
     * @return
     */
    public int position_of(Mutation m){
        int i = 0;
        for(Mutation a: mutations){
            if(a == m)
                break;
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Geralt:\n" +
                "Livello: " + livello + "\n" +
                "Forza: " + forza + "\n" +
                "Velocita: " + velocita + "\n" +
                "Tolleranza: " + tolleranza + "\n" +
                "Mutazioni: " + mutations.toString() + "\n" +
                "Magie: " + spells.toString() + "\n";
    }
}
