//*****************
//Game class
//
//*****************

import java.util.Scanner;

public class Game {

    public Player p1; // creates player 1
    public Player p2; // creates player 2
    private int again; 
    private int watch;
    private Scanner input; // input for the user to utilize
    private int playerSum;

    //constructor for Game
    public Game (int type1, int type2, int sim, double strat1, double strat2) { // type (human or not human), sim activates simulation, strategies of each player
	p1 = new Player (type1, sim, strat1);
	p2 = new Player (type2, sim, strat2);
	again=1;
	watch=1;
	input=new Scanner(System.in);
    }
    
    public void run () { // the main command in Game, directs which type of game will be player
	if (p1.isHuman == true){ // Human vs. Computer
	    runHuman();
	}
        else if ((p1.isHuman == false) && (p1.sim!=1)) { // Computer vs. Computer
	    runComp();
	}
    } // end of method
    
    private void runHuman () { // method for Human
	int parity;
	System.out.println ("Which player would you like to be? (odd-1, even-0)"); // asks the user which player s/he would like to be
	parity = input.nextInt(); 
	if (parity == 1){ //if player 1 is odd, and player 2 is not odd (even)
	    p1.odd = true; 
	    p2.odd = false;
	}
	else if (parity == 0){ // if player 1 is not odd (even), player 2 is odd 
	    p1.odd = false;
	    p2.odd = true;
	}
	while (again == 1) { // again will be reset after each iteration, provided the user wants it to keep being 1
	    p1.play (); 
	    p2.play ();
	    playerSum = (p1.getCurrentThrow() + p2.getCurrentThrow()); //gets the sum of each player's throws to be evaluated below
	    if ( p1.odd == true  && playerSum % 2 != 0 ) { 
		p1.addBalance(playerSum); 
		p2.subtractBalance(playerSum); 
	    }                                                        
	    else if (p1.odd == false  && playerSum%2 == 0) {
		p1.addBalance(playerSum);
		p2.subtractBalance(playerSum); 
	    }
	    else if ( p1.odd == true  && playerSum % 2 == 0 ) { 
		p2.addBalance(playerSum);
		p1.subtractBalance(playerSum);
	    }
	    else if (p1.odd == false  && playerSum%2 != 0) { 
		p2.addBalance(playerSum);
		p1.subtractBalance(playerSum);
	    }
	    System.out.println ( "Your round total is now " + p1.getBalance()); 
	    System.out.println ( "The computer's round total is now " + p2.getBalance());
	    playAgain(); 
	    if (again==0) { 
		getWinner();		
	    }
	    while ((again!=1) && (again!=0)) { // is neither 1 nor 0 is inputted, Game asks user to input the right numbers
		System.out.println ("Please enter either a 1 or 0");
		playAgain(); 
	    } // end of while
	} // end of outer while
    } // end of method
    
    private void runComp () { // runs Computer vs. Computer
	if (p1.isHuman==false) { // assigns "odd" to player 1, "not odd" to player 2 when there is no human player.
	    p1.odd=true;
       	    p2.odd=false;
	}
	while (watch==1){ 
	    p1.play();	
	    p2.play();
	    playerSum=(p1.getCurrentThrow() + p2.getCurrentThrow());
	    if (p1.odd==false  && playerSum % 2==0){
		p1.addBalance(playerSum);
		p2.subtractBalance(playerSum);
	    }
	    else if (p1.odd==true && playerSum%2!=0){
		p1.addBalance(playerSum);
		p2.subtractBalance(playerSum);
	    }
	    else if (p1.odd==true  && playerSum % 2==0){
		p2.addBalance(playerSum);
		p1.subtractBalance(playerSum);
	    }
	    else if (p1.odd==false && playerSum%2!=0){
		p2.addBalance(playerSum);
		p1.subtractBalance(playerSum);
	    }
	    System.out.println ( "Computer 1's total is now " + p1.getBalance());
	    System.out.println ( "Computer 2's round total is now " + p2.getBalance());
	    againComp(); 
	    if (watch==0) {
		getWinner();
	    }
	    else if (watch !=1) {
		System.out.println ("Please enter either a 1 or 0");
		againComp();
	    }
	} // end of while loop	    
    } // end of method
    
    public void runSim(){ // runs Computer vs. Computer in simulation mode
	p1.odd = true; 
	p2.odd = false;
	
	p1.play(); 
        p1.play();
	playerSum = (p1.getCurrentThrow() + p2.getCurrentThrow());
	if ( p1.odd==false && playerSum % 2==0){
	    p1.addBalance(playerSum);
	    p2.subtractBalance(playerSum);
	}
	else if (p1.odd==true && playerSum%2!=0){
	    p1.addBalance(playerSum);
	    p2.subtractBalance(playerSum);
	}
	else if (p1.odd==true && playerSum % 2==0){
	    p2.addBalance(playerSum);
	    p1.subtractBalance(playerSum);
	}
	else if (p1.odd==false && playerSum%2!=0){
	    p2.addBalance(playerSum);
	    p1.subtractBalance(playerSum);
	}
    } // plays only one iteration of the game. Also, end of method
    
    public int againComp () { // method to ask the user whether s/he wants to watch again                                                                                             
	System.out.println ("Keep watching? (yes-1, no-0)");
        watch=input.nextInt();
        return watch;
    } // end of method        

    public void reset () { // calls upon the method reset in class Player                                                                                                   
	p1.reset ();
        p2.reset ();
    }

    public int playAgain () { // asks user whether s/he wants to play again                                                                                                           
	System.out.println ( "Play again? (okay- 1, nah-0) ");
        again = input.nextInt();
        return again;
    }
    public void getWinner () { // Will return the winner, judged as whomever has the most money in its balance
	if (p1.getBalance() > p2.getBalance()){
	    if (p1.isHuman==true)
		System.out.println ("You won!");
	    else 
		System.out.println ("The computer won!");
	}
	else {
	    if (p1.isHuman==true)
		System.out.println ("Computer won!"); 
       	    else if (p1.isHuman==false)
		System.out.println ("Computer 2 won!");
	}
    } // end of method
} // end of class
