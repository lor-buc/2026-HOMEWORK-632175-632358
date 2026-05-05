package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class PartitaTest {
	
	private Partita partita;
	private IO io;
	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
		partita=  new Partita(io);
	}

	@Test
	void testPartitaIsNonFinitaInizio(){
		assertFalse(partita.isFinita());
	}
	
	@Test //cioè stanza corrente == stanza vincente
	void testPartitaIsFinitaAllaFine() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.isFinita());
	}
	
	@Test 
	void testPartitaIsNonFinitaNelMezzo(){
		partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("est"));
		assertFalse(partita.isFinita());
	}
	
	@Test
	void testPartitaSetFinitaPartitaFinita(){
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	void testPartitaIsNonVintaInizio(){
		assertFalse(partita.vinta());
	}
	
	@Test
	void testPartitaIsVintaInStanzaVincente(){
		partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertTrue(partita.vinta());
	}
	
	@Test
	void testPartitaFinitaConZeroCFU() {
		partita.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	void testPartitaIsNotFinitaAllInizio() {
		assertFalse(partita.isFinita());
	}
	
	
	@Test
	void testPartitaNonFinitaConCFUPositivi() {
		partita.setCfu(5);
		assertFalse(partita.isFinita());
	}
	
	@Test
	void testPartitaGetCFUIniziali() {
		assertEquals(20,partita.getCfu());
	}
	
	@Test
	void testPartitaAggiornaValoreCFU() {
		partita.setCfu(7);
		assertEquals(7,partita.getCfu());
	}
	
}
