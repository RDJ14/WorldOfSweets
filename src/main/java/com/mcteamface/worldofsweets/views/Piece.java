package com.mcteamface.worldofsweets;

import java.awt.Image;
import java.util.UUID;

public class Piece {
	private final int mInitialX;
	private final int mInitialY;

	private String mId;
	private Image mImg;
	private int mX;
	private int mY;

	private boolean mEnabled;

	public Piece(Image img, int x, int y) {
		mId = UUID.randomUUID().toString();
		mImg = img;
		mInitialX = x;
		mInitialY = y;
		mX = x;
		mY = y;
		mEnabled = true;
	}

	public void setEnabled(boolean enabled) {
		mEnabled = enabled;
	}

	public boolean isEnabled() {
		return mEnabled;
	}

	public String getId() {
		return mId;
	}

	public Image getImage() {
		return mImg;
	}

	public int getX() {
		return mX;
	}

	public int getY() {
		return mY;
	}

	public void moveTo(int position) {
		// 0 == Start
		// 53 == Grandmas House

		// 0  -> -> 9
		// 19 <- <- 10
		// 20 -> -> 29
		// 39 <- <- 30
		// 40 -> 46
		// 53 <- 47

		// This could be more elegant.
		if (position <= 9) {
			setX(mInitialX + (position * 100));
			setY(mInitialY);
		} else if (position <= 19) {
			setX(mInitialX + ((9 - (position % 10)) * 100));
			setY(100 + mInitialY);
		} else if (position <= 29) {
			setX(mInitialX + ((position % 10) * 100));
			setY(200 + mInitialY);
		} else if (position <= 39) {
			setX(mInitialX + ((9 - (position % 10)) * 100));
			setY(300 + mInitialY);
		} else if (position <= 46) {
			setX(mInitialX + ((position % 10) * 100));
			setY(400 + mInitialY);
		} else if (position <= 53) {
			setX(mInitialX + ((9 - (position - 44)) * 100));
			setY(500 + mInitialY);
		}
	}

	public void setX(int x) {
		mX = x;
	}

	public void setY(int y) {
		mY = y;
	}

	public int getWidth() {
		return mImg.getHeight(null) / 2;
	}

	public int getHeight() {
		return mImg.getHeight(null) / 2;
	}

}
