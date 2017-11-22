package com.mcteamface.worldofsweets;

import javax.swing.ImageIcon;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class DeckModel {
  public static final int NUM_SINGLE = 10;
  public static final int NUM_DOUBLE = 2;
  public static final int NUM_SPECIAL = 1;

  private GameBoardView mGameBoardView;
  private ArrayList<Cards> mCards = new ArrayList<Cards>();

  public DeckModel(GameBoardView gameBoardView) {
    mGameBoardView = gameBoardView;
    initDeck();
    initListeners();
  }

  private void initDeck() {
    for (int i = 0; i < NUM_SINGLE; i++) {
      mCards.add(Cards.RED);
      mCards.add(Cards.YELLOW);
      mCards.add(Cards.BLUE);
      mCards.add(Cards.GREEN);
      mCards.add(Cards.ORANGE);
    }

    for (int i = 0; i < NUM_DOUBLE; i++) {
      mCards.add(Cards.DOUBLE_RED);
      mCards.add(Cards.DOUBLE_YELLOW);
      mCards.add(Cards.DOUBLE_BLUE);
      mCards.add(Cards.DOUBLE_GREEN);
      mCards.add(Cards.DOUBLE_ORANGE);
    }

    for (int i = 0; i < NUM_SPECIAL; i++) {
      mCards.add(Cards.SPECIAL_LOLLIPOP);
      mCards.add(Cards.SPECIAL_CORDIAL);
      mCards.add(Cards.SPECIAL_CANDY_CANE);
      mCards.add(Cards.SPECIAL_GUM_DROP);
      mCards.add(Cards.SPECIAL_NOUGAT);
    }

    Collections.shuffle(mCards);
  }

  private void initListeners() {
    mGameBoardView.addCardDrawnListener(new GameBoardView.CardDrawnListener() {
      @Override
      public void cardDrawn() {
        mGameBoardView.setDiscard(mCards.remove(0).getImage());
        mGameBoardView.repaint();
      }
    });
  }
}
