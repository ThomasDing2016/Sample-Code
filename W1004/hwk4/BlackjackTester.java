import java.util.Scanner;

public class BlackjackTester{
    public static void main (String [] args){
	Scanner input=new Scanner(System.in);
	System.out.println("Welcome to Blackjack!");
	Game g=new Game();
	g.run();
	System.out.println("Thanks for playing");
    }
}
  
