package com.mcteamface.worldofsweets;

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

public class Deck extends JPanel {

  static final int NUMBER_COLORS = 5;
  static final int COLOR_SINGLE = 10;
  static final int COLOR_DOUBLE = 2;
  static final int SPECIAL_CARDS = 2;
  static final int DECK_SIZE = ((COLOR_SINGLE + COLOR_DOUBLE) * NUMBER_COLORS) + SPECIAL_CARDS;

  ArrayList<Card> deck;
  protected int cardToDraw;
  JPanel cardPanel;
  JPanel emptyPanel;
  volatile Card lastDrawnCard;
  protected JButton cardButton;
  protected JButton emptyDeck;
  volatile boolean hasDrawn;

  public Deck() {
    deck = new ArrayList<Card>();
    cardToDraw = 0;
    hasDrawn = false;
    //create single cards
    for (int i = 0; i < COLOR_SINGLE; i++) {
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
    for (int i = 0; i < COLOR_DOUBLE; i++) {
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

    Card sugarRush = new Card(SpecialType.RUSH);
    Card swap = new Card(SpecialType.SWAP);

    deck.add(sugarRush);
    deck.add(swap);

    //initial shuffle
    Collections.shuffle(deck);
    BufferedImage cardBack;
    cardButton = new JButton();
    cardButton.setIcon(new ImageIcon(getClass().getResource("/images/Card-back.jpg")));
    cardButton.setBorder(BorderFactory.createEmptyBorder());
    cardButton.setContentAreaFilled(false);
    cardButton.addActionListener(new drawAction());
    JLabel drawText = new JLabel("Click the candy to draw a card!");

    cardPanel = new JPanel(new BorderLayout());
    cardPanel.add(cardButton, BorderLayout.CENTER);
    cardPanel.add(drawText, BorderLayout.SOUTH);

    emptyPanel = new JPanel(new BorderLayout());

    emptyDeck = new JButton("Click here to shuffle!");
    emptyDeck.addActionListener(new emptyDeckAction());
    JLabel emptyMessage = new JLabel("All cards have been drawn!");

    emptyPanel.add(emptyDeck, BorderLayout.CENTER);
    emptyPanel.add(emptyMessage, BorderLayout.SOUTH);

    add(cardPanel);
  }

  protected void shuffle() {
    cardToDraw = 0;
    Collections.shuffle(this.deck);
  }

  public Card lastDraw() {
    return lastDrawnCard;
  }

  public void disableDraw() {
    lastDrawnCard = null;
    cardButton.setEnabled(false);
  }

  public void enableDraw() {
    hasDrawn = false;
    cardButton.setEnabled(true);
  }

  public void simulateDraw() {
    cardButton.doClick();
  }

  public boolean hasDrawn() {
    return hasDrawn;
  }

  public void setHasDrawn(boolean flag) {
    this.hasDrawn = flag;
  }

  protected class drawAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      if (cardToDraw < DECK_SIZE) {
        if (cardToDraw > 0) {
          Card cardToDiscard = deck.get(cardToDraw - 1);
          cardToDiscard.discard();
        }
        Card drawCard = deck.get(cardToDraw);
        lastDrawnCard = drawCard;
        drawCard.draw();
        cardToDraw++;
        hasDrawn = true;
        if (cardToDraw == DECK_SIZE) {
          // getContentPane().removeAll();
          add(emptyPanel);
        }
      } else {
        // getContentPane().removeAll();
        add(emptyPanel);
      }
    }
  }

  private class emptyDeckAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("SHUFFLING");
      Card discardLastCard = deck.get(cardToDraw - 1);
      discardLastCard.discard();
      Collections.shuffle(deck);
      cardToDraw = 0;
      // getContentPane().removeAll();
      add(cardPanel);
    }
  }
}
