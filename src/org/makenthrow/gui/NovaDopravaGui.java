package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.makenthrow.doprava.Auto;
import org.makenthrow.doprava.Bicykel;
import org.makenthrow.doprava.Dodavka;
import org.makenthrow.doprava.Kamion;
import org.makenthrow.doprava.Segway;
import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;

public class NovaDopravaGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JTextField txtSPZ;
	private JTextField txtCenaZaDovoz;
	private JButton btnPridajBicykel;
	private JButton btnPridajSegway;
	private JButton btnPridajAuto;
	private JButton btnPridajDodavka;
	private JButton btnPridajKamion;
	private JButton btnSpat;
	
	
	public NovaDopravaGui() {
		new JFrame("Nova doprava");
		nastavOkno();
	}
	
	public void nastavOkno(){
		panel = new JPanel();
		txtSPZ = new JTextField(10);
		txtCenaZaDovoz = new JTextField(8);
		btnPridajBicykel = new JButton("Pridaj bicykel");
		btnPridajSegway = new JButton("Pridaj segway");
		btnPridajAuto = new JButton("Pridaj auto");
		btnPridajDodavka = new JButton("Pridaj dodavku");
		btnPridajKamion = new JButton("Pridaj kamion");
		btnSpat = new JButton("Spat");
		
		txtSPZ.setText("Znacka");
		txtCenaZaDovoz.setText("Dopravna cena");
		
		btnPridajBicykel.addActionListener(this);
		btnPridajSegway.addActionListener(this);
		btnPridajAuto.addActionListener(this);
		btnPridajDodavka.addActionListener(this);
		btnPridajKamion.addActionListener(this);
		btnSpat.addActionListener(this);
		
		panel.add(txtSPZ);
		panel.add(txtCenaZaDovoz);
		panel.add(btnPridajBicykel);
		panel.add(btnPridajSegway);
		panel.add(btnPridajAuto);
		panel.add(btnPridajDodavka);
		panel.add(btnPridajKamion);
		panel.add(btnSpat);
		
		MainGui.vymazPanel();
		MainGui.getFrame().add(panel);
		MainGui.getFrame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPridajBicykel){
			Main.getBicykle().add(new Bicykel(txtSPZ.getText(), Integer.parseInt(txtCenaZaDovoz.getText())));
			new Notification("Bol pridany novy bicykel "+txtSPZ.getText()+" a doprava bude stat "+txtCenaZaDovoz.getText()+" euro");
		}
		if(e.getSource()==btnPridajSegway){
			Main.getSegwaye().add(new Segway(txtSPZ.getText(), Integer.parseInt(txtCenaZaDovoz.getText())));
			new Notification("Bol pridany novy segway "+txtSPZ.getText()+" a doprava bude stat "+txtCenaZaDovoz.getText()+" euro");
		}
		if(e.getSource()==btnPridajAuto){
			Main.getAuta().add(new Auto(txtSPZ.getText(), Integer.parseInt(txtCenaZaDovoz.getText())));
			new Notification("Bolo pridane nove auto "+txtSPZ.getText()+" a doprava bude stat "+txtCenaZaDovoz.getText()+" euro");
		}
		if(e.getSource()==btnPridajDodavka){
			Main.getDodavky().add(new Dodavka(txtSPZ.getText(), Integer.parseInt(txtCenaZaDovoz.getText())));
			new Notification("Bola pridana nova dodavka "+txtSPZ.getText()+" a doprava bude stat "+txtCenaZaDovoz.getText()+" euro");
		}
		if(e.getSource()==btnPridajKamion){
			Main.getKamiony().add(new Kamion(txtSPZ.getText(), Integer.parseInt(txtCenaZaDovoz.getText())));
			new Notification("Bol pridany novy kamion "+txtSPZ.getText()+" a doprava bude stat "+txtCenaZaDovoz.getText()+" euro");
		}
		if(e.getSource()==btnSpat){
			new PersonalistaGui();
			panel.setVisible(false);
		}
		
	}

}
