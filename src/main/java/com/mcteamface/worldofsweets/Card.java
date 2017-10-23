package com.mcteamface.worldofsweats;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.lang.Enum;

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

      String color_image_location = " ";
      String color_text = " ";
      switch(this.color){
        case RED:
          if(single){
            color_image_location = "CardImage/Red-Single.png";
            color_text = "red single";
          }
          else{
            color_image_location = "CardImage/Red-Double.png";
            color_text = "red double";
          }
          break;
        case YELLOW:
          if(single){
            color_image_location = "CardImage/Yellow-single.png";
            color_text = "yellow single";
          }
          else{
            color_image_location = "CardImage/Yellow-double.png";
            color_text = "yellow double";
          }
          break;
        case BLUE:
          if(single){
            color_image_location = "CardImage/Blue-single.png";
            color_text = "blue single";
          }
          else{
            color_image_location = "CardImage/Blue-Double.png";
            color_text = "blue double";
          }
          break;
        case GREEN:
          if(single){
            color_image_location = "CardImage/Green-single.png";
            color_text = "green single";
          }
          else{
            color_image_location = "CardImage/Green-double.png";
            color_text = "green double";
          }
          break;
        case ORANGE:
          if(single){
            color_image_location = "CardImage/Orange-single.png";
            color_text = "orange single";
          }
          else{
            color_image_location = "CardImage/Orange-double.png";
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
}
