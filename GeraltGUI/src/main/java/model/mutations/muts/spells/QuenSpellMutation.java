package model.mutations.muts.spells;

import model.geralt.Geralt;
import model.geralt.Mutation;
import model.geralt.Spell;
import model.mutations.abstracts.SpellMutation;

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
