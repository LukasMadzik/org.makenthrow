package org.makenthrow.doprava;

public class Bicykel extends Prostriedok{

	public Bicykel(String SPZ, int cena) {
		super(SPZ, cena);
	}
	
	public static String getTyp(){
		return "Bicykel";
	}

}
