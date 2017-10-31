package game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Board /*implements KeyListener*/{
	public Player player;
	public int timer;
	private ArrayList<NPC> obstacles;
	private boolean isGameOver;
	
	public final static int frameWidth = 700;
	public final static int frameHeight = 500;
	///*
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
	//*/
	
	public Board() {
		player = new Player();
		obstacles = new ArrayList<NPC>();
		isGameOver = false;
	}
	
	public void modelInConsole(int n) {
		if(n==0) {
			player.jumpDown();
			System.out.println("Player has jumped to lane:"+player.getLane());
		}else if(n==1) {
			player.jumpUp();
			System.out.println("Player has jumped to lane:"+player.getLane());
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
				(player.getXloc() < o.getXloc()) && 
						(o.getXloc() < player.getXloc()+50))  {
				System.out.println("Collision");
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
	
	public boolean getIsGameOver() {
		return isGameOver;
	}

	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

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