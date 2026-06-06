package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.Proprieta;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	
	private String ciboPreferito=Proprieta.getCiboPreferito();
	
	public Cane(String n, String p) {
		super(n,p);
	}
	
	@Override
	public String agisci(Partita partita) {
		int cfu=partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu-1);
		return "hai perso un cfu perché il cane t'ha morso!"; 
		
		
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
	if(attrezzo.getNome().equals(ciboPreferito)) {
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(), new Attrezzo("spada", 5));
	return "bau che bontà! tieni la spada per la tua carità";
	}
	else 
		return this.agisci(partita);	
		
	
	}
	
}
