package org.makenthrow.notify;

import javax.swing.JOptionPane;

public class Notification extends JOptionPane{
	
	private static final long serialVersionUID = 1L;
	/**
	 * vytvara okno s upozornenim podla argumentu konstruktora, pouziva sa pri osetreni mimoriadnych stavov a pri informacii o postupe ukonov pracovnikov
	 * @param popis
	 */
	public Notification(String popis){
		Notification.showMessageDialog(getComponent(0), popis);
	}

}
