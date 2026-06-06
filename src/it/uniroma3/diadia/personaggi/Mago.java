package it.uniroma3.diadia.personaggi;



import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
"con una mia magica azione, troverai un nuovo oggetto " +
"per il tuo borsone!";
private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
private Attrezzo attrezzo;
public Mago(String nome, String presentazione, Attrezzo attrezzo) {
super(nome, presentazione);
this.attrezzo = attrezzo;
}
@Override
public String agisci(Partita partita) {
String msg;
if (this.attrezzo!=null) {
partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(),this.attrezzo);
this.attrezzo = null;
msg = MESSAGGIO_DONO;
}
else {
msg = MESSAGGIO_SCUSE;
}
return msg;
}


@Override
public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
Attrezzo nuovo=new Attrezzo(attrezzo.getNome(),attrezzo.getPeso()/2);
partita.getLabirinto().addAttrezzoLabirinto(partita.getStanzaCorrente(), nuovo);
return "oibò! guarda un po'! un oggetto con peso che costui dimezzò!";


}



}
