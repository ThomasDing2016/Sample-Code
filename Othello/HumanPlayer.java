/** This the Human player class, there will also be a computer player
 * it implements the Player interface 
 * Cecilia Reyes • kc2118
 */

import java.util.Scanner;

public class HumanPlayer implements Player{

    private Board pBoard;
    private int horizontal, vertical, playerNumber;
    private Scanner input = new Scanner(System.in);

    public HumanPlayer(int p){
	horizontal = 0;
	vertical = 0;
	playerNumber = p;
	pBoard = new Board (8,8);
    }
 
   /** @Override */
    public Location placeTile(boolean retry) {
	/** get the tile's coordinates from the user */
	String entered;
	System.out.println("please enter the x coordinate of your piece");
	entered = input.nextLine();
	int x = Integer.parseInt(entered);
	System.out.println("please enter the y coordinate for your piece");
	entered = input.nextLine();
	int y = Integer.parseInt(entered);
	/**	System.out.println("please enter the number of player you are");
	entered = input.nextLine();
	int p = Integer.parseInt(entered); */
        Location move = new Piece (x, y, getPlayer());
	return move;
    }

    /** @Override */
    public void setResult(Location move) {
	if (getPlayer()==1)
	    pBoard.setTile(move.getHorizontal(), move.getVertical(), 2);
	else if (getPlayer()==2)
	    pBoard.setTile(move.getHorizontal(), move.getVertical(), 1);
    }

    private int getPlayer(){
	return playerNumber;
    }
}