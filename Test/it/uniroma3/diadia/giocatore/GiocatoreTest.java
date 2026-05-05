package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	private Giocatore giocatore;
	private Attrezzo osso;
	
	@BeforeEach
	void setUp() throws Exception {
		giocatore=new Giocatore();
		osso=new Attrezzo("osso",3);
	}

	@Test //borsa è stata creata
	void testGiocatoreBorsaNotNull() {
		assertNotNull(giocatore.getBorsa());
	}
	
	@Test
	void testGiocatoreBorsaVuotaInizio() {
		assertTrue(giocatore.getBorsa().isEmpty());
	}
	
	@Test
	void testGiocatoreBorsaNonVuota() {
		giocatore.addAttrezzo(osso);
		assertTrue(giocatore.getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void testGiocatoreCfuIniziali() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	void testSetCfu() {
		giocatore.setCfu(3);
		assertEquals(3,giocatore.getCfu());
	}
	
	
}
