package JUNIT_TESTS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.Board;

public class BoardTest {
	
	@Test
	public void testGameIsOver(){
		Board b1 = new Board();
		if(b1.isGameOver == true){
			assertEquals("Time should read 5",true,b1.getIsGameOver());
		}
		else
			assertEquals("Time should read 5",false,b1.getIsGameOver());

	}

}
