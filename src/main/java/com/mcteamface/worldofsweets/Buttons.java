package com.mcteamface.worldofsweats;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Buttons extends JFrame implements ActionListener{
	int numPlayers;
	JLabel playerMessage;
	JPanel panel;
	JButton b1;
    JButton b2;
    JButton b3;

	public static void main(String[] args) {
		Buttons buttonFrame = new Buttons();

	}

	public Buttons() {
        setSize(400, 400);
        // Create JButton and JPanel
        playerMessage = new JLabel("Select Number of Players:");
        panel = new JPanel();
        b1 = new JButton("2");
        b2 = new JButton("3");
        b3 = new JButton("4");

        /*
         *Not sure where to put ActionListener
         */

        ActionListener b1Event = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numPlayers = 2;
    			playerMessage.setText("Playing with "+numPlayers+" players");

    		}
    	};
    	ActionListener b2Event = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numPlayers = 3;
    			playerMessage.setText("Playing with "+numPlayers+" players");

    		}
    	};
    	ActionListener b3Event = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numPlayers = 4;
    			playerMessage.setText("Playing with "+numPlayers+" players");

    		}
    	};


        b1.addActionListener(b1Event);
        b2.addActionListener(b2Event);
        b3.addActionListener(b3Event);



        // Add button to JPanel
        panel.add(playerMessage);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
