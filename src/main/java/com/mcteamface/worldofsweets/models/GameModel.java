package com.mcteamface.worldofsweets;

import java.util.ArrayList;

public class GameModel {
  private GameBoardView mGameBoardView;
  private DeckModel mDeck;
  private Card mCurrentCard;
  private ArrayList<PlayerModel> mPlayers = new ArrayList<PlayerModel>();
  private boolean mPlayerHasMoved;

  public GameModel(GameBoardView gameBoardView) {
    // Start out as true so we can draw a card.
    mPlayerHasMoved = true;
    mGameBoardView = gameBoardView;
    mDeck = new DeckModel();

    PlayerModel player1 = new PlayerModel("Bob");
    player1.assignPiece(mGameBoardView.createPiece().getId());
    mPlayers.add(player1);

    PlayerModel player2 = new PlayerModel("Alice");
    player2.assignPiece(mGameBoardView.createPiece().getId());
    mPlayers.add(player2);

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
      public void tokenMoved(Piece piece, int x, int y) {
        for (PlayerModel player : mPlayers) {
          // Find the player of the piece and check if it's their turn.
          if (mCurrentCard != null
              && player.checkPiece(piece.getId())
              && player.getId().equals(mPlayers.get(0).getId())) {
            mPlayerHasMoved = true;

            // Rotate player order.
            mPlayers.remove(0);
            mPlayers.add(player);

            int newPosition = GameHelperUtil.getNext(player.getLocation(), mCurrentCard);
            mCurrentCard = null;
            
            player.setLocation(newPosition);
            piece.moveTo(player.getLocation());
            mGameBoardView.repaint();
            break;

          // It's not their turn.
          } else if (player.checkPiece(piece.getId())) {
            piece.moveTo(player.getLocation());
            mGameBoardView.repaint();
            break;
          }
        }
      }
    });
  }
}
