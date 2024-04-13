package model.mutations.muts.combat;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.CombatMutation;

public class VelCombatMutation extends CombatMutation {


    public VelCombatMutation(Geralt g) {
        super(g, Mutation.Vel);
    }

    @Override
    public void applica() throws Exception {
        super.applica();
        g.setVelocita(g.getVelocita() + 2);
    }

    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setVelocita(g.getVelocita() - 2);
    }
}
