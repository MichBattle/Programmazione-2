package model.mutations.muts.potions;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.PotionMutation;

public class TolPotionMutation extends PotionMutation {

    public TolPotionMutation(Geralt g) {
        super(g, Mutation.Tol);
    }

    @Override
    public void applica() throws Exception {
        super.applica();
        g.setTolleranza(g.getTolleranza() + 2);
    }

    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setTolleranza(g.getTolleranza() - 2);
    }
}
