package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
private  Stanza biblioteca;
private Stanza laboratorio;
private Stanza atrio;
private Stanza ovest;
private Attrezzo martello;
private Attrezzo osso;
static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	@BeforeEach
	void setUp() throws Exception {
		biblioteca= new Stanza("biblioteca");
		laboratorio= new Stanza("laboratorio");
		atrio=new Stanza("atrio");
		ovest=new Stanza("ovest");
		martello=new Attrezzo("martello",6);
		osso=new Attrezzo("osso",2);
	}

	@Test
	void testImpostaStanzaAdiacente() {
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"));
	}

	@Test
	void testImpostaStanzaAdiacenteNull() {
		assertNull(atrio.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testAggiornaStanzaAdiacente() {
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("nord", laboratorio);
		assertEquals(laboratorio, atrio.getStanzaAdiacente("nord"));	
	}
	
	@Test
	void testAddAttrezzoAggiungoUnAttrezzo() {
		assertTrue(atrio.addAttrezzo(martello));
	}
	
	@Test
	void testAddAttrezzoAggiungoDueAttrezzi() {
		atrio.addAttrezzo(martello);
		atrio.addAttrezzo(osso);
		assertTrue(atrio.hasAttrezzo("martello"));
		assertTrue(atrio.hasAttrezzo("osso"));
	} 
	
	@Test
	void testAddAttrezzoDopoMax() {
	for(int i=0;i<NUMERO_MASSIMO_ATTREZZI;i++) {
	atrio.addAttrezzo(martello);	
	}
	assertFalse(atrio.addAttrezzo(osso));
	}	
	
	
	@Test
	void testGetAttrezziStanzaSenzaAttrezzi() {
		for (int i=0;i<NUMERO_MASSIMO_ATTREZZI;i++) {
			assertEquals(atrio.getAttrezzi()[i], null);
		}
	}
	
	@Test
	void testGetAttrezziStanzaVuota() {
		atrio.addAttrezzo(martello);
		assertEquals(martello,atrio.getAttrezzi()[0]);
	}
	
	@Test
	void testGetAttrezziStanzaNonVuota() {
		for (int i=0;i<5;i++) {
			atrio.addAttrezzo(martello);
		}
		assertEquals(martello,atrio.getAttrezzi()[4]);
	}
	
	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(atrio.hasAttrezzo("martello"));
	}
	
	@Test
	void testStanzaHasUnAttrezzo() {
		atrio.addAttrezzo(martello);
		assertTrue(atrio.hasAttrezzo("martello"));
	}
	
	@Test
	void testHasAttrezzoConSoloOsso() {
		for(int i=0;i<NUMERO_MASSIMO_ATTREZZI;i++) {
			atrio.addAttrezzo(osso);	
			}
		assertFalse(atrio.hasAttrezzo("martello"));
	}
	
	@Test
	void testGetAttrezzoStanzaVuota() {
		assertNull(atrio.getAttrezzo("martello"));
	}
	
	@Test
	void testGetAttrezzoStanzaConOggetto() {
		atrio.addAttrezzo(martello);
		assertEquals(martello,atrio.getAttrezzo("martello"));
	}
	
	@Test
	void testGetAttrezzoStanzaSenzaOggetto() {
		atrio.addAttrezzo(martello);
		assertNull(atrio.getAttrezzo("osso"));
	}
	
	@Test
	void testRemoveOggettoDaStanzaVuota() {
		assertFalse(atrio.removeAttrezzo(martello));
	}
	
	
	@Test
	void testRemoveAttrezzoDaStanzaConUnOggetto() {
		atrio.addAttrezzo(martello);
		assertTrue(atrio.removeAttrezzo(martello));
	}
	
	@Test
	void testRemoveAttrezzoStanzaSenzaOggetto() {
		atrio.addAttrezzo(martello);
		assertFalse(atrio.removeAttrezzo(osso));
	}
	
	@Test
	void testSenzaDirezioni() {
		assertEquals(0,atrio.getDirezioni().length);
	}
	
	@Test
	void testUnaDirezione() {
		atrio.impostaStanzaAdiacente("sud",laboratorio);
		assertEquals("sud",atrio.getDirezioni()[0]);
	}
	
	@Test
	void testTuttaTranneUnaDirezione() {
		atrio.impostaStanzaAdiacente("sud",laboratorio);
		atrio.impostaStanzaAdiacente("est",biblioteca);
		atrio.impostaStanzaAdiacente("ovest",ovest);
		for(int i=0;i<3;i++)
		assertNotEquals("nord",atrio.getDirezioni()[i]);
	}
}
