
package com.mcteamface.worldofsweets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;

//import javax.smartcardio.Card;

//import javax.smartcardio.Card;


public class WorldOfSweets{

    public static void main(String[] args) {


    	GameTimer gt = new GameTimer();

      Buttons numPlayersButton = new Buttons();
      int numPlayers = 0;
      boolean loadGame = false;
      while(numPlayers == 0){
        numPlayers = numPlayersButton.getNumPlayers();
        loadGame = numPlayersButton.loadGameSelect();
        if(numPlayers != 0 || loadGame){
          break;
        }
      }
      ArrayList<Player> players = new ArrayList<Player>();
      Deck testDeck = null;
      GameBoard board = null;
      if(loadGame){
            JFrame frame = new JFrame();
            testDeck = new Deck();
            testDeck.setVisible(false);
            board = loadSaveFile();
            if(board == null) {
              loadGame = false;
              JOptionPane.showMessageDialog(frame,
                  "The save file does not exist or has been corrupted. You can start a new game",
                  "Inane error",
                  JOptionPane.ERROR_MESSAGE);      
	    }
	   else if(!testDeck.load()) {
              loadGame = false;
              JOptionPane.showMessageDialog(frame,
                  "The save file does not exist or has been corrupted. You can start a new game",
                  "Inane error",
                  JOptionPane.ERROR_MESSAGE);
            }
            else if(!gt.load()){
              loadGame = false;
              JOptionPane.showMessageDialog(frame,
                  "The save file does not exist or has been corrupted. You can start a new game",
                  "Inane error",
                  JOptionPane.ERROR_MESSAGE);
            }
            if(!loadGame){
              Buttons numPlayersButton2 = new Buttons();
              numPlayersButton2.disableLoad();
              while(numPlayers == 0){
                numPlayers = numPlayersButton2.getNumPlayers();
                if(numPlayers != 0){
                  break;
                }
              }
              for(int i = 1; i <= numPlayers; i++){
                players.add(new Player(i, "", 0));
              }
              board = new GameBoard(numPlayers);
              testDeck = new Deck();
            } else testDeck.setVisible(true);
      } else{
        board = new GameBoard(numPlayers);
        testDeck = new Deck();
        for(int i = 1; i <= numPlayers; i++){
          players.add(new Player(i, "", 0));
        }
      }
      board.setVisible(true);

      gt.createAndShowGUI();
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
            		board.moveMiddle(currentTurn);
            	}
            	if(type=="LICORICE") {
            		System.out.println("Licorice");
            		board.specialSquare(type, currentTurn);
            	}
            	if(type=="COOKIE") {
            		System.out.println("cookie");
            		board.specialSquare(type, currentTurn);
            	}
            	if(type=="ICECREAM") {
            		System.out.println("icecream");
            		board.specialSquare(type, currentTurn);
            	}
            	if(type=="CHOCOLATE") {
            		System.out.println("chocolate");
            		board.specialSquare(type, currentTurn);
            	}
            	if(type=="MINT") {
            		board.specialSquare(type, currentTurn);
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

    public static GameBoard loadSaveFile() {
    BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader("gameboard.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;
			sCurrentLine = br.readLine();
			int numPlayers = Integer.parseInt(sCurrentLine);
			int[] positions = new int[numPlayers];
			for(int i = 0; i<numPlayers;i++) {
				sCurrentLine = br.readLine();
				positions[i] = Integer.parseInt(sCurrentLine);
			}
			int[] specialSquares = new int[5];
			for(int i =0;i<5;i++) {
				sCurrentLine = br.readLine();
				specialSquares[i] = Integer.parseInt(sCurrentLine);
			}
			br.close();
			fr.close();
      if(numPlayers == 0) return null;
      if(numPlayers > 4) return null;
      if(numPlayers < 2) return null;
			return new GameBoard(numPlayers, specialSquares, positions);
		} catch (IOException e) {

			return null;

		}
    }
}
