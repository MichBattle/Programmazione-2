package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;

public abstract class CombatMutation extends AbstractMutation{

    protected CombatMutation(Geralt g, Mutation m){
        super(g, m);
    }

    @Override
    public String toString() {
        return "Combat Mutation: " + super.toString();
    }
}
