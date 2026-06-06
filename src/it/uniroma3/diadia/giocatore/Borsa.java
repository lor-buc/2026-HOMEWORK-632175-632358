package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Collections;

import it.uniroma3.diadia.Proprieta;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparaPerNome;
import it.uniroma3.diadia.attrezzi.ComparaPerPeso;
public class Borsa {
		private List<Attrezzo> attrezzi;
		private int pesoMax;
		
		
		
		public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
		
		}
		public Borsa() {
			this.pesoMax=Proprieta.getPesoMaxBorsa();
			this.attrezzi = new ArrayList<>();
					
		}
		
		public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
		return false;
		
		this.attrezzi.add(attrezzo);
		
		return true;
		}
		
		public int getPesoMax() {
		return pesoMax;
		}
		
		  public Attrezzo getAttrezzo(String nomeAttrezzo) {
		        for (Attrezzo a : this.attrezzi)
		            if (a.getNome().equals(nomeAttrezzo))
		                return a;
		        return null;
		    }
		
		public int getPeso() {
			int peso=0;
			for(Attrezzo attrezzo : attrezzi) {
				peso+=attrezzo.getPeso();
			}
			
			return peso;
			}
		
			public boolean isEmpty() {
			return this.attrezzi.isEmpty();
			}
			
			public boolean hasAttrezzo(String nomeAttrezzo) {
			for(Attrezzo attrezzo : attrezzi) {
				if(attrezzo.getNome().equals(nomeAttrezzo))
					return true;
			} return false;
				
				
			}
			
			public Attrezzo removeAttrezzo(String nomeAttrezzo) {
			    Attrezzo trovato = this.getAttrezzo(nomeAttrezzo);
			    if (trovato != null)
			        this.attrezzi.remove(trovato);
			    return trovato;
			}
			
			public String toString() {
			StringBuilder s = new StringBuilder();
			if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo : this.getContenutoOrdinatoPerPeso())
			s.append(attrezzo.toString()+" ");
			}
			else
			s.append("Borsa vuota");
			return s.toString();
			}
			
			
			
			
			public List<Attrezzo> getContenutoOrdinatoPerPeso(){
				List<Attrezzo> copia = new ArrayList<>(this.attrezzi);
				Collections.sort(copia, new ComparaPerPeso());
				return copia;
				
				
				
			}
			
			public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){

				SortedSet<Attrezzo> copia = new TreeSet<>(new ComparaPerNome());
				copia.addAll(attrezzi);
				return copia;
				
				
				
			}
			
			public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
				
				Map<Integer, Set<Attrezzo>> mappa= new HashMap<>();
				
				for(Attrezzo attrezzo : attrezzi) {
					
					if(!mappa.containsKey(attrezzo.getPeso())) {
						Set<Attrezzo> set=new HashSet<>();
						set.add(attrezzo);
						mappa.put(attrezzo.getPeso(),set);
					}
					else {
						mappa.get(attrezzo.getPeso()).add(attrezzo);
						
						
					}
					
					
					
				}
				return mappa;
				
				
			}
			public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
				SortedSet<Attrezzo> copia = new TreeSet<>(new ComparaPerPeso());
				copia.addAll(attrezzi);
				return copia;
				
				
				
			}
			
			
		}

