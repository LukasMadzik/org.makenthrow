package org.makenthrow.main;


import java.util.ArrayList;
import java.util.List;

import org.makenthrow.doprava.Prostriedok;
import org.makenthrow.gui.MainGui;
import org.makenthrow.ulohy.Uloha;
import org.makenthrow.zamestnanci.Dopravca;
import org.makenthrow.zamestnanci.Objednavac;
import org.makenthrow.zamestnanci.Personalista;
import org.makenthrow.zamestnanci.Skladnik;
import org.makenthrow.zamestnanci.Vyrobca;
import org.makenthrow.zamestnanci.Zamestnanec;
/**
* tu su vytvorene vsetky potrebne zoznamy
* su k nim spravene getre
*/

public class Main {
	
	
	public static List<Prostriedok> bicykle = new ArrayList<Prostriedok>();
	public static List<Prostriedok> dodavky = new ArrayList<Prostriedok>();
	public static List<Prostriedok> kamiony = new ArrayList<Prostriedok>();
	public static List<Prostriedok> segwaye = new ArrayList<Prostriedok>();
	public static List<Zamestnanec> vyrobcovia = new ArrayList<Zamestnanec>();
	public static List<Zamestnanec> objednavaci = new ArrayList<Zamestnanec>();
	public static List<Zamestnanec> dopravcovia = new ArrayList<Zamestnanec>();
	public static List<Zamestnanec> skladnici = new ArrayList<Zamestnanec>();
	public static List<Zamestnanec> personalisti = new ArrayList<Zamestnanec>();
	public static List<Uloha> ulohyObjednavaca = new ArrayList<Uloha>();
	public static List<Uloha> ulohyVyrobca = new ArrayList<Uloha>();
	public static List<Uloha> ulohySkladnik = new ArrayList<Uloha>();
	public static List<Uloha> ulohyDopravca = new ArrayList<Uloha>();
	

	
	public static List<Prostriedok> auta = new ArrayList<Prostriedok>();
	public static List<Prostriedok> getAuta() {
		return auta;
	}

	public static List<Prostriedok> getBicykle() {
		return bicykle;
	}

	public static List<Prostriedok> getDodavky() {
		return dodavky;
	}

	public static List<Prostriedok> getKamiony() {
		return kamiony;
	}

	public static List<Prostriedok> getSegwaye() {
		return segwaye;
	}
	
	public static List<Uloha> getUlohyDopravca() {
		return ulohyDopravca;
	}

	public static List<Uloha> getUlohyVyrobca() {
		return ulohyVyrobca;
	}

	public static List<Uloha> getUlohySkladnik() {
		return ulohySkladnik;
	}
	
	public static List<Zamestnanec> getPersonalisti() {
		return personalisti;
	}

	public static List<Zamestnanec> getDopravcovia() {
		return dopravcovia;
	}

	public static List<Zamestnanec> getSkladnici() {
		return skladnici;
	}

	public static List<Zamestnanec> getObjednavaci() {
		return objednavaci;
	}

	public static List<Zamestnanec> getVyrobcovia() {
		return vyrobcovia;
	}

	public static List<Uloha> getUlohyObjednavaca() {
		return ulohyObjednavaca;
	}
/**
 * v main je potrebne vytvorit prveho zamestnanca ktory moze dalej pridavat inych zamestnancov
 */
	public static void main(String[] args) {
		
		new MainGui();
		
		personalisti.add(new Personalista("Janko", 500));
		
	}

}
