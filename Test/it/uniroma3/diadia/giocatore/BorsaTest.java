package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	
private Borsa borsa;
private Attrezzo martello;
private Attrezzo osso;
private Attrezzo macchina;

	@BeforeEach
	void setUp() throws Exception {
		borsa=new Borsa();
		martello=new Attrezzo("martello",7);
		osso=new Attrezzo("osso",2);
		macchina=new Attrezzo("macchina",2000);
	}

	@Test
	void testBorsaVuotaAllInizio() {
	assertTrue(borsa.isEmpty());
	}

	@Test //restituisce attrezzo nella borsa
	void testBorsaGetAttrezzo() {
		borsa.addAttrezzo(martello);
	assertEquals(martello,borsa.getAttrezzo("martello"));
	}
	
	@Test //cerchiamo attrezzo che non è nella borsa
	void testBorsaGetAttrezzoNonInBorsa() {
		borsa.addAttrezzo(martello);
	assertEquals(null,borsa.getAttrezzo("osso"));
	}	
	
	@Test
	void testBorsaAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(martello));
	}
	
	
	@Test //pesoMax=10;
	void testBorsaAddOggettoTroppoPesante() {
		assertFalse(borsa.addAttrezzo(macchina));
	}
	
	@Test
	void testRestituiscePesoTotale() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(osso);
		assertEquals(9,borsa.getPeso());
		}
	
	@Test
	void testRestituiscePesoTotaleNullo() {
		assertEquals(0,borsa.getPeso());
		}
	
	
	@Test //verifico se attrezzo è nella borsa
	void testBorsaHasAttrezzoInBorsa() {
		borsa.addAttrezzo(martello);
	assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test //verifico se attrezzo non è nella borsa
	void testBorsaHasAttrezzoNonInBorsa() {
		borsa.addAttrezzo(martello);
	assertFalse(borsa.hasAttrezzo("osso"));
	}
	
	@Test //verifico se attrezzo non è nella borsa
	void testBorsaHasAttrezzoVuota() {
	assertFalse(borsa.hasAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzoPresente() {
		borsa.addAttrezzo(martello);
		assertEquals(martello,borsa.removeAttrezzo("martello"));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		borsa.addAttrezzo(martello);
		assertNull(borsa.removeAttrezzo("osso"));
	}
	
	@Test //due oggetti differenti. 
	void testRemoveUnaAttrezzoSuDueUguali() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(new Attrezzo("martello", 2));
		assertEquals(martello,borsa.removeAttrezzo("martello"));
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
}
