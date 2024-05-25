package Model.mutations.muts.spells;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.geralt.Spell;
import Model.mutations.abstracts.SpellMutation;

public class QuenSpellMutation extends SpellMutation {

    public QuenSpellMutation(Geralt g) {
        super(g, Mutation.Quen);
    }

    @Override
    public void applica() throws Exception {
        super.applica();
        g.addSpell(Spell.Quen);
    }

    @Override
    public void rimuovi() {
        super.rimuovi();
        g.removeSpell(Spell.Quen);
    }
}
