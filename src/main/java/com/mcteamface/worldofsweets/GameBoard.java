package com.mcteamface.worldofsweets;


import java.awt.*; //for color and flowlayout

import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.*; //for borderfactory

import java.awt.Color;
import java.net.URL;

public class GameBoard extends JFrame {

	private JLayeredPane contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GameBoard(int players) {

		//resizing left image
		ImageIcon left = new ImageIcon("left.png"); //absolute pathing only for testing
		Image leftImg = left.getImage();
		Image newLeftImage = leftImg.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
		left = new ImageIcon(newLeftImage);

		//resizing right image
		ImageIcon right = new ImageIcon("right.png"); //absolute pathing only for testing
		Image rightImg = right.getImage();
		Image newRightImage = rightImg.getScaledInstance(150, 80, java.awt.Image.SCALE_SMOOTH);
		right = new ImageIcon(newRightImage);

		//resizing up image
		ImageIcon up = new ImageIcon("up.png"); // absolute pathing only for testing
		Image upImg = up.getImage();
		Image newUpImage = upImg.getScaledInstance(80, 120, java.awt.Image.SCALE_SMOOTH);
		up = new ImageIcon(newUpImage);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 548);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 5, 0, 0));
		//border width of 2
		Border border = BorderFactory.createLineBorder(Color.black, 2);

		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_19.setIcon(right);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setBorder(border);
		lblNewLabel_19.setBackground(Color.RED);
		contentPane.add(lblNewLabel_19);

		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_18.setIcon(right);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setBorder(border);
		lblNewLabel_18.setBackground(Color.YELLOW);
		contentPane.add(lblNewLabel_18);

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(right);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_17.setOpaque(true);
		lblNewLabel_17.setBorder(border);
		lblNewLabel_17.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_17);

		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(right);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_16.setOpaque(true);
		lblNewLabel_16.setBorder(border);
		lblNewLabel_16.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel_16);

		URL grandmaHouse = Deck.class.getClassLoader().getResource("images/GrandmaHouse.jpg");

		ImageIcon housePic = new ImageIcon(grandmaHouse); //absolute path just for testing
		Image img = housePic.getImage();
		Image newImage = img.getScaledInstance(150, 120, java.awt.Image.SCALE_SMOOTH);
		housePic = new ImageIcon(newImage);
		JLabel lblNewLabel_15 = new JLabel("", housePic, JLabel.CENTER);

		lblNewLabel_15.setBorder(border);
		contentPane.add(lblNewLabel_15);

		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setIcon(up);
		lblNewLabel_14.setOpaque(true);
		lblNewLabel_14.setBorder(border);
		lblNewLabel_14.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(left);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_13.setOpaque(true);
		lblNewLabel_13.setBorder(border);
		lblNewLabel_13.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel_13);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(left);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setBorder(border);
		lblNewLabel_12.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(left);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setBorder(border);
		lblNewLabel_11.setBackground(Color.YELLOW);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(left);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setBorder(border);
		lblNewLabel_10.setBackground(Color.RED);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setIcon(right);
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setBorder(border);
		lblNewLabel_9.setBackground(Color.RED);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setIcon(right);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setBorder(border);
		lblNewLabel_8.setBackground(Color.YELLOW);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setIcon(right);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBorder(border);
		lblNewLabel_7.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setIcon(right);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBorder(border);
		lblNewLabel_6.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(up);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBorder(border);
		lblNewLabel_5.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(up);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBorder(border);
		lblNewLabel_4.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(left);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBorder(border);
		lblNewLabel_3.setBackground(Color.GREEN);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(left);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBorder(border);
		lblNewLabel_2.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(left);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBorder(border);
		lblNewLabel_1.setBackground(Color.YELLOW);
		contentPane.add(lblNewLabel_1);

		JPanel startPanel = new JPanel();
		startPanel.setOpaque(true);
		startPanel.setBorder(border);
		startPanel.setBackground(Color.RED);
		contentPane.add(startPanel);
		
		//adding player tokens...make this better later
		if (players == 1) {
			JButton token1 = new JButton("Player1");
			startPanel.add(token1);
		}
		if (players == 2) {
			JButton token1 = new JButton("Player1");
			startPanel.add(token1);
			
			JButton token2 = new JButton("Player2");
			startPanel.add(token2);
		}
		if (players == 3) {
			JButton token1 = new JButton("Player1");
			startPanel.add(token1);
			
			JButton token2 = new JButton("Player2");
			startPanel.add(token2);
			
			JButton token3 = new JButton("Player3");
			startPanel.add(token3);
			
		}
		if (players == 4) {
			JButton token1 = new JButton("Player1");
			startPanel.add(token1);
			
			JButton token2 = new JButton("Player2");
			startPanel.add(token2);
			
			JButton token3 = new JButton("Player3");
			startPanel.add(token3);
			
			JButton token4 = new JButton("Player4");
			startPanel.add(token4);
	
		}
				
		JLabel txtStart = new JLabel();
		txtStart.setForeground(Color.BLACK);
		txtStart.setBackground(Color.RED);
		txtStart.setFont(new Font("Papyrus", Font.PLAIN, 19));
		txtStart.setText("START");
		startPanel.add(txtStart);
	}

}
