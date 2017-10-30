package com.mcteamface.worldofsweets;
import com.mcteamface.worldofsweets.GameBoard;
import com.mcteamface.worldofsweets.Deck;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void test1() {
		GameBoard g = new GameBoard(1);
		assert(g.p == 1);
	}
	@Test
	public void test2() {
		GameBoard g = new GameBoard(2);
		assert(g.p == 2);
	}
	@Test
	public void test3() {
		GameBoard g = new GameBoard(3);
		assert(g.p == 3);
	}
	@Test
	public void test4() {
		GameBoard g = new GameBoard(4);
		assert(g.p == 4);
	}



}
