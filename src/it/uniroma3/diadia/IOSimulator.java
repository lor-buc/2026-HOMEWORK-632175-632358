package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOSimulator implements IO {
private List<String> input;
private int rigaCorrente;
private List<String> messaggi;

public IOSimulator(String[] input) {
	this.input=new ArrayList<>(Arrays.asList(input));
	
	rigaCorrente=0;
	this.messaggi=new ArrayList<>();
	
	
}
@Override
public void mostraMessaggio(String messaggio) {
messaggi.add(messaggio);
}
@Override
public String leggiRiga() {
	return input.get(rigaCorrente++);
}
public boolean hasMessaggio(String messaggio) {
    for (String m : messaggi)
        if (m.contains(messaggio))
            return true;
    return false;
}

}
