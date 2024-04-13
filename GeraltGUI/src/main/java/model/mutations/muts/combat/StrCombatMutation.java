package model.mutations.muts.combat;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.abstracts.CombatMutation;

public class StrCombatMutation extends CombatMutation {

    public StrCombatMutation(Geralt g) {
        super(g, Mutation.Str);
    }

    @Override
    public void applica() throws Exception {
        super.applica();
        g.setForza(g.getForza() + 2);
    }

    @Override
    public void rimuovi() {
        super.rimuovi();
        g.setForza(g.getForza() - 2);
    }
}
