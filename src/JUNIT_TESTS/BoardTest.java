package JUNIT_TESTS;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.NPC;
import game.Player;
import game.Character;
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
	
	@Test
	public void testPlayer(){
		Board b1 = new Board();
		b1.getPlayer();
		assertEquals("Player To String at the start","This player has lane:3 Their score is:0 Player Health:10",b1.getPlayer().toString());
	}
	@Test
	public void testGetObstacles(){
		//ArrayList<NPC> getObstacles() {
		Board b1 = new Board();
		ArrayList a1 = new ArrayList<NPC>(); // empty arraylist
		b1.getObstacles();
		System.out.println(b1.getObstacles());
		
		assertEquals("No obstacles have been created yet",a1,b1.getObstacles());

	}

}
