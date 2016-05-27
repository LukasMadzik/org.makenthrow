package org.makenthrow.sklad;

public class Surovina {
	private String nazov;
	private int mnozstvo;

	public Surovina(String nazov, int mnozstvo) {
		this.nazov = nazov;
		this.mnozstvo = mnozstvo;
	}

	public int getMnozstvo() {
		return mnozstvo;
	}

	public void setMnozstvo(int mnozstvo) {
		this.mnozstvo = mnozstvo;
	}

	public String getNazov() {
		return nazov;
	}
	
}
