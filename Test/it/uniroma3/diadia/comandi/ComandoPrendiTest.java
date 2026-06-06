package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Attrezzo piuma;
	private Attrezzo fero;
	private Partita partita;
	private ComandoPrendi prendi;
	private IO io;
		@BeforeEach
		void setUp() throws Exception {
			io=new IOSimulator(new String[] {});
			partita=new Partita(io);
			piuma=new Attrezzo("piuma",1);
			fero=new Attrezzo("fero",6);
			prendi=new ComandoPrendi();
		}
	@Test
	void testPrendiUno() {
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(),fero);

		prendi.setParametro("fero");
		prendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("fero"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("fero"));
	}
	@Test
	void testPrendi2() {
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(),fero);
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(),piuma);

		prendi.setParametro("fero");
		prendi.esegui(partita);
		prendi.setParametro("piuma");
		prendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("fero"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("piuma"));
	}
	@Test
	void testPrendiMaNonCe() {
		
		prendi.setParametro("fero");
		prendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("fero"));
	}
	
	@Test
	void prendiOggettoBuilder() {
		Labirinto labirinto= Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 2)
				.getLabirinto();
		Partita custom=new Partita(labirinto,io);
		prendi.setParametro("osso");
		prendi.esegui(custom);
		assertTrue(custom.getGiocatore().getBorsa().hasAttrezzo("osso"));
		
		
		
		
	}
	@Test 
	void prendiOggettoMaNonCeBuilder() {
		Labirinto labirinto=Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.getLabirinto();
		Partita custom=new Partita(labirinto,io);
		prendi.setParametro("osso");
		prendi.esegui(custom);
		assertSame(custom.getGiocatore().getBorsa().getPeso(),0);
		
		
		
		
		
		
	}
}
