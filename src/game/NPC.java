package game;

import java.util.Random;

public class NPC extends Character {
	int image;
	int[] imagetype = {1,2,3,4,5};
	int value;
	boolean isGarbage;
	
	public NPC() {
		image = imagetype[(int) (Math.random()*5)];
		Random random = new Random();
		isGarbage = random.nextBoolean();
		value = 100;
		if (isGarbage)
			value = -100;
		lane = (int) (Math.random()*5);
		yloc = lane * (Main.frameHeight / 5);
		xloc = 600;
	}
	
	public void moveNPC() {
		xloc--;
	}
	
	public boolean getIsGarbage() {
		return isGarbage;
	}

	public int getValue() {
		return value;
	}
	
	public int getXloc() {
		return xloc;
	}
}
