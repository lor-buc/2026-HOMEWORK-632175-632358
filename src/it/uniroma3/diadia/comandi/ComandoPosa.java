package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;



public class ComandoPosa implements Comando {

    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
    	if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
		}
    }

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    @Override
    public String getNome() {
    	return "posa";
    }
    @Override
    public String getParametro() {
    	return this.nomeAttrezzo;
    }
}