
package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai extends AbstractComando {
    private static final String NOME = "vai";
    private Direzioni direzione;
    
    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        
        if (this.direzione == null) {
            partita.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
            return;
        }
        
        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        if (prossimaStanza == null) {
            if (stanzaCorrente instanceof StanzaBloccata)
                partita.getIO().mostraMessaggio("è stata bloccata, è necessario possedere l'attrezzo");
            else
                partita.getIO().mostraMessaggio("Direzione inesistente");
            return;
        }
        
        partita.setStanzaCorrente(prossimaStanza);
        partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getNome());
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
    }
    
    @Override
    public void setParametro(String parametro) {
        try {
            this.direzione = Direzioni.valueOf(parametro.toUpperCase().replace("-", "_"));
        } catch (IllegalArgumentException | NullPointerException e) {
            this.direzione = null; // direzione non valida
        }
    }

    @Override
    public String getParametro() {
        return this.direzione != null ? this.direzione.name() : null;
    }
    
    @Override
    public String getNome() {
        return NOME;
    }
}