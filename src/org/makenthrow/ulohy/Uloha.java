package org.makenthrow.ulohy;

import java.util.ArrayList;
import java.util.List;

import org.makenthrow.sklad.Surovina;

public class Uloha {
	private String nazov;
	private List<Surovina> potrebneSuroviny = new ArrayList<Surovina>();
	/**
	 * konstruktor pre jedinu surovinu, pouziva sa pri skladnikoch
	 */
	public Uloha(String nazov, Surovina surovina){
		this.nazov = nazov;
		potrebneSuroviny.add(surovina);
	}
	
	public Uloha() {
	}
	/**
	 * konstruktor pre list surovin, pouziva sa pri zadani konkretnej ulohy
	 */
	public Uloha (String nazov, List<Surovina> suroviny){
		this.nazov = nazov;
		potrebneSuroviny = suroviny;
	}
	
	public Uloha (Uloha a){
		nazov = a.nazov;
		potrebneSuroviny = a.potrebneSuroviny;
	}
	
	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public List<Surovina> getPotrebneSuroviny() {
		return potrebneSuroviny;
	}
	public void setPotrebneSuroviny(List<Surovina> potrebneSuroviny) {
		this.potrebneSuroviny = potrebneSuroviny;
	}

}
