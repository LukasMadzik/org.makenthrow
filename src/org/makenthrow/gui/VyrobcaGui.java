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
import org.makenthrow.zamestnanci.Vyrobca;

public class VyrobcaGui extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel panel;
	private static JButton btnOdhlas;
	private static JLabel lblZadanie;
	private static JButton btnVyrob;
	private static JTextField txtVyrob;
	
	private Vyrobca vyrobca;
	
	
	public VyrobcaGui(Vyrobca a) {
		new JFrame("Personalista");
		nastavOkno(a);
	}
	
	public void nastavOkno(Vyrobca a){
		panel = new JPanel();
		lblZadanie = new JLabel("Potrebujeme vyrobit ");
		btnVyrob = new JButton("Vyrob ");
		txtVyrob = new JTextField(6);
		
		vyrobca = a;
		
		btnOdhlas = new JButton("Odhlasenie");
		btnOdhlas.addActionListener(this);
		
		btnVyrob.addActionListener(this);
		panel.add(lblZadanie);
		panel.add(txtVyrob);
		panel.add(btnVyrob);
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
		if(e.getSource()==btnVyrob){
			if(txtVyrob.getText().isEmpty())
				new Notification("Zadaj nazov ulohy");
			else{
				VyriesUlohu.vyrobUlohu(txtVyrob.getText());
				for(Uloha u:vyrobca.getUlohy()){
					if(u.getNazov().equals(txtVyrob.getText())){
						try{
							new Notification("Uloha "+u.getNazov()+" bola poslana na expediciu\n"+Vyrobca.getPozicia()+" "+vyrobca.getMeno()+" ziskal "+vyrobca.getM_plat()+" euro");
							lblZadanie.setText("");
							vyrobca.getUlohy().remove(u);
							for(Uloha s : vyrobca.getUlohy()){
								lblZadanie.setText(lblZadanie.getText()+" "+s.getNazov());
							}
							break;
						}
						catch(IndexOutOfBoundsException exeption){
							new Notification("Nie su dostupny zamestnanci");
						}
					}
				}
			}
		}
		
	}

}
