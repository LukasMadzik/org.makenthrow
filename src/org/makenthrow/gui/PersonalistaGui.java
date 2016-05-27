package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PersonalistaGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private JButton btnPridajZamestnanca;
	private JButton btnPridajDopravu;
	private JButton btnOdhlas;
	
	
	public PersonalistaGui() {
		new JFrame("Personalista");
		nastavOkno();
	}
	
	public void nastavOkno(){
		panel = new JPanel();
		btnPridajZamestnanca = new JButton("Pridaj zamestnanca");
		btnPridajDopravu = new JButton("Pridaj dopravu");
		btnOdhlas = new JButton("Odhlasenie");
		
		btnPridajDopravu.addActionListener(this);
		btnPridajZamestnanca.addActionListener(this);
		btnOdhlas.addActionListener(this);
		
		panel.add(btnPridajDopravu);
		panel.add(btnPridajZamestnanca);
		panel.add(btnOdhlas);
		
		MainGui.vymazPanel();
		MainGui.getFrame().add(panel);
		MainGui.getFrame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPridajZamestnanca){
			new NovyZamestnanecGui();
			panel.setVisible(false);
		}
		if(e.getSource()==btnPridajDopravu){
			new NovaDopravaGui();
			panel.setVisible(false);
		}
		if(e.getSource()==btnOdhlas){
			new Prihlasenie();
			panel.setVisible(false);
		}
		
	}

}
