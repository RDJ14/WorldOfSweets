package com.mcteamface.worldofsweets;
import com.mcteamface.worldofsweets.GameTimer;

import static org.junit.Assert.*;
import org.junit.Test;

public class TimerTest {
	@Test
	public void test1() {
		GameTimer gt = new GameTimer();
		assertFalse(gt.load());
	}
	
	@Test
	public void test2() {
		GameTimer gt = new GameTimer();
		assertTrue(gt.save());
	}
}
