package Model.geralt;

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

    public void setForza(int forza) {
        this.forza = forza;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    public void setTolleranza(int tolleranza) {
        this.tolleranza = tolleranza;
    }

    public void addSpell(Spell s){
        spells.add(s);
    }

    public void removeSpell(Spell s){
        spells.remove(s);
    }

    public void addMutation(Mutation m) {
        int index = 4;

        if(m == Mutation.Str || m == Mutation.Vel && check_mutation_position_empty(0))
            index = 0;
        else if(m == Mutation.Igni || m == Mutation.Quen && check_mutation_position_empty(1))
            index = 1;
        else if(m == Mutation.Tol && check_mutation_position_empty(2))
            index = 2;
        else if(check_mutation_position_empty(3))
            index = 3;

        mutations.remove(index);
        mutations.add(index, m);
    }

    public void removeMutation(Mutation m){
        int index = position_of(m);
        mutations.add(index, Mutation.Empty);
        mutations.remove(m);
    }

    private boolean check_mutation_position_empty(int index){
        return mutations.get(index) == Mutation.Empty;
    }

    public String isPresent(Mutation m){
        for(Mutation k: mutations){
            if(k == m)
                return "-";
        }
        return "+";
    }

    public int position_of(Mutation m){
        int i = 0;
        for(Mutation a: mutations){
            if(a == m)
                break;
            i++;
        }
        return i;
    }

    public String stringaStats(){
        return "Lvl: " + livello + "\n" +
                "Str: " + forza + "\n" +
                "Vel: " + velocita + "\n" + "\n" +
                "Tol: " + tolleranza;
    }
}
