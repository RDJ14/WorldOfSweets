package com.mcteamface.worldofsweets;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import java.net.URL;
import javax.swing.ImageIcon;

public class PiecesDragAndDropListener implements MouseListener, MouseMotionListener {
  private GameBoardView mGameBoard;
  private Piece dragPiece;
  private int dragOffsetX;
  private int dragOffsetY;

  public PiecesDragAndDropListener(GameBoardView gameBoard) {
    mGameBoard = gameBoard;
  }

  @Override
  public void mousePressed(MouseEvent evt) {
    int x = evt.getPoint().x;
    int y = evt.getPoint().y;

    int cardWidth = mGameBoard.getDrawCard().getWidth(null) / 2;
    int cardHeight = mGameBoard.getDrawCard().getHeight(null) / 2;
    int paddingY = (200 - cardHeight) / 2;
    if (750 + 50 <= x && 750 + 50 + cardWidth >= x && 465 + paddingY <= y && 465 + paddingY + cardHeight >= y) {
      mGameBoard.cardDrawn();
    }

    if (150 <= x && 300 + 150 >= x && 0 <= y && 65 >= y) {
      mGameBoard.boomerangUsed();
    }

    // Find out which piece to move.
    for (Piece piece : mGameBoard.getPieces()) {
      if (mouseOverPiece(piece, x, y)) {
        // Calculate offset, because we do not want the drag piece to jump with
        // it's upper left corner to the current mouse position.
        this.dragOffsetX = x - piece.getX();
        this.dragOffsetY = y - piece.getY();
        this.dragPiece = piece;
        break;
      }
    }
  }

  /**
  * check whether the mouse is currently over this piece
  * @param piece the playing piece
  * @param x x coordinate of mouse
  * @param y y coordinate of mouse
  * @return true if mouse is over the piece
  */
  private boolean mouseOverPiece(Piece piece, int x, int y) {
    // Our pieces are circles. We should change this to not allow corner clicks.
    return piece.getX() <= x
      && piece.getX() + piece.getWidth() >= x
      && piece.getY() <= y
      && piece.getY() + piece.getHeight() >= y;
  }

  @Override
  public void mouseReleased(MouseEvent evt) {
    int x = evt.getPoint().x;
    int y = evt.getPoint().y;
    if (this.dragPiece != null) {
      mGameBoard.tokenMoved(this.dragPiece, x, y);
    }
    this.dragPiece = null;
  }

  @Override
  public void mouseDragged(MouseEvent evt) {
    if (this.dragPiece != null) {
      this.dragPiece.setX(evt.getPoint().x - this.dragOffsetX);
      this.dragPiece.setY(evt.getPoint().y - this.dragOffsetY);
      mGameBoard.repaint();
    }
  }

  @Override
  public void mouseClicked(MouseEvent evt) {
    // Ideally I would draw a card here, however if you move the mouse it
    // doesn't fire reliably.
  }

  @Override
  public void mouseEntered(MouseEvent evt) {}

  @Override
  public void mouseExited(MouseEvent evt) {}

  @Override
  public void mouseMoved(MouseEvent evt) {}
}
