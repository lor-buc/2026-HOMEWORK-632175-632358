package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	
private Borsa borsa;
private Attrezzo martello;
private Attrezzo osso;
private Attrezzo macchina;

	@BeforeEach
	void setUp() throws Exception {
		borsa=new Borsa(10);
		martello=new Attrezzo("martello",7);
		osso=new Attrezzo("osso",2);
		macchina=new Attrezzo("macchina",2000);
	}

	@Test
	void testBorsaVuotaAllInizio() {
	assertTrue(borsa.isEmpty());
	}

	@Test //restituisce attrezzo nella borsa
	void testBorsaGetAttrezzo() {
		borsa.addAttrezzo(martello);
	assertEquals(martello,borsa.getAttrezzo("martello"));
	}
	
	@Test //cerchiamo attrezzo che non è nella borsa
	void testBorsaGetAttrezzoNonInBorsa() {
		borsa.addAttrezzo(martello);
	assertEquals(null,borsa.getAttrezzo("osso"));
	}	
	
	@Test
	void testBorsaAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(martello));
	}
	
	
	@Test //pesoMax=10;
	void testBorsaAddOggettoTroppoPesante() {
		assertFalse(borsa.addAttrezzo(macchina));
	}
	
	@Test
	void testRestituiscePesoTotale() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(osso);
		assertEquals(9,borsa.getPeso());
		}
	
	@Test
	void testRestituiscePesoTotaleNullo() {
		assertEquals(0,borsa.getPeso());
		}
	
	
	@Test //verifico se attrezzo è nella borsa
	void testBorsaHasAttrezzoInBorsa() {
		borsa.addAttrezzo(martello);
	assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	@Test //verifico se attrezzo non è nella borsa
	void testBorsaHasAttrezzoNonInBorsa() {
		borsa.addAttrezzo(martello);
	assertFalse(borsa.hasAttrezzo("osso"));
	}
	
	@Test //verifico se attrezzo non è nella borsa
	void testBorsaHasAttrezzoVuota() {
	assertFalse(borsa.hasAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzoPresente() {
		borsa.addAttrezzo(martello);
		assertEquals(martello,borsa.removeAttrezzo("martello"));
	}
	
	@Test
	void testRemoveAttrezzoNonPresente() {
		borsa.addAttrezzo(martello);
		assertNull(borsa.removeAttrezzo("osso"));
	}
	
	@Test //due oggetti differenti. 
	void testRemoveUnaAttrezzoSuDueUguali() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(new Attrezzo("martello", 2));
		assertEquals(martello,borsa.removeAttrezzo("martello"));
		assertTrue(borsa.hasAttrezzo("martello"));
	}
	
	
	@Test
	void testDueAttrezziConPesoUgualeMaNomeDiverso() {
		Attrezzo falce=new Attrezzo("falce",2);
		borsa.addAttrezzo(falce);
		borsa.addAttrezzo(osso);
		SortedSet<Attrezzo> set=borsa.getSortedSetOrdinatoPerPeso();
		assertTrue(set.contains(falce));
		assertTrue(set.contains(osso));
		
	}
	
	@Test
	void OridinaDuePerPeso() {
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(martello);
		List<Attrezzo> lista=borsa.getContenutoOrdinatoPerPeso();
		assertEquals(lista.getLast(),martello);
		assertEquals(lista.getFirst(),osso);
	}
	@Test
	void OridinaTrePerPeso() {
		Attrezzo piuma=new Attrezzo("piuma",1);
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(piuma);
		List<Attrezzo> lista=borsa.getContenutoOrdinatoPerPeso();
		assertEquals(lista.getFirst(),piuma);
		assertEquals(lista.getLast(),martello);
		assertTrue(lista.contains(osso));
	}
	@Test
	void OridinaPerPesoConOggettiUguali() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(martello);
		List<Attrezzo> lista=borsa.getContenutoOrdinatoPerPeso();
		assertTrue(lista.contains(martello));
		assertSame(1,lista.size());
	}
	
	@Test
	void OrdinaDuePerNomeSet() {

		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(martello);
		SortedSet<Attrezzo> set=borsa.getContenutoOrdinatoPerNome();
		assertEquals(set.getFirst(),martello);
		assertEquals(set.getLast(),osso);		
	}
	@Test
	void OridinaTrePerNomeSet() {
		Attrezzo piuma=new Attrezzo("piuma",1);
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(piuma);
		SortedSet<Attrezzo> set=borsa.getContenutoOrdinatoPerNome();
		assertEquals(set.getFirst(),martello);
		assertEquals(set.getLast(),piuma);
		assertTrue(set.contains(osso));
	}
	
	@Test
	void OridinaPerNomeSetConOggettiUgualiInNome() {
		borsa.addAttrezzo(martello);
		Attrezzo burla=new Attrezzo("martello",4);
		borsa.addAttrezzo(burla);
		SortedSet<Attrezzo> set=borsa.getContenutoOrdinatoPerNome();
		assertTrue(set.contains(martello));
		assertSame(1,set.size());
	}
	
	@Test
	void MappaOrdinataConDueUgualiInPeso() {
		Attrezzo chiave=new Attrezzo("chiave",2);
		borsa.addAttrezzo(chiave);
		borsa.addAttrezzo(osso);
		Map<Integer,Set<Attrezzo>> mappa= borsa.getContenutoRaggruppatoPerPeso();
		
		assertTrue(mappa.get(2).contains(chiave));
		assertTrue(mappa.get(2).contains(osso));
		
		
	}
	@Test
	void MappaOrdinataConDueDiversiInPeso() {
		borsa.addAttrezzo(martello);
		borsa.addAttrezzo(osso);
		Map<Integer,Set<Attrezzo>> mappa= borsa.getContenutoRaggruppatoPerPeso();
		
		assertFalse(mappa.get(2).contains(martello));
		assertTrue(mappa.get(2).contains(osso));
		assertTrue(mappa.get(7).contains(martello));
		
		
	}
	@Test
	void MappaOrdinataConDueIdentici() {
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(osso);
		Map<Integer,Set<Attrezzo>> mappa= borsa.getContenutoRaggruppatoPerPeso();
		
		assertTrue(mappa.get(2).contains(osso));
		assertTrue(mappa.get(2).size()==1);
		
		
	}
}
