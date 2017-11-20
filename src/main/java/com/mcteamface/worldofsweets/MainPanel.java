package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

class MainPanel extends JPanel {
  public MainPanel() {
    super(new BorderLayout());

    PipeIcon icon = new TopLeftCap(100, Color.gray);
    JLabel label = new JLabel("", icon, JLabel.CENTER);
    add(label, BorderLayout.CENTER);
    // Model model = new Model();
    // View view = new View(model);
    // Control control = new Control(model, view);
    // JLabel label = new JLabel("Guess what color!", JLabel.CENTER);
    // this.add(label, BorderLayout.NORTH);
    // this.add(view, BorderLayout.CENTER);
    // this.add(control, BorderLayout.SOUTH);
  }
}
