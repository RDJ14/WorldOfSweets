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

public class Card{

  boolean single;
  Color color;
  JFrame display;

  public Card(boolean single, Color color){
      this.single = single;
      this.color = color;

      URL color_image_location = null;
      String color_text = " ";
      switch(this.color){
        case RED:
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
}
