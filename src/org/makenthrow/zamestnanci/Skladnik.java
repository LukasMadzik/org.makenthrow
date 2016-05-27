package org.makenthrow.zamestnanci;

public class Skladnik extends Zamestnanec{

	public Skladnik(String meno, int m_plat) {
		super(meno, m_plat);
	}
	
	public static String getPozicia(){
		return "Skladnik";
	}

}
