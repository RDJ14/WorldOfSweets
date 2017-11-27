package com.mcteamface.worldofsweets;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

class GameBoardView extends JPanel {
  private static final Color[] COLOR_ORDER = new Color[] {
		Colors.RED.getColor(),
		Colors.YELLOW.getColor(),
		Colors.BLUE.getColor(),
		Colors.GREEN.getColor(),
		Colors.ORANGE.getColor()
	};

  private CardDrawnListener mCardDrawnListener;
  private TokenMovedListener mTokenMovedListener;
  private Image mImgBackground;
  private Image mImgDrawCard;
  private Image mImgDiscard;
  private ArrayList<Piece> mPieces = new ArrayList<Piece>();

  public GameBoardView() {
    setLayout(null);
    URL urlBackgroundImg = getClass().getResource("/images/game_board_layout.png");
		mImgBackground = new ImageIcon(urlBackgroundImg).getImage();

    URL urlDrawCardImg = getClass().getResource("/images/card_back.png");
		mImgDrawCard = new ImageIcon(urlDrawCardImg).getImage();

    setPreferredSize(new Dimension(mImgBackground.getWidth(null) / 2, mImgBackground.getHeight(null) / 2));

    PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
  }

  public Piece createPiece() {
    int number = mPieces.size();
    switch(number) {
      case 0:
        return addPiece(number, 70, 75);
      case 1:
        return addPiece(number, 70, 115);
      case 2:
        return addPiece(number, 110, 75);
      default:
        return addPiece(number, 110, 115);
    }
  }

  private Piece addPiece(int color, int x, int y) {
    URL urlPieceImg;
    switch(color) {
      case 0:
        urlPieceImg = getClass().getResource("/images/piece_red.png");
        break;
      case 1:
        urlPieceImg = getClass().getResource("/images/piece_green.png");
        break;
      case 2:
        urlPieceImg = getClass().getResource("/images/piece_blue.png");
        break;
      default:
        urlPieceImg = getClass().getResource("/images/piece_yellow.png");
        break;
    }
		Image img = new ImageIcon(urlPieceImg).getImage();
		Piece piece = new Piece(img, x, y);
		mPieces.add(piece);
    return piece;
	}

  public ArrayList<Piece> getPieces() {
    return mPieces;
  }

  public void cardDrawn() {
    mCardDrawnListener.cardDrawn();
  }

  public Image getDrawCard() {
    return mImgDrawCard;
  }

  public Image getDiscard() {
    return mImgDiscard;
  }

  public void setDiscard(Image image) {
    mImgDiscard = image;
  }

  public void addCardDrawnListener(CardDrawnListener listener) {
    mCardDrawnListener = listener;
  }

  public void tokenMoved(Piece piece, int x, int y) {
    mTokenMovedListener.tokenMoved(piece, x, y);
  }

  public void addTokenMovedListener(TokenMovedListener listener) {
    mTokenMovedListener = listener;
  }

  public interface CardDrawnListener {
    void cardDrawn();
  }

  public interface TokenMovedListener {
    void tokenMoved(Piece piece, int x, int y);
  }

  @Override
	protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    /**
     * The board is a grid of 100x100 pixel tiles with a top-padding of 65px and
     * a left-padding of 50px.
     */
    g.drawImage(mImgBackground, 0, 0, mImgBackground.getWidth(null) / 2, mImgBackground.getHeight(null) / 2, null);

    // The deck is located 7 tiles to the left and 4 tiles down.
    int cardWidth = mImgDrawCard.getWidth(null) / 2;
    int cardHeight = mImgDrawCard.getHeight(null) / 2;
    int paddingY = (200 - cardHeight) / 2;
    g.drawImage(mImgDrawCard, 750 + 50, 465 + paddingY, cardWidth, cardHeight, null);
    g.drawImage(mImgDiscard, 750 + cardWidth + 80, 465 + paddingY, cardWidth, cardHeight, null);
		for (Piece piece : mPieces) {
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), piece.getWidth(), piece.getHeight(), null);
		}

    // Start of timer UI.
    g.setColor(Color.black);
    g.setFont(new Font("SanSerif", Font.PLAIN, 16));
    g.drawString("Timer goes here", 900, 50);
	}
}
