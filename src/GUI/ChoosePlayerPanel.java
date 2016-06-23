package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ChoosePlayerPanel extends JPanel implements MouseListener {
	
	JRadioButton spieler2, spieler3, spieler4, spieler5, spieler6, spieler7, spieler8, spieler9, spieler10;
	JButton auswahl;
	
	public ChoosePlayerPanel() {
		//Buttons definieren
		spieler2 = new JRadioButton("2 Spieler");
		spieler2.setSelected(true);
		spieler3 = new JRadioButton("3 Spieler");
		spieler3.setSelected(true);
		spieler4 = new JRadioButton("4 Spieler");
		spieler4.setSelected(true);
		spieler5 = new JRadioButton("5 Spieler");
		spieler5.setSelected(true);
		spieler6 = new JRadioButton("6 Spieler");
		spieler6.setSelected(true);
		spieler7 = new JRadioButton("7 Spieler");
		spieler7.setSelected(true);
		spieler8 = new JRadioButton("8 Spieler");
		spieler8.setSelected(true);
		spieler9 = new JRadioButton("9 Spieler");
		spieler9.setSelected(true);
		spieler10 = new JRadioButton("10 Spieler");
		spieler10.setSelected(true);
		
		
		//Buttons gruppieren
		ButtonGroup group = new ButtonGroup();
		group.add(spieler2);
		group.add(spieler3);
		group.add(spieler4);
		group.add(spieler5);
		group.add(spieler6);
		group.add(spieler7);
		group.add(spieler8);
		group.add(spieler9);
		group.add(spieler10);
		
		
		//ActionListener registrieren
		spieler2.addMouseListener(this);
		spieler3.addMouseListener(this);
		spieler4.addMouseListener(this);
		spieler5.addMouseListener(this);
		spieler6.addMouseListener(this);
		spieler7.addMouseListener(this);
		spieler8.addMouseListener(this);
		spieler9.addMouseListener(this);
		spieler10.addMouseListener(this);
		
		
		//Buttons zu einem Panel zusammenfassen
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.setSize(250, 280);
		radioPanel.add(spieler2);
		radioPanel.add(spieler3);
		radioPanel.add(spieler4);
		radioPanel.add(spieler5);
		radioPanel.add(spieler6);
		radioPanel.add(spieler7);
		radioPanel.add(spieler8);
		radioPanel.add(spieler9);
		radioPanel.add(spieler10);
		
		Border border = BorderFactory.createTitledBorder("Spieleranzahl Auswahl");
		this.setBorder(border);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(radioPanel);
		
		auswahl = new JButton("Auswahl speichern");
		radioPanel.add(auswahl);
		auswahl.addMouseListener(this);
		//this.setVisible(true);
		//this.setSize(500, 500);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source == spieler2) {
			//10-50
		} else if(source == spieler3) {
			//15-60
		} else if(source == spieler4) {
			//20-70
		} else if(source == spieler5) {
			//25-80
		} else if(source == spieler6) {
			//30-90
		} else if(source == spieler7) {
			//35-100
		} else if(source == spieler8) {
			//40-150
		} else if(source == spieler9) {
			//45-200
		} else if(source == spieler10) {
			//50-300
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}