package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;
import org.makenthrow.sklad.Sklad;
import org.makenthrow.sklad.Surovina;
import org.makenthrow.ulohy.Uloha;
import org.makenthrow.ulohy.VyriesUlohu;
import org.makenthrow.zamestnanci.Skladnik;

public class SkladnikGui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JButton btnOdhlas;
	private JTextField txtMamNazov;
	private JTextField txtMamMnozstvo;
	private JButton btnNaskladnit;
	private Skladnik skladnik;
	
	private JLabel lblzadanie;
	
	public SkladnikGui(Skladnik a) {
		new JFrame("Personalista");
		nastavOkno(a);
	}
	
	public void nastavOkno(Skladnik a){
		skladnik = a;
		panel = new JPanel();
		lblzadanie = new JLabel();
		btnOdhlas = new JButton("Odhlasenie");
		txtMamNazov = new JTextField("Nazov", 8);
		txtMamMnozstvo = new JTextField("Mnozstvo", 8);
		btnNaskladnit = new JButton("Naskladnit");
		
		btnOdhlas.addActionListener(this);
		btnNaskladnit.addActionListener(this);
		
		
		
		panel.add(lblzadanie);
		panel.add(txtMamNazov);
		panel.add(txtMamMnozstvo);
		panel.add(btnNaskladnit);
		panel.add(btnOdhlas);
		
		for(Uloha u : a.getUlohy()){
			lblzadanie.setText(lblzadanie.getText()+" " +u.getNazov());
		}
		
		MainGui.vymazPanel();
		MainGui.getFrame().add(panel);
		MainGui.getFrame().setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOdhlas){
			new Prihlasenie();
			panel.setVisible(false);
		}
		
		if(e.getSource()==btnNaskladnit){
			if(Sklad.existuje(txtMamNazov.getText())){
				Sklad.navysMnozstvo(txtMamNazov.getText(), Integer.parseInt(txtMamMnozstvo.getText()));
				try{
					Sklad.getSuroviny().add(new Surovina(txtMamNazov.getText(),Integer.parseInt(txtMamMnozstvo.getText())));
					skladnik.odstranUlohu(txtMamNazov.getText());
					for(Uloha a:Main.getUlohySkladnik()){
						if(VyriesUlohu.mozemVykonatUlohu(a)){
							Main.getUlohyVyrobca().add(a);
							Main.getVyrobcovia().get(VyriesUlohu.najmenejUlohPracovnika(Main.getVyrobcovia())).getUlohy().add(a);
							VyriesUlohu.posliSurovinyVyrobcovi(a);
							new Notification("Uloha "+a.getNazov()+" bola poslana na vyrobu\n"+Skladnik.getPozicia()+" "+skladnik.getMeno()+" ziskal "+skladnik.getM_plat()+" euro");
							Main.getUlohySkladnik().remove(a);
						}
					}
					
					lblzadanie.setText("");
					for(Uloha u : skladnik.getUlohy()){
						lblzadanie.setText(lblzadanie.getText()+" " +u.getNazov());
					}
				}
				catch(NumberFormatException exeption){
					new Notification("Zadane mnozstvo je v zlom formate");
				}
			}
			else{
				try{
					Sklad.getSuroviny().add(new Surovina(txtMamNazov.getText(),Integer.parseInt(txtMamMnozstvo.getText())));
					skladnik.odstranUlohu(txtMamNazov.getText());
					for(Uloha a:Main.getUlohySkladnik()){
						if(VyriesUlohu.mozemVykonatUlohu(a)){
							try{
								Main.getUlohyVyrobca().add(a);
								Main.getVyrobcovia().get(VyriesUlohu.najmenejUlohPracovnika(Main.getVyrobcovia())).getUlohy().add(a);
								VyriesUlohu.posliSurovinyVyrobcovi(a);
								new Notification("Uloha "+a.getNazov()+" bola poslana na vyrobu\n"+Skladnik.getPozicia()+" "+skladnik.getMeno()+" ziskal "+skladnik.getM_plat()+" euro");
								Main.getUlohySkladnik().remove(a);
							}
							catch(IndexOutOfBoundsException exeption){
								new Notification("Nie su dostupny zamestnanci");
							}
						}
					}
					
					lblzadanie.setText("");
					for(Uloha u : skladnik.getUlohy()){
						lblzadanie.setText(lblzadanie.getText()+" " +u.getNazov());
					}
				}
				catch(NumberFormatException exeption){
					new Notification("Zadane mnozstvo je v zlom formate");
				}
			}
		}
		
	}

}
