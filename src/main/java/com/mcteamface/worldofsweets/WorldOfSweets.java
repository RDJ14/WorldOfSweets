package com.mcteamface.worldofsweets;

import java.util.ArrayList;

public class WorldOfSweets {
  public static void main(String[] args) {
    ChoosePlayersActivity numPlayersButton = new ChoosePlayersActivity();

    numPlayersButton.addPlayersChosenListener(new ChoosePlayersActivity.PlayersChosenListener() {
			@Override
			public void playersChosen(int numPlayers) {
        numPlayersButton.dispose();
        GameActivity GameActivity = new GameActivity();
			}
		});
  }
}
