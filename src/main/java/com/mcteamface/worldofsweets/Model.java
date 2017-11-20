package com.mcteamface.worldofsweets;

import java.util.Observable;
import java.util.Random;
import java.awt.Color;

class Model extends Observable {
  private static final Random rnd = new Random();
  private static final Piece[] pieces = Piece.values();
  private Piece hidden = init();

  private Piece init() {
    return pieces[rnd.nextInt(pieces.length)];
  }

  public void reset() {
    hidden = init();
    setChanged();
    notifyObservers();
  }

  public void check(Piece guess) {
    setChanged();
    notifyObservers(guess.equals(hidden));
  }
}

enum Piece {
  Red(Color.red), Green(Color.green), Blue(Color.blue);
  public Color color;

  private Piece(Color color) {
    this.color = color;
  }
}
