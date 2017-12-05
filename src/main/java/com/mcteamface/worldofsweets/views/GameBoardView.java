package com.mcteamface.worldofsweets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import java.awt.AlphaComposite;

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
  private BoomerangUsedListener mBoomerangUsedListener;
  private Image mImgBackground;
  private Image mImgDrawCard;
  private Image mImgDiscard;
  private Image mImgBoomerang;
  private Image mImgBoomerangUsed;
  private String mRightLabel = "";
  private ArrayList<Piece> mPieces = new ArrayList<Piece>();
  private int mBoomerangs;
  private boolean mStrategic;

  public GameBoardView() {
    setLayout(null);
    URL urlBackgroundImg = getClass().getResource("/images/game_board_layout.png");
		mImgBackground = new ImageIcon(urlBackgroundImg).getImage();

    URL urlDrawCardImg = getClass().getResource("/images/card_back.png");
		mImgDrawCard = new ImageIcon(urlDrawCardImg).getImage();

    URL urlBoomerangImg = getClass().getResource("/images/boomerang.png");
		mImgBoomerang = new ImageIcon(urlBoomerangImg).getImage();

    URL urlBoomerangUsedImg = getClass().getResource("/images/boomerang_used.png");
		mImgBoomerangUsed = new ImageIcon(urlBoomerangUsedImg).getImage();

    mBoomerangs = 3;

    setPreferredSize(new Dimension(mImgBackground.getWidth(null) / 2, mImgBackground.getHeight(null) / 2));

    PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
  }

  public void setBoomerangs(int boomerangs) {
    mBoomerangs = boomerangs;
  }

  public void isStrategic(boolean strategic) {
    mStrategic = strategic;
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

  public Image getDrawCard() {
    return mImgDrawCard;
  }

  public Image getDiscard() {
    return mImgDiscard;
  }

  public void setDiscard(Image image) {
    mImgDiscard = image;
  }

  public void setRightLabel(String rightLabel) {
    mRightLabel = rightLabel;
  }

  public void cardDrawn() {
    mCardDrawnListener.cardDrawn();
  }

  public void boomerangUsed() {
    mBoomerangUsedListener.boomerangUsed();
  }

  public void tokenMoved(Piece piece, int x, int y) {
    mTokenMovedListener.tokenMoved(piece, x, y);
  }

  public void addCardDrawnListener(CardDrawnListener listener) {
    mCardDrawnListener = listener;
  }

  public void addBoomerangUsedListener(BoomerangUsedListener listener) {
    mBoomerangUsedListener = listener;
  }

  public void addTokenMovedListener(TokenMovedListener listener) {
    mTokenMovedListener = listener;
  }

  public interface CardDrawnListener {
    void cardDrawn();
  }

  public interface BoomerangUsedListener {
    void boomerangUsed();
  }

  public interface TokenMovedListener {
    void tokenMoved(Piece piece, int x, int y);
  }

  private int mRot = 0;
  private Image mTmpImgDiscard;
  public void animateDiscard(Image image) {
    mTmpImgDiscard = image;
    int fullRotation = 180;
    int animationStep = 3; // ms
    int animationDuration = 150; // ms
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Timer(animationStep, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (mRot < fullRotation) {
              mRot += ((float) animationStep / (float) animationDuration) * fullRotation;
            } else {
              mRot = 0;
              mImgDiscard = image;
              ((Timer) e.getSource()).stop();
            }
            repaint();
          }
        }).start();
      }
    });
  }

  @Override
	protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(
      RenderingHints.KEY_INTERPOLATION,
      RenderingHints.VALUE_INTERPOLATION_BILINEAR
    );

    g2.setRenderingHint(
      RenderingHints.KEY_TEXT_ANTIALIASING,
      RenderingHints.VALUE_TEXT_ANTIALIAS_ON
    );

    /**
     * The board is a grid of 100x100 pixel tiles with a top-padding of 65px and
     * a left-padding of 50px.
     */
    int windowWidth = mImgBackground.getWidth(null) / 2;
    g.drawImage(mImgBackground, 0, 0, windowWidth, mImgBackground.getHeight(null) / 2, null);

    // The deck is located 7 tiles to the left and 4 tiles down.
    int cardWidth = mImgDrawCard.getWidth(null) / 2;
    int cardHeight = mImgDrawCard.getHeight(null) / 2;
    int paddingY = (200 - cardHeight) / 2;
    g.drawImage(mImgDrawCard, 750 + 50, 465 + paddingY, cardWidth, cardHeight, null);
    g.drawImage(mImgDiscard, 750 + cardWidth + 80, 465 + paddingY, cardWidth, cardHeight, null);

    // Boomerangs
    if (mStrategic) {
      if (mBoomerangs >= 1) {
        g.drawImage(mImgBoomerang, 150, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      } else {
        g.drawImage(mImgBoomerangUsed, 150, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      }

      if (mBoomerangs >= 2) {
        g.drawImage(mImgBoomerang, 200, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      } else {
        g.drawImage(mImgBoomerangUsed, 200, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      }

      if (mBoomerangs >= 3) {
        g.drawImage(mImgBoomerang, 250, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      } else {
        g.drawImage(mImgBoomerangUsed, 250, 0, mImgBoomerang.getWidth(null) / 2, mImgBoomerang.getHeight(null) / 2, null);
      }
    }

    if (mRot > 0 && mRot <= 90) {
      int newWidth = (int) (((double) cardWidth) * Math.cos(Math.toRadians(mRot)));
      double radius = (30 + (2 * cardWidth)) / 2;
      int offSet = (int) (radius - radius * Math.cos(Math.toRadians(mRot)));

      g.drawImage(mImgDrawCard, 750 + 50 + offSet, 465 + paddingY, newWidth, cardHeight, null);
    } else if (mRot > 90 && mRot < 180) {
      int newWidth = -1 * (int) (((double) cardWidth) * Math.cos(Math.toRadians(mRot)));
      double radius = 15;
      int offSet = -1 * (int) (radius * Math.cos(Math.toRadians(mRot)));
      int outRadius = (30 + (2 * cardWidth)) / 2;
      g.drawImage(mTmpImgDiscard, 750 + 50 + outRadius + offSet, 465 + paddingY, newWidth, cardHeight, null);
    }

    AlphaComposite transparent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
    AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
		for (Piece piece : mPieces) {
      if (!piece.isEnabled()) {
        g2.setComposite(transparent);
      }
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), piece.getWidth(), piece.getHeight(), null);
      g2.setComposite(opaque);
		}

    // Start of timer UI.
    g.setColor(new Color(82, 82, 82));
    Font font = new Font("SanSerif", Font.PLAIN, 16);
    g.setFont(font);
    FontMetrics fm = g.getFontMetrics(font);
    int labelWidth = fm.stringWidth(mRightLabel);
    int labelHeight = fm.getHeight();
    // 38 is the right board padding.
    // 65 is the top board padding, I should make these things constants.
    g.drawString(mRightLabel, (windowWidth - labelWidth) - 38, (65 - labelHeight) / 2 + fm.getAscent());
	}
}
