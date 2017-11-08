package com.mcteamface.worldofsweets;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GameActivity extends JFrame {
	public GameActivity(int numberOfPlayers) {
		setBounds(100, 100, 1073, 548);

		GameBoardView board = new GameBoardView(numberOfPlayers);
		board.setPreferredSize(new Dimension(773, 548));

		Deck deck = new Deck();
		deck.setPreferredSize(new Dimension(300, 300));

		setLayout(new BorderLayout());
		add(deck, BorderLayout.WEST);
		add(board, BorderLayout.EAST);

    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
