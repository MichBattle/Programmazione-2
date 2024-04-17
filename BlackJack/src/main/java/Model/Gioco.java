package Model;

public class Gioco {
    private Mazzo mazzo;
    private Giocatore g1;
    private Giocatore g2;

    public Gioco() {
        mazzo = new Mazzo();
        mazzo.mescolaMazzo();

        Mano m1 = new Mano();
        Mano m2 = new Mano();

        for(int i = 0; i < 4; i++){
            m1.aggiungiCarta(daiCarta());
            m2.aggiungiCarta(daiCarta());
        }

        m1.ordinaMano();
        m2.ordinaMano();

        g1 = new Giocatore("PIPPO", m1);
        g2 = new Giocatore("PLUTO", m2);
    }

    private Carta daiCarta(){
        Carta c = mazzo.getFirst();
        mazzo.removeFirst();
        return c;
    }

    public void pescaDalMazzo(Giocatore g){
        if(g.rimuoviDoppi()){
            System.out.println("===");
            System.out.println(g.getNome() + ": ho scartato, non pesco");
        }else{
            if(!mazzo.isEmpty()){
                g.getMano().add(mazzo.getFirst());
                mazzo.removeFirst();
                System.out.println(mazzo.size());
            }else
                System.out.println("Deck is Empty\n");
        }
    }

    public boolean rimuoviDoppi(Giocatore g){
        return g.rimuoviDoppi();
    }

    public void pescaDallAvversario(Giocatore current){
        Giocatore k;
        if(current.getNome().equals(g1.getNome()))
            k = g2;
        else
            k = g1;
        current.pescaDallAvversario(k);
    }

    private boolean checkLoose(Giocatore g){
        return g.getMano().isEmpty();
    }

    public String partita(){
        boolean turno = true;
        String winner;

        while(!checkLoose(g1) && !checkLoose(g2)){
            System.out.println(g1);
            System.out.println(g2);
            System.out.println("=== pesco dall'avversario");
            Giocatore f, q;

            if(turno){
                f = g1;
                q = g2;
                turno = false;
            }else{
                f = g2;
                q = g1;
                turno = true;
            }

            f.pescaDallAvversario(q);
            System.out.println(g1);
            System.out.println(g2);
            if(checkLoose(q))
                break;

            System.out.println("=== rimuovo doppie");
            pescaDalMazzo(f);
            if(checkLoose(f))
                break;
            System.out.println("=== stampa");
        }

        if(checkLoose(g1))
            winner = g1.getNome() + " HA VINTO\n";
        else
            winner = g2.getNome() + " HA VINTO\n";

        return winner;
    }

    public Giocatore getG1() {
        return g1;
    }

    public Giocatore getG2() {
        return g2;
    }

    public boolean checkLoost(){
        return g1.getMano().isEmpty() || g2.getMano().isEmpty();
    }
}