package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.makenthrow.main.Main;
import org.makenthrow.notify.Notification;
import org.makenthrow.ulohy.Uloha;
import org.makenthrow.ulohy.VyriesUlohu;

public class ObjednavacGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private static JFrame frame;
	
	private JComboBox<Object> boxUlohy;
	private JButton btnOdhlas;
	private JButton btnRozposli;
	private JButton btnNovaUloha;
	//private JTextField txtMnozstvo;
	
	
	
	public ObjednavacGui() {
		frame = new JFrame("Objednavac");
		nastavOkno();

	}
	
	public void nastavOkno(){
		panel = new JPanel();
		boxUlohy = new JComboBox<>();
		btnNovaUloha = new JButton("Vytvor ulohu");
		btnOdhlas = new JButton("Odhlasenie");
		btnRozposli = new JButton("Rozposli ulohu");
		//txtMnozstvo = new JTextField();
		
		btnNovaUloha.addActionListener(this);
		btnOdhlas.addActionListener(this);
		btnRozposli.addActionListener(this);
		
		panel.add(boxUlohy);
		//panel.add(txtMnozstvo);
		panel.add(btnRozposli);
		panel.add(btnNovaUloha);
		panel.add(btnOdhlas);
		
		//txtMnozstvo.setText("Zadaj mnozstvo");
		
		for(Uloha a : Main.getUlohyObjednavaca()){
			boxUlohy.addItem(a.getNazov());
		}

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
		if(e.getSource()==btnNovaUloha){
				new NovaUloha();
				panel.setVisible(false);
		}
		if(e.getSource()==btnOdhlas){
			new Prihlasenie();
			panel.setVisible(false);
		}
		if(e.getSource()==btnRozposli){
			if(boxUlohy.getItemCount()==0){
				new Notification("Nebola zvolena ziadna uloha");
			}
			else{
				if(Main.getSkladnici().size()==0){
					new Notification("Niesu dostupny zamestnanci");
				}
				else{
					new VyriesUlohu(Main.getUlohyObjednavaca().get(boxUlohy.getSelectedIndex()));
					new Notification("Uloha bola rozposlana");
				}
			}
		}
	}

}
