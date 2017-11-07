package com.mcteamface.worldofsweets;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class ChoosePlayersActivity extends JFrame {
	private static int MIN_PLAYERS = 2;
	private static int MAX_PLAYERS = 4;

	private JLabel mPlayerMessage;
	private JPanel mPanel;
	private JButton[] mButtons;
	private PlayersChosenListener mPlayersChosenListener;

	public ChoosePlayersActivity() {
    setSize(600, 400);
    // Create JButton and JPanel
    mPlayerMessage = new JLabel("Select Number of Players:");
    mPanel = new JPanel();
		mPanel.add(mPlayerMessage);

		int num = (MAX_PLAYERS + 1) - MIN_PLAYERS;
		mButtons = new JButton[num];
		for (int i = 0; i < num; i++) {
			mButtons[i] = new JButton(Integer.toString(i + MIN_PLAYERS));
			mButtons[i].putClientProperty("id", i + MIN_PLAYERS);
			mButtons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
          int id = (int) source.getClientProperty("id");
					mPlayersChosenListener.playersChosen(id);
				}
			});
			mPanel.add(mButtons[i]);
		}

    // And JPanel needs to be added to the JFrame itself!
    getContentPane().add(mPanel);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addPlayersChosenListener(PlayersChosenListener listener) {
		mPlayersChosenListener = listener;
	}

	public interface PlayersChosenListener {
		void playersChosen(int numberOfPlayers);
	}
}
