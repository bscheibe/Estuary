package game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ericallen
 *
 */

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private ArrayList<NPC> obstacles;
	private Player player;
	public static BufferedImage testImage;
	
	/**
	 * @param width
	 * @param height
	 * @param obstacles
	 * @param player
	 */
	public View(int width, int height, ArrayList<NPC> obstacles, Player player){
//		try {
//			testImage = ImageIO.read(new File("resources/think.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		this.setObstacles(obstacles);
	    panel = new GamePanel();
	    panel.obstacles = obstacles;
	    panel.player = player;
	    panel.addKeyListener(panel);
	    getContentPane().add(panel);
	    setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
	    panel.setPreferredSize(new Dimension(width,height));
//	    panel.addMouseMotionListener((KeyListener) this);
	    panel.setOpaque(true);
	    pack();
	    setVisible(true);
	}
	
	/**
	 *  Lets UI delegate paint first, which includes background
	 *  filling since the component is square
	 * @param g
	 */
	protected void paintComponent(Graphics g){
		super.paintComponents(g);	
		
	}
	
	
	/**
	 * Handle the key-released event from the text field.
	 */
	/**
	 * @param obstacles
	 */
	public void passCharacters(ArrayList<game.NPC> obstacles) {
		this.setObstacles(obstacles);
	}

	/**
	 * This redraws all the views once an object is added or deleted, the layer
	 * is modified or object display attributes.
	 */

	/**
	 * redraw view
	 */
	public void redraw() {
		
	}

	/**
	 * @param player
	 */
	public void passPlayer(Player player) {
		this.setPlayer(player);
	}

	/**
	 * Retrieves the obstacles
	 */
	/**
	 * @return obstacles
	 */
	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

	/**
	 * Places and updates the obstacles onto the map for render
	 */
	/**
	 * @param obstacles
	 */
	public void setObstacles(ArrayList<NPC> obstacles) {
		this.obstacles = obstacles;
	}

	/**
	 * Retrieves the player
	 */
	
	/**
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Places and updates the player onto the map for render
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}

/**
 * @author ericallen
 *
 */
class GamePanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	ArrayList<game.NPC> obstacles;
	Player player;
	int[] lanes;
	int lanesTall;
	

	/**
	 *  Lets UI delegate paint first, which includes background
	 *  filling since the component is square
	 */
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (game.NPC o : obstacles){
			if (o.getIsGarbage()) {
				g.setColor(Color.green);
				g.drawRect(o.getXloc(), o.getYloc(), 50, 50);
			} else {
				g.setColor(Color.blue);
				g.drawRect(o.getXloc(), o.getYloc(), 50, 50);
			}
		}
		g.setColor(Color.red);
		g.drawRect(player.getXloc(), player.getYloc(), 50, 50);
		g.setColor(Color.BLACK);
		g.drawString("" + player.getScore(), 50, 50);
		g.drawString("" + player.getHealth(), 50, 70);
		}
	
	/**
	 * Told the panel that it was updated, and is required.
	 */

	public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	

	@Override
	/**
	 * Handles the key-pressed event from the text field. Once a key is pressed, either up or down, the player will move accordingly in that direction. Prints out "Player has jumped to land, once a key is pressed.
	 */
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			player.jumpUp();
		if (KeyEvent.VK_DOWN == keyCode)
			player.jumpDown();
		System.out.println("Player has jumped to lane:"+player.getLane());
		repaint();
	}

	@Override
	/**
	 * Handle the key-released event from the text field.
	 */
	public void keyReleased(KeyEvent e) {
		return;
	}



	@Override
	/**
	 * Handles the key typed event from the text field. 
	 */
	public void keyTyped(KeyEvent e) {
		return;
	}
}
