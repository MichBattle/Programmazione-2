package Model;

public class Giocatore {
    private String nome;
    private Mano mano;

    public Giocatore(String nome, Mano mano) {
        this.nome = nome;
        this.mano = mano;
    }

    public Carta getRandomCard(){
        return mano.getRandomCard();
    }

    public String getNome() {
        return nome;
    }

    public Mano getMano() {
        return mano;
    }

    public void rimuoviCarta(Carta c){
        mano.remove(c);
    }

    public void aggiungiCarta(Carta c){
        mano.aggiungiCarta(c);
    }

    public boolean rimuoviDoppi() {
        boolean a = mano.rimuoviDoppie();
        System.out.println(this);
        return a;
    }

    public void pescaDallAvversario(Giocatore avversario){
        Carta c = avversario.getRandomCard();
        avversario.rimuoviCarta(c);
        aggiungiCarta(c);
    }

    @Override
    public String toString() {
        return nome + ": " + mano.toString();
    }
}
