package game;


public class Main {
	public final static int frameWidth = 700;
	public final static int frameHeight = 500;
	
	public static void main(String[] args) {
		Board board = new Board();
		View view = new View(700,500, board.getObstacles(), board.getPlayer());
		Controller controller = new Controller(board,view);
		while (!board.getIsGameOver()) {
			controller.tick();
			controller.updateView();
			/*System.out.println(board.player);
			for (NPC n : board.getObstacles()) {
				System.out.println(n);
			}*/
			try {
				Thread.sleep(18);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
