package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class CaneTest {

private Cane cane;	
	@BeforeEach
	void setUp() throws Exception {
	
		cane=new Cane("Cane","bau");

		
	}

	@Test
	void AgisciTest() {
		IOSimulator io=new IOSimulator(new String[] {});	
		Partita partita=new Partita(io);
		assertEquals("hai perso un cfu perché il cane t'ha morso!",cane.agisci(partita));
		assertEquals(19,partita.getGiocatore().getCfu());
		
		
	}
	@Test
	void IlCaneUccideTest() {
		IOSimulator io=new IOSimulator(new String[] {});	
		Partita partita=new Partita(io);
		
		for(int i=0;i<20;i++) {
			cane.agisci(partita);
		}
		assertTrue(partita.isFinita());
		
		
	}
	
	@Test
	void salutaCaneTest() {
		
		assertEquals("Ciao, io sono Cane.bau",cane.saluta());
		
	}
	
	

}
