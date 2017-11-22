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

    // find out which piece to move.
    // we check the list from top to buttom
    // (therefore we itereate in reverse order)
    for (int i = mGameBoard.getPieces().size() - 1; i >= 0; i--) {
      Piece piece = mGameBoard.getPieces().get(i);

      if (mouseOverPiece(piece, x, y)) {
        // calculate offset, because we do not want the drag piece
        // to jump with it's upper left corner to the current mouse
        // position
        this.dragOffsetX = x - piece.getX();
        this.dragOffsetY = y - piece.getY();
        this.dragPiece = piece;
        break;
      }
    }

    // move drag piece to the top of the list
    if (this.dragPiece != null) {
      mGameBoard.getPieces().remove(this.dragPiece);
      mGameBoard.getPieces().add(this.dragPiece);
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
  public void mouseReleased(MouseEvent arg0) {
    if (this.dragPiece != null) {
      mGameBoard.tokenMoved();
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
    int x = evt.getPoint().x;
    int y = evt.getPoint().y;

    int cardWidth = mGameBoard.getDrawCard().getWidth(null) / 2;
    int cardHeight = mGameBoard.getDrawCard().getHeight(null) / 2;
    int paddingY = (200 - cardHeight) / 2;
    if (750 + 50 <= x && 750 + 50 + cardWidth >= x && 465 + paddingY <= y && 465 + paddingY + cardHeight >= y) {
      mGameBoard.cardDrawn();
    }
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {}

  @Override
  public void mouseExited(MouseEvent arg0) {}

  @Override
  public void mouseMoved(MouseEvent arg0) {}
}