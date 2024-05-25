package Model.mutations.abstracts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;

public abstract class PotionMutation extends AbstractMutation{

    protected PotionMutation(Geralt g, Mutation m){
        super(g, m);
    }

    @Override
    public String toString() {
        return "Potion Mutation: " + super.toString();
    }
}
