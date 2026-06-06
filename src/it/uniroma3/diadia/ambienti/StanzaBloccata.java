	package it.uniroma3.diadia.ambienti;
	
	public class StanzaBloccata extends Stanza{
	
		
		private Direzioni direzioneBloccata;
	    private String nomeAttrezzoChiave;
		
		public StanzaBloccata(String nome, Direzioni direzioneBloccata, String nomeAttrezzoChiave) {
			super(nome);
			this.direzioneBloccata=direzioneBloccata;
			this.nomeAttrezzoChiave=nomeAttrezzoChiave;
			
		}
		@Override
		public Stanza getStanzaAdiacente(Direzioni direzione) {
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
