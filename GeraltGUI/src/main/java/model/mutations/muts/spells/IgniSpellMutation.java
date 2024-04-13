package model.mutations.muts.spells;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.mutations.abstracts.SpellMutation;

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
