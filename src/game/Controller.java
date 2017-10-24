package game;

public class Controller {
	private Board board;
	private View view;
	
	public Controller(Board board, View view) {
		this.board = board;
		this.view = view;
	}
	
	public void tick() {
		board.update();
	}
	
	public void updateView() {
		view.passCharacters(board.getObstacles());
		view.passPlayer(board.getPlayer());
		view.repaint();
	}

}
