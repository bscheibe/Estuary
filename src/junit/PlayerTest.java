package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Player;

public class PlayerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHealthPass() {
		Player p1 = new Player();
		assertEquals("My health is 10",10,p1.getHealth());
	}
	
	@Test
	public void testEatFoodPass() {
		Player p1 = new Player();
		p1.eatFood();
		//assertEquals("I have 1 food",1,p1.getfood());   needs a getter/setter
	}
	
	@Test
	public void testEatFoodFail() {
		Player p1 = new Player();
		p1.eatFood();
		p1.eatFood();
		//assertNotEquals("I do not have 1 food, I have 2",1,p1.getfood());   needs a getter/setter
	}

}
