package Model.mutations.muts.combat;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.abstracts.CombatMutation;

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
