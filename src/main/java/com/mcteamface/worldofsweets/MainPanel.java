package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

class MainPanel extends JPanel {
  public MainPanel() {
    super();

    add(new GameBoardView());
    add(new GameTimer());
    add(new Deck());
  }
}
