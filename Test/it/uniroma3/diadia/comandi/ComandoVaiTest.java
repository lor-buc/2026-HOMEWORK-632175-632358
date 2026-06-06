package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoVaiTest {

private Partita partita;
private IO io;
private ComandoVai vai;
private Partita custom;
private Labirinto labirinto;
 
	@BeforeEach
	void setUp() throws Exception {
		io=new IOSimulator(new String[] {});
		partita=new Partita(io);
		
		vai=new ComandoVai();
		
	}

	@Test
	void testSetParametro() {
		vai.setParametro("nord");
		vai.esegui(partita);
		assertEquals("Biblioteca",this.partita.getStanzaCorrente().getNome());
		assertEquals(19,this.partita.getGiocatore().getCfu());	
	}
	@Test
	void testDirezioneInesistente() {
		vai.setParametro("nor");
		vai.esegui(partita);
		assertEquals("Atrio",this.partita.getStanzaCorrente().getNome());
		assertEquals(20,this.partita.getGiocatore().getCfu());	
	}
	@Test
	void testSetParametroNull() {
		vai.setParametro(null);
		vai.esegui(partita);
		assertEquals("Atrio",this.partita.getStanzaCorrente().getNome());
		assertEquals(20,this.partita.getGiocatore().getCfu());	
	}

	
	
	@Test
	void testBilocale() {
		labirinto=Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAdiacenza("Atrio", "Bagno", "est")
				.getLabirinto();
		custom=new Partita(labirinto,io);
		vai.setParametro("nord");
		vai.esegui(custom);
		vai.setParametro("ovest");
		vai.esegui(custom);
		vai.setParametro("sud");
		vai.esegui(custom);
		vai.setParametro("est");
		vai.esegui(custom);
		assertEquals(custom.getStanzaCorrente().getNome(),"Bagno");
		
	}
	@Test
	void testPercorsoVittoria() {
		labirinto=Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAdiacenza("Atrio", "Bagno", "est")
				.addAdiacenza("Bagno", "Cantina", "nord")
				.addAdiacenza("Cantina", "Uscita", "ovest")
				.addStanzaVincente("Uscita")
				.getLabirinto();
		custom=new Partita(labirinto,io);
		
		vai.setParametro("est");
		vai.esegui(custom);
		vai.setParametro("nord");
		vai.esegui(custom);
        vai.setParametro("ovest");
		vai.esegui(custom);
		assertTrue(custom.vinta());
		
	}
	
	
	
	
	
	
	
}
