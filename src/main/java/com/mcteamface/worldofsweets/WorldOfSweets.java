package com.mcteamface.worldofsweets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Boot up the game. There should be no need to modify this.
 * Touch it and I'll chop your fingers off.
 */
public class WorldOfSweets extends JFrame {
  public WorldOfSweets(String title) {
      super(title);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      add(new MainPanel());

      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new WorldOfSweets("World of Sweets");
      }
    });
  }
}
