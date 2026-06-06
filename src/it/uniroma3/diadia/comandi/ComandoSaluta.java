package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	
	
	@Override
	public void esegui(Partita partita) {
		
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
		partita.getIO().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		partita.getIO().mostraMessaggio("non c'è nessuno");
			
	}
	@Override
	public String getNome() {
		return "saluta";
	}
	
	
}
