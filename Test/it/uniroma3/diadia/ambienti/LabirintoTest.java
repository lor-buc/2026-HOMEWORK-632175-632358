package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {

	private Labirinto labirinto;
	private Partita partita;
	private IO io;
	@BeforeEach
	void setUp() throws Exception {
		labirinto=new Labirinto();
		io=new IOConsole();
		partita=new Partita(io);
	}

	@Test
	void testStanzaCorrenteAtrio() {
		assertEquals("Atrio",partita.getStanzaCorrente().getNome());
	}
	
    @Test
    void testCambioStanzaCorrenteNull() {
    	partita.setStanzaCorrente(null);
    	assertNull(partita.getStanzaCorrente());
    }
    
    @Test
    void testVerificoStanzaVincenteBiblioteca() {
    	assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
    }

    @Test
    void testCambioStanzaSudCorrente() {
    	partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("sud"));
    	assertEquals("Aula N10",partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testVerificaNordAtrio() {
    	partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("nord"));
    	assertEquals("Biblioteca",partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testCambioStanzaEstCorrente() {
    	partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("est"));
    	assertEquals("Aula N11",partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testCambioStanzaOvestCorrente() {
    	partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("ovest"));
    	assertEquals("Laboratorio Campus",partita.getStanzaCorrente().getNome());
    }
    
    
}
