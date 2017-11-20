package com.mcteamface.worldofsweets;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class GameController extends JFrame {

  public GameController(int numberOfPlayers) {
    setBounds(100, 100, 1073, 548);
    GameBoard board = new GameBoard(numberOfPlayers);
    Deck deck = new Deck();
    GameTimer timer = new GameTimer();


    board.setPreferredSize(new Dimension(773, 548));
    deck.setPreferredSize(new Dimension(300, 300));
    timer.setPreferredSize(new Dimension(300, 300));

    setLayout(new BorderLayout());
    add(board, BorderLayout.EAST);
    add(deck, BorderLayout.WEST);
    add(timer, BorderLayout.WEST);

    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
