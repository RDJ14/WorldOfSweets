package com.mcteamface.worldofsweets;

import java.awt.Image;
import java.util.UUID;

public class Piece {
	private String mId;
	private Image mImg;
	private int mX;
	private int mY;

	public Piece(Image img, int x, int y) {
		mId = UUID.randomUUID().toString();
		mImg = img;
		mX = x;
		mY = y;
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
		// 0  -> -> 9
		// 19 <- <- 10
		// 20 -> -> 29
		// 39 <- <- 30
		// 40 -> 46
		// 53 <- 47
    //
		// 0 == Start
		// 53 == Grandmas House
		if (position <= 9) {
			setX(50 + (position * 100) + 20);
			setY(75);
		} else if (position <= 19) {
			setX(50 + ((9 - (position % 10)) * 100) + 20);
			setY(175);
		} else if (position <= 29) {
			setX(50 + ((position % 10) * 100) + 20);
			setY(275);
		} else if (position <= 39) {
			setX(50 + ((9 - (position % 10)) * 100) + 20);
			setY(375);
		} else if (position <= 46) {
			setX(50 + ((position % 10) * 100) + 20);
			setY(475);
		} else if (position <= 53) {
			setX(50 + ((9 - (position - 44)) * 100) + 20);
			setY(575);
		}


		// int line = (int) Math.floor(position / WIDTH) % 2;
		// if (line == 0) {
		// 	return position;
		// }
		// return position + (WIDTH - 1 - (2 * (position % 5)));
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
