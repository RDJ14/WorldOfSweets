import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void test1() {
		GameBoard g = new GameBoard(0);
		assert(g.p==0);

	}
	@Test
	public void test2() {
		GameBoard g = new GameBoard(-1);
		assert(g.p==-1);

	}
	@Test
	public void test3() {
		GameBoard g = new GameBoard(-2);
		assert(g.p==-2);

	}
	@Test
	public void test4() {
		GameBoard g = new GameBoard(-100);
		assert(g.p==-100);

	}
}
