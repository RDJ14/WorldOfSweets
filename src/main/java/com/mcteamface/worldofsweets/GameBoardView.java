package com.mcteamface.worldofsweets;

import java.awt.*; //for color and flowlayout

import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.*; //for borderfactory
import javax.imageio.*;

import java.awt.Color;
import java.net.URL;

public class GameBoardView extends JLayeredPane {
	private static final int HEIGHT = 4;
	private static final int WIDTH = 5;
	// Arrays are mutalable so please don't mutate this ;)
	private static final Color[] COLOR_ORDER = new Color[] {
		Color.RED,
		Color.YELLOW,
		Color.BLUE,
		Color.GREEN,
		Color.ORANGE
	};

	public GameBoardView(int players) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(HEIGHT, WIDTH, 0, 0));

		// Resize "left" image.
		ImageIcon left = new ImageIcon(getClass().getResource("/images/left.png"));
		Image leftImg = left.getImage();
		Image newLeftImage = leftImg.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
		left = new ImageIcon(newLeftImage);

		// Resize "right" image.
		ImageIcon right = new ImageIcon(getClass().getResource("/images/right.png"));
		Image rightImg = right.getImage();
		Image newRightImage = rightImg.getScaledInstance(150, 80, Image.SCALE_SMOOTH);
		right = new ImageIcon(newRightImage);

		// Resize "down" image.
		ImageIcon down = new ImageIcon(getClass().getResource("/images/down.png"));
		Image downImg = down.getImage();
		Image newdownImage = downImg.getScaledInstance(80, 120, Image.SCALE_SMOOTH);
		down = new ImageIcon(newdownImage);

		// Resize "Grandma's house" image.
		ImageIcon grandmasHouse = new ImageIcon(getClass().getResource("/images/GrandmaHouse.jpg"));
		Image houseImg = grandmasHouse.getImage();
		Image newHouseImage = houseImg.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
		grandmasHouse = new ImageIcon(newHouseImage);

		// Border of width of 2.
		Border border = BorderFactory.createLineBorder(Color.black, 2);

		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			int snakeCoord = gridToSnake(i);
			System.out.println(snakeCoord);
			// Last tile is "Grandma's House".
			if (snakeCoord == WIDTH * HEIGHT - 1) {
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setIcon(grandmasHouse);
				label.setBorder(border);
				add(label);

			// Zeroth tile is "Start".
			} else if (snakeCoord == 0) {
				JPanel startPanel = new JPanel();
				startPanel.setBorder(border);
				add(startPanel);

				for (int x = 1; x < players + 1; x++) {
					JButton token = new JButton("Player" + x);
					startPanel.add(token);
				}

				JLabel txtStart = new JLabel();
				// How dare you...
				txtStart.setFont(new Font("Papyrus", Font.PLAIN, 19));
				txtStart.setText("START");
				startPanel.add(txtStart);

			// All the other tiles
			} else {
				JLabel label = new JLabel("");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setOpaque(true); // This lets us see the color.
				label.setBorder(border);
				label.setBackground(COLOR_ORDER[(snakeCoord - 1) % COLOR_ORDER.length]);
				int line = (int) Math.floor(snakeCoord / 5) % 2;
				if (line == 0) {
					if ((snakeCoord + 1) % 5 == 0) {
						label.setIcon(down);
					} else {
						label.setIcon(right);
					}
				} else {
					if ((snakeCoord + 1) % 5 == 0) {
						label.setIcon(down);
					} else {
						label.setIcon(left);
					}
				}
				add(label);
			}
		}
	}

	private int gridToSnake(int i) {
		int line = (int) Math.floor(i / WIDTH) % 2;
		if (line == 0) {
			return i;
		}
		return i + (WIDTH - 1 - (2 * (i % 5)));
	}
}
