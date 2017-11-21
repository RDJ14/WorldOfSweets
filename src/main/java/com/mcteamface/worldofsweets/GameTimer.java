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
	private Timer mTimer;
	private JLabel mTimeDisplay;
	private long mStartTime;
	private long mElapsed;

	public GameTimer() {
		mTimeDisplay = new JLabel("0");
		add(mTimeDisplay);

		mStartTime = System.currentTimeMillis() / 1000;
		mTimer = new Timer(1000, this);
		mTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long now = System.currentTimeMillis() / 1000;
		mElapsed = now - mStartTime;
		mTimeDisplay.setText(mElapsed + " Seconds since start");
	}
}
