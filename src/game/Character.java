package game;

/**
 * @author ericallen     
 *
 */
public class Character {
	int xloc;
	int yloc;
	int lane;
	/**
	 * Character constructor.
	 */
	public Character(){	
	}
	
	//JUNIT
	/**
	 * get lane position
	 * @return lane
	 */
	public int getLane() {
		return this.lane;
	}
	//JUNIT
	/**
	 * set x location
	 * @param xloc
	 */
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}
	//JUNIT
	/**
	 * set y location
	 * @param yloc
	 */
	public void setYloc(int yloc) {
		this.yloc = yloc;
		
	}	
	//JUNIT
	/**
	 * get x location
	 * @return xloc
	 */
	public int getXloc() {
		return this.xloc;
	}
	//JUNIT
	/**
	 * get's y location
	 * @return yloc
	 */
	public int getYloc() {
		return this.yloc;
	}
	/**
	 * It moves
	 */
	public void Move() {
	}
}
