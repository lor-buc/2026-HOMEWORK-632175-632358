package it.uniroma3.diadia;

import java.io.*;
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.personaggi.TipoPersonaggio;

public class CaricatoreLabirinto {

    private static final String STANZE_MARKER = "Stanze:";
    private static final String ESTREMI_MARKER = "Estremi:";
    private static final String ATTREZZI_MARKER = "Attrezzi:";
    private static final String USCITE_MARKER = "Uscite:";
    private static final String PERSONAGGIO_MARKER = "Personaggi:";
    private static final String STANZA_BUIA_MARKER = "Stanze buie:";
    private static final String STANZA_CHIUSA_MARKER = "Stanze chiuse:";
    private static final String STANZA_MAGICA_MARKER = "Stanze magiche:";
    


    private LineNumberReader reader;
    private Labirinto.LabirintoBuilder builder;

    public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
        this.reader = new LineNumberReader(new FileReader(nomeFile));
        this.builder = Labirinto.newBuilder();
    }

    // costruttore con Reader — utile per i test con StringReader
    public CaricatoreLabirinto(Reader reader) {
        this.reader = new LineNumberReader(reader);
        this.builder = Labirinto.newBuilder();
    }

    public void carica() throws FormatoFileNonValidoException {
        try {
            this.leggiECreaStanze();
            this.leggiECreaStanzeMagiche();
            this.leggiECreaStanzeChiuse();
            this.leggiECreaStanzeBuie();
            this.leggiEstremi();
            this.leggiECollocaAttrezzi();
            this.leggiECollocaPersonaggi();
            this.leggiEImpostaUscite();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void leggiECreaStanze() throws FormatoFileNonValidoException {
        this.leggiRigaCheCominciaPer(STANZE_MARKER);
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(STANZA_MAGICA_MARKER)) {
            String nomeStanza = riga.trim();
            if (!nomeStanza.isEmpty())
                this.builder.addStanza(nomeStanza);
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Estremi: non trovato");
    }
    private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException {
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(ESTREMI_MARKER)) {
            String nomeStanza = riga.trim();
            if (!nomeStanza.isEmpty()) {
            	Scanner s=new Scanner(riga);
            	 check(s.hasNext(), "Nome stanza mancante per la stanza");
            	 String nome=s.next();
            	 check(s.hasNext(), "Attrezzo per vedere mancante per la stanza "+nome);
            	 String attrezzo=s.next();
            	 s.close();

                 this.builder.addStanzaBuia(nome,attrezzo); 
            	
            }
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Estremi: non trovato");
    }
    private void leggiECreaStanzeChiuse() throws FormatoFileNonValidoException {
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(STANZA_BUIA_MARKER)) {
            String nomeStanza = riga.trim();
            if (!nomeStanza.isEmpty()) {
            	Scanner s=new Scanner(riga);
            	 check(s.hasNext(), "Nome stanza mancante per la stanza");
            	 String nome=s.next();
            	 check(s.hasNext(), "Direzione bloccata mancante per la stanza" +nome);
            	 String direzione=s.next();
            	 check(s.hasNext(), "Attrezzo per aprire la direzione "+direzione+" mancante per la stanza "+nome);
            	 String attrezzo=s.next();
            	 s.close();

                 this.builder.addStanzaBloccata(nome,direzione,attrezzo); 
            	
            }
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Estremi: non trovato");
    }
    
    private void leggiECreaStanzeMagiche() throws FormatoFileNonValidoException {
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(STANZA_CHIUSA_MARKER)) {
            String nomeStanza = riga.trim();
            if (!nomeStanza.isEmpty()) {
            	Scanner s=new Scanner(riga);
            	 check(s.hasNext(), "Nome stanza mancante per la stanza");
            	 String nome=s.next();
            	 
            	 
            	 if(s.hasNextInt()) {
            		 int soglia=s.nextInt();
            		 this.builder.addStanzaMagica(nome,soglia); 
            	 }
            	 else
            		 this.builder.addStanzaMagica(nomeStanza);
            }
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Estremi: non trovato");
    }

    private void leggiEstremi() throws FormatoFileNonValidoException {
        // la prima riga (Estremi:) è già stata letta da leggiECreaStanze
        String nomeIniziale = leggiProssimaRiga();
        check(nomeIniziale != null, "Nome stanza iniziale mancante");
        this.builder.addStanzaIniziale(nomeIniziale.trim());

        String nomeVincente = leggiProssimaRiga();
        check(nomeVincente != null, "Nome stanza vincente mancante");
        this.builder.addStanzaVincente(nomeVincente.trim());
    }

    private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
        this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(PERSONAGGIO_MARKER)) {
            if (!riga.trim().isEmpty()) {
                Scanner s = new Scanner(riga);
                check(s.hasNext(), "Nome attrezzo mancante");
                String nomeAttrezzo = s.next();
                check(s.hasNext(), "Peso attrezzo mancante per " + nomeAttrezzo);
                String pesoStr = s.next();
                check(s.hasNext(), "Nome stanza mancante per " + nomeAttrezzo);
                String nomeStanza = s.next();
                s.close();
                try {
                    int peso = Integer.parseInt(pesoStr);
                    this.builder.addAttrezzoAStanza(nomeStanza, nomeAttrezzo, peso);
                } catch (NumberFormatException e) {
                    check(false, "Peso non valido per attrezzo " + nomeAttrezzo);
                }
            }
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Uscite: non trovato");
    }

    private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
        // la riga Uscite: è già stata letta
        String riga = leggiProssimaRiga();
        while (riga != null) {
            if (!riga.trim().isEmpty()) {
                Scanner s = new Scanner(riga);
                check(s.hasNext(), "Stanza partenza mancante");
                String stanzaDa = s.next();
                check(s.hasNext(), "Direzione mancante per " + stanzaDa);
                String direzione = s.next();
                check(s.hasNext(), "Stanza destinazione mancante");
                String stanzaA = s.next();
                s.close();
                this.builder.addAdiacenza(stanzaDa, stanzaA, direzione);
            }
            riga = leggiProssimaRiga();
        }
    }

    private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
        try {
            String riga = this.reader.readLine();
            check(riga != null && riga.startsWith(marker), 
                "Attesa riga che comincia per " + marker);
            return riga.substring(marker.length());
        } catch (IOException e) {
            throw new FormatoFileNonValidoException(e.getMessage());
        }
    }

    private String leggiProssimaRiga() throws FormatoFileNonValidoException {
        try {
            return this.reader.readLine();
        } catch (IOException e) {
            throw new FormatoFileNonValidoException(e.getMessage());
        }
    }

    private void check(boolean condizione, String msg) throws FormatoFileNonValidoException {
        if (!condizione)
            throw new FormatoFileNonValidoException(
                "Errore riga " + this.reader.getLineNumber() + ": " + msg);
    }

    public Labirinto getLabirinto() {
        return this.builder.getLabirinto();
    }
    private void leggiECollocaPersonaggi() throws FormatoFileNonValidoException {
        // "Personaggi:" già consumato dal while precedente
        String riga = leggiProssimaRiga();
        while (riga != null && !riga.startsWith(USCITE_MARKER)) {
            if (!riga.trim().isEmpty()) {
                Scanner s = new Scanner(riga);
                check(s.hasNext(), "Tipo personaggio mancante");
                TipoPersonaggio tipo;
                try {
                    tipo = TipoPersonaggio.valueOf(s.next().toUpperCase());
                } catch (IllegalArgumentException e) {
                    check(false, "Tipo personaggio sconosciuto");
                    return;
                }
                check(s.hasNext(), "Nome personaggio mancante");
                String nome = s.next();
                check(s.hasNext(), "Presentazione mancante per " + nome);
                String presentazione = s.next();
                check(s.hasNext(), "Nome stanza mancante per " + nome);
                String nomeStanza = s.next();

                AbstractPersonaggio personaggio;
                switch (tipo) {
                    case STREGA:
                        personaggio = new Strega(nome, presentazione);
                        break;
                    case MAGO:
                        if (s.hasNext()) {
                            String nomeAttrezzo = s.next();
                            check(s.hasNextInt(), "Peso attrezzo mago mancante");
                            int peso = s.nextInt();
                            personaggio = new Mago(nome, presentazione, 
                                new Attrezzo(nomeAttrezzo, peso));
                        } else {
                            personaggio = new Mago(nome, presentazione, null);
                        }
                        break;
                    case CANE:
                        personaggio = new Cane(nome, presentazione);
                        break;
                    default:
                        check(false, "Tipo personaggio sconosciuto: " + tipo);
                        return;
                }
                s.close();

                Stanza stanza = this.builder.getMappaStanze().get(nomeStanza);
                check(stanza != null, "Stanza " + nomeStanza + " non trovata");
                stanza.setPersonaggio(personaggio);
            }
            riga = leggiProssimaRiga();
        }
        check(riga != null, "Marker Uscite: non trovato");
    }
}