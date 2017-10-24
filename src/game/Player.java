package game;
public class Player extends Character {
	int score = 0;
	int health = 10;
	int food = 0;
	
	public Player() {
		xloc = Main.frameWidth - 650;
		yloc = 2 * (Main.frameHeight / 5);
		lane = 3;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void eatFood() {
		this.food++;
	}
	
	public void jumpUp() {
		if (lane < 5) {
			lane++;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}
	
	public void jumpDown() {
		if (lane > 1) {
			lane--;
			yloc = Main.frameHeight - (lane * (Main.frameHeight / 5));
		}
	}
	
	public int getXloc() {
		return xloc;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int i) {
		this.score = i;
	}
	
	public void changeScore(int value) {
		score += value;
	}
	
	public void takeDamage(int dmg) {
		health += dmg;
	}
}
