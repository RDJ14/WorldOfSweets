package com.mcteamface.worldofsweets;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.lang.Enum;
import java.net.URL;

enum Color{
  RED,
  YELLOW,
  BLUE,
  GREEN,
  ORANGE
}

enum SpecialType{
  LICORICE,
  MINT,
  CHOCOLATE,
  ICECREAM,
  COOKIE,
  SKIP
}

public class Card{

  private static final int _greenSingle = 11;
  private static final int _redSingle = 21;
  private static final int _blueSingle = 31;
  private static final int _yellowSingle = 41;
  private static final int _orangeSingle = 51;
  private static final int _greenDouble = 12;
  private static final int _redDouble = 22;
  private static final int _blueDouble = 32;
  private static final int _yellowDouble = 42;
  private static final int _orangeDouble = 52;
  private static final int _licorice = -1;
  private static final int _cookie = -2;
  private static final int _icecream = -3;
  private static final int _chocolate = -4;
  private static final int _mint = -5;


  boolean single;
  Color c;
  Color color;
  SpecialType type;
  boolean isSpecial;
  JFrame display;

  public Card(boolean single, Color color){
      this.single = single;
      this.color = color;
      this.c = color.ORANGE;
      this.isSpecial = false;
      URL color_image_location = null;
      String color_text = " ";
      ArrayList resources = getResources(color, single);
      color_image_location = (URL) resources.get(0);
      color_text = (String) resources.get(1);
      display = new JFrame();
      JPanel panel = new JPanel(new BorderLayout());
      ImageIcon color_image = new ImageIcon(color_image_location);
      JLabel label = new JLabel("", color_image, JLabel.CENTER);
      JLabel you_drew = new JLabel("Your drew a " + color_text + "!");
      panel.add(label, BorderLayout.CENTER);
      panel.add(you_drew, BorderLayout.SOUTH);
      display.add(panel);
      display.pack();
      display.setVisible(false);
  }

  public Card(SpecialType type){
    this.type = type;
    this.isSpecial = true;
    URL image_location = null;
    String color_text = " ";
    ArrayList resources = getResources(type);
    image_location = (URL) resources.get(0);
    color_text = (String) resources.get(1);
    display = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());
    ImageIcon color_image = new ImageIcon(image_location);
    JLabel label = new JLabel("", color_image, JLabel.CENTER);
    JLabel you_drew = new JLabel(color_text);
    panel.add(label, BorderLayout.CENTER);
    panel.add(you_drew, BorderLayout.SOUTH);
    display.add(panel);
    display.pack();
    display.setVisible(false);
  }

  public Card(int cardNumber){
    boolean single = true;
    Color cardColor = null;
    SpecialType newCardType = null;
    if(cardNumber > 0 && cardNumber <= 52){
      if(cardNumber % 2 == 0){
        single = false;
      }
      if((cardNumber - 10) < 10) cardColor = Color.GREEN;
      else if((cardNumber - 20) < 10) cardColor = Color.RED;
      else if((cardNumber - 30) < 10) cardColor = Color.BLUE;
      else if((cardNumber - 40) < 10) cardColor = Color.YELLOW;
      else if((cardNumber - 50) < 10) cardColor = Color.ORANGE;
      this.single = single;
      this.color = cardColor;
      this.isSpecial = false;
      ArrayList resources = getResources(cardColor, single);
      URL color_image_location = (URL) resources.get(0);
      String color_text = (String) resources.get(1);
      display = new JFrame();
      JPanel panel = new JPanel(new BorderLayout());
      ImageIcon color_image = new ImageIcon(color_image_location);
      JLabel label = new JLabel("", color_image, JLabel.CENTER);
      JLabel you_drew = new JLabel("Your drew a " + color_text + "!");
      panel.add(label, BorderLayout.CENTER);
      panel.add(you_drew, BorderLayout.SOUTH);
      display.add(panel);
      display.pack();
      display.setVisible(false);

    }
    else if(cardNumber < 0 && cardNumber >= -5){
      if(cardNumber == -1) newCardType = SpecialType.LICORICE;
      else if(cardNumber == -2) newCardType = SpecialType.COOKIE;
      else if(cardNumber == -3) newCardType = SpecialType.ICECREAM;
      else if(cardNumber == -4) newCardType = SpecialType.CHOCOLATE;
      else if(cardNumber == -5) newCardType = SpecialType.MINT;
      ArrayList resources = getResources(newCardType);
      URL color_image_location = (URL) resources.get(0);
      String color_text = (String) resources.get(1);
      display = new JFrame();
      JPanel panel = new JPanel(new BorderLayout());
      ImageIcon color_image = new ImageIcon(color_image_location);
      JLabel label = new JLabel("", color_image, JLabel.CENTER);
      JLabel you_drew = new JLabel("Your drew a " + color_text + "!");
      panel.add(label, BorderLayout.CENTER);
      panel.add(you_drew, BorderLayout.SOUTH);
      display.add(panel);
      display.pack();
      display.setVisible(false);
    }
  }

  private ArrayList getResources(SpecialType special){
    URL image_location = null;
    String color_text = "";
    ArrayList resources = new ArrayList<>();
    switch(special){
      case LICORICE:
        image_location = Deck.class.getClassLoader().getResource("images/licorice.png");
        color_text = "Licorice! Move to the Licorice tile!)";
        break;
      case MINT:
        image_location = Deck.class.getClassLoader().getResource("images/mint.png");
        color_text = "Mint! Move to the Mint tile!)";
        break;
      case CHOCOLATE:
        image_location = Deck.class.getClassLoader().getResource("images/chocolate.png");
        color_text = "Chocolate! Move to the Chocolate tile!)";
        break;
      case ICECREAM:
        image_location = Deck.class.getClassLoader().getResource("images/icecream.png");
        color_text = "Ice Cream! Move to the Ice Cream tile!)";
        break;
      case COOKIE:
        image_location = Deck.class.getClassLoader().getResource("images/cookie.png");
        color_text = "Cookie! Move to the Cookie tile!)";
        break;
      case SKIP:
        image_location = Deck.class.getClassLoader().getResource("images/Swap.png");
        color_text = "Cand Mix Up! Your turn is skipped!";
        break;
    }
    resources.add(image_location);
    resources.add(color_text);
    return resources;
  }

  private ArrayList getResources(Color cardColor, boolean singleMove){
    ArrayList resources = new ArrayList<>();
    URL color_image_location = null;
    String color_text = "";

    switch(this.color){
      case RED:
        this.c=color.RED;
        if(single){
          color_image_location = Deck.class.getClassLoader().getResource("images/Red-single.png");
          color_text = "red single";
        }
        else{
          color_image_location = Deck.class.getClassLoader().getResource("images/Red-double.png");
          color_text = "red double";
        }
        break;
      case YELLOW:
        this.c=color.YELLOW;
        if(single){
          color_image_location = Deck.class.getClassLoader().getResource("images/Yellow-single.png");
          color_text = "yellow single";
        }
        else{
          color_image_location = Deck.class.getClassLoader().getResource("images/Yellow-double.png");
          color_text = "yellow double";
        }
        break;
      case BLUE:
        this.c=color.BLUE;
        if(single){
          color_image_location = Deck.class.getClassLoader().getResource("images/Blue-single.png");
          color_text = "blue single";
        }
        else{
          color_image_location = Deck.class.getClassLoader().getResource("images/Blue-Double.png");
          color_text = "blue double";
        }
        break;
      case GREEN:
        this.c=color.GREEN;
        if(single){
          color_image_location = Deck.class.getClassLoader().getResource("images/Green-single.png");
          color_text = "green single";
        }
        else{
          color_image_location = Deck.class.getClassLoader().getResource("images/Green-double.png");
          color_text = "green double";
        }
        break;
      case ORANGE:
        this.c=color.ORANGE;
        if(single){
          color_image_location = Deck.class.getClassLoader().getResource("images/Orange-single.png");
          color_text = "orange single";
        }
        else{
          color_image_location = Deck.class.getClassLoader().getResource("images/Orange-double.png");
          color_text = "orange double";
        }
        break;
    }
    resources.add(color_image_location);
    resources.add(color_text);
    return resources;
  }


  public void draw(){
    display.setVisible(true);
    return;
  }

  public void discard(){
    display.setVisible(false);
    display.dispose();
    return;
  }

  public Color getColor(){
    return this.color;
  }

  public SpecialType getType(){
    if(isSpecial)
      return type;
    else return null;
  }
  public boolean isSingle(){
    return single;
  }

  public boolean isSpecial(){
    return isSpecial;
  }

  public int toInt(){
    if(this.isSpecial){
      if(type == SpecialType.LICORICE) return -1;
      if(type == SpecialType.COOKIE) return -2;
      if(type == SpecialType.ICECREAM) return -3;
      if(type == SpecialType.CHOCOLATE) return -4;
      if(type == SpecialType.MINT) return -5;
    }
    int toReturn = 0;
    if(color == Color.GREEN) toReturn = 10;
    else if(color == Color.RED) toReturn = 20;
    else if(color == Color.BLUE) toReturn = 30;
    else if(color == Color.YELLOW) toReturn = 40;
    else if(color == Color.ORANGE) toReturn = 50;
    if(this.single) toReturn++;
    else toReturn += 2;

    return toReturn;
  }

}
