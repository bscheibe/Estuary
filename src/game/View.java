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

public class View extends JFrame{
	private static final long serialVersionUID = 1L;
	private GamePanel panel;
	private ArrayList<NPC> obstacles;
	private Player player;
	public static BufferedImage testImage;
	
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

	protected void paintCoponent(Graphics g){
		super.paintComponents(g);	
		
		
	}
	public void passCharacters(ArrayList<game.NPC> obstacles) {
		this.setObstacles(obstacles);
	}

	public void redraw() {
		
	}

	public void passPlayer(Player player) {
		this.setPlayer(player);
	}

	public ArrayList<NPC> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<NPC> obstacles) {
		this.obstacles = obstacles;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}

class GamePanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 1L;
	ArrayList<game.NPC> obstacles;
	Player player;
	int[] lanes;
	int lanesTall;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (game.NPC o : obstacles){
			if (o.getIsGarbage()) {
				g.setColor(Color.yellow);
				g.drawRect(o.getXloc(), o.getYloc(), 10, 10);
			} else {
				g.setColor(Color.blue);
				g.drawRect(o.getXloc(), o.getYloc(), 10, 10);
			}
		}
		g.setColor(Color.red);
		g.drawRect(player.getXloc(), player.getYloc(), 10, 10);
		g.setColor(Color.BLACK);
		g.drawString("" + player.getScore(), 50, 50);
		g.drawString("" + player.getHealth(), 50, 70);
		}
	
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	@Override
	public void keyPressed(KeyEvent key) {
		int keyCode = key.getKeyCode();
		if (KeyEvent.VK_UP == keyCode)
			player.jumpUp();
		if (KeyEvent.VK_DOWN == keyCode)
			player.jumpDown();
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		return;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		return;
	}
}
