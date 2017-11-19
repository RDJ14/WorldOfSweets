package com.mcteamface.worldofsweets;


import java.awt.*; //for color and flowlayout

import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.*; //for borderfactory
import java.awt.event.*; 
import java.awt.Color;
import java.net.URL;

public class GameBoard extends JFrame {
	Border border = BorderFactory.createLineBorder(Color.black, 2);
	private JLayeredPane contentPane;
	boolean turnTaken = false;
	JPanel[][] board;
	JPanel[] Board;
	JButton[] players;
	int onDouble = 2;
	int PlayerPosition[];
	int p;
	int w = 7;
	int h = 7;
	final int chocolateSpot = 9;
	final int cookieSpot = 15;
	final int icecreamSpot = 22;
	final int licoriceSpot = 29;
	final int mintSpot = 38;
	String cc="BLACK";
	Color blue = Color.BLUE;
	Color yellow = Color.YELLOW;
	Color orange = Color.ORANGE;
	Color red = Color.RED;
	Color green = Color.GREEN;
	Color curColor = Color.black;
	boolean movingLeft=true;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	public void makeBoard(int width, int height) {
		
		board = new JPanel[h][w];
		Board = new JPanel[h*w];
		int vertical = 0;
		boolean goingRight = true;
		int horizontal = 0;
		int count = 0;
		//boolean reverse = false;
		boolean grandmasHouse = true;
		for(int i = 0; i<h;i++) {
			for(int j = 0; j<w;j++) {
				makeSquare(i,j,count%5, horizontal, vertical, grandmasHouse, count, goingRight);
				grandmasHouse=false;
				if(horizontal == w*100&&goingRight) {
					vertical+=100;
					goingRight=false;
				}
				else if(goingRight) {
					horizontal+=100;
				}
				else if (!goingRight&&horizontal == 0) {
					vertical +=100;
					goingRight = true;
				}
				else if (!goingRight) {
					horizontal-=100;
				}
				count++;
			}
		}
		boardFlipColors();
	}

	
	
public String getStringColor() {
		
		if(curColor.equals(blue)) {
			cc="BLUE";
		}
		if(curColor==orange) {
			cc="ORANGE";
		}
		if(curColor==red) {
			cc="RED";
		}
		if(curColor==green) {
			cc="GREEN";
		}
		if(curColor==yellow) {
			cc="YELLOW";
		}
		String ret = cc;
		return ret.replace(" ", "");
	}
	
	private boolean specialSpot(int spot) {
		boolean isSpecial = false;
		
		if(spot == chocolateSpot) {
			isSpecial = true;
		}
		if(spot == cookieSpot) {
			isSpecial = true;
		}
		if(spot == licoriceSpot) {
			isSpecial = true;
		}
		if(spot == mintSpot) {
			isSpecial = true;
		}
		if(spot == icecreamSpot) {
			isSpecial = true;
		}
		return isSpecial;
	}

	public void boardFlipColors() {
		int color = 0;
		for(int i = 0; i <h;i++) {
			for(int j = 0;j<w;j++) {
				if(specialSpot(color)) {
					
				}
					if(color%5 == 0) {
						board[i][j].setBackground(Color.RED);
					}
					if(color%5 == 1) {
						board[i][j].setBackground(Color.YELLOW);
					}
					if(color%5 == 2) {
						board[i][j].setBackground(Color.BLUE);
					}
					if(color%5 == 3) {
						board[i][j].setBackground(Color.GREEN);
					}
					if(color%5 == 4) {
						board[i][j].setBackground(Color.ORANGE);
					}
					color++;
			}
			
		}
	}
	
	public void playerDisable(int p) {
		for(int i =0;i<players.length;i++) {
			if(i!=p-1){
				players[i].setEnabled(false);
			}
			else {
				players[i].setEnabled(true);
			}
		}
	}
	public void makeSquare(int height, int width, int color, int hor, int vert, boolean grandmas, int count, boolean right) {
		JPanel square = new JPanel();
		if(grandmas) {
			URL grandmaHouse = Deck.class.getClassLoader().getResource("images/GrandmaHouse.jpg");

			ImageIcon housePic = new ImageIcon(grandmaHouse); //absolute path just for testing
			Image img = housePic.getImage();
			Image newImage = img.getScaledInstance(150, 120, java.awt.Image.SCALE_SMOOTH);
			housePic = new ImageIcon(newImage);
			square = new JPanel();
			JLabel label = new JLabel("", housePic, JLabel.CENTER);
			square.add(label, BorderLayout.CENTER);
		}
		else {
			
			square.setOpaque(true);
			square.setBorder(border);
			if(color == 0) {
				square.setBackground(Color.RED);
			}
			if(color == 1) {
				square.setBackground(Color.YELLOW);
			}
			if(color == 2) {
				square.setBackground(Color.BLUE);
			}
			if(color == 3) {
				square.setBackground(Color.GREEN);
			}
			if(color == 4) {
				square.setBackground(Color.ORANGE);
			}
			square.setEnabled(false);
		}
		
		square.setLocation(1000, vert);
		contentPane.add(square);
		if(height%2==0) {
			board[height][width]=square;
			Board[height*7+width]=square;
		}
		
		else {
			board[height][(w-width)-1]=square;
			Board[height*7+((w-width)-1)] = square;
		}
		
	}
	public void disableAll(){
		for(int i = 0; i<players.length;i++) {
			players[i].setEnabled(false);
		}
	}
	public void addPlayerTokens(int p) {
		players = new JButton[p];
		PlayerPosition = new int[p];
		for(int i = 0; i<p;i++) {
			ActionListener buttonListener = new ButtonListener();
			JButton t = new JButton(Integer.toString(i+1));
			t.addActionListener(buttonListener);
			board[h-1][w-1].add(t);
			players[i] = t;
			String a = Integer.toString(h-1)+Integer.toString(w-1);
			PlayerPosition[i] = Integer.parseInt(a);
			PlayerPosition[i] = h*w-1;		
		}
	}
	
	public GameBoard(int players) {

		//resizing left image
		p = players; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 773, 548);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(h, w, 0, 0));
		
		makeBoard(w,h);
		addPlayerTokens(p);
		
		
		//adding player tokens...make this better later
/*
		JPanel startPanel = new JPanel();
		JLabel txtStart = new JLabel();
		txtStart.setForeground(Color.BLACK);
		txtStart.setBackground(Color.RED);
		txtStart.setFont(new Font("Papyrus", Font.PLAIN, 19));
		txtStart.setText("START");
		startPanel.add(txtStart);
		*/
	}
	
	public void  nextPlayerMessage(int n) {
		JOptionPane.showMessageDialog(contentPane, "Player "+n+", It's your turn!");
	}
	public void revertCur() {
		curColor = Color.black;
	}
	
	public void moveMiddle(int n) {
		int pos = PlayerPosition[n];
		JButton a = players[n];
		a.setVisible(false);
		JButton comp = new JButton(Integer.toString(n+1));
		ActionListener buttonListener = new ButtonListener();
		comp.addActionListener(buttonListener);
		Board[(h*w)/2].add(comp);
		players[n]=comp;
		PlayerPosition[n] = (h*w)/2;
		contentPane.revalidate();
		contentPane.repaint();
		
	}
	public void MovePlayerForward(int n) {
		
		int pos = PlayerPosition[n];
		pos-=1;
		JButton comp = new JButton(Integer.toString(n+1));
		ActionListener buttonListener = new ButtonListener();
		comp.addActionListener(buttonListener);
		Board[pos].add(comp);
		comp.setVisible(true);
		PlayerPosition[n] = pos;
		curColor = Board[pos].getBackground();
		contentPane.revalidate();
		contentPane.repaint();
		players[n] = comp;
		turnTaken = true;
		if(pos==0) {
			curColor = Color.DARK_GRAY;
			JOptionPane.showMessageDialog(contentPane, "Player "+n+1+", you win!");

		}
		
	}
	class ButtonListener implements ActionListener {

		// Every time we click the button, it will perform
		// the following action.
		public void actionPerformed(ActionEvent e) {

		    JButton source = (JButton) e.getSource();
		    String currentText = source.getText();
		    int num = Integer.parseInt(currentText);
		    MovePlayerForward(num-1);
		    source.setVisible(false);
		}
	  
	  }
}
