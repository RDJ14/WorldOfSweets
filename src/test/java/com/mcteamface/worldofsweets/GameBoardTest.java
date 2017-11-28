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

	@Test
	public void test5() {
		GameBoard g = new GameBoard(2);
		assert(g.cookieSpot!=g.licoriceSpot);
	}
	@Test
	public void test6() {
		GameBoard g = new GameBoard(2);
		assert(g.cookieSpot!=g.icecreamSpot);
	}
	@Test
	public void test7() {
		GameBoard g = new GameBoard(2);
		assert(g.cookieSpot!=g.mintSpot);
	}
	@Test
	public void test8() {
		GameBoard g = new GameBoard(2);
		assert(g.cookieSpot!=g.chocolateSpot);
	}
	@Test
	public void test9() {
		GameBoard g = new GameBoard(2);
		assert(g.mintSpot!=g.licoriceSpot);
	}
	@Test
	public void test10() {
		GameBoard g = new GameBoard(2);
		assert(g.cookieSpot!=g.licoriceSpot);
	}
	@Test
	public void test11() {
		GameBoard g = new GameBoard(2);
		assert(g.chocolateSpot!=g.licoriceSpot);
	}
	@Test
	public void test12() {
		GameBoard g = new GameBoard(2);
		assert(g.icecreamSpot!=g.licoriceSpot);
	}

}
