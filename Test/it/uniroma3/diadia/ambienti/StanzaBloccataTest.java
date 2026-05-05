package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBloccataTest {
private Stanza stanza;
private Attrezzo chiave;
private Attrezzo osso;
private String direzioneBloccata;
private String unlock;
private Stanza adiacenteBloccata;
private Stanza adiacenteLibera;
 
	@BeforeEach
	void setUp() throws Exception {
		direzioneBloccata="nord";
		unlock="chiave";
		stanza=new StanzaBloccata("Atrio",direzioneBloccata,unlock);
		chiave=new Attrezzo("chiave",2);
		osso=new Attrezzo("osso",4);
		adiacenteBloccata=new Stanza("Biblioteca");
		adiacenteLibera=new Stanza("Cinema");
		stanza.impostaStanzaAdiacente(direzioneBloccata, adiacenteBloccata);
		stanza.impostaStanzaAdiacente("sud", adiacenteLibera);
		
		
	}

	@Test
	void testOggettoChiave() {
	stanza.addAttrezzo(chiave);
	assertEquals(adiacenteBloccata,stanza.getStanzaAdiacente(direzioneBloccata));
	}
	@Test
	void testNienteOggettoChiave() {
		stanza.addAttrezzo(osso);
		assertEquals(stanza,stanza.getStanzaAdiacente(direzioneBloccata));
	}
	@Test
	void testStanzaLibera() {
		assertEquals(adiacenteLibera,stanza.getStanzaAdiacente("sud"));
	}
	@Test
	void testDescrizioneSenzaOggetto() {
		assertEquals(stanza.toString() + "\nla direzione "+direzioneBloccata+" è stata bloccata, è necessario possedere l'attrezzo "+unlock,stanza.getDescrizione());
	}
	@Test
	void testDescrizioneConOggetto() {
		stanza.addAttrezzo(chiave);
		assertEquals(stanza.toString() + "\nla direzione "+direzioneBloccata+" è stata sbloccata grazie all'attrezzo "+unlock,stanza.getDescrizione());
	}

}
