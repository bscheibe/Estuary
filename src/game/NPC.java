package game;


import java.util.Random;

public class NPC extends Character {
	int image;
	int[] imagetype = {1,2,3,4,5};
	int value;
	boolean isGarbage;
	int speed;
	
	public NPC() {
		image = imagetype[(int) (Math.random()*5)];
		Random random = new Random();
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
	public void moveNPC() {
		xloc -= speed;
	}
	
	//JUNIT
	public boolean getIsGarbage() {
		return isGarbage;
	}

	//JUNIT
	public int getValue() {
		return value;
	}
	
	//JUNIT
	public int getXloc() {
		return xloc;
	}
	
	//JUNIT
	public String toString() {
		if(this.value == 100) {
			return "This food has lane:" + this.lane+ " It's xloc is:"+this.xloc;
		}else {
			return "This garbage has lane:" + this.lane + " It's xloc is:"+this.xloc;
		}
	}
	
	
}
