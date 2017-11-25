package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

class MainPanel extends JPanel {
  private static enum NumberOfPlayers {
    TWO(2, "two"), THREE(3, "three"), FOUR(4, "four");

    private int mIntNumberOfPlayers;
    private String mStrNumberOfPlayers;

    private NumberOfPlayers(int intNumberOfPlayers, String strNumberOfPlayers) {
      mIntNumberOfPlayers = intNumberOfPlayers;
      mStrNumberOfPlayers = strNumberOfPlayers;
    }

    public static NumberOfPlayers fromString(String numberOfPlayers) {
      for (NumberOfPlayers value : values()) {
        if (value.toString().equals(numberOfPlayers)) {
          return value;
        }
      }
      return null;
    }

    public int toInt() {
      return mIntNumberOfPlayers;
    }

    @Override
    public String toString() {
      return mStrNumberOfPlayers;
    }
  }

  ArrayList<String> mPlayers = new ArrayList<String>();

  public MainPanel() {
    super();

    JRadioButton r1 = new JRadioButton(NumberOfPlayers.TWO.toString());
    r1.setSelected(true);
    JRadioButton r2 = new JRadioButton(NumberOfPlayers.THREE.toString());
    JRadioButton r3 = new JRadioButton(NumberOfPlayers.FOUR.toString());

    final JPanel panel = new JPanel();

    final ButtonGroup group = new ButtonGroup();
    group.add(r1);
    group.add(r2);
    group.add(r3);

    panel.setLayout(new GridLayout(0, 1));
    panel.add(new JLabel("Please choose the number of players:"));
    panel.add(r1);
    panel.add(r2);
    panel.add(r3);

    Object[] options = { "Next", "Load Saved Game", "Cancel" };

    int result = JOptionPane.showOptionDialog(
      null, panel, "World of Sweets",
      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
      null, options, null
    );

    if (result == JOptionPane.YES_OPTION) {
      String text = RadioButtonUtils.getSelectedButtonText(group);

      int numberOfPlayers = NumberOfPlayers.fromString(text).toInt();

      for (int i = 1; i <= numberOfPlayers; i++) {
        JPanel playerSetupPanel = new JPanel();
        JTextField playerSetupTextField = new JTextField(10);
        Object[] playerSetupOptions = { "Next", "Cancel" };

        playerSetupPanel.setLayout(new GridLayout(0, 1));
        playerSetupPanel.add(new JLabel("Player " + i + " please enter your name:"));
        playerSetupPanel.add(playerSetupTextField);

        int playerSetupResult = JOptionPane.showOptionDialog(
          null, playerSetupPanel, "World of Sweets",
          JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
          null, playerSetupOptions, null
        );

        if (playerSetupResult == JOptionPane.YES_OPTION) {
          mPlayers.add(playerSetupTextField.getText());
        } else {
          System.exit(0);
        }
      }
    } else {
      System.exit(0);
    }

    GameBoardView gameBoardView = new GameBoardView();
    add(gameBoardView);

    // Initialize game.
    new GameModel(gameBoardView, mPlayers);

    // Run this after the game boots up.
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        JOptionPane.showMessageDialog(
          null,
          "It's " + mPlayers.get(0) + "'s turn! \nPlease click on the deck to draw a card. Then move your piece to the matching tile.",
          "World of Sweets",
          JOptionPane.PLAIN_MESSAGE
        );
      }
    });
  }
}
