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

		// ArrayList<Player> players = new ArrayList<Player>();
    // for(int i = 1; i <= numPlayers; i++){
    //   players.add(new Player(i, "", 0));
    // }
    // Deck testDeck = new Deck();
    // GameBoard board = new GameBoard(numPlayers);
    // board.setVisible(true);

		// boolean gamePlay = true;
		// Card drawn;
		// int counter = 0;
		// int playersTurn = 0;
		//
		// while(gamePlay){
		//
		//   int currentTurn = playersTurn % numPlayers;
		//   players.get(currentTurn);
		//   //TODO
		//   //Make this message part of the board or a pop up
		//   System.out.println("It is Player : " +(currentTurn + 1) + "'s turn!");
		//   playersTurn++;
		//   boolean userDrew = false;
		//   boolean aCardWasDrawn = false;
		//
		//
		//   while(!userDrew)
		//   {
		//     drawn = testDeck.lastDraw();
		//     testDeck.enableDraw();
		//     if(drawn != null)
		//     {
		//       testDeck.disableDraw();
		//       counter++;
		//       drawn = testDeck.lastDraw();
		//       break;
		//     }
		//   }
		//
		//   //TO DO
		//   //Play Game
		//
		//   testDeck.enableDraw();

    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
