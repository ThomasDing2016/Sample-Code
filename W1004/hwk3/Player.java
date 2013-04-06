// **************************
// Player class for human/computer game
//
// **************************

import java.util.Scanner;

public class Player {

    public boolean isHuman; 
    public boolean simMode; 
    public Boolean odd; // if odd is false, we also have a value for even
    public int balance; 
    public int currentThrow;
    public double strategy; 
    public int sim;
    private Scanner input; //input for the user to use               
 
    public Player (int human, int sim, double strat) { // instantiates a player with its type and strategy
	if (human==1) {
	    isHuman=true;
	}
        else if (human==0){
	    isHuman=false;
	}	
	if (sim==1){ // activates simMode
	    simMode=true;
	}
	odd=null;
	strategy=strat;
	input=new Scanner(System.in);
	balance=0;
    }

    public void play () { // decides whether player will play a Human or Computer game
	if (isHuman)
	    playHuman ();
	else 
	    playComp (); 
    }

    private void playHuman () { // for human, enter the number you want to play
	System.out.println ("Enter the number you'd like to play (1 or 2)");
	currentThrow=input.nextInt ();
    }

    private void playComp () { // this method lets user either see two computers play each other or activates simulation mode
	if (simMode==false){
	    double n=(Math.random());
	    if (n>=0.5) { // each computers' strategy is hardcoded to 0.5
		currentThrow=2;
		System.out.println("Computer played 2");	    
	    }
	    else {
		currentThrow=1;
		System.out.println("Computer played 1");
	    }
	}
	else { // if this is a simulation, strategy is set by Simulation class
	    double n=(Math.random()); 
	    if (n>=strategy){
		currentThrow=2;
  	    }
	    else{
		currentThrow=1;
	    }
	} // end of outer else
    } // end of method

    public int playAgain () { // ask user if s/he wants to play again and returns value of again                                                                           
        int again=1;
        System.out.println ( "Play again? (okay- 1, nah-0) ");
        again=input.nextInt();
        return again;
    }

    public int getCurrentThrow () { // get current throw from each player                                                                                                           
        return currentThrow;
    }
    
    public int getBalance () { // returns a player's balance
	return balance;
    }
    
    public void reset() { // sets the balance of a player back to 0
	balance=0;
    }
    
    public void addBalance(int x){ // adds desired amount to a player's balance
	balance=balance + x;
    }
    
    public void subtractBalance(int x){ // subtracts desired amount to player's balance
	balance=balance - x;
    }
    
} // end of class
