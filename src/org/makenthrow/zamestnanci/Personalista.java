package org.makenthrow.zamestnanci;

public class Personalista extends Zamestnanec{
	
	public Personalista(String meno, int m_plat) {
		super(meno, m_plat);
	}
	
	public static String getPozicia(){
		return "Personalista";
	}

}
