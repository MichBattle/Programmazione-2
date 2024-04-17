package View;

import Model.Giocatore;
import Model.Gioco;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Comparator;

public class StatsPane extends HBox {
    private Giocatore g;
    private Gioco k;
    private StatsPane altroGiocatore;
    private MainGUI mg;

    private Text name;
    private Button pesca_avversario;
    private Button rimuovi_copie;
    private Button pesca_mazzo;

    private boolean pa;
    private boolean rc;
    private boolean pm;

    public StatsPane(Gioco k, Giocatore g, StatsPane sp, MainGUI mg) {
        super();

        this.g = g;
        this.k = k;
        this.mg = mg;
        this.altroGiocatore = sp;

        name = new Text(g.getNome());
        pesca_avversario = attivaBottoneOpaco("Pesca dall'avversario");
        rimuovi_copie = attivaBottoneOpaco("Cerca le coppie");
        pesca_mazzo = attivaBottoneOpaco("Pesca dal mazzo");

        pa = false;
        rc = false;
        pm = false;

        activatePescaAvversario();
        activateRimuoviCopie();
        activatePescaMazzo();

        super.getChildren().addAll(name, pesca_avversario, rimuovi_copie, pesca_mazzo);
    }

    private Button attivaBottoneOpaco(String s){
        Button b = new Button(s);
        b.setOpacity(0.5);
        return b;
    }

    private void activatePescaAvversario(){
        pesca_avversario.setOnAction(actionEvent -> {
            if(pa){
                k.pescaDallAvversario(g);
                //---------------------------
                pa = false;
                pesca_avversario.setOpacity(0.5);
                mg.updateMano();
                if(k.checkLoost()){
                    evidenziaVincitore(this);
                }else{
                    rimuovi_copie.setOpacity(1);
                    rc = true;
                }
            }
        });
    }

    private void activateRimuoviCopie(){
        rimuovi_copie.setOnAction(actionEvent -> {
            if(rc){
                if(k.rimuoviDoppi(g)){
                    rc = false;
                    rimuovi_copie.setOpacity(0.5);
                    if(k.checkLoost()){
                        evidenziaVincitore(altroGiocatore);
                    }else{
                        altroGiocatore.getPesca_avversario().setOpacity(1);
                        altroGiocatore.setPa(true);
                    }
                }else{
                    pesca_mazzo.setOpacity(1);
                    rimuovi_copie.setOpacity(0.5);
                    rc = false;
                    pm = true;
                }
                mg.updateMano();
            }
        });
    }

    private void activatePescaMazzo(){
        pesca_mazzo.setOnAction(actionEvent -> {
            if(pm){
                k.pescaDalMazzo(g);
                //---------------------------
                altroGiocatore.getPesca_avversario().setOpacity(1);
                pesca_mazzo.setOpacity(0.5);
                altroGiocatore.setPa(true);
                pm = false;
                mg.updateMano();
            }
        });
    }

    public void setPa(boolean pa) {
        this.pa = pa;
    }

    public Button getPesca_avversario() {
        return pesca_avversario;
    }

    public void iniziaAGiocare(){
        pa = true;
        pesca_avversario.setOpacity(1);
    }

    public void setAltroGiocatore(StatsPane sp) {
        this.altroGiocatore = sp;
    }

    private void evidenziaVincitore(StatsPane sp){
        sp.getName().setFill(Color.DARKRED);
    }

    public Text getName() {
        return name;
    }
}
