package com.mcteamface.worldofsweets;

//FOR UI ELEMENTS
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.lang.Enum;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.*;
import javax.imageio.*;
import java.io.File;
import java.net.URL;

//FOR SAVING DECK
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Deck{

  static final int NUMBER_COLORS = 5;
  static final int COLOR_SINGLE = 10;
  static final int COLOR_DOUBLE = 2;
  static final int SPECIAL_CARDS = 8;
  static final int DECK_SIZE = ((COLOR_SINGLE + COLOR_DOUBLE) * NUMBER_COLORS) + SPECIAL_CARDS;

  ArrayList<Card> deck;
  JFrame display;
  protected int cardToDraw;
  JPanel cardPanel;
  JPanel emptyPanel;
  volatile Card lastDrawnCard;
  protected JButton cardButton;
  protected JButton emptyDeck;
  volatile boolean hasDrawn;

  public Deck(){
    deck = new ArrayList<Card>();
    display = new JFrame();
    cardToDraw = 0;
    hasDrawn = false;
    //create single cards
    for(int i = 0; i < COLOR_SINGLE; i++)
    {
      Card blueCard = new Card(true, Color.BLUE);
      Card greenCard =  new Card(true, Color.GREEN);
      Card redCard = new Card(true, Color.RED);
      Card orangeCard = new Card(true, Color.ORANGE);
      Card yellowCard = new Card(true, Color.YELLOW);

      deck.add(blueCard);
      deck.add(greenCard);
      deck.add(redCard);
      deck.add(orangeCard);
      deck.add(yellowCard);
    }

    //create double cards
    for(int i = 0; i < COLOR_DOUBLE; i++)
    {
      Card blueCard = new Card(false, Color.BLUE);
      Card greenCard = new Card(false, Color.GREEN);
      Card redCard = new Card(false, Color.RED);
      Card orangeCard = new Card(false, Color.ORANGE);
      Card yellowCard = new Card(false, Color.YELLOW);

      deck.add(blueCard);
      deck.add(greenCard);
      deck.add(redCard);
      deck.add(orangeCard);
      deck.add(yellowCard);
    }

    Card licorice = new Card(SpecialType.LICORICE);
    Card ice_cream = new Card(SpecialType.ICECREAM);
    Card cookie = new Card(SpecialType.COOKIE);
    Card chocolate = new Card(SpecialType.CHOCOLATE);
    Card mint = new Card(SpecialType.MINT);
    deck.add(licorice);
    deck.add(ice_cream);
    deck.add(cookie);
    deck.add(chocolate);
    deck.add(mint);

    Card skip = new Card(SpecialType.SKIP);
    for(int i = 0; i < 5; i++) deck.add(skip);

    //initial shuffle
    Collections.shuffle(deck);
    BufferedImage cardBack;
    try{
      URL cardBackLoc = Deck.class.getClassLoader().getResource("images/Card-back.jpg");
      //cardBack = ImageIO.read(new File("images/Card-back.jpg"));
      cardBack = ImageIO.read(cardBackLoc);
      cardButton = new JButton();
      cardButton.setIcon(new ImageIcon(cardBack));
      cardButton.setBorder(BorderFactory.createEmptyBorder());
      cardButton.setContentAreaFilled(false);
      cardButton.addActionListener(new drawAction());
      JLabel drawText = new JLabel("Click the candy to draw a card!");

      cardPanel= new JPanel(new BorderLayout());
      cardPanel.add(cardButton, BorderLayout.CENTER);
      cardPanel.add(drawText, BorderLayout.SOUTH);

      emptyPanel = new JPanel(new BorderLayout());

      emptyDeck = new JButton("Click here to shuffle!");
      emptyDeck.addActionListener(new emptyDeckAction());
      JLabel emptyMessage = new JLabel("All cards have been drawn!");

      emptyPanel.add(emptyDeck, BorderLayout.CENTER);
      emptyPanel.add(emptyMessage, BorderLayout.SOUTH);


      display.add(cardPanel);
      display.pack();
      display.setVisible(true);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

  protected void shuffle(){
    cardToDraw = 0;
    Collections.shuffle(this.deck);
  }

  public Card lastDraw(){
    return lastDrawnCard;
  }

  public void disableDraw(){
    lastDrawnCard = null;
    cardButton.setEnabled(false);
  }

  public void enableDraw(){
    hasDrawn = false;
    cardButton.setEnabled(true);
  }

  public void simulateDraw(){
      cardButton.doClick();
    }

  public boolean hasDrawn(){
    return hasDrawn;
  }
  public void setHasDrawn(boolean flag)
  {
    this.hasDrawn = flag;
  }

  public void dispose(){
    display.dispose();
  }

  public boolean save(){

  }
  protected class drawAction implements ActionListener{

    public void actionPerformed(ActionEvent e){
      if(cardToDraw < DECK_SIZE) {
        if(cardToDraw > 0)
        {
          Card cardToDiscard = deck.get(cardToDraw - 1);
          cardToDiscard.discard();
        }
        Card drawCard = deck.get(cardToDraw);
        lastDrawnCard = drawCard;
        drawCard.draw();
        cardToDraw++;
        hasDrawn = true;
        if(cardToDraw == DECK_SIZE)
        {
          display.getContentPane().removeAll();
          display.add(emptyPanel);
          display.pack();
          display.setVisible(true);
        }
      }
      else {
        display.getContentPane().removeAll();
        display.add(emptyPanel);
        display.pack();
        display.setVisible(true);
      }
    }


  }

  private class emptyDeckAction implements ActionListener{

    public void actionPerformed(ActionEvent e){
      System.out.println("SHUFFLING");
      Card discardLastCard = deck.get(cardToDraw - 1);
      discardLastCard.discard();
      Collections.shuffle(deck);
      cardToDraw = 0;
      display.getContentPane().removeAll();
      display.add(cardPanel);
      display.pack();
      display.setVisible(true);
    }

  }
}
