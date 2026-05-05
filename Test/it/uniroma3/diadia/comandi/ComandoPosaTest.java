package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPosaTest {
private Attrezzo piuma;
private Attrezzo fero;
private Partita partita;
private ComandoPosa posa;
private IO io;

	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
		partita=new Partita(io);
		piuma=new Attrezzo("piuma",1);
		fero=new Attrezzo("fero",6);
		posa=new ComandoPosa();
	}

	@Test
	void testPosa() {
		posa.setParametro("piuma");
		partita.getGiocatore().addAttrezzo(piuma);
		posa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("piuma"));
	}
	@Test
	void testPosa2oggetti() {
		posa.setParametro("piuma");
		partita.getGiocatore().addAttrezzo(piuma);
		partita.getGiocatore().addAttrezzo(fero);
		posa.esegui(partita);
		posa.setParametro("fero");
		posa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("piuma"));
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("fero"));
	}
	@Test
	void testNonHaAttrezzi(){
		posa.setParametro("piuma");
		
		posa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("piuma"));
	}

}
