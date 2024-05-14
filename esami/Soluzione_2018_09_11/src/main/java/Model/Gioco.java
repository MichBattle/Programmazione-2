package Model;

import java.util.ArrayList;
import java.util.Random;

public class Gioco {
    private Mano mano1;
    private Mano mano2;
    private Mazzo mazzo;

    public Gioco() {
        mazzo = new Mazzo();
        mazzo.mescola();

        ArrayList<Carta> m1 = new ArrayList<>();
        ArrayList<Carta> m2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            m1.add(mazzo.daiCarta());
            m2.add(mazzo.daiCarta());
        }

        mano1 = new Mano("PIPPO", m1);
        mano2 = new Mano("PLUTO", m2);
    }

    public Mano getMano1() {
        return mano1;
    }

    public Mano getMano2() {
        return mano2;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

    public void pescaDallAvversario(Mano giocatoreCorrente, Mano avversario){
        Random r = new Random();
        int cardIndex = r.nextInt(avversario.getCarte().size());
        Carta c = avversario.getCarte().get(cardIndex);
        giocatoreCorrente.aggiungiCarta(c);
        avversario.rimuoviCarta(cardIndex);
        System.out.println(giocatoreCorrente);
    }

    public boolean scartaCoppie(Mano mano){
        ArrayList<Carta> m = new ArrayList<>(mano.getCarte());
        boolean ret = false;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        for (Carta carta : m) {
            switch (carta.getValore()) {
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                case 3:
                    c3++;
                    break;
                case 4:
                    c4++;
                    break;
            }
        }

        if(c1 > 1){
            removeAllElementsWithValue(m, 1);
            ret = true;
        }
        if(c2 > 1){
            removeAllElementsWithValue(m, 2);
            ret = true;
        }
        if(c3 > 1){
            removeAllElementsWithValue(m, 3);
            ret = true;
        }
        if(c4 > 1){
            removeAllElementsWithValue(m, 4);
            ret = true;
        }

        return ret;
    }

    public void pescaDalMazzo(Mano mano){
        Carta c = mazzo.daiCarta();
        mano.aggiungiCarta(c);
    }

    private void removeAllElementsWithValue(ArrayList<Carta> mano, int value){
        mano.removeIf(carta -> carta.getValore() == value);
    }

    private boolean equals(Carta a, Carta b){
        return a.getValore() == b.getValore();
    }
}
