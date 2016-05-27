package org.makenthrow.doprava;

public class Segway extends Prostriedok{

	public Segway(String SPZ, int cena) {
		super(SPZ, cena);
	}
	
	public static String getTyp(){
		return "Segway";
	}

}
