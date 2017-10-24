package game;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	public Player player;
	public int timer;
	private ArrayList<NPC> obstacles;
	private boolean isGameOver;
	
	public Board() {
		player = new Player();
		obstacles = new ArrayList<NPC>();
		isGameOver = false;
		}
	
	public void spawnNPC() {
		Random rand = new Random();
		int x = rand.nextInt(2);
		if (x == 1) {
			obstacles.add(new Garbage());
		}else {
			obstacles.add(new Food());
		}
	}
	
	public void removeNPC(int i) {
		obstacles.remove(i);
	}
	
	public void moveNPCs() {
		ArrayList<NPC> removes = new ArrayList<NPC>();
		for (NPC o : obstacles) {
			o.moveNPC();
			if (o.getXloc() <= 0) {
				removes.add(o);
				continue;
			}
			if ((5-o.getLane() == player.getLane()) &&
				(player.getXloc()-10 < o.getXloc()) && 
						(o.getXloc() < player.getXloc()+10))  {
				player.changeScore(o.getValue());//player hits an NPC and we adjust score
				if (o.getValue() < 0)
					player.takeDamage(o.getValue()/20);//take damage if it was garbage
				removes.add(o);//remove NPC after impact
			}
		}
		obstacles.removeAll(removes);
	}

	public void update() {
		moveNPCs();
		if (player.health <= 0) {
			isGameOver = true;
		}
		Random rand = new Random();
		int x = rand.nextInt(15);
		if (x == 1)
			obstacles.add(new NPC());
	}
	
	public boolean getIsGameOver() {
		return isGameOver;
	}

	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

	public Player getPlayer() {
		return player;
	}
}

