package model.mutations.abstracts;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.MutationInterface;

public abstract class PotionMutation extends AbstractMutation{

    protected PotionMutation(Geralt g, Mutation m){
        super(g, m);
    }

    @Override
    public String toString() {
        return "Potion Mutation: " + super.toString();
    }
}
