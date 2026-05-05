package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

    private String nomeAttrezzo;

    @Override
    public void esegui(Partita partita) {
    	if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo=partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	partita.getStanzaCorrente().removeAttrezzo(attrezzo);
    }
    	}

    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    @Override
    public String getNome() {
    	return "prendi";
    }
    @Override
    public String getParametro() {
    	return this.nomeAttrezzo;
    }
}
