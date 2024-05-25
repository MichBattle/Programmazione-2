package Model.mutations.muts.spells;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.geralt.Spell;
import Model.mutations.abstracts.SpellMutation;

public class IgniSpellMutation extends SpellMutation {

    public IgniSpellMutation(Geralt g) {
        super(g, Mutation.Igni);
    }

    @Override
    public void applica() throws Exception {
        super.applica();
        g.addSpell(Spell.Igni);
    }

    @Override
    public void rimuovi() {
        super.rimuovi();
        g.removeSpell(Spell.Igni);
    }
}
