package com.mcteamface.worldofsweets;

import java.awt.LayoutManager;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Container;

public class GameBoardLayout implements LayoutManager {
  private int mMinWidth = 0;
  private int mMinHeight = 0;
  private int mPreferredWidth = 0;
  private int mPreferredHeight = 0;
  private int mColumns = 0;
  private boolean mSizeUnknown = true;

  public GameBoardLayout() {
    this(7);
  }

  public GameBoardLayout(int columns) {
    mColumns = columns;
  }

  @Override
  public void addLayoutComponent(String name, Component comp) {
  }

  @Override
  public void removeLayoutComponent(Component comp) {
  }

  private void setSizes(Container parent) {
    int nComps = parent.getComponentCount();
    Dimension d = null;

    Component c = parent.getComponent(0);
    d = c.getPreferredSize();
    mPreferredWidth = d.width * mColumns;
    mPreferredHeight = d.height * mColumns;
    mMinWidth = d.width * mColumns;
    mMinHeight = d.height * mColumns;
  }

  @Override
  public Dimension preferredLayoutSize(Container parent) {
    Dimension dim = new Dimension(0, 0);
    int nComps = parent.getComponentCount();

    setSizes(parent);

    // Always add the container's insets!
    Insets insets = parent.getInsets();
    dim.width = mPreferredWidth + insets.left + insets.right;
    dim.height = mPreferredHeight + insets.top + insets.bottom;

    mSizeUnknown = false;

    return dim;
  }

  @Override
  public Dimension minimumLayoutSize(Container parent) {
    Dimension dim = new Dimension(0, 0);
    int nComps = parent.getComponentCount();

    // Always add the container's insets!
    Insets insets = parent.getInsets();
    dim.width = mMinWidth + insets.left + insets.right;
    dim.height = mMinHeight + insets.top + insets.bottom;

    mSizeUnknown = false;

    return dim;
  }

  /*
  * This is called when the panel is first displayed,
  * and every time its size changes.
  * Note: You CAN'T assume preferredLayoutSize or
  * minimumLayoutSize will be called -- in the case
  * of applets, at least, they probably won't be.
  */
  @Override
  public void layoutContainer(Container parent) {
    int nComps = parent.getComponentCount();

    // Go through the components' sizes, if neither
    // preferredLayoutSize nor minimumLayoutSize has
    // been called.
    if (mSizeUnknown) {
      setSizes(parent);
    }

    for (int i = 0; i < nComps; i++) {
      Component c = parent.getComponent(i);
      if (c.isVisible()) {
        Dimension d = c.getPreferredSize();
        c.setBounds((gridToSnake(i) % mColumns) * d.width, (gridToSnake(i) / mColumns) * d.height, d.width, d.height);
      }
    }
  }

  private int gridToSnake(int i) {
		int line = (int) Math.floor(i / mColumns) % 2;
		if (line == 0) {
			return i;
		}
		return i + (mColumns - 1 - (2 * (i % mColumns)));
	}
}
