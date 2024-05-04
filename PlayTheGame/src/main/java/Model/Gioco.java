package Model;

import Model.Tessere.TesseraP;
import Model.Tessere.TesseraS;
import Model.Tessere.TesseraV;
import View.MainGUI;

import java.util.Random;

public class Gioco {
    private int N;
    private MainGUI mg;

    private Tessera[][]scacchiera;
    private int punteggio;
    private int partiteVinte;

    public Gioco(int N, MainGUI mg) {
        scacchiera = new Tessera[N][N];
        this.N = N;
        this.mg = mg;
        punteggio = 0;
        partiteVinte = 0;

        riempiScacchiera();
        printScacchiera();
    }

    public int getN() {
        return N;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void setPartiteVinte(int partiteVinte) {
        this.partiteVinte = partiteVinte;
    }

    public Tessera[][] getScacchiera() {
        return scacchiera;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getPartiteVinte() {
        return partiteVinte;
    }

    public void riempiScacchiera(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                scacchiera[i][j] = new TesseraS(this);
            }
        }

        Random rand = new Random();
        int pRow = rand.nextInt(N);
        int pCol = rand.nextInt(N);
        int vRow, vCol;
        do {
            vRow = rand.nextInt(N);
            vCol = rand.nextInt(N);
        } while (vRow == pRow && vCol == pCol);

        scacchiera[pRow][pCol] = new TesseraP();
        scacchiera[vRow][vCol] = new TesseraV(this);
    }

    public void printScacchiera(){
        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                System.out.print(scacchiera[i][k] + " ");
            }
            System.out.print("\n");
        }
    }

    public void resetAll(){
        mg.resetAll();
    }
}