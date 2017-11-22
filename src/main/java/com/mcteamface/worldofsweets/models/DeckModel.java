package com.mcteamface.worldofsweets;

import javax.swing.ImageIcon;
import java.net.URL;

public class DeckModel {
  GameBoardView mGameBoardView;

  public DeckModel(GameBoardView gameBoardView) {
    mGameBoardView = gameBoardView;
    initListeners();
  }

  private void initListeners() {
    mGameBoardView.addCardDrawnListener(new GameBoardView.CardDrawnListener() {
      @Override
      public void cardDrawn() {
        URL urlDiscardImg = getClass().getResource("/images/card_special_lollipop.png");
        mGameBoardView.setDiscard(new ImageIcon(urlDiscardImg).getImage());
        mGameBoardView.repaint();
      }
    });
  }
}
