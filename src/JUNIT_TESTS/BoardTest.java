package JUNIT_TESTS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import game.Board;
import game.NPC;


public class BoardTest {
	// NOT TESTED: Update
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
		ArrayList<String> a1 = new ArrayList<String>(); // empty arraylist
		b1.getObstacles();
		//System.out.println(b1.getObstacles());
		assertEquals("No obstacles have been created yet",a1,b1.getObstacles());
		NPC n = new NPC();
		NPC n2 = new NPC();
		n.setXloc(1);
		n2.setXloc(1);

		b1.obstacles.add(n);
		b1.obstacles.add(n2);
		assertEquals("Obstacles have been removed",2,b1.getObstacles().size());

	}
	@Test
	public void testMoveNPCs(){
		Board b1 = new Board();

		
		NPC n = new NPC();
		NPC n2 = new NPC();
		n.setXloc(1);
		n2.setXloc(1);

		b1.obstacles.add(n);
		b1.obstacles.add(n2);

		//System.out.println(b1.obstacles.size());

		b1.moveNPCs();
		
		//System.out.println(b1.obstacles.size());
		assertEquals("Obstacles have been removed",0,b1.getObstacles().size());
		assertNotEquals("Obstacles have been removed",2,b1.getObstacles().size());

	}
	@Test
	public void testRemoveNPC(){
		Board b1 = new Board();
		
		NPC n = new NPC();
		NPC n2 = new NPC();
		n.setXloc(1);
		n2.setXloc(1);

		b1.obstacles.add(n);
		b1.obstacles.add(n2);
		//System.out.println("-------Original-----------");

		//System.out.println(b1.obstacles);
		//System.out.println(b1.obstacles.size());

		b1.removeNPC(1);
		//System.out.println("-------Remove 1-----------");

		//System.out.println(b1.obstacles);
		//System.out.println(b1.obstacles.size());
		
		assertEquals("1 of the 2 Obstacles have been removed",1,b1.getObstacles().size());
		assertNotEquals("None were removed",2,b1.getObstacles().size());
		assertNotEquals("ALL were removed",2,b1.getObstacles().size());
		
		//System.out.println("-------Remove 2 (empty)-----------");

		b1.removeNPC(0);
		//System.out.println(b1.obstacles);

		//System.out.println(b1.obstacles.size());
		
		assertEquals("Obstacles have been removed",0,b1.getObstacles().size());
		assertNotEquals("Obstacles have been removed",1,b1.getObstacles().size());
		//System.out.println("------- Add 2 More -----------");

		NPC n1 = new NPC();
		NPC n3 = new NPC();
		n1.setXloc(1);
		n3.setXloc(1);

		b1.obstacles.add(n1);
		b1.obstacles.add(n3);
		//System.out.println(b1.obstacles);

		//System.out.println("-------N3-----------");

		ArrayList<String> a1 = new ArrayList<String>();
		a1.add(n3.toString());
		//System.out.print(a1);
		//System.out.println("");
		//System.out.println("-------Remove 1-----------");

		b1.removeNPC(0);
		//System.out.println(b1.obstacles);
		assertEquals("make sure the right obstacle remains",a1.toString(),b1.getObstacles().toString());


		
	}
	@Test
	public void testModelInConsole() {
		Board b1 = new Board();	
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",2,b1.getPlayer().getLane());
		b1.modelInConsole(1);
		assertEquals("Check out string comparison",3,b1.getPlayer().getLane());
		b1.modelInConsole(1);
		assertEquals("Check out string comparison",4,b1.getPlayer().getLane());
		b1.modelInConsole(1);
		assertEquals("Check out string comparison",5,b1.getPlayer().getLane());
		b1.modelInConsole(1);
		assertEquals("Check out string comparison",5,b1.getPlayer().getLane());
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",4,b1.getPlayer().getLane());
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",3,b1.getPlayer().getLane());
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",2,b1.getPlayer().getLane());
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",1,b1.getPlayer().getLane());
		b1.modelInConsole(0);
		assertEquals("Check out string comparison",1,b1.getPlayer().getLane());
	}
}
