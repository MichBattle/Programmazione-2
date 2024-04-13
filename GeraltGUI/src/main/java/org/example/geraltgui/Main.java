package org.example.geraltgui;

import model.geralt.Geralt;
import model.mutations.MutationInterface;
import model.mutations.muts.combat.StrCombatMutation;
import model.mutations.muts.potions.TolPotionMutation;
import model.mutations.muts.spells.QuenSpellMutation;

public class Main {
    public static void main(String[] args) throws Exception {
        Geralt g = new Geralt();

        MutationInterface forza = new StrCombatMutation(g);
        forza.applica();
        System.out.println(g);
        MutationInterface tol = new TolPotionMutation(g);
        tol.applica();
        System.out.println(g);
        MutationInterface spel = new QuenSpellMutation(g);
        spel.applica();
        System.out.println(g);
    }
}
