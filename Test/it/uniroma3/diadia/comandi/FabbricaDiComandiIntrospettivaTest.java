package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiIntrospettivaTest {

 private FabbricaDiComandiRiflessiva fabbrica;
	
	@BeforeEach
	void setUp() throws Exception {
		fabbrica=new FabbricaDiComandiRiflessiva();
	}

	@Test
	void testComandoNonEsistente() {
		
		assertEquals("nonvalido",fabbrica.costruisciComando("vola").getNome());
	}
	@Test
	void testComandoStringaVuota() {
		
		assertEquals("nonvalido",fabbrica.costruisciComando("").getNome());
	}
	@Test
	void testComandoNULL() {
		
		assertEquals("nonvalido",fabbrica.costruisciComando(null).getNome());
	}
	
	@Test
	void testComandoPrendi() {
		
		assertEquals("nonvalido",fabbrica.costruisciComando("    ").getNome());
	}
	
	@Test
	void testComandoVai() {
		
		assertNotEquals("nonvalido",fabbrica.costruisciComando("prendi").getNome());
	}

}
