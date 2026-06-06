
package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class DiaDiaAccettazioneTest {
	
	

	@Test
    void testVittoriaImmediata() {
        String[] comandi = {"vai nord"};
        IOSimulator io = new IOSimulator(comandi);
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
        assertTrue(io.hasMessaggio("Hai vinto!"));
    }
	@Test
	void testFineSubito(){
		String[] comandi= {"fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Grazie di aver giocato!"));
	}
	
	@Test
	void testEsploraEVinci() {
		String[] comandi= {"vai ovest","vai est","vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Hai vinto!"));
	}
	@Test 
	void testPerdiCfu(){
		String[] comandi= {"vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est","vai ovest","vai est"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Hai esaurito i CFU..."));
	}
	@Test
	void testGuarda() {
		String[] comandi= {"guarda", "fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Atrio"));
	
	}
	@Test
	void testAiuto() {
		String[] comandi= {"aiuto","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("vai"));
		assertTrue(io.hasMessaggio("aiuto"));
		assertTrue(io.hasMessaggio("fine"));
		assertTrue(io.hasMessaggio("prendi"));
		assertTrue(io.hasMessaggio("posa"));
		assertTrue(io.hasMessaggio("guarda"));
	
	}
		@Test
		void testComandoNonValido() {
			String[] comandi= {"ciao","fine"};
			IOSimulator io= new IOSimulator(comandi);
			DiaDia gioco=new DiaDia(io);
				gioco.gioca();
			assertTrue(io.hasMessaggio("Comando sconosciuto"));
		}
	@Test
	void testPrendi() {
		
		String[] comandi= {"prendi osso","guarda","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		
		assertFalse(io.hasMessaggio("osso"));
	}
	@Test
	void testPrendiOggettoNonPresente() {
		String[] comandi= {"prendi lanterna","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Grazie di aver giocato!"));
	}
	@Test 
	void testPosa() {
		String[] comandi= {"prendi osso","vai est","posa osso","guarda","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("osso"));
		assertTrue(io.hasMessaggio("Grazie di aver giocato!"));
	}
	@Test
	void testPosaAttrezzoNonPosseduto() {
		String[] comandi= {"posa lanterna","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);
		gioco.gioca();
		assertTrue(io.hasMessaggio("Grazie di aver giocato!"));
	}
	
	
	@Test
	void vaiDirezioneInesistente() {
		String[] comandi= {"vai nord-est","fine"};
		IOSimulator io= new IOSimulator(comandi);
		DiaDia gioco=new DiaDia(io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("Direzione inesistente"));
	}
	
	@Test
	void VittoriaIstantaneaConBuilder() {
		String[] comandi= {"vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto= Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
				
		DiaDia gioco=new DiaDia(labirinto,io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("Hai vinto!"));
		
	}
	
	@Test
	void StanzaHaOggettoBuilder() {
		String[] comandi= {"guarda","fine"};
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto= Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 2)
				.getLabirinto();
		DiaDia gioco=new DiaDia(labirinto,io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("osso"));
		
		
		
	}
	@Test
	void VaiInStanzaBuiaSenzaOggettoBuilder() {
		String[] comandi= {"vai nord","guarda","fine"};
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto=Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("osso", 2)
				.addStanzaBuia("Caverna","torcia")
				.addAdiacenza("Atrio", "Caverna", "nord")
				.getLabirinto();
		DiaDia gioco=new DiaDia(labirinto,io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("è buio pesto"));
		
		
		
	}
	@Test
	void VaiInStanzaBuiaConOggettoBuilder() {
		String[] comandi= {"prendi","vai nord","guarda","fine"};
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto= Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("torcia", 2)
				.addStanzaBuia("Caverna","torcia")
				.addAdiacenza("Atrio", "Caverna", "nord")
				.getLabirinto();
		DiaDia gioco=new DiaDia(labirinto,io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("Caverna"));
		
		
		
	}
	@Test
	void testStanzaBloccataSenzaAttrezzo() {
	    Labirinto labirinto = Labirinto.newBuilder()
	        .addStanzaIniziale("Ingresso")
	        .addStanzaBloccata("Bloccata", "nord", "chiave")
	        .addStanzaVincente("Uscita")
	        .addAdiacenza("Ingresso", "Bloccata", "nord")
	        .addAdiacenza("Bloccata", "Uscita", "nord")
	        .getLabirinto();
	    String[] comandi = {"vai nord", "vai nord", "fine"};
	    IOSimulator io = new IOSimulator(comandi);
	    DiaDia gioco = new DiaDia(labirinto, io);
	    gioco.gioca();
	    assertFalse(io.hasMessaggio("Hai vinto!"));
	}

	 @Test
	void VaiInStanzaBloccataConOggettoBuilder() {
		String[] comandi= {"prendi","vai nord","vai nord"};
		IOSimulator io= new IOSimulator(comandi);
		Labirinto labirinto= Labirinto.newBuilder()
				
				.addStanzaBloccata("Caverna","nord","chiave")
				.addStanzaIniziale("Caverna")
				.addAttrezzo("chiave", 1)
				.addAdiacenza("Caverna", "Atrio", "nord")
				.addStanzaVincente("Uscita")
				.addAdiacenza("Caverna", "Uscita", "nord")
				.getLabirinto();
	
		DiaDia gioco=new DiaDia(labirinto,io);	
		gioco.gioca();
		assertTrue(io.hasMessaggio("Hai vinto!"));
		
		
		
	}
	 
	 
	
		
		
}