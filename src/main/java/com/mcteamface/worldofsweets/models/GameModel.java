package com.mcteamface.worldofsweets;

import java.util.ArrayList;

public class GameModel {
  private GameBoardView mGameBoardView;
  private DeckModel mDeck;
  private Card mCurrentCard;
  private PlayerModel mCurrentPlayer;
  private ArrayList<PlayerModel> mPlayers = new ArrayList<PlayerModel>();
  private boolean mPlayerHasMoved;

  public GameModel(GameBoardView gameBoardView) {
    // Start out as true so we can draw a card.
    mPlayerHasMoved = true;
    mGameBoardView = gameBoardView;
    mDeck = new DeckModel();

    PlayerModel player1 = new PlayerModel("Bob");
    player1.assignPiece(mGameBoardView.createPiece().getId());
    mCurrentPlayer = player1;
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
          if (player.checkPiece(piece.getId()) && player.getId().equals(mCurrentPlayer.getId())) {
            mPlayerHasMoved = true;
            player.setLocation(player.getLocation() + 1);
            piece.moveTo(player.getLocation());
            mGameBoardView.repaint();
          } else if (player.checkPiece(piece.getId())) {
            piece.moveTo(player.getLocation());
            mGameBoardView.repaint();
          }
        }
      }
    });
  }
}
