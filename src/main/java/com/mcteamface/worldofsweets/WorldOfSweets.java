package com.mcteamface.worldofsweets;

import java.util.ArrayList;

public class WorldOfSweets {

  public static void main(String[] args) {
    // runGame(3);

    ChoosePlayersActivity numPlayersButton = new ChoosePlayersActivity();

    numPlayersButton.addPlayersChosenListener(new ChoosePlayersActivity.PlayersChosenListener() {
			@Override
			public void playersChosen(int numPlayers) {
        numPlayersButton.dispose();
        runGame(numPlayers);
			}
		});
  }

  private static void runGame(int numPlayers) {
    ArrayList<Player> players = new ArrayList<Player>();
    for(int i = 1; i <= numPlayers; i++){
      players.add(new Player(i, "", 0));
    }
    Deck testDeck = new Deck();
    GameBoard board = new GameBoard(numPlayers);
    board.setVisible(true);

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
    // }
  }
}
