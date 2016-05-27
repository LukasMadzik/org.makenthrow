package org.makenthrow.doprava;

public class Kamion extends Prostriedok{

	public Kamion(String SPZ, int cena) {
		super(SPZ, cena);
	}
	
	public static String getTyp(){
		return "Kamion";
	}

}
