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
 
	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
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

}
