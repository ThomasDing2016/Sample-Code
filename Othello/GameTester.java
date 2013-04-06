/** This is the Tester class
 *
 * Cecilia Reyes • kcr2118
 */

import java.util.Scanner;

public class GameTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Player p1 = null, p2 = null;
	Scanner in = new Scanner(System.in);
	System.out.println("****** Welcome to Othello! The funnest game ever! ******");
	System.out.println("Computer v Computer enter 1");
	System.out.println("Computer v Human enter 2");
	System.out.println("Human v Human enter 3");
	int choice = in.nextInt();
	in.nextLine();
	
	if(choice==1){
	    p1 = new ComputerPlayer(1);
	    p2 = new ComputerPlayer(2);
	}
	else if(choice == 2 ){
	    p1 = new ComputerPlayer(1);
	    p2 = new HumanPlayer(2);
	}
	else if(choice == 3){
	    p1 = new HumanPlayer(1);
	    p2 = new HumanPlayer(2);
	}
	else{
	    System.out.println("Please choose a number between 1 and 3.");
	    System.exit(1);
	}
	
	Othello mygame = new Othello();
	mygame.initialize(p1, p2);
	mygame.playGame();
	
    }
}

