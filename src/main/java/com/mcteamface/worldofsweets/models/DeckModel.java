package com.mcteamface.worldofsweets;

import java.util.ArrayList;
import java.util.Collections;

public class DeckModel {
  public static final int NUM_SINGLE = 10;
  public static final int NUM_DOUBLE = 2;
  public static final int NUM_SPECIAL = 1;

  private ArrayList<Card> mCards = new ArrayList<Card>();

  public DeckModel() {
    initDeck();
  }

  private void initDeck() {
    for (int i = 0; i < NUM_SINGLE; i++) {
      mCards.add(Card.RED);
      mCards.add(Card.YELLOW);
      mCards.add(Card.BLUE);
      mCards.add(Card.GREEN);
      mCards.add(Card.ORANGE);
    }

    for (int i = 0; i < NUM_DOUBLE; i++) {
      mCards.add(Card.DOUBLE_RED);
      mCards.add(Card.DOUBLE_YELLOW);
      mCards.add(Card.DOUBLE_BLUE);
      mCards.add(Card.DOUBLE_GREEN);
      mCards.add(Card.DOUBLE_ORANGE);
    }

    for (int i = 0; i < NUM_SPECIAL; i++) {
      mCards.add(Card.SPECIAL_LOLLIPOP);
      mCards.add(Card.SPECIAL_CORDIAL);
      mCards.add(Card.SPECIAL_CANDY_CANE);
      mCards.add(Card.SPECIAL_GUM_DROP);
      mCards.add(Card.SPECIAL_NOUGAT);
    }

    Collections.shuffle(mCards);
  }

  public Card dequeCard() {
    return mCards.remove(0);
  }
}
