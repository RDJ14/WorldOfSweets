import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ButtonsTest {
/*
 * Presses each button, and asserts that the appropriate number of players
 * are selected as a result
 */
	@Test
	void button1Test() {
		Buttons testButtons = new Buttons();
		testButtons.b1.doClick();
		assert(testButtons.numPlayers==2);
	}
	@Test
	void button2Test() {
		Buttons testButtons= new Buttons();
		testButtons.b2.doClick();
		assert(testButtons.numPlayers==3);
	}@Test
	void button3Test() {
		Buttons testButtons = new Buttons();
		testButtons.b3.doClick();
		assert(testButtons.numPlayers==4);
	}
/*
 * Asserts that, after a button press, the message displayed to the player is the appropriate one
 */
	@Test
	void wordDisplayTestb1() {
		Buttons testButtons = new Buttons();
		testButtons.b1.doClick();
		System.out.println(testButtons.playerMessage.getText());
		assert(testButtons.playerMessage.getText().equals("Playing with 2 players"));
	}
	@Test
	void wordDisplayTestb2() {
		Buttons testButtons = new Buttons();
		testButtons.b2.doClick();
		System.out.println(testButtons.playerMessage.getText());
		assert(testButtons.playerMessage.getText().equals("Playing with 3 players"));
	}
	@Test
	void wordDisplayTestb3() {
		Buttons testButtons = new Buttons();
		testButtons.b3.doClick();
		System.out.println(testButtons.playerMessage.getText());
		assert(testButtons.playerMessage.getText().equals("Playing with 4 players"));
	}
}
