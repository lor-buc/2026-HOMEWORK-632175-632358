package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.attrezzi.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBuiaTest {
private String luce;
private Stanza stanza;
private Attrezzo lanterna;
private Attrezzo osso;

	@BeforeEach
	void setUp() throws Exception {
		luce="luce";
		stanza=new StanzaBuia("Atrio",luce);
		lanterna=new Attrezzo("luce",2);
		osso=new Attrezzo("osso",4);
	}

	@Test
	void testCeLuce() {
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(),stanza.getDescrizione());
	}
	@Test
	void testNoOggetti() {
		assertEquals("qui c'è buio pesto", stanza.getDescrizione());
	}
	@Test
	void testOggettoNonLuminoso() {
		stanza.addAttrezzo(osso);
		assertEquals("qui c'è buio pesto", stanza.getDescrizione());
	}

}
