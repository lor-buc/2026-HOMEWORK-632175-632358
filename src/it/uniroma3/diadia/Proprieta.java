package it.uniroma3.diadia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Proprieta {
private static final Properties prop=new Properties();
	

static {
	
	try { InputStream is=Proprieta.class
			.getClassLoader()
			.getResourceAsStream("diadia.properties");
	prop.load(is);
	} catch (IOException e) {
		throw new RuntimeException("File non trovato");
	}
}


public static int getCFUiniziali() {
	return Integer.parseInt(prop.getProperty("cfu_iniziali","20").trim());
}
public static int getPesoMaxBorsa() {
	return Integer.parseInt(prop.getProperty("peso_max_borsa","10").trim());
}	
public static int getSogliaMagica() {
	return Integer.parseInt(prop.getProperty("soglia_magica","3").trim());
}
public static String getCiboPreferito() {
	return prop.getProperty("cibo_preferito","osso").trim();
}
}
