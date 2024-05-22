package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BottoniCelle extends BorderPane {
    private Button stradaNord;
    private Button stradaSud;
    private Button stradaEst;
    private Button stradaOvest;
    private Button prato;

    public BottoniCelle() {
        super();
        stradaNord = new Button("Strada NORD");
        stradaSud = new Button("Strada SUD");
        stradaEst = new Button("Strada EST");
        stradaOvest = new Button("Strada OVEST");
        prato = new Button("PRATO");

        stradaNord.setPrefSize(100, 10);
        stradaSud.setPrefSize(100, 10);
        stradaEst.setPrefSize(100, 10);
        stradaOvest.setPrefSize(100, 10);
        prato.setPrefSize(100, 10);

        VBox topContainer = new VBox(stradaNord);
        VBox bottomContainer = new VBox(stradaSud);
        VBox rightContainer = new VBox(stradaEst);
        VBox leftContainer = new VBox(stradaOvest);

        topContainer.setAlignment(Pos.CENTER);
        bottomContainer.setAlignment(Pos.CENTER);
        leftContainer.setAlignment(Pos.CENTER);
        rightContainer.setAlignment(Pos.CENTER);

        super.setTop(topContainer);
        super.setBottom(bottomContainer);
        super.setLeft(leftContainer);
        super.setRight(rightContainer);
        super.setCenter(prato);
    }
}
