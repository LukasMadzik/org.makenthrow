package org.makenthrow.zamestnanci;

public class Objednavac extends Zamestnanec{

	public Objednavac(String meno, int m_plat) {
		super(meno, m_plat);

	}
	
	public static String getPozicia(){
		return "Objednavac";
	}
	

}
