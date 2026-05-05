package it.uniroma3.diadia;

public class IOSimulator implements IO {
private String[] input;
private int rigaCorrente;
private String[] messaggi;
private int numeroMessaggi;

public IOSimulator(String[] input) {
	this.input=input;
	rigaCorrente=0;
	this.messaggi=new String[100];
	numeroMessaggi=0;
	
}
@Override
public void mostraMessaggio(String messaggio) {
messaggi[numeroMessaggi]=messaggio;
numeroMessaggi++;
}
@Override
public String leggiRiga() {
	rigaCorrente++;
	return input[rigaCorrente-1];
}
public boolean hasMessaggio(String messaggio) {
	for (int i=0;i<numeroMessaggi;i++) {
		if(this.messaggi[i]!=null&&messaggi[i].contains(messaggio))
			return true;
	}
	return false;
	
}

}
