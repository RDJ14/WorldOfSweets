package com.mcteamface.worldofsweets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

public class GameTimer extends JPanel implements ActionListener {

	private static final String FILENAME = "gameTimer.dat";

	JLabel timeDisplay;
	long startTime;
	Timer timer;
	volatile int seconds;
	volatile long elapsed;

	public GameTimer() {
		timeDisplay = new JLabel("0");
		add(timeDisplay);

		startTime = System.currentTimeMillis() / 1000;
		seconds = 1;
		timer = new Timer(1000, this);
		timer.setRepeats(false);
		timer.start();
	}

	public boolean save() {
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
			oos.writeObject(elapsed);
			oos.close();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public boolean load(){
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
			startTime = (long) ois.readObject();
			System.out.println("new start time: " + startTime);

			if(startTime == 0)
			{
				ois.close();
				return false;
			}

		} catch(Exception e){

			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long now = System.currentTimeMillis()/1000;
		elapsed = now - startTime;
		seconds++;
		timeDisplay.setText(elapsed + " Seconds since start");
		timer.setInitialDelay((int)(startTime + seconds * 1000 - now));
		timer.start();
	}
}
