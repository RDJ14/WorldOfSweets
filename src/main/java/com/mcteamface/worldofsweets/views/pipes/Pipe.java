package com.mcteamface.worldofsweets;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.geom.Path2D;

public class Pipe extends JComponent {
  private int mSize;
  private float mRotation;
  private float mThickness;
  private Color mColor;

  public Pipe(int size, float thickness, float rotation, Color color) {
    super();
    mSize = size;
    mColor = color;
    mRotation = rotation;
    mThickness = thickness;
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
    g2d.rotate(Math.toRadians(mRotation), mSize / 2, mSize / 2);
    g2d.fill(new BottomLeftCap(mSize, mSize, mThickness, mSize - ((mSize - mThickness) / 2)));
  }

  private static class BottomLeftCap extends Path2D.Float {
    public BottomLeftCap(float width, float height, float thickness, float radius) {
      float padding = (width - thickness) / 2;
      float radiusBuffer = width - (padding + radius);
      float innerRadius = radius - thickness;
      moveTo(padding, 0);
      lineTo(padding + thickness, 0);
      lineTo(padding + thickness, radiusBuffer);
      curveTo(
      padding + thickness, radiusBuffer + (innerRadius / 2), // Start bez point.
      padding + thickness + (innerRadius / 2), padding, // End bez point.
      padding + radius, padding // To point.
      );
      lineTo(width, padding);
      lineTo(width, thickness + padding);
      lineTo(padding + radius, thickness + padding);
      curveTo(
      padding + (radius / 2), thickness + padding, // Start bez point.
      padding, radiusBuffer + (radius / 2), // End bez point.
      padding, radiusBuffer // To point.
      );
      closePath();
    }
  }
}
