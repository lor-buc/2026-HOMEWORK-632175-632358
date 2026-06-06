package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

class AbstractComandoTest {

	
	
	
	private AbstractComando comando;
	private Partita partita=new Partita(new IOSimulator(new String[] {}));
	@BeforeEach
	void setUp() {
	
		        comando = new AbstractComando() {
		            @Override
		            public void esegui(Partita partita) {
		            
		            }
		            
		            @Override 
		            public String getNome() {
		            	return "abstract comando";
		            }
		        };
		    }
	
	@Test
	void creaComandoVaiTest() {
	comando=new ComandoVai();
	comando.setParametro("nord");
	comando.esegui(partita);
	assertTrue(partita.vinta());
	assertEquals(comando.getNome(),"vai");
	
	
	}
	@Test
	void creaComandoPrendi() {
	comando=new ComandoPrendi();
	comando.setParametro("osso");
	comando.esegui(partita);
	assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	assertEquals(comando.getNome(),"prendi");
	
	
	}
	@Test
	void creaComandoGuarda() {
	comando=new ComandoGuarda();
	comando.setParametro("osso");
	comando.esegui(partita);
	assertEquals(comando.getNome(),"guarda");
	assertEquals(null,comando.getParametro());
	
	
	}
	@Test
	void AbstractComando() {
		assertEquals(comando.getNome(),"abstract comando");
		assertEquals(null,comando.getParametro());	
		
	}

}
