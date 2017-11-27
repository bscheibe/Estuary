package game;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Board /*implements KeyListener*/{
	public Player player;
	public static int timer;
	public ArrayList<NPC> obstacles; //ERIC Changed from Private to Public
	public boolean isGameOver; // ERIC Changed from private to Public
	
	public final static int frameWidth = 700;
	public final static int frameHeight = 500;
	/*
	public static void main(String[] args) {
		Board board = new Board();
		while (!board.getIsGameOver()) {
			Random rand = new Random();
			int n = rand.nextInt(300);
			board.modelInConsole(n);
			board.update();
			try {
				Thread.sleep(18);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Game over!");
	}
	*/
	
	public Board() {
		timer=0;
		player = new Player();
		obstacles = new ArrayList<NPC>();
		isGameOver = false;
	}
	
	//JUNIT
	public void modelInConsole(int n) {
		if(n==0) {
			player.jumpDown();
			System.out.println("Player is moving with a velocity of "+player.getVerticalVelocity());
		}else if(n==1) {
			player.jumpUp();
			System.out.println("Player is moving with a velocity of "+player.getVerticalVelocity());
		}
		
	}
	
	//JUNIT
	public void removeNPC(int i) {
		obstacles.remove(i);
	}
	
	//JUNIT
	public void moveNPCs() {
		ArrayList<NPC> removes = new ArrayList<NPC>();
		for (NPC o : obstacles) {
			o.moveNPC();
			if (o.getXloc() <= 0) {
				removes.add(o);
				continue;
			}
			if ((o.getYloc() < player.getYloc()+50) &&
					(o.getYloc() > player.getYloc()-50) &&
				(player.getXloc() < o.getXloc()) && 
						(o.getXloc() < player.getXloc()+50))  {
				System.out.println("Collision value:" + o.getValue() + " (+100 means food, -100 means garbage).");
				player.changeScore(o.getValue());//player hits an NPC and we adjust score
				if (o.getValue() < 0)
					player.takeDamage(o.getValue()/20);//take damage if it was garbage
				removes.add(o);//remove NPC after impact
				System.out.println(player);
			}
		}
		obstacles.removeAll(removes);
	}

	public void update() {
		timer++;
		player.updateMovement();
		Random rand = new Random();
		boolean isThereSpace = true;
		moveNPCs();
		if (player.health <= 0) {
			isGameOver = true;
		}
		NPC newNpc = new NPC();
		for (NPC o : obstacles) {
			if ((o.getLane() == newNpc.getLane()) && (o.getXloc() > Main.frameWidth-350)){
				isThereSpace = false;
			}
		}
		int x = rand.nextInt(25);
		if (x == 1 && isThereSpace) {
			obstacles.add(newNpc);
		}
	}
	
	//JUNIT
	public boolean getIsGameOver() {
		return isGameOver;
	}

	//JUNIT
	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

	//JUNIT
	public Player getPlayer() {
		return player;
	}
		
/*
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			player.jumpUp();
		if (KeyEvent.VK_DOWN == keyCode)
			player.jumpDown();
		System.out.println("Moved to: " + player.getLane());
	}
		*/
}

/*class GameBoard implements KeyListener{
	Board board = new Board();

	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			board.player.jumpUp();
		if (KeyEvent.VK_DOWN == keyCode)
			board.player.jumpDown();
		System.out.println("Moved to: " + board.player.getLane());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}

*/