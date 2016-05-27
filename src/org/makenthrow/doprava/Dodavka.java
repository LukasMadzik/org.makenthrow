package org.makenthrow.doprava;

public class Dodavka extends Prostriedok{

	public Dodavka(String SPZ, int cena) {
		super(SPZ, cena);
	}
	
	public static String getTyp(){
		return "Dodavka";
	}

}
