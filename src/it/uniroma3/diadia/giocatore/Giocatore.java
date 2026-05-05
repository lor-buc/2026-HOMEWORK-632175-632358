package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private int cfu;
	private Borsa borsa;
	
	 public Giocatore() {
	        this.cfu = 20;
	        this.borsa = new Borsa();
	    }

	 public Borsa getBorsa() {
		    return this.borsa;
		}
	 
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public void addAttrezzo(Attrezzo attrezzo){
		borsa.addAttrezzo(attrezzo);
	}
	
}

