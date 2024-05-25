package Model.mutations.muts;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.AbstractMutation;

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
