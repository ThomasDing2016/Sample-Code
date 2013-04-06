/** This is the Othello class, which will referee the game
 * It implements the Location class
 * Cecilia Reyes œôó¢ kcr2118
 */
import java.util.Scanner;

public class Othello implements Game {
    Player p1 = null, p2 = null;
    Board b = new Board (SIZE, SIZE);

    /** @Override */
    public void initialize(Player p1, Player p2) {
	this.p1 = p1;
	this.p2 = p2;
    }

    /** @Override */
    public Player playGame(){
	boolean retry = true;
	while (retry){
	    System.out.println(b.toString());
	    Location myMove = p1.placeTile(retry);
	    System.out.println("L1: " + myMove.getHorizontal() + " , " + myMove.getVertical());
	    if (b.fullBoard()){
		getWinner();
		retry = false;
	    }
	    if (b.valid(myMove.getHorizontal(), myMove.getVertical(), 1)){
		b.setTile(myMove.getHorizontal(), myMove.getVertical(), 1);
		p2.setResult (myMove);
	    }
	 
	    System.out.println(b.toString());
	    myMove = p2.placeTile(retry);
	    System.out.println("L2: " + myMove.getHorizontal() + " , " + myMove.getVertical());
	    if (b.fullBoard()){
		getWinner();
		retry = false;
	    }
	    if (b.valid(myMove.getHorizontal(), myMove.getVertical(), 2)){
		b.setTile(myMove.getHorizontal(), myMove.getVertical(), 2);
		retry = true;
		p1.setResult (myMove);
	    }
	}
	System.out.println(b.toString());
	getWinner();
	return getWinner();
    }
    
    private Player getWinner(){
	if (b.countWhiteTiles() > b.countBlackTiles()){ 
	    /** player1 wins */
	    System.out.println("Player 1 wins!");
	    return p1;
	}
	else if (b.countWhiteTiles() < b.countBlackTiles()){
	    /** player2 wins */
	    System.out.println("Player 2 wins!");
	    return p2;
	}
	else {
	    return null;
	}
    }
}
