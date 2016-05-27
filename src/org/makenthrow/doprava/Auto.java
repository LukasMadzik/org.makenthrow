package org.makenthrow.doprava;

public class Auto extends Prostriedok{

	public Auto(String SPZ, int cena) {
		super(SPZ, cena);
	}
	
	public static String getTyp(){
		return "Auto";
	}

}
