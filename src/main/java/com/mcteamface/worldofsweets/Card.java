package com.mcteamface.worldofsweets;

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
  RUSH,
  SWAP
}

public class Card{
	
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
    switch(type){
      case RUSH:
        image_location = Deck.class.getClassLoader().getResource("images/SugarRush.png");
        color_text = "Sugar Rush! Move forward as if this was a card of the same color tile you are on.)";
        break;
      case SWAP:
        image_location = Deck.class.getClassLoader().getResource("images/Swap.png");
        color_text = "Cand Mix Up! Switch places with the player directly in front of you!";
        break;
    }
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

  public boolean isSingle(){
    return single;
  }

  public boolean isSpecial(){
    return isSpecial;
  }
}
