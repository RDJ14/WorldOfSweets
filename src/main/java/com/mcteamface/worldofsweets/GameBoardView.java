package com.mcteamface.worldofsweets;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;

class GameBoardView extends JPanel {
  private static final Color[] COLOR_ORDER = new Color[] {
		Colors.RED.getColor(),
		Colors.YELLOW.getColor(),
		Colors.BLUE.getColor(),
		Colors.GREEN.getColor(),
		Colors.ORANGE.getColor()
	};

  private List<Piece> mPieces = new ArrayList<Piece>();

  public GameBoardView() {
    super(new GameBoardLayout());

    addPiece(0, 0, 0);
    addPiece(1, 100, 0);
    addPiece(2, 200, 0);
    addPiece(3, 300, 0);

    PiecesDragAndDropListener listener = new PiecesDragAndDropListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

    for (int i = 0; i < 25; i++) {
      if (i == 0) {
        add(new BarMiddle(100, Color.gray));
      } else if (i == 24) {
        add(new BarMiddle(100, Color.gray));
      } else {
        Color color = COLOR_ORDER[(i - 1) % 5];
        if (i % 14 == 13) {
          add(new CapTopLeft(100, color));
        } else if (i % 14 == 6) {
          add(new CapTopRight(100, color));
        } else if (i % 14 == 0) {
          add(new CapBottomLeft(100, color));
        } else if (i % 14 == 7) {
          add(new CapBottomRight(100, color));
        } else {
          add(new BarMiddle(100, color));
        }
      }
    }
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
		for (Piece piece: mPieces) {
			g.drawImage(piece.getImage(), piece.getX(), piece.getY(), piece.getWidth() / 2, piece.getHeight() / 2, null);
		}
	}
}
