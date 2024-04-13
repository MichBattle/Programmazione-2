package View;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.geralt.Geralt;
import model.geralt.Mutation;
import model.mutations.muts.combat.StrCombatMutation;
import model.mutations.muts.combat.VelCombatMutation;
import model.mutations.muts.potions.TolPotionMutation;
import model.mutations.muts.spells.IgniSpellMutation;
import model.mutations.muts.spells.QuenSpellMutation;

public class ButtonPane extends HBox {
    private final static int RECTANGLE_SIZE = 60;

    private Geralt g;
    private MainGUI m;

    public ButtonPane(Geralt k, MainGUI mg) {
        super();

        this.m = mg;
        this.g = k;

        String[] s = {g.isPresent(Mutation.Str) + "Str",
                g.isPresent(Mutation.Vel) + "Vel",
                g.isPresent(Mutation.Tol) + "Tol",
                g.isPresent(Mutation.Igni) + "Igni",
                g.isPresent(Mutation.Quen) + "Quen"};

        Color[] c = {Color.RED, Color.RED, Color.GREEN, Color.CYAN, Color.CYAN};

        for(int i = 0; i < 5; i++){
            StackPane sp = create_button(s[i], c[i]);
            super.getChildren().add(sp);
        }

    }

    /**
     * ritorna uno StackPane che contiene un Rettangolo colorato e sopra il bottone con il testo preso dalla stringa del costruttore
     * imposta l'azione del bottone
     * @param s
     * @param c
     * @return
     */
    private StackPane create_button(String s, Color c){
        Rectangle r = new Rectangle(RECTANGLE_SIZE, RECTANGLE_SIZE);
        r.setStroke(Color.BLACK);
        r.setFill(c);
        Button b = new Button(s);
        set_on_action_button(b, s);
        b.setBackground(Background.fill(Color.TRANSPARENT));
        return new StackPane(r, b);
    }

    /**
     * imposta l'azione del bottone
     * riconosce la mutazione che viene premuta ed esegue l'applica o il rimuovi su di essa
     * aggiorna le varie lable
     * @param b
     * @param s
     */
    private void set_on_action_button(Button b, String s){
        b.setOnAction(actionEvent -> {
            Mutation k = riconosci_mutazione(s);

            if(g.isPresent(k).equals("-")){
                rimuovi_mutazione(k);
                b.setText("+" + k);
            }else if(g.isPresent(k).equals("+")){
                try {
                    applica_mutazione(k);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                b.setText("-" + k);
            }

            m.update_mutation_lable();
            m.update_spells_lable();
            m.update_stats_lable();
        });

    }

    /**
     * riconosce la mutazione in base alla Stringa
     * @param s
     * @return
     */
    private Mutation riconosci_mutazione(String s){
        if(s.contains("Str"))
            return Mutation.Str;
        else if(s.contains("Vel"))
            return Mutation.Vel;
        else if(s.contains("Tol"))
            return Mutation.Tol;
        else if(s.contains("Igni"))
            return Mutation.Igni;
        else if(s.contains("Quen"))
            return Mutation.Quen;
        return null;
    }

    /**
     * chiama il metodo applica della relativa mutazione
     * @param m
     * @throws Exception
     */
    private void applica_mutazione(Mutation m) throws Exception {
        if(m.toString().equals("Str")){
            StrCombatMutation s = new StrCombatMutation(g);
            s.applica();
        }else if(m.toString().equals("Vel")){
            VelCombatMutation s = new VelCombatMutation(g);
            s.applica();
        }else if(m.toString().equals("Tol")){
            TolPotionMutation s = new TolPotionMutation(g);
            s.applica();
        }else if(m.toString().equals("Igni")){
            IgniSpellMutation s = new IgniSpellMutation(g);
            s.applica();
        }else if(m.toString().equals("Quen")) {
            QuenSpellMutation s = new QuenSpellMutation(g);
            s.applica();
        }
    }

    /**
     * chiama il metodo rimuovi della relativa mutazione
     * @param m
     */
    private void rimuovi_mutazione(Mutation m){
        if(m.toString().equals("Str")){
            StrCombatMutation s = new StrCombatMutation(g);
            s.rimuovi();
        }else if(m.toString().equals("Vel")){
            VelCombatMutation s = new VelCombatMutation(g);
            s.rimuovi();
        }else if(m.toString().equals("Tol")){
            TolPotionMutation s = new TolPotionMutation(g);
            s.rimuovi();
        }else if(m.toString().equals("Igni")){
            IgniSpellMutation s = new IgniSpellMutation(g);
            s.rimuovi();
        }else if(m.toString().equals("Quen")) {
            QuenSpellMutation s = new QuenSpellMutation(g);
            s.rimuovi();
        }
    }
}