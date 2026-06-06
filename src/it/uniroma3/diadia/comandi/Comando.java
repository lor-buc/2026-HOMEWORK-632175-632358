package it.uniroma3.diadia.comandi;



import java.util.Scanner;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public interface Comando {
void esegui(Partita partita);
void setParametro(String parametro);
   

String getNome();
String getParametro();
}