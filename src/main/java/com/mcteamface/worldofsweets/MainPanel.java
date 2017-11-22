package com.mcteamface.worldofsweets;

import javax.swing.JPanel;

class MainPanel extends JPanel {
  public MainPanel() {
    super();

    GameBoardView gameBoardView = new GameBoardView();
    add(gameBoardView);

    // Initialize game.
    new GameModel(gameBoardView);
  }
}
