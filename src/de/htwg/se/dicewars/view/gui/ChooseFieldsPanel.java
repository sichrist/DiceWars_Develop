package de.htwg.se.dicewars.view.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import de.htwg.se.dicewars.boardsetup.Convertmethods;
import de.htwg.se.dicewars.controller.IController;

@SuppressWarnings("serial")
public class ChooseFieldsPanel extends JPanel implements MouseListener {

	private JTextField fieldsEingabe;
	private JButton anwenden, start;
	private Integer felderanzahl = 20;
	private IController controller;
	
	public ChooseFieldsPanel(IController controller) {
		
		this.controller=controller;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setSize(250, 200);
		panel.add(new JLabel("Felderanzahl eingeben (max 300)"));
		
		JPanel panel1 = new JPanel();
		panel1.setSize( 0, 80);
		panel1.setLayout(new GridLayout(0, 1));
		fieldsEingabe = new JTextField("", 3);
		panel1.add(fieldsEingabe);
		
		Border border = BorderFactory.createTitledBorder("Felderanzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(panel);
		this.add(panel1);
		anwenden = new JButton("Anwenden");
		panel1.add(anwenden);
		anwenden.addMouseListener(this);
		
		start = new JButton("Start");
		panel1.add(start);
		start.addMouseListener(this);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source == anwenden) {
			if(fieldsEingabe.getText().length() == 0) {
				JOptionPane.showMessageDialog(
					    fieldsEingabe, "Waehle Anzahl Felder und Anzahl Spieler!",
					    "Eingabefehler",
					    JOptionPane.ERROR_MESSAGE);
			} else 
				felderanzahl = Integer.valueOf(fieldsEingabe.getText());
				controller.setNumberOfFields(felderanzahl);
				controller.setfieldSize(Convertmethods.converteFieldSize(felderanzahl));
				
				
		}
		
		if(source == start) {
			if(fieldsEingabe.getText().length() == 0) {
				JOptionPane.showMessageDialog(
					    fieldsEingabe, "Waehle Anzahl Felder und Anzahl Spieler!",
					    "Eingabefehler",
					    JOptionPane.ERROR_MESSAGE);
			} else {
				JFrame frame = new JFrame("Spielfeld");
				frame.setSize(400, 400);
				frame.setLayout(new GridLayout(1, 0));
	
				frame.pack();
				frame.setVisible(true);
			}
			
		}
	}

	public int getAnzFelder(){
		return this.felderanzahl;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/**** 
		 * 
		 */
	}


	@Override
	public void mouseExited(MouseEvent e) {
		/**** 
		 * 
		 */
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		/**** 
		 * 
		 */
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		/**** 
		 * 
		 */
		
	}
}
