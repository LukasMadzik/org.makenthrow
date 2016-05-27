package org.makenthrow.sklad;

import java.util.ArrayList;
import java.util.List;



public class Sklad {
	private static Sklad sklad = new Sklad();
	private static List<Surovina> suroviny;
	
	private Sklad() {
		suroviny=new ArrayList<>();
	}

	public static List<Surovina> getSuroviny() {
		return suroviny;
	}

	public static Sklad getSklad() {
		return sklad;
	}
	
	public static void odstranSurovinu(String nazov){
		for(int i=0;i<suroviny.size();i++){
			if(suroviny.get(i).getNazov().equals(nazov))
				suroviny.remove(i);
		}
	}
	
	public static void znizMnozstvo(String menoSuroviny){
		for(Surovina a:suroviny){
			if(a.getNazov().equals(menoSuroviny))
				a.setMnozstvo(a.getMnozstvo()-1);
		}
	}
	
	public static void navysMnozstvo(String menoSuroviny, int mnozstvo){
		for(Surovina a:suroviny){
			if(a.getNazov().equals(menoSuroviny))
				a.setMnozstvo(a.getMnozstvo()+mnozstvo);
		}
	}
	
	public static boolean existuje(String surovina){
		for(Surovina a : suroviny){
			if(a.getNazov().equals(surovina))
				return true;
		}
		return false;		
	}
	
	public static boolean mame(String surovina){
		for(Surovina a : suroviny){
			if(a.getNazov().equals(surovina))
				if(a.getMnozstvo()>0)
					return true;
		}
		return false;
	}

}
