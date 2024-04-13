package model.mutations.muts;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.AbstractMutation;

public class EmptyMutation extends AbstractMutation {

    public EmptyMutation(Geralt g) {
        super(g, Mutation.Empty);
    }

    @Override
    public void applica() {

    }

    @Override
    public void rimuovi() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
