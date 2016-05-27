package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;
import org.makenthrow.zamestnanci.Dopravca;
import org.makenthrow.zamestnanci.Skladnik;
import org.makenthrow.zamestnanci.Vyrobca;
import org.makenthrow.zamestnanci.Zamestnanec;

public class Prihlasenie extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnPrihlas;
	private static JPanel panel;
	private JTextField txtMeno;
	private static JFrame frame;
	
	public Prihlasenie(){
		frame = new JFrame("Prihlasenie");
		nastavOkno();
	}
	
	public void nastavOkno(){
		panel = new JPanel();
		btnPrihlas = new JButton("Prihlasenie");
		txtMeno = new JTextField(10);
		btnPrihlas.addActionListener(this);
		panel.add(btnPrihlas);
		panel.add(txtMeno);
		
		MainGui.vymazPanel();
        MainGui.getFrame().add(panel);
        MainGui.getFrame().setVisible(true);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static void vymazPanel(){
		frame.remove(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPrihlas){
			boolean prihlaseny = false;
			for(Zamestnanec a : Main.getVyrobcovia()){
				if(txtMeno.getText().equals(a.getMeno())){
					new VyrobcaGui((Vyrobca) a);
					panel.setVisible(false);
					prihlaseny = true;
				}
			}
			
			for(Zamestnanec a : Main.getSkladnici()){
				if(txtMeno.getText().equals(a.getMeno())){
					new SkladnikGui((Skladnik) a);
					panel.setVisible(false);
					prihlaseny = true;
				}
			}
			
			for(Zamestnanec a : Main.getObjednavaci()){
				if(txtMeno.getText().equals(a.getMeno())){
					new ObjednavacGui();
					panel.setVisible(false);
					prihlaseny = true;
				}
			}
			
			for(Zamestnanec a : Main.getPersonalisti()){
				if(txtMeno.getText().equals(a.getMeno())){
					new PersonalistaGui();
					panel.setVisible(false);
					prihlaseny = true;
				}
			}
			
			for(Zamestnanec a : Main.getDopravcovia()){
				if(txtMeno.getText().equals(a.getMeno())){
					new DopravcaGui((Dopravca) a);
					panel.setVisible(false);
					prihlaseny = true;
				}
			}
			if(!prihlaseny)
				new Notification("Zadany pouzivatel neexistuje");
			
		}
		
	}

}
