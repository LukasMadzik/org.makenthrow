package org.makenthrow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGui extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton btnPrihlas;
	private static JPanel panel;
	private static JFrame frame;
	
	

	public MainGui(){
		frame = new JFrame("Make´n´throw");
		nastavOkno();
	}

	public void nastavOkno(){
		panel = new JPanel();
		
		btnPrihlas = new JButton("Prihlasenie");
		btnPrihlas.addActionListener(this);
		panel.add(btnPrihlas);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
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
			new Prihlasenie();
		}
	}
	
}
