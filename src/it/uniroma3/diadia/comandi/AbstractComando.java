package it.uniroma3.diadia.comandi;

import java.util.HashSet;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;

public abstract class AbstractComando implements Comando {

	protected static Set<String> comandi=new HashSet<>();

public AbstractComando() {
	String nomeClasse=this.getClass().getSimpleName();
	if(!nomeClasse.equals("ComandoNonValido")) {
	String nomeFinale=nomeClasse.replace("Comando", "").toLowerCase();
	comandi.add(nomeFinale);}
	}

	
public abstract void esegui(Partita partita);
	
public void setParametro(String parametro) {

	
}

public abstract String getNome();

public  String getParametro(){
	return null;
	
	
}
}
	

