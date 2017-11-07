package game;
public class Player extends Character {
	int score = 0;
	int health = 10;
	int food = 0;
	
	//JUNIT
	public Player() {
		xloc = Main.frameWidth - 650;
		yloc = 2 * (Main.frameHeight / 5);
		lane = 3;
	}
	//JUNIT
	public int getHealth() {
		return health;
	}
	//JUNIT
	public void eatFood() {
		this.food++;
	}
	//JUNIT
	public void jumpUp() {
		if (lane < 5) {
			lane++;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}
	//JUNIT
	public void jumpDown() {
		if (lane > 1) {
			lane--;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}
	//JUNIT
	public int getXloc() {
		return xloc;
	}
	//JUNIT
	public int getScore() {
		return this.score;
	}
	
	// JUNIT
	public void setScore(int i) {
		this.score = i;
	}
	// JUNIT
	public void changeScore(int value) {
		score += value;
	}
	// JUNIT
	public void takeDamage(int dmg) {
		health +=  dmg;
	}
	//JUNIT
	public String toString() {
		//return "This player has lane:" + this.lane + " Their score is:" + this.score;
		return "This player has lane:" + this.lane + " Their score is:" + this.score + " Player Health:"+this.health;
	}
}
