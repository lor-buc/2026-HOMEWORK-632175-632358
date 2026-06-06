package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.Proprieta;
import it.uniroma3.diadia.attrezzi.*;
class StanzaMagica extends Stanza {
private int soglia_magica_default =Proprieta.getSogliaMagica();
private int contatoreAttrezziPosati;
private int sogliaMagica;
public StanzaMagica(String nome) {
	super(nome);
	this.contatoreAttrezziPosati=0;
	this.sogliaMagica=soglia_magica_default;
	}
public StanzaMagica(String nome, int soglia) {
super(nome);
this.contatoreAttrezziPosati = 0;
this.sogliaMagica = soglia;
}
@Override
public boolean addAttrezzo(Attrezzo attrezzo) {
	this.contatoreAttrezziPosati++;
	if (this.contatoreAttrezziPosati>this.sogliaMagica)
	attrezzo = this.modificaAttrezzo(attrezzo);
	return super.addAttrezzo(attrezzo);
}
private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
	StringBuilder nomeInvertito;
	int pesoX2 = attrezzo.getPeso() * 2;
	nomeInvertito = new StringBuilder(attrezzo.getNome());
	nomeInvertito = nomeInvertito.reverse();
	attrezzo = new Attrezzo(nomeInvertito.toString(),
	pesoX2);
	return attrezzo;
}

}