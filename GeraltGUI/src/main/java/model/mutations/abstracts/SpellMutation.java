package model.mutations.abstracts;

import model.geralt.Geralt;
import model.geralt.Mutation;

public abstract class SpellMutation extends AbstractMutation{
    protected SpellMutation(Geralt g, Mutation m) {
        super(g, m);
    }

    @Override
    public String toString() {
        return "Spell Mutation: " + super.toString();
    }
}
