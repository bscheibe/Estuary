package game;


import java.util.Random;

/**
 * @author Chris N
 *
 */
public class NPC extends Character {
	int image;
	int[] imagetype = {1,2,3,4,5};
	int value;
	boolean isGarbage;
	int speed;
	
	/**Constructor for NPC
	 * sets a random imagetype
	 * sets the boolean isGarbage randomly
	 * sets the speed randomly between 2 and 4
	 * sets the value to 100 or -100 depending on isGarbage
	 * sets a random lane between 1-5
	 * sets yloc dependant on the lane
	 * sets xloc to 600
	 */
	public NPC() {;
		Random random = new Random();
		image = random.nextInt(2);
		isGarbage = random.nextBoolean();
		speed = 2 + random.nextInt(2);
		value = 100;
		if (isGarbage)
			value = -100;
		lane = (int) (Math.random()*5);
		yloc = lane * (Main.frameHeight / 5);
		xloc = 600;
	}
	
	//JUNIT
	/**Moves the NPC to the left by speed pixels
	 * 
	 */
	public void moveNPC() {
		xloc -= speed;
	}
	
	//JUNIT
	/**
	 * @return isGarbage, a boolean depending on the type of the NPC
	 */
	public boolean getIsGarbage() {
		return isGarbage;
	}

	//JUNIT
	/**
	 * @return value, the points value of the npc
	 */
	public int getValue() {
		return value;
	}
	
	//JUNIT
	/* (non-Javadoc)
	 * @see game.Character#getXloc()
	 */
	public int getXloc() {
		return xloc;
	}
	
	//JUNIT
	/** toString method for any NPC
	 * @return String describing the NPC and its location depending on if it is garbage or food
	 *  
	 */
	public String toString() {
		if(this.value == 100) {
			return "This food has lane:" + this.lane+ " It's xloc is:"+this.xloc;
		}else {
			return "This garbage has lane:" + this.lane + " It's xloc is:"+this.xloc;
		}
	}
	
	
}
