package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StregaTest {

	private Strega strega;
	private IOSimulator io;
	private Partita partita;
	private Stanza lab;
	
	@BeforeEach
	void setUp() throws Exception {
		strega=new Strega("strega","uwu");
		io=
				new IOSimulator(new String[] {});	
		
		partita=new Partita(io);
		
	}
	
	
	
	
	
	
	
	
	
	

	@Test
	void agisciNonSalutatest() {
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.NORD),new Attrezzo("osso",6));

		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.SUD),new Attrezzo("totti",6));
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.EST),new Attrezzo("gabriele",6));
		lab=partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.OVEST);
		assertEquals("mo te porto nella stanza peggiore perché non mi hai salutato",strega.agisci(partita));
		
		assertSame(partita.getStanzaCorrente(),lab);
		
		
	}
	@Test
	void agisciSalutaTest() {
		strega.saluta();
		
		assertEquals("mo te porto nella stanza co più roba solo perché mi hai salutato",strega.agisci(partita));
		assertEquals(partita.getStanzaCorrente().getNome(),"Aula N10");
		
		
	}
	@Test
	void agisciSalutaConVittoriaTest() {
		strega.saluta();

		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.NORD),new Attrezzo("osso",6));
		partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente().getStanzaAdiacente(Direzioni.NORD),new Attrezzo("osso",6));
		
		assertEquals("mo te porto nella stanza co più roba solo perché mi hai salutato",strega.agisci(partita));
		assertEquals(partita.getStanzaCorrente().getNome(),"Biblioteca");
		assertTrue(partita.vinta());
		
		
	}
	

}
