package com.mcteamface.worldofsweets;

public class GameModel {
  private GameBoardView mGameBoardView;
  private DeckModel mDeck;
  private Card mCurrentCard;
  private boolean mPlayerHasMoved;

  public GameModel(GameBoardView gameBoardView) {
    // Start out as true so we can draw a card.
    mPlayerHasMoved = true;
    mGameBoardView = gameBoardView;
    mDeck = new DeckModel();
    initListeners();
  }

  private void initListeners() {
    mGameBoardView.addCardDrawnListener(new GameBoardView.CardDrawnListener() {
      @Override
      public void cardDrawn() {
        if (mPlayerHasMoved) {
          mPlayerHasMoved = false;
          mCurrentCard = mDeck.dequeCard();
          if (mCurrentCard == null) {
            return;
          }
          mGameBoardView.setDiscard(mCurrentCard.getImage());
          mGameBoardView.repaint();
        }
      }
    });

    mGameBoardView.addTokenMovedListener(new GameBoardView.TokenMovedListener() {
      @Override
      public void tokenMoved() {
        mPlayerHasMoved = true;
      }
    });
  }
}
