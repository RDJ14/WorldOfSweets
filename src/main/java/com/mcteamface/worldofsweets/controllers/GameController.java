package com.mcteamface.worldofsweets;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.text.SimpleDateFormat;

public class GameController implements Serializable {
  // We don't need a serialized gameboard so we mark it transient.
  private transient GameBoardView mGameBoardView;
  private transient Timer mTimer;
  private DeckModel mDeck;
  private boolean mAboutToRang;
  private long mLastClockedTime;
  private long mElapsedTime;
  private Card mCurrentCard;
  private Card mLastDrawCard; // For reloading class.
  private ArrayList<PlayerModel> mInitialLineup = new ArrayList<PlayerModel>();
  private ArrayList<PlayerModel> mPlayers = new ArrayList<PlayerModel>();
  private boolean mPlayerHasMoved;
  private boolean mStrategic;

  public GameController(GameBoardView gameBoardView, ArrayList<PlayerModel> players, boolean strategic) {
    mAboutToRang = false;
    mStrategic = strategic;

    mLastClockedTime = System.currentTimeMillis() / 1000;
    // Start out as true so we can draw a card.
    mPlayerHasMoved = true;
    mGameBoardView = gameBoardView;
    mDeck = new DeckModel();

    for (PlayerModel player : players) {
      Piece piece = mGameBoardView.createPiece();
      piece.setEnabled(false);
      player.assignPiece(piece.getId());
      if (strategic) {
        player.setBoomerangs(3);
      }
      mPlayers.add(player);
      mInitialLineup.add(player);
    }

    mGameBoardView.isStrategic(mStrategic);

    // Draw time of zero, because it will take a second for the first time to be
    // rendered.
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    mGameBoardView.setRightLabel("Time: " + sdf.format(0));
    mGameBoardView.repaint();

    initListeners();
  }

  private void addGameBoard(GameBoardView gameBoardView) {
    mLastClockedTime = System.currentTimeMillis() / 1000;

    mGameBoardView = gameBoardView;

    for (PlayerModel player : mInitialLineup) {
      Piece piece = mGameBoardView.createPiece();
      piece.setEnabled(mPlayers.get(0).getId().equals(player.getId()) && !mPlayerHasMoved);
      player.assignPiece(piece.getId());
      piece.moveTo(player.getLocation());
    }

    // On the first move if nobody draws a card and they close and load the game
    // last drawn card will be null.
    if (mLastDrawCard != null) {
      mGameBoardView.setDiscard(mLastDrawCard.getImage());
    }

    mGameBoardView.isStrategic(mStrategic);

    // Draw elapsed time, because it will take a second for the first time to be
    // rendered.
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    mGameBoardView.setRightLabel("Time: " + sdf.format(mElapsedTime * 1000));

    mGameBoardView.repaint();
    initListeners();
  }

  public static GameController load(GameBoardView gameBoardView) {
    try {
      FileInputStream fileIn = new FileInputStream("/tmp/game.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      GameController gameController = (GameController) in.readObject();
      in.close();
      fileIn.close();

      gameController.addGameBoard(gameBoardView);

      return gameController;
    } catch (IOException i) {
      i.printStackTrace();
      return null;
    } catch (ClassNotFoundException c) {
      System.out.println("GameController class not found");
      c.printStackTrace();
      return null;
    }
  }

  public void serialize() {
    try {
      FileOutputStream fileOut = new FileOutputStream("/tmp/game.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(this);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  private void drawCard() {
    mPlayerHasMoved = false;
    mCurrentCard = mDeck.dequeCard();
    mLastDrawCard = mCurrentCard;
    if (mCurrentCard == null) {
      return;
    }

    enableCurrentPiece();

    mGameBoardView.animateDiscard(mCurrentCard.getImage());
  }

  public void enableCurrentPiece() {
    for (Piece piece : mGameBoardView.getPieces()) {
      if (mPlayers.get(0).checkPiece(piece.getId())) {
        piece.setEnabled(true);
        mGameBoardView.repaint();
        break;
      }
    }
  }

  public void enableAllButCurrentPiece() {
    for (Piece piece : mGameBoardView.getPieces()) {
      if (mPlayers.get(0).checkPiece(piece.getId())) {
        piece.setEnabled(false);
      } else {
        piece.setEnabled(true);
      }
    }
    mGameBoardView.repaint();
  }

  public void disableAllPieces() {
    for (Piece piece : mGameBoardView.getPieces()) {
      piece.setEnabled(false);
    }
    mGameBoardView.repaint();
  }

  private void makeMove(Piece piece) {
    mPlayerHasMoved = true;

    // Rotate player order.
    PlayerModel player = mPlayers.remove(0);
    mPlayers.add(player);

    int newPosition = GameHelperUtil.getNext(player.getLocation(), mCurrentCard);
    mCurrentCard = null;

    player.setLocation(newPosition);
    if (piece != null) {
      piece.moveTo(player.getLocation());
    }
    mGameBoardView.repaint();

    disableAllPieces();

    if (newPosition == GameHelperUtil.getBoardLength() - 1) {
      JOptionPane.showMessageDialog(
        null,
        player.getName() + " wins!",
        "World of Sweets",
        JOptionPane.PLAIN_MESSAGE
      );
      System.exit(0);
    }

    PlayerModel nextPlayer = mPlayers.get(0);
    JOptionPane.showMessageDialog(
      null,
      "It's " + nextPlayer.getName() + "'s turn!",
      "World of Sweets",
      JOptionPane.PLAIN_MESSAGE
    );

    if (mPlayers.get(0).isAI()) {
      drawCard();
      // We might want to just add the piece to the player instead of an id.
      for (Piece nextPiece : mGameBoardView.getPieces()) {
        if (nextPlayer.checkPiece(nextPiece.getId())) {
          makeMove(nextPiece);
          break;
        }
      }
    }
  }

  private void initListeners() {
    mTimer = new Timer(1000, new ActionListener() {
      @Override
    	public void actionPerformed(ActionEvent e) {
    		long now = System.currentTimeMillis() / 1000;
    		mElapsedTime += now - mLastClockedTime;
        mLastClockedTime = now;
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        mGameBoardView.setRightLabel("Time: " + sdf.format(mElapsedTime * 1000));
        mGameBoardView.repaint();
    	}
    });
    mTimer.start();

    mGameBoardView.addCardDrawnListener(new GameBoardView.CardDrawnListener() {
      @Override
      public void cardDrawn() {
        if (mPlayerHasMoved) {
          drawCard();

          // If it's a skip card tokenMoved() will never be called.
          if (mCurrentCard == Card.SKIP) {
            // We don't really have a piece that needs to move, so pass null.
            makeMove(null);
          }
        }
      }
    });

    mGameBoardView.addBoomerangUsedListener(new GameBoardView.BoomerangUsedListener() {
      @Override
      public void boomerangUsed() {
        if (mPlayerHasMoved && mPlayers.get(0).hasBoomerang() && !mAboutToRang) {
          mPlayers.get(0).useBoomerang();
          mAboutToRang = true;
          JOptionPane.showMessageDialog(
            null,
            "Boomerang activated!\nClick on a player to move them back.",
            "World of Sweets",
            JOptionPane.PLAIN_MESSAGE
          );
          enableAllButCurrentPiece();
        }
      }
    });

    mGameBoardView.addTokenMovedListener(new GameBoardView.TokenMovedListener() {
      @Override
      public void tokenMoved(Piece piece, int x, int y) {
        // If 'aboutToRang' is true, we are clicking on a player to move back.
        if (mAboutToRang) {
          for (PlayerModel boomerangedPlayer : mPlayers) {
            // Find the player of the piece and make sure they aren't boomeranging themselves.
            if (boomerangedPlayer.checkPiece(piece.getId()) && !boomerangedPlayer.getId().equals(mPlayers.get(0).getId())) {
              mAboutToRang = false;
              // Rotate player order.
              PlayerModel player = mPlayers.remove(0);
              mPlayers.add(player);

              drawCard();
              int newPosition = GameHelperUtil.getPrevious(boomerangedPlayer.getLocation(), mCurrentCard);
              mCurrentCard = null;
              boomerangedPlayer.setLocation(newPosition);
              piece.moveTo(boomerangedPlayer.getLocation());
              mGameBoardView.repaint();

              // A boomerang counts as a move.
              mPlayerHasMoved = true;

              disableAllPieces();

              JOptionPane.showMessageDialog(
                null,
                "It's " + mPlayers.get(0).getName() + "'s turn!",
                "World of Sweets",
                JOptionPane.PLAIN_MESSAGE
              );
            }
          }
        }

        for (PlayerModel player : mPlayers) {
          // Find the player of the piece and check if it's their turn.
          if (
            mCurrentCard != null
            && player.checkPiece(piece.getId())
            && player.getId().equals(mPlayers.get(0).getId())
          ) {
            makeMove(piece);
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

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        serialize();
      }
    });
  }
}
