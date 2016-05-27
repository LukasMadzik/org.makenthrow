package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.makenthrow.notify.Notification;
import org.makenthrow.ulohy.Uloha;
import org.makenthrow.ulohy.VyriesUlohu;
import org.makenthrow.zamestnanci.Dopravca;

public class DopravcaGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private static JButton btnDoprav;
	private static JLabel lblZadanie;
	private static JTextField txtDoprav;
	private static JButton btnOdhlas;
	
	private Dopravca dopravca;
	
	public DopravcaGui(Dopravca a) {
		new JFrame("Personalista");
		nastavOkno(a);
	}
	
	public void nastavOkno(Dopravca a){
		panel = new JPanel();
		btnOdhlas = new JButton("Odhlasenie");
		btnOdhlas.addActionListener(this);
		lblZadanie = new JLabel("Doprav ");
		btnDoprav = new JButton("Doprav");
		btnDoprav.addActionListener(this);
		txtDoprav = new JTextField(6);
		
		dopravca=a;
		
		panel.add(lblZadanie);
		panel.add(txtDoprav);
		panel.add(btnDoprav);
		panel.add(btnOdhlas);
		
		for(Uloha u : a.getUlohy()){
			lblZadanie.setText(lblZadanie.getText()+" "+u.getNazov());
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
		if(e.getSource()==btnDoprav){
			if(txtDoprav.getText().isEmpty())
				new Notification("Zadaj nazov ulohy");
			else{
				for(Uloha a:dopravca.getUlohy()){
					System.out.println(a.getNazov());
				}
				for(Uloha a:dopravca.getUlohy()){
					if(a.getNazov().equals(txtDoprav.getText())){
						new Notification("Uloha "+a.getNazov()+" bola dopravena zakaznikovy "+VyriesUlohu.vyberVhodneVozidlo(a)+"\n"+Dopravca.getPozicia()+" "+dopravca.getMeno()+" ziskal "+dopravca.getM_plat()+" euro");
						lblZadanie.setText("Doprav ");
						dopravca.getUlohy().remove(a);
						for(Uloha u : dopravca.getUlohy()){
							lblZadanie.setText(lblZadanie.getText()+" "+u.getNazov());
						}
						break;
					}
				}
			}
		}
	}

}
