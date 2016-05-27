package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;
import org.makenthrow.sklad.Surovina;
import org.makenthrow.ulohy.Uloha;

public class NovaUloha extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JTextField txtSurovina;
	private JTextField txtNazov;
	private JButton btnPridaj;
	private JButton btnVytvor;
	
	private static List<Surovina> suroviny = new ArrayList<Surovina>();
	
	public NovaUloha(){
		new JFrame("Nova uloha");
		nastavOkno();
	}

	public void nastavOkno(){
		panel = new JPanel();
		txtNazov = new JTextField();
		txtSurovina = new JTextField();
		btnPridaj = new JButton("Pridaj surovinu");
		btnVytvor = new JButton("Vytvor ulohu");
		
		txtNazov.setText("Nazov ulohy");
		txtSurovina.setText("Potrebna surovina");
		
		btnPridaj.addActionListener(this);
		btnVytvor.addActionListener(this);
		
		panel.add(txtSurovina);
		panel.add(btnPridaj);
		panel.add(txtNazov);
		panel.add(btnVytvor);
		

		MainGui.vymazPanel();
		MainGui.getFrame().add(panel);
		MainGui.getFrame().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPridaj){
			if(txtSurovina.getText().equals("")){
				new Notification("Zadajte nazov suroviny");
			}
			else{
				suroviny.add(new Surovina(txtSurovina.getText(), 1));
				txtSurovina.setText("");
			}
		}
		if(e.getSource()==btnVytvor){
			if(txtNazov.getText().equals("")){
				new Notification("Zadajte nazov ulohy");
			}
			else{
				Uloha a = new Uloha();
				a.setPotrebneSuroviny(suroviny);
				a.setNazov(txtNazov.getText());
				Main.getUlohyObjednavaca().add(a);
				new ObjednavacGui();
				panel.setVisible(false);				
			}
		}
	}

}
