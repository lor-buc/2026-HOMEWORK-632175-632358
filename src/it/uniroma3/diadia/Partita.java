package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private IO io;
	public Partita(IO io){
		this.finita = false;
		this.giocatore = new Giocatore();
		this.labirinto=new Labirinto();
		this.stanzaCorrente=labirinto.getStanzaIniziale();
		this.io=io;
	}
	public int getCfu() {
	    return this.giocatore.getCfu();
	}
	
	public void setCfu(int x) {
		this.giocatore.setCfu(x);
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public Labirinto getLabirinto() {
	    return this.labirinto;
	}
	
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 */
	public boolean vinta() {
		return getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	public void setStanzaCorrente(Stanza stanzaNuova) {
		this.stanzaCorrente = stanzaNuova;
	}

	public boolean giocatoreIsVivo() {
		return giocatore.getCfu()>0;
	}
	public IO getIO() {
		return this.io;
	}
	
}
