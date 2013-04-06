/** This a computer player, which has a strategy and extends the interface Player
 * It works.
 * Cecilia Reyes • kcr2118
 */

public class ComputerPlayer implements Player {
    private Board pBoard;
    private int playerNumber;
    private int[] move = {9,9};
    
    public ComputerPlayer(int p){
	pBoard = new Board(8,8);
	playerNumber = p;
    }
    
    /** @Override */
    public Location placeTile(boolean retry) {
	if ((move[0]==9)){
	    move[0] = (int)(Math.random()*8);
	    move[1] = (int)(Math.random()*8);
	    while (!pBoard.valid(move[0], move[1], getPlayer())){
		move[0] = (int)(Math.random()*8);
		move[1] = (int)(Math.random()*8);
	    }
	}
	else {
	    System.out.println("blah");
	    move[0] = move[0]+(int)(Math.random()*3);
	    move[1] = move[1]+(int)(Math.random()*3);
	    System.out.println("this is " + move[0] + " " + move[1]);
	    if ((move[0]>=8) || (move[0]< 0))
		move[0] = (int)(Math.random()*8);
	    if ((move[1]>=8) || (move[1]< 0))
                move[1] = (int)(Math.random()*8);	
	    if (!pBoard.valid(move[0], move[1], getPlayer())){
		move[0] = move[0]-(int)(Math.random()*3);
		move[1] = move[1]-(int)(Math.random()*3);
	    }
	}
	Piece myMove = new Piece(move[0], move[1], getPlayer());
	return myMove;
    }
    
    /** @Override */
    public void setResult(Location move) {
	int x = move.getHorizontal();
	int y = move.getVertical();
	nextMove(x,y);
    }
    
    private int[] nextMove(int x, int y){
	System.out.println("going into next move");
	move[0] = x;
	move[1] = y;
	return move;
    }
    
    private int getPlayer(){
	return playerNumber;
    }
}