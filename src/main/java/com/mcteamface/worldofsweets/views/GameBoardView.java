package com.mcteamface.worldofsweets;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

class GameBoardView extends JPanel {
  private static final Color[] COLOR_ORDER = new Color[] {
		Colors.RED.getColor(),
		Colors.YELLOW.getColor(),
		Colors.BLUE.getColor(),
		Colors.GREEN.getColor(),
		Colors.ORANGE.getColor()
	};

  private CardDrawnListener mCardDrawnListener;
  private Image mImgBackground;
  private Image mImgDrawCard;
  private Image mImgDiscard;
  private List<Piece> mPieces = new ArrayList<Piece>();

  public GameBoardView() {
    setLayout(null);
    URL urlBackgroundImg = getClass().getResource("/images/game_board_layout.png");
		mImgBackground = new ImageIcon(urlBackgroundImg).getImage();

    URL urlDrawCardImg = getClass().getResource("/images/card_back.png");
		mImgDrawCard = new ImageIcon(urlDrawCardImg).getImage();

    URL urlDiscardImg = getClass().getResource("/images/card_special_cordial.png");
		mImgDiscard = new ImageIcon(urlDiscardImg).getImage();

    setPreferredSize(new Dimension(mImgBackground.getWidth(null) / 2, mImgBackground.getHeight(null) / 2));

    addPiece(0, 70, 75);
    addPiece(1, 70, 115);
    addPiece(2, 110, 75);
    addPiece(3, 110, 115);

    PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
  }

  private void addPiece(int color, int x, int y) {
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
	}

  public List<Piece> getPieces() {
    return mPieces;
  }

  public void drawCard() {
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

  public interface CardDrawnListener {
    void cardDrawn();
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
		for (Piece piece: mPieces) {
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), piece.getWidth(), piece.getHeight(), null);
		}
	}
}
