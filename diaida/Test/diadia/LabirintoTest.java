package diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {

	private Labirinto labirinto;
	@BeforeEach
	void setUp() throws Exception {
		labirinto=new Labirinto();
	}

	@Test
	void testStanzaCorrenteAtrio() {
		assertEquals("Atrio",labirinto.getStanzaCorrente().getNome());
	}
	
    @Test
    void testCambioStanzaCorrenteNull() {
    	labirinto.setStanzaCorrente(null);
    	assertNull(labirinto.getStanzaCorrente());
    }
    
    @Test
    void testVerificoStanzaVincenteBiblioteca() {
    	assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
    }

    @Test
    void testCambioStanzaSudCorrente() {
    	labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("sud"));
    	assertEquals("Aula N10",labirinto.getStanzaCorrente().getNome());
    }
    
    @Test
    void testVerificaNordAtrio() {
    	labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("nord"));
    	assertEquals("Biblioteca",labirinto.getStanzaCorrente().getNome());
    }
    
    @Test
    void testCambioStanzaEstCorrente() {
    	labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("est"));
    	assertEquals("Aula N11",labirinto.getStanzaCorrente().getNome());
    }
    
    @Test
    void testCambioStanzaOvestCorrente() {
    	labirinto.setStanzaCorrente(labirinto.getStanzaCorrente().getStanzaAdiacente("ovest"));
    	assertEquals("Laboratorio Campus",labirinto.getStanzaCorrente().getNome());
    }
    
    
}
