package org.makenthrow.ulohy;

import java.util.List;

import org.makenthrow.main.Main;
import org.makenthrow.sklad.Sklad;
import org.makenthrow.sklad.Surovina;
import org.makenthrow.zamestnanci.Zamestnanec;

public class VyriesUlohu {
	
	/**
	 * tato funkcia vrati najvhodnejsie vozidlo ktore je k dispozicii pre danu ulohu
	 * ak nemam ziadne vozidlo tak idem peso a zadarmo
	 */
	public static String vyberVhodneVozidlo(Uloha a){
		switch(a.getPotrebneSuroviny().size()){
		case 1:{
			if(Main.getBicykle().size()==0){
				return "peso a zadarmo";
			}
			else{
				return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za "+Main.getBicykle().get(0).getCena()+" euro";
			}
		}
		case 2:{
			if(Main.getSegwaye().size()==0){
				if(Main.getBicykle().size()==0){
					return "peso a zadarmo";
				}
				else{
					return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za dvojnasobnu cenu "+2*Main.getBicykle().get(0).getCena()+" euro";
				}
			}
			else{
				return "segwayom "+Main.getSegwaye().get(0).getSPZ()+" za "+Main.getSegwaye().get(0).getCena()+" euro";
			}
		}
		case 3:{
			if(Main.getAuta().size()==0){
				if(Main.getSegwaye().size()==0){
					if(Main.getBicykle().size()==0){
						return "peso a zadarmo";
					}
					else{
						return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za trojnasobnu cenu "+3*Main.getBicykle().get(0).getCena()+" euro";
					}
				}
				else{
					return "segwayom "+Main.getSegwaye().get(0).getSPZ()+" za dvojnasobnu cenu "+2*Main.getSegwaye().get(0).getCena()+" euro";
				}
			}
			else{
				return "autom "+Main.getAuta().get(0).getSPZ()+" za "+Main.getAuta().get(0).getCena()+" euro";
			}
		}
		case 4:{
			if(Main.getDodavky().size()==0){
				if(Main.getAuta().size()==0){
					if(Main.getSegwaye().size()==0){
						if(Main.getBicykle().size()==0){
							return "peso a zadarmo";
						}
						else{
							return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za stvornasobnu cenu "+4*Main.getBicykle().get(0).getCena()+" euro";
						}
					}
					else{
						return "segwayom "+Main.getSegwaye().get(0).getSPZ()+" za trojnasobnu cenu "+3*Main.getSegwaye().get(0).getCena()+" euro";
					}
				}
				else{
					return "autom "+Main.getAuta().get(0).getSPZ()+" za dvojnasobnu cenu "+2*Main.getAuta().get(0).getCena()+" euro";
				}
			}
			else{
				return "dodavkou "+Main.getDodavky().get(0).getSPZ()+" za "+Main.getDodavky().get(0).getCena()+" euro";
			}
		}
		case 5:{
			if(Main.getKamiony().size()==0){
				if(Main.getDodavky().size()==0){
					if(Main.getAuta().size()==0){
						if(Main.getSegwaye().size()==0){
							if(Main.getBicykle().size()==0){
								return "peso a zadarmo";
							}
							else{
								return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za patnasobnu cenu "+5*Main.getBicykle().get(0).getCena()+" euro";
							}
						}
						else{
							return "segwayom "+Main.getSegwaye().get(0).getSPZ()+" za stvornasobnu cenu "+4*Main.getSegwaye().get(0).getCena()+" euro";
						}
					}
					else{
						return "autom "+Main.getAuta().get(0).getSPZ()+" za trojnasobnu cenu "+3*Main.getAuta().get(0).getCena()+" euro";
					}
				}
				else{
					return "dodavkou "+Main.getDodavky().get(0).getSPZ()+" za dvojnasobnu cenu "+2*Main.getDodavky().get(0).getCena()+" euro";
				}
			}
			else{
				return "kamionom "+Main.getKamiony().get(0).getSPZ()+" za "+Main.getKamiony().get(0).getCena()+" euro";
			}
		}
		default:{
			if(a.getPotrebneSuroviny().size()>=5){
				if(Main.getKamiony().size()==0){
					if(Main.getDodavky().size()==0){
						if(Main.getAuta().size()==0){
							if(Main.getSegwaye().size()==0){
								if(Main.getBicykle().size()==0){
									return null;
								}
								else{
									return "bicyklom "+Main.getBicykle().get(0).getSPZ()+" za patnasobnu cenu "+5*Main.getBicykle().get(0).getCena()+" euro";
								}
							}
							else{
								return "segwayom "+Main.getSegwaye().get(0).getSPZ()+" za stvornasobnu cenu "+4*Main.getSegwaye().get(0).getCena()+" euro";
							}
						}
						else{
							return "autom "+Main.getAuta().get(0).getSPZ()+" za trojnasobnu cenu "+3*Main.getAuta().get(0).getCena()+" euro";
						}
					}
					else{
						return "dodavkou "+Main.getDodavky().get(0).getSPZ()+" za dvojnasobnu cenu "+2*Main.getDodavky().get(0).getCena()+" euro";
					}
				}
				else{
					return "kamionom "+Main.getKamiony().get(0).getSPZ()+" za "+Main.getKamiony().get(0).getCena()+" euro";
				}
			}
			else{
				return "peso a zadarmo";
			}
		}
		}
	}
	
	public static void zistiChybajuceSuroviny(Uloha testovanaUloha){
		for(Surovina a:testovanaUloha.getPotrebneSuroviny()){
			if(!Sklad.mame(a.getNazov())){
				Main.getSkladnici().get(najmenejUlohPracovnika(Main.getSkladnici())).getUlohy().add(new Uloha("Zozen "+a.getNazov(), a));
			}
		}
	}
	
	public static void vyrobUlohu(String nazovUlohy){
		for(Uloha a:Main.getUlohyVyrobca()){
			if(a.getNazov().equals(nazovUlohy)){
				posliVyrobokDopravcovi(a);
				Main.getUlohyVyrobca().remove(a);
				break;
			}
		}
	}
	
	private static void posliVyrobokDopravcovi(Uloha a){
		Main.getUlohyDopravca().add(a);
		Main.getDopravcovia().get(najmenejUlohPracovnika(Main.getDopravcovia())).getUlohy().add(new Uloha(a.getNazov(), a.getPotrebneSuroviny()));
	}
	
	public static void posliSurovinyVyrobcovi(Uloha a){
		for(Surovina s:a.getPotrebneSuroviny()){
			Sklad.getSklad();
			Sklad.znizMnozstvo(s.getNazov());
		}
	}
	
	public static boolean mozemVykonatUlohu(Uloha testovanaUloha){
		int kolkoMam=0;
		for(Surovina a:testovanaUloha.getPotrebneSuroviny()){
			for(int i=0; i<Sklad.getSuroviny().size();i++){
				if(a.getNazov().equals(Sklad.getSuroviny().get(i).getNazov())){
					if(Sklad.getSuroviny().get(i).getMnozstvo()>0){
						kolkoMam++;
					}
				}
			}
		}
		if(kolkoMam==testovanaUloha.getPotrebneSuroviny().size()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static int najmenejUlohPracovnika(List<Zamestnanec> zamestnanci){
		int index = 0;
		for(int i=0;i<zamestnanci.size();i++){
			if(zamestnanci.get(i).getUlohy().size()<zamestnanci.get(index).getUlohy().size())
				index=i;
		}
		System.out.println(index);
		return index;
	}
	
	public static void posliUlohuDalej(Uloha ulohaNaPoslanie){
		Main.getVyrobcovia().get(najmenejUlohPracovnika(Main.getVyrobcovia())).getUlohy().add(ulohaNaPoslanie);
	}
	
	public VyriesUlohu(Uloha zadanaUloha){
		Main.ulohySkladnik.add(zadanaUloha);
		if(mozemVykonatUlohu(zadanaUloha)){
			posliUlohuDalej(zadanaUloha);
		}
		else{
			Main.getUlohySkladnik().add(zadanaUloha);
			zistiChybajuceSuroviny(zadanaUloha);
		}
	}

}
