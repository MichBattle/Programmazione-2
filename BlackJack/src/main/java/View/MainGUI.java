package View;

import Model.Giocatore;
import Model.Gioco;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane {
    private Gioco g;
    private StatsPane g1;
    private StatsPane g2;
    private ManoPane m1;
    private ManoPane m2;

    public MainGUI() {
        super();

        g = new Gioco();

        Giocatore p1 = g.getG1();
        Giocatore p2 = g.getG2();

        g1 = new StatsPane(g, p1, null, this);
        g2 = new StatsPane(g, p2, g1, this);
        g1.setAltroGiocatore(g2);
        m1 = new ManoPane(p1);
        m2 = new ManoPane(p2);

        g1.iniziaAGiocare();

        //grafica
        g1.setSpacing(20);
        g2.setSpacing(20);

        super.setTop(g2);
        super.setBottom(g1);

        AnchorPane hp = new AnchorPane(m1, m2);
        AnchorPane.setTopAnchor(m2, 0.0);
        AnchorPane.setBottomAnchor(m1, 0.0);

        super.setCenter(hp);
    }

    public void updateMano(){
        m1.creaMano();
        m2.creaMano();
    }
}
