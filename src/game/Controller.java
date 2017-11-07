package game;
/**
 *  @author Bruce
 *  The controller class of our mvc, holds Board
 *	and View objects. Updates the board with the
 *	tick() method, and passes the board to the
 *	view so it can draw the list of characters.
 */
public class Controller {
	private Board board;
	private View view;
	/**
	 * Takes in a given board and view and
	 * initiates the controller.
	 * @param board
	 * @param view
	 */
	public Controller(Board board, View view) {
		this.board = board;
		this.view = view;
	}
	/**
	 * Calls the update() method in board.
	 */
	public void tick() {
		board.update();
	}
	/**
	 * Passes the list of obstacles, and player
	 * locations to the view, then tells the view
	 * to repaint.
	 */
	public void updateView() {
		view.passCharacters(board.getObstacles());
		view.passPlayer(board.getPlayer());
		view.repaint();
	}

}
