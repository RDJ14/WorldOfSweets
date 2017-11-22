package com.mcteamface.worldofsweets;

import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;

public enum Card {
  RED("/images/card_single_red.png"),
  YELLOW("/images/card_single_yellow.png"),
  BLUE("/images/card_single_blue.png"),
  GREEN("/images/card_single_green.png"),
  ORANGE("/images/card_single_orange.png"),
  DOUBLE_RED("/images/card_double_red.png"),
  DOUBLE_YELLOW("/images/card_double_yellow.png"),
  DOUBLE_BLUE("/images/card_double_blue.png"),
  DOUBLE_GREEN("/images/card_double_green.png"),
  DOUBLE_ORANGE("/images/card_double_orange.png"),
  SPECIAL_LOLLIPOP("/images/card_special_lollipop.png"),
  SPECIAL_CORDIAL("/images/card_special_cordial.png"),
  SPECIAL_CANDY_CANE("/images/card_special_candycane.png"),
  SPECIAL_GUM_DROP("/images/card_special_gumdrop.png"),
  SPECIAL_NOUGAT("/images/card_special_nougat.png");

  private final String stringLocation;

  private Card(final String stringLocation) {
    this.stringLocation = stringLocation;
  }

  public Image getImage() {
    URL url = getClass().getResource(stringLocation);
    return new ImageIcon(url).getImage();
  }
}
