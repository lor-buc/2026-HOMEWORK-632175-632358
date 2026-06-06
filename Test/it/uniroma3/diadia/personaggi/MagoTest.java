package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class MagoTest {

	private Mago mago;
	private Attrezzo attrezzo;
	private Partita partita;
	private IOSimulator io;
	@BeforeEach
	void setUp() throws Exception {
	
		attrezzo=new Attrezzo("osso",2);
		mago=new Mago("mago", "skibidi",attrezzo);
		io=new IOSimulator(new String[] {});	
		partita=new Partita(io);
	
	
		
	}

	@Test
	void agisciTest() {
	assertEquals("Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!",mago.agisci(partita));
	
	assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
		
	}
	@Test
	void agisci2VolteTest() {
	mago.agisci(partita);
		assertEquals("Mi spiace, ma non ho piu' nulla...",mago.agisci(partita));
	
	assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
		
	}
	
	@Test
	void agisciNullTest() {
	Mago mago2=new Mago("mago","ski",null); 
		assertEquals("Mi spiace, ma non ho piu' nulla...",mago2.agisci(partita));
	
		
	}

}
