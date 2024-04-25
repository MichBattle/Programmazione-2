package model.mutations.abstracts;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.MutationInterface;

public abstract class AbstractMutation implements MutationInterface {
    private final Mutation m;
    protected Geralt g;

    protected AbstractMutation(Geralt g, Mutation m) {
        super();
        this.m = m;
        this.g = g;
    }

    @Override
    public void applica() throws Exception {
        g.addMutation(m);
    }

    @Override
    public void rimuovi() {
        g.removeMutation(m);
    }

    @Override
    public String toString() {
        return m.toString();
    }
}