
package com.mcteamface.worldofsweets;

public class WorldOfSweets{

    public static void main(String[] args) {
      Buttons numPlayersButton = new Buttons();
      boolean numPlayersSelected = false;
      int numPlayers = 0;
      while(!numPlayersSelected){
        numPlayersSelected = numPlayersButton.havePlayerSelected();
        if(numPlayers != 0){
          numPlayers = numPlayersButton.getNumPlayers();
          numPlayersButton.dispose();
          break;
        }
      }

      Deck testDeck = new Deck();
      GameBoard board = new GameBoard();
      board.setVisible(true);
      boolean gamePlay = true;
      Card drawn;
      while(gamePlay){
        while(true)
        {
          drawn = testDeck.lastDraw();
          if(drawn != null)
          {
            testDeck.disableDraw();
            System.out.println("Card: " +drawn.color);
            break;
          }
        }

        //TO DO
        //Play Game

        drawn = null;
        testDeck.enableDraw();
      }
    }
}
