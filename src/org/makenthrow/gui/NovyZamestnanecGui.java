package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;
import org.makenthrow.zamestnanci.Dopravca;
import org.makenthrow.zamestnanci.Objednavac;
import org.makenthrow.zamestnanci.Personalista;
import org.makenthrow.zamestnanci.Skladnik;
import org.makenthrow.zamestnanci.Vyrobca;

public class NovyZamestnanecGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JTextField txtMeno;
	private JTextField txtPlat;
	private JButton btnPridajDopravcu;
	private JButton btnPridajObjednavaca;
	private JButton btnPridajPersonalistu;
	private JButton btnPridajSkladnika;
	private JButton btnPridajVyrobcu;
	private JButton btnSpat;
	
	
	public NovyZamestnanecGui() {
		new JFrame("Novy zamestnanec");
		nastavOkno();
	}
	
	public void nastavOkno(){
		panel = new JPanel();
		txtMeno = new JTextField(8);
		txtPlat = new JTextField(8);
		btnPridajDopravcu = new JButton("Pridaj dopravcu");
		btnPridajObjednavaca = new JButton("Pridaj objednavaca");
		btnPridajPersonalistu = new JButton("Pridaj personalistu");
		btnPridajSkladnika = new JButton("Pridaj skladnika");
		btnPridajVyrobcu = new JButton("Pridaj vyrobcu");
		btnSpat = new JButton("Spat");
		
		txtMeno.setText("Meno");
		txtPlat.setText("Plat");
		
		btnPridajDopravcu.addActionListener(this);
		btnPridajObjednavaca.addActionListener(this);
		btnPridajPersonalistu.addActionListener(this);
		btnPridajSkladnika.addActionListener(this);
		btnPridajVyrobcu.addActionListener(this);
		btnSpat.addActionListener(this);
		
		panel.add(txtMeno);
		panel.add(txtPlat);
		panel.add(btnPridajDopravcu);
		panel.add(btnPridajObjednavaca);
		panel.add(btnPridajPersonalistu);
		panel.add(btnPridajSkladnika);
		panel.add(btnPridajVyrobcu);
		panel.add(btnSpat);
		
		MainGui.vymazPanel();
		MainGui.getFrame().add(panel);
		MainGui.getFrame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPridajDopravcu){
			Main.getDopravcovia().add(new Dopravca(txtMeno.getText(), Integer.parseInt(txtPlat.getText())));
			new Notification("Bol pridany novy dopravca "+txtMeno.getText()+" a bude pracovat za plat "+txtPlat.getText()+" euro");
		}
		if(e.getSource()==btnPridajObjednavaca){
			Main.getObjednavaci().add(new Objednavac(txtMeno.getText(), Integer.parseInt(txtPlat.getText())));
			new Notification("Bol pridany novy objednavac "+txtMeno.getText()+" a bude pracovat za plat "+txtPlat.getText()+" euro");
		}
		if(e.getSource()==btnPridajPersonalistu){
			Main.getPersonalisti().add(new Personalista(txtMeno.getText(), Integer.parseInt(txtPlat.getText())));
			new Notification("Bol pridany novy personalista "+txtMeno.getText()+" a bude pracovat za plat "+txtPlat.getText()+" euro");
		}
		if(e.getSource()==btnPridajSkladnika){
			Main.getSkladnici().add(new Skladnik(txtMeno.getText(), Integer.parseInt(txtPlat.getText())));
			new Notification("Bol pridany novy skladnik "+txtMeno.getText()+" a bude pracovat za plat "+txtPlat.getText()+" euro");
		}
		if(e.getSource()==btnPridajVyrobcu){
			Main.getVyrobcovia().add(new Vyrobca(txtMeno.getText(), Integer.parseInt(txtPlat.getText())));
			new Notification("Bol pridany novy vyrobca "+txtMeno.getText()+" a bude pracovat za plat "+txtPlat.getText()+" euro");
		}
		if(e.getSource()==btnSpat){
			new PersonalistaGui();
			panel.setVisible(false);
		}
		
	}

}
