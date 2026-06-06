package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	
	@Override
	public void esegui(Partita partita) {
	for(String elencoComandi : this.comandi) 
	            
		partita.getIO().mostraMessaggio(elencoComandi+" ");
	        
	        }
	
	
	   @Override
	    public String getNome() {
	    	return "aiuto";
	    }
	    
}