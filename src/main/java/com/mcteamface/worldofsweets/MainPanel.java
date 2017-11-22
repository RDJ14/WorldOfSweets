package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

class MainPanel extends JPanel {
  public MainPanel() {
    super();

    GameBoardView gameBoardView = new GameBoardView();
    add(gameBoardView);

    // Initialize deck model.
    new DeckModel(gameBoardView);
  }
}
