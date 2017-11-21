package com.mcteamface.worldofsweets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.text.SimpleDateFormat;

public class GameTimer extends JPanel implements ActionListener {
	private Timer mTimer;
	private JLabel mTimeDisplay;
	private long mStartTime;

	public GameTimer() {
		mTimeDisplay = new JLabel("0");
		add(mTimeDisplay);
		setPreferredSize(new Dimension(100, 100));

		mStartTime = System.currentTimeMillis();
		mTimer = new Timer(1000, this);
		mTimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long now = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat("mm:ss");
		mTimeDisplay.setText(df.format(now - mStartTime));
	}
}
