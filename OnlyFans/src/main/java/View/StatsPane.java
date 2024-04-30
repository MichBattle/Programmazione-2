package View;

import Controller.Stats;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatsPane extends HBox {
    private Stats s;

    private Text capitaleText;
    private Text spesaText;
    private Text mesiTrascorsiText;

    public StatsPane(Stats s) {
        super();
        this.s = s;
        capitaleText = new Text();
        spesaText = new Text();
        mesiTrascorsiText = new Text();

        update_all_labels(0, 0, 0);
        super.getChildren().addAll(capitaleText, spesaText, mesiTrascorsiText);
        super.setSpacing(5);
    }

    public Text getMesiTrascorsiText() {
        return mesiTrascorsiText;
    }

    public void update_all_labels(int capitale, int spesaMensile, int mesiTrascorsi){
        update_label_capitale(capitale);
        update_label_spesa(spesaMensile);
        update_label_mesiTrascorsi(mesiTrascorsi);
    }

    private void update_label_capitale(int capitale){
        s.setCapitale(s.getCapitale() + capitale);
        capitaleText.setText("Capitale: " + s.getCapitale());
    }

    private void update_label_spesa(int spesaMensile){
        s.setSpesaMensile(spesaMensile);
        spesaText.setText("Spesa Mensile: " + spesaMensile);
    }

    private void update_label_mesiTrascorsi(int mesiTrascorsi){
        s.setMesiTrascorsi(s.getMesiTrascorsi() + mesiTrascorsi);
        mesiTrascorsiText.setText("Mesi Trascorsi: " + s.getMesiTrascorsi());
    }
}