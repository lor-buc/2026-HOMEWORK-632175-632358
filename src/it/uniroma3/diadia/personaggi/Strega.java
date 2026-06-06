package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	

	public Strega(String n, String p) {
		super(n,p);
	}
	
	@Override
	public String agisci(Partita partita) {
		if(this.haSalutato()) {
			List<Direzioni> direzioni=partita.getStanzaCorrente().getDirezioni();
			Stanza best=null;
					
			for (Direzioni direzione : direzioni) {
				if(best==null)
					best=partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				
				if (best.getAttrezzi().size()<partita.getStanzaCorrente().getStanzaAdiacente(direzione).getAttrezzi().size())
					best=partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				
				
			}
			partita.setStanzaCorrente(best);
			return "mo te porto nella stanza co più roba solo perché mi hai salutato";
			
		}
		else {
			List<Direzioni> direzioni=partita.getStanzaCorrente().getDirezioni();
			Stanza worst=null;
					
			for (Direzioni direzione : direzioni) {
				if(worst==null)
					worst=partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				
				if (worst.getAttrezzi().size()>partita.getStanzaCorrente().getStanzaAdiacente(direzione).getAttrezzi().size())
					worst=partita.getStanzaCorrente().getStanzaAdiacente(direzione);
				
				
			}
			partita.setStanzaCorrente(worst);
			return "mo te porto nella stanza peggiore perché non mi hai salutato";
			
			
		}
		
		
		
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
	return "AHAHAHAHAHA mo me lo tengo io";
	}
	
	
}
	

