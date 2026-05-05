package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoGuarda implements Comando {

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        partita.getIO().mostraMessaggio(stanzaCorrente.getDescrizione());
        partita.getIO().mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu());
    }

    @Override
    public void setParametro(String parametro) {
        // ComandoGuarda non ha parametri
    }
    @Override
    public String getNome() {
    	return "guarda";
    }
    @Override
    public String getParametro() {
    	return null;
    }
}