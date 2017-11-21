package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

class MainPanel extends JPanel {
  public MainPanel() {
    super();

    add(new GameBoardView());
    add(new GameTimer());


    // Model model = new Model();
    // View view = new View(model);
    // Control control = new Control(model, view);
    // JLabel label = new JLabel("Guess what color!", JLabel.CENTER);
    // this.add(label, BorderLayout.NORTH);
    // this.add(view, BorderLayout.CENTER);
    // this.add(control, BorderLayout.SOUTH);
  }
}
