// *****************
//
// Simulation class 
//
// ******************

public class Simulation{
    
    private int p1Wins, p2Wins, trials;
    private Game g; 
    public double strat1;
    public double strat2; 

    public Simulation(){ // constructor for Simulation, takes no arguments
	strat1=0.01;
	strat2=0.01;
    }
    
    public void simulate (){
	while (strat1 <= 1.0){ // will execute until strategy of player 1 has been incremented to at least 1.0
	    p1Wins=0;	   
	    strat2=0.01;
	    while(strat2 <= 1.0){ // nested while loop will increase strategy of player 2 to 1.0 before incrementing player 1's
		Game g = new Game (0, 0, 1, strat1, strat2); 
		for (int i=0; i<1000; i++){ // each game will have 1000 rounds
		    g.reset(); 
		    g.runSim(); 
		}
		if ((g.p1.getBalance()) > (g.p2.getBalance())){ // checks to see whether the total balance of player 1 is greater than 1
		    p1Wins ++;
		}
		else{
		    p2Wins ++;
		}
		strat2=strat2 + 0.01; //increases strategy of player 2 by 0.01
		if (p1Wins == 99){ // 198 is the number of times strat2 will be increased to 0.005 to become 1.0)
		    System.out.println("This game is unfair, and the optimal strategy for player 1 is " + strat1);
		}
	    } // end of inner while
			
	    strat1=strat1+0.01; // increases strategy of player 1 by 0.01
	} // end of outer while
    } // end of method
} // end of class