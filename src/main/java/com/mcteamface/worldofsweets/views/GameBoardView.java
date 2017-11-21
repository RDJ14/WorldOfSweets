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

  private Image mImgBackground;
  private List<Piece> mPieces = new ArrayList<Piece>();

  public GameBoardView() {
    setLayout(null);
    URL urlBackgroundImg = getClass().getResource("/images/game_board_layout.png");
		mImgBackground = new ImageIcon(urlBackgroundImg).getImage();

    setPreferredSize(new Dimension(1088, 682));

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

  @Override
	protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(mImgBackground, 0, 0, 1088, 682, null);
		for (Piece piece: mPieces) {
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), piece.getWidth(), piece.getHeight(), null);
		}
	}
}
