
package com.mcteamface.worldofsweets;

import java.util.ArrayList;

//import javax.smartcardio.Card;

//import javax.smartcardio.Card;


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


        int currentTurn = playersTurn % numPlayers;
        board.nextPlayerMessage(currentTurn+1);
        board.disableAll();
        players.get(currentTurn);
        //TODO
        //Make this message part of the board or a pop up
        System.out.println("It is Player : " +(currentTurn + 1) + "'s turn!");
        playersTurn++;
        boolean userDrew = false;
        boolean aCardWasDrawn = false;
        String c="";
        int n;
        Color boardColor;
        Color cardColor = null;
        while(!userDrew)
        {

          drawn = testDeck.lastDraw();
          testDeck.enableDraw();
          if(drawn != null)
          {
              Color s = drawn.c;
              String type = null;
              if(drawn.isSpecial) {
            	  n=3;
            	  type = drawn.type.toString();
              }
              else if(drawn.isSingle()) {
            	  n=1;
              }
              else{
            	  n=2;
              }
              if(s != null)
                System.out.println(s.toString());
              //System.out.println(board.curColor.toString());

        	  board.playerDisable(currentTurn+1);
            testDeck.disableDraw();

            counter++;
            drawn = testDeck.lastDraw();
            if(n!=3) {
            	if(n==1) {
                	while(s.toString()!=board.getStringColor()) {

                    }
            	}
            	else {
                	while(s.toString()!=board.getStringColor()) {

                    }
                	
                	while(s.toString()==board.getStringColor()) {
                		
                	}
               
                	while(s.toString()!=board.getStringColor()) {
                		
                    }
                	
            	}

            }
            else {
            	if(type=="RUSH") {
            		board.moveMiddle(currentTurn+1);
            	}
            	else {

            	}
            }

            board.cc = "BLACK";
            board.revertCur();

            //currentTurn++;

            //System.out.println(drawn.getColor());

            //cardColor = drawn.getColor();
            //boardColor = board.curColor;


            break;
          }
        }

        drawn = null;
        //TO DO
        //Play Game

        testDeck.enableDraw();
      }
    }
}
