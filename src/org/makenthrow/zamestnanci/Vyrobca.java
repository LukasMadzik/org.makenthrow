package org.makenthrow.zamestnanci;

public class Vyrobca extends Zamestnanec{

	public Vyrobca(String meno, int m_plat) {
		super(meno, m_plat);
		// TODO Auto-generated constructor stub
	}
	
	public static String getPozicia(){
		return "Vyrobca";
	}

}
