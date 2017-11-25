package com.mcteamface.worldofsweets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Boot up the game. There should be no need to modify this.
 * Touch it and I'll chop your fingers off.
 */
public class WorldOfSweets extends JFrame {
  public WorldOfSweets(String title) {
      super(title);
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

      addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          int result = JOptionPane.showConfirmDialog(null, "Would you like to save your game?");
          if (result == JOptionPane.OK_OPTION) {
            System.exit(0);
          } else if (result == JOptionPane.NO_OPTION) {
            System.exit(0);
          }
        }
      });

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
