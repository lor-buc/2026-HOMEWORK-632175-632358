package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class AbstractPersonaggioTest {

	private AbstractPersonaggio personaggio;
	@BeforeEach
	void setUp() {
	
		        personaggio = new AbstractPersonaggio("Gandalf", " Sono un mago!") {
		            @Override
		            public String agisci(Partita partita) {
		                return "Hai perso 5 CFU!";
		            }
		        };
		    }
	

	@Test
	void NoSalutoTest() {
	assertFalse(personaggio.haSalutato());
	
	}
	@Test
	void SiSalutoTest() {
	personaggio.saluta();		assertTrue(personaggio.haSalutato());
	
	}
	
	@Test
	void AgisciTest() {
	IOSimulator io=new IOSimulator(new String[] {});	
	Partita partita=new Partita(io);
		
	assertEquals("Hai perso 5 CFU!",personaggio.agisci(partita));
	}
	
	
	
	

}
