
package com.mcteamface.worldofsweets;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class Buttons extends JFrame implements ActionListener{
	volatile int numPlayers;
	JLabel playerMessage;
	JPanel panel;

	JButton b1;
  JButton b2;
  JButton b3;
	volatile boolean playersSelected;

	public static void main(String[] args) {
		Buttons buttonFrame = new Buttons();

	}

	public Buttons() {
		JFrame frame = this;
        setSize(400, 400);
        // Create JButton and JPanel
				playersSelected = false;
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
					playersSelected = true;
    			playerMessage.setText("Playing with "+numPlayers+" players");
    			frame.dispose();

    		}
    	};
    	ActionListener b2Event = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numPlayers = 3;
					playersSelected = true;
    			playerMessage.setText("Playing with "+numPlayers+" players");
    			frame.dispose();

    		}
    	};
    	ActionListener b3Event = new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			numPlayers = 4;
					playersSelected = true;
    			playerMessage.setText("Playing with "+numPlayers+" players");
    			frame.dispose();
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

	public boolean havePlayerSelected(){
		return playersSelected;
	}

	public int getNumPlayers(){
		return numPlayers;
	}
}