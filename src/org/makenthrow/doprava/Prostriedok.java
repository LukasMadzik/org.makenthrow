package org.makenthrow.doprava;

public abstract class Prostriedok {
	private String SPZ;
	private int cena;
	
	public Prostriedok(String SPZ, int cena){
		this.SPZ=SPZ;
		this.cena=cena;
	}
	
	public String getSPZ() {
		return SPZ;
	}
	public void setSPZ(String sPZ) {
		SPZ = sPZ;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}

}
