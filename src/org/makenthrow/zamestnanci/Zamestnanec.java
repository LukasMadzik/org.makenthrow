package org.makenthrow.zamestnanci;

import java.util.ArrayList;
import java.util.List;

import org.makenthrow.ulohy.Uloha;

public abstract class Zamestnanec {
	private String meno;
	private int m_plat;
	private List<Uloha> ulohy = new ArrayList<Uloha>();
	
	public Zamestnanec(String meno, int m_plat){
		this.meno=meno;
		this.m_plat=m_plat;
	}

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public int getM_plat() {
		return m_plat;
	}

	public void setM_plat(int m_plat) {
		this.m_plat = m_plat;
	}

	public List<Uloha> getUlohy() {
		return ulohy;
	}
	
	public void odstranUlohu(String meno){
		for(int i=0;i<ulohy.size();i++){
			if(ulohy.get(i).getNazov().equals("Zozen "+meno))
				ulohy.remove(i);
		}
	}

}
