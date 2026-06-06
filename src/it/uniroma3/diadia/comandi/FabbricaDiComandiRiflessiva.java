

package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IOConsole; 

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

   public FabbricaDiComandiRiflessiva() {
	    new ComandoVai();
	    new ComandoFine();
	    new ComandoPrendi();
	    new ComandoPosa();
	    new ComandoGuarda();
	    new ComandoAiuto();
	    new ComandoInteragisci();
	    new ComandoSaluta();
	    new ComandoRegala();
}

    @Override
public Comando costruisciComando(String istruzione) {
    	if (istruzione == null)           // ← aggiunto
            return new ComandoNonValido();
Scanner scannerDiParole = new Scanner(istruzione);
String nomeComando = null;
String parametro = null;
Comando comando = null;
if (scannerDiParole.hasNext())
nomeComando = scannerDiParole.next();//prima parola: nome del comando
if (scannerDiParole.hasNext())
parametro = scannerDiParole.next();//seconda parola: eventuale parametro
scannerDiParole.close();
try {
String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
nomeClasse += nomeComando.substring(1);
comando = (Comando)Class.forName(nomeClasse).newInstance();
comando.setParametro(parametro);
} catch (Exception e) {
comando = new ComandoNonValido();
}
return comando;
}
}