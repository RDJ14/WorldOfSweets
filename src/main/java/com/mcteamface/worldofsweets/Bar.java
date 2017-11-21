package com.mcteamface.worldofsweets;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.geom.Path2D;

public class Bar extends JComponent {
  private int mSize;
  private float mThickness;
  private Color mColor;

  public Bar(int size, float thickness, Color color) {
    super();
    mSize = size;
    mThickness = thickness;
    mColor = color;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(mSize, mSize);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON
    );
    g2d.setColor(mColor);
    float padding = (mSize - mThickness) / 2;
    g2d.fillRect(0, (int) padding, mSize, (int) mThickness);
  }
}
