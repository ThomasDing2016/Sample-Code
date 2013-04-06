//*********
//
// Game class
//
//*********
import java.util.Scanner;

public class Game{
    
    public BlackjackPlayer p1;
    public Dealer p2;
    private Boolean BJ;
    private Boolean splitMode;
    private int valueSum;
    private int currentSum;
    private Deck d;
    private int Hitme;
    private Scanner input;
    private double currentBet;
    public int again;
    public double buyIn;
    public double amt;

    public Game(){
	p1= new BlackjackPlayer(currentBet);
	p2=new Dealer();
	BJ=false;
	again=0;
	buyIn=0;
	amt=0;
	valueSum=0;
        currentSum=0;
	currentBet=0;
	splitMode=false;
        d=new Deck();
	input=new Scanner(System.in);
    }

    public void placeBet(){
	System.out.println("Enter your first bet in decimals (min 10.00, max 1000.00)");
        currentBet=input.nextDouble();
	if((p1.getBalance())<currentBet){
	    System.out.println("You don't have enough money, your balance is " + p1.getBalance() +" Would you like to buy in? yes-1, no-0");
	    buyIn=input.nextDouble();
	    if(buyIn==1){
		System.out.println("How much would you like to buy? You must buy in for at least 100.00");
		amt=input.nextDouble();
		p1.buyIn(amt);
		placeBet();
	    }
	    else if(buyIn==0){
		System.out.println("You must enter a bet to play");
		placeBet();
	    }
	}
	if(currentBet>1000.0){
            System.out.println("Please enter a decimal less than 1000.00");
	    placeBet();
	}
	else if(currentBet<10.0){
	    System.out.println("Please enter a decimal greater than 10.00");
	    placeBet();
	}
    }

    public void run(){
	p1.hand=new Card[6];
	placeBet();
	Card x=d.deal(); 
	Card y=d.deal();
	p1.addHand(x); //adds dealed card to hand
	p1.addHand(y); //and again
	checkBJ(); //checks for BlackJack
	checkBust(); //checks for bust
	if(again==1)
	    hitMe();
    }
    
    public void hitMe(){
	System.out.println("hit? yes-1, no-0");
	Hitme=input.nextInt();
	if(Hitme==1){
	    p1.Hit(d.deal());
	    System.out.println("Would you like to double down your bet? yes-1, no-0");
	    //	    doubleYes=input.nextInt();
	    //  if(doubleYes==1)
	    //	System.out.println("How much would you like to add?");
	    // p1.doubleBet(
	    checkBust();  
	}
	else if(Hitme==0){
	    p2.run();
	    getWinner();
	}
    }
    
    public void checkSplit(Card[] x){
	int yes;
	if(p1.hand[0].getValue()==p1.hand[1].getValue()){
	    System.out.println("Would you like to split your cards? (yes-1, no-0)");
	    yes=input.nextInt();
	    if (yes==1){	   
		p1.split(p1.hand);
		splitMode=true;
	    }
	}
    }

    public void checkBJ(){
	p1.getSum(p1.hand);
	if(p1.sum==21){
	    BJ=true;
	    System.out.println("You got a Blackjack!");
	    p1.addBJ(currentBet);
	    betAgain();
	}
	else if((p1.getSum(p1.hand))>21){
	    System.out.println("You bust!");
            p1.subtractBalance(currentBet);
            betAgain();
	}
	if(!BJ){
	    checkSplit(p1.hand);
	    System.out.println("Your points so far are "+ p1.sum);
	}
    }
    
    public int betAgain(){    
	System.out.println("Do you want to bet again? (yes-1, no-0)");
	again=input.nextInt();
   	if(again==1){
	    p1.reset();
	    p2.reset();
	    run();
	}
	if(again==0){
	}
	return again;
    }
    
    public void checkBust(){
	if(Hitme==1){
	    p1.getSum(p1.hand);
	}
	if ((p1.sum)>21){
	    System.out.println("You bust!");
	    p1.subtractBalance(currentBet);
	    betAgain();
	}
	else if ((p1.sum)<21){
	    hitMe();
	}
    }
    
    public void getWinner(){
	if((p1.sum)==(p2.sum)){
	    System.out.println("It's a push");
	    betAgain();
	}
	else if(((p1.sum)<=21)&&((p2.sum)<21)){ 
	    if ((p1.sum)>(p2.sum)){
		System.out.println("You win!");
		betAgain();
	    }
	    else{
		System.out.println("The dealer wins");
		betAgain();
	    }
	}	
	else if((p2.sum)>21){
	    System.out.println("You win!");
	    betAgain();
	}
	else if ((p1.sum)>21){
	    System.out.println("The dealer wins"); 
	    betAgain();
	}
    }    
    
    public void check(){ //checks the cards in a hand
	for (int i=0; i < ((p1.add+p1.i)-2); i++){
	    toString(p1.hand[i]);
        }
    }
    
    public String toString(Card x){
        System.out.println("Suit: " + x.getSuit() + " Value: " + x.getValue() + " Face: " + x.getFace());
        return "Suit: " + x.getSuit() + " Value: " + x.getValue() + " Face " + x.getFace();
    }
}

