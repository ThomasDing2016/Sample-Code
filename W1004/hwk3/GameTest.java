//*************************
//  Test class for Game
//
// ************************

import java.util.Scanner;

public class GameTest{
    
    public static void main (String [] ags){
	int sim=0; // assumes there will not be a simulation
	double strat1=0.01;
	double strat2=0.01;
	Scanner input=new Scanner(System.in);
	System.out.println ("Welcome to the game");
	System.out.println ("Are you human? (yes-1, no-0)");
       	int ans1=input.nextInt();
    	if (ans1==0){	// asks if this a simulation only if player 1 is not human
	    System.out.println("Is this a simulation? (yes-1, no-0)");
	    sim = input.nextInt();
	    if (sim==1){ 
		Simulation s=new Simulation(); // creates instance of class Simulation
		s.simulate(); // simulates games
       	    }	
	}
	if (sim==0){ // if not a simulation
	    int ans2=0;
	    Game g=new Game (ans1, ans2, sim, strat1, strat2);
	    g.run();
	    System.out.println ("Thanks for playing!");
	}
    }
} // end of class


