package View;

import Controller.MainGUI;
import Model.Gioco;
import Model.Mano;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PlayerPane extends HBox {
    private Mano current;
    private Mano avversario;

    private Text nome;
    private Button pescaDallAvversario;
    private Button cercaCoppie;
    private Button pescaDalMazzo;

    public PlayerPane(MainGUI mg, Mano giocatoreCorrente, Mano avversario) {
        super();

        Gioco g = mg.getGioco();
        current = giocatoreCorrente;
        this.avversario = avversario;

        nome = new Text(giocatoreCorrente.getGiocatore());
        pescaDallAvversario = new Button("Pesca dall'avversario");
        cercaCoppie = new Button("Cerca le coppie");
        pescaDalMazzo = new Button("Pesca dal mazzo");

        pescaDallAvversario.setDisable(true);
        cercaCoppie.setDisable(true);
        pescaDalMazzo.setDisable(true);

        setPescaDallAvversarioAction(mg, g);
        setCercaCoppieAction(mg, g);
        setPescaDalMazzo(mg, g);

        super.getChildren().addAll(nome, pescaDallAvversario, cercaCoppie, pescaDalMazzo);
        super.setSpacing(10);
    }

    public Button getPescaDallAvversario() {
        return pescaDallAvversario;
    }

    private void setPescaDallAvversarioAction(MainGUI mg, Gioco g){
        pescaDallAvversario.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " PESCO DALL'AVVERSARIO:");
            g.pescaDallAvversario(current, avversario);

            aggiornaMani(mg);
            stampaMani();

            if(checkWin(avversario))
                displayAlert(mg, avversario);

            else {
                pescaDallAvversario.setDisable(true);
                cercaCoppie.setDisable(false);
            }
        });
    }

    private void setCercaCoppieAction(MainGUI mg, Gioco g){
        cercaCoppie.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " SCARTO LE COPPIE:");
            if(g.scartaCoppie(current)){
                cercaCoppie.setDisable(true);
                mg.getOtherPlayer(this).pescaDallAvversario.setDisable(false);
                System.out.println(current.getGiocatore() + ": HO SCARTATO NON PESCO");

                aggiornaMani(mg);
                stampaMani();

                if(checkWin(current)) {
                    displayAlert(mg, current);
                } else
                    System.out.println("\nTURNO DI " + avversario.getGiocatore());
            }else{
                cercaCoppie.setDisable(true);
                pescaDalMazzo.setDisable(false);
                aggiornaMani(mg);
                stampaMani();
            }
        });
    }

    private void setPescaDalMazzo(MainGUI mg, Gioco g){
        pescaDalMazzo.setOnAction(event -> {
            System.out.println(current.getGiocatore() + " NON HO SCARTATO, PESCO DAL MAZZO");
            g.pescaDalMazzo(current);

            aggiornaMani(mg);
            stampaMani();

            pescaDalMazzo.setDisable(true);
            mg.getOtherPlayer(this).pescaDallAvversario.setDisable(false);

            System.out.println("\nTURNO DI " + avversario.getGiocatore());
        });
    }

    private void aggiornaMani(MainGUI mg){
        mg.getAvversario(this).creaMano(avversario.getCarte());
        mg.getCurrent(this).creaMano(current.getCarte());
    }

    private void stampaMani(){
        System.out.println(current.toString());
        System.out.println(avversario.toString());
    }

    private void displayAlert(MainGUI mg, Mano m){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("GAME OVER!");
        a.setContentText(m.getGiocatore() + " HA VINTO!");
        a.show();
        disabilitaBottoni();
        mg.getOtherPlayer(this).disabilitaBottoni();
        System.out.println(current.getGiocatore() + " HA VINTO!");
    }

    private boolean checkWin(Mano m){
        return m.getCarte().isEmpty();
    }

    public void disabilitaBottoni(){
        pescaDalMazzo.setDisable(true);
        pescaDallAvversario.setDisable(true);
        cercaCoppie.setDisable(true);
    }
}
