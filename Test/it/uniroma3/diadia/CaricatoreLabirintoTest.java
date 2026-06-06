
package it.uniroma3.diadia;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzioni;

class CaricatoreLabirintoTest {

	

	@Test
	void testMonolocale() throws Exception {
	String file= "Stanze: \nN10\nStanze magiche: \nStanze chiuse: \nStanze buie: \nEstremi: \nN10\nN10\nAttrezzi: \nPersonaggi: \nUscite: \n";
	CaricatoreLabirinto carica=new CaricatoreLabirinto(new StringReader(file));
	carica.carica();
	assertEquals("N10",carica.getLabirinto().getStanzaVincente().getNome());

	assertEquals("N10",carica.getLabirinto().getStanzaIniziale().getNome());
		
	}

	
	@Test
	void testBilocale() throws Exception{
		String file= "Stanze:\nN10\nBiblioteca\nStanze magiche: \nStanze chiuse: \nStanze buie: \nEstremi:\nN10\nBiblioteca\n" +
	            "Attrezzi: \nPersonaggi: \nUscite:\nN10 nord Biblioteca\nBiblioteca sud N10\n";;
		CaricatoreLabirinto carica=new CaricatoreLabirinto(new StringReader(file));
		carica.carica();
		assertEquals("Biblioteca",carica.getLabirinto().getStanzaVincente().getNome());

		assertEquals("N10",carica.getLabirinto().getStanzaIniziale().getNome());
		assertEquals("Biblioteca",carica.getLabirinto().getStanza("N10").getStanzaAdiacente(Direzioni.NORD).getNome());

	}

	@Test
	void testAttrezzo() throws Exception{
		String file= "Stanze:\nN10\nBiblioteca\nStanze magiche: \nStanze chiuse: \nStanze buie: \nEstremi:\nN10\nBiblioteca\nAttrezzi:\nosso 2 N10 \nspada 10 N10\nlibro 3 Biblioteca\nPersonaggi: \nUscite:\nN10 nord Biblioteca\nBiblioteca sud N10\n";
		CaricatoreLabirinto carica=new CaricatoreLabirinto(new StringReader(file));
		carica.carica();
		assertTrue(carica.getLabirinto().getStanzaIniziale().hasAttrezzo("osso"));
		assertTrue(carica.getLabirinto().getStanza("Biblioteca").hasAttrezzo("libro"));
		assertTrue(carica.getLabirinto().getStanzaIniziale().hasAttrezzo("spada"));
		
		
		
	}
	   @Test
	    void testFormatoNonValido() {
	        String testo = "FormatoSbagliato\n";
	        CaricatoreLabirinto c = new CaricatoreLabirinto(new StringReader(testo));
	        boolean b=false;
	        try {
	        	c.carica();
	        	
	        }catch (FormatoFileNonValidoException e ) {
	        	b=true;
	        }
	        assertTrue(b);
	    }
	
}

	

