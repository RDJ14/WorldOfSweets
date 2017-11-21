package com.mcteamface.worldofsweets;

import java.awt.Color;

public enum Colors {
  RED(254, 74, 73),
  YELLOW(255, 231, 76),
  BLUE(0, 157, 220),
  GREEN(172, 243, 157),
  ORANGE(249, 160, 63);

  private final int r;
  private final int g;
  private final int b;

  private Colors(final int r,final int g,final int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public Color getColor() {
    return new Color(r,g,b);
  }
}
