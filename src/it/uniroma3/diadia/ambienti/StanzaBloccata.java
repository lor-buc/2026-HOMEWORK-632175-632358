	package it.uniroma3.diadia.ambienti;
	
	public class StanzaBloccata extends Stanza{
	
		
		private String direzioneBloccata;
	    private String nomeAttrezzoChiave;
		
		public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoChiave) {
			super(nome);
			this.direzioneBloccata=direzioneBloccata;
			this.nomeAttrezzoChiave=nomeAttrezzoChiave;
			
		}
		@Override
		public Stanza getStanzaAdiacente(String direzione) {
			if(direzioneBloccata.equals(direzione)&&!this.hasAttrezzo(nomeAttrezzoChiave)) {
				return this;
			}
			return super.getStanzaAdiacente(direzione);
		}
		@Override
		public String getDescrizione() {
			
			if(this.hasAttrezzo(nomeAttrezzoChiave))
			return this.toString() + "\nla direzione "+direzioneBloccata+" è stata sbloccata grazie all'attrezzo "+nomeAttrezzoChiave;
			else
				return this.toString() + "\nla direzione "+direzioneBloccata+" è stata bloccata, è necessario possedere l'attrezzo "+nomeAttrezzoChiave;
		}
		
	}
