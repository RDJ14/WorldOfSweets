
package com.mcteamface.worldofsweets;

import java.util.ArrayList;
public class WorldOfSweets{

    public static void main(String[] args) {
      Buttons numPlayersButton = new Buttons();
      int numPlayers = 0;
      while(numPlayers == 0){
        numPlayers = numPlayersButton.getNumPlayers();
        if(numPlayers != 0){
          break;
        }
      }

      ArrayList<Player> players = new ArrayList<Player>();
      for(int i = 1; i <= numPlayers; i++){
        players.add(new Player(i, "", 0));
      }
      Deck testDeck = new Deck();
      GameBoard board = new GameBoard(numPlayers);
      board.setVisible(true);

      boolean gamePlay = true;
      Card drawn;
      int counter = 0;
      int playersTurn = 0;

      while(gamePlay){
    	  board.disableAll();
        int currentTurn = playersTurn % numPlayers;
        players.get(currentTurn);
        //TODO
        //Make this message part of the board or a pop up
        System.out.println("It is Player : " +(currentTurn + 1) + "'s turn!");
        playersTurn++;
        boolean userDrew = false;
        boolean aCardWasDrawn = false;
        String c="";
        Color boardColor;
        Color cardColor = null;
        while(!userDrew)
        {
        	
          drawn = testDeck.lastDraw();
          testDeck.enableDraw();
          if(drawn != null)
          {
        	  board.playerDisable(currentTurn+1);
            testDeck.disableDraw();
            counter++;
            drawn = testDeck.lastDraw();
            //String a = drawn.getColor();
            //System.out.println(drawn.getColor());
            //cardColor = drawn.getColor();
            //boardColor = board.curColor;

            board.disableAll();
            break;
          }
        }
        while(true) {
        	//System.out.println(boardColor);
        	//System.out.println(cardColor);
        	break;
        	
        }
        
        //TO DO
        //Play Game

        testDeck.enableDraw();
      }
    }
}
