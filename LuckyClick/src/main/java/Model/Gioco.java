package Model;

import Model.utils.CellaFactory;

import java.util.Random;

public class Gioco {
    public final static int DIM_TABELLONE = 10;

    private int punteggioTotale;
    private Cella[][] tabellone;
    private int tentativi = 10;

    public Gioco() {
        this.punteggioTotale = 0;
        tabellone = new Cella[DIM_TABELLONE][DIM_TABELLONE];
        inizializzaMatrice();
    }

    public void setPunteggioTotale(int punteggioTotale) {
        this.punteggioTotale = punteggioTotale;
    }

    public int getPunteggioTotale() {
        return punteggioTotale;
    }

    private void setTabelloneAtCoords(Cella c, int x, int y){
        tabellone[x][y] = c;
    }

    private void inizializzaMatrice(){
        CellaFactory cf = new CellaFactory(this);
        Random rand = new Random();
        int celleBase = 75;
        int celleMolt = 10;
        int celleDiv = 10;
        int celleBoom = 5;

        for(int i = 0; i < DIM_TABELLONE; i++){
            for(int k = 0; k < DIM_TABELLONE; k++){
                Cella c;
                int scelta = rand.nextInt(celleBase + celleMolt + celleDiv + celleBoom);

                if(scelta < celleMolt){
                    c = cf.cellaMolt();
                    celleMolt --;
                }else if(scelta < celleMolt + celleDiv){
                    c = cf.cellaDiv();
                    celleDiv --;
                }else if(scelta < celleMolt + celleDiv + celleBoom){
                    c = cf.cellaBoom();
                    celleBoom--;
                }else{
                    c = cf.cellaBase();
                    celleBase --;
                }
                setTabelloneAtCoords(c, i, k);
            }
        }
    }

    public void stampaTabellone(){
        for(int i = 0; i < DIM_TABELLONE; i++){
            for(int k = 0; k < DIM_TABELLONE; k++){
                System.out.print(tabellone[k][i].content() + " ");
            }
            System.out.print("\n");
        }
    }

    public Cella[][] getTabellone() {
        return tabellone;
    }

    public int getTentativi() {
        return tentativi;
    }

    public void setTentativi(int tentativi) {
        this.tentativi = tentativi;
    }
}