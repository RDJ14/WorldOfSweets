package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Control extends JPanel {
  private Model model;
  private View view;
  private JButton reset = new JButton("Reset");

  public Control(Model model, View view) {
    this.model = model;
    this.view = view;
    this.add(reset);
    reset.addActionListener(new ButtonHandler());
  }

  private class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String cmd = e.getActionCommand();
      if ("Reset".equals(cmd)) {
        model.reset();
      }
    }
  }
}
