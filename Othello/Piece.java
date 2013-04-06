/** This is the Piece class
 *
 * Cecilia Reyes • kcr2118
 */

public class Piece implements Location{

    private int horizontal, vertical, player;
   
    public Piece(int x, int y, int p){
	this.horizontal = x;
	this.vertical = y;
	this.player = p;
    }
    
    /** @Override */
    public int getHorizontal() {
	return horizontal;
    }

    /** @Override */
    public int getVertical() {
	return vertical;
    }
 
    public int getPlayer(){
	return player;
    }

    public String toString() {
	return "horizontal: " + horizontal + ", vertical: " + vertical;
    }
}