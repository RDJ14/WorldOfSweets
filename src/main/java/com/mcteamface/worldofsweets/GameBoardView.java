package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Color;

class GameBoardView extends JPanel {
  private static final Color[] COLOR_ORDER = new Color[] {
		Colors.RED.getColor(),
		Colors.YELLOW.getColor(),
		Colors.BLUE.getColor(),
		Colors.GREEN.getColor(),
		Colors.ORANGE.getColor()
	};

  public GameBoardView() {
    super(new GameBoardLayout());

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
}
