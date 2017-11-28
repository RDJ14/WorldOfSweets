package com.mcteamface.worldofsweets;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GameSetupController {
  public GameSetupController(GameBoardView gameBoardView) {
    ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();

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
        JCheckBox playerSetupCheckBox = new JCheckBox("AI");
        Object[] playerSetupOptions = { "Next", "Cancel" };

        playerSetupPanel.setLayout(new GridLayout(0, 1));
        playerSetupPanel.add(new JLabel("Player " + i + " please enter your name:"));
        playerSetupPanel.add(playerSetupTextField);
        playerSetupPanel.add(playerSetupCheckBox);

        int playerSetupResult = JOptionPane.showOptionDialog(
          null, playerSetupPanel, "World of Sweets",
          JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
          null, playerSetupOptions, null
        );

        if (playerSetupResult == JOptionPane.YES_OPTION) {
          players.add(new PlayerModel(playerSetupTextField.getText()));
        } else {
          System.exit(0);
        }
      }

      new GameController(gameBoardView, players);

      // Run this after the game boots up.
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          JOptionPane.showMessageDialog(
            null,
            "It's " + players.get(0).getName() + "'s turn! \nPlease click on the deck to draw a card. Then move your piece to the matching tile.",
            "World of Sweets",
            JOptionPane.PLAIN_MESSAGE
          );
        }
      });
    } else if (result == JOptionPane.NO_OPTION) {
      GameController.load(gameBoardView);
    } else {
      System.exit(0);
    }
  }

  /**
   * Convenience enum for converting string number of players to int.
   */
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
}
