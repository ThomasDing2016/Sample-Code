//***********
//
// A player class
//
//************

public class BlackjackPlayer{
    
    private double balance;
    public Card[] hand;
    private double bet;
    private Deck deck;
    public Card[] hand1; 
    public Card[] hand2;
    public int alternateSum;
    public int currentSum;
    public int sum;
    private Boolean softHand;
    public int add;
    public int i;

    public BlackjackPlayer(double amt){
	currentSum=0;
	sum=0;
	i=2; //indexing begins at 2 because anything added as a hit will be in array position 2
	balance=amt;
	bet=0;
	add=0; // indexing begins at 0, the first location of the deck
	softHand=false;
	deck=new Deck();
	hand=new Card[6];
	hand1=new Card[6];
	hand2=new Card[6];
    }

    public void Bet(double newBet){
	bet=bet+newBet;
    }

    public void buyIn(double x){
	balance=balance+x;
    }

    public double getBalance(){
	return balance;
    }
    
    public int getSum(Card[] x){ //gets the sum in the hand
	sum=0;
	for (int k=0; k<((add+i)-2); k++){ // the indexing accounts only for cards within hand that have been initialized
	    sum=sum+(x[k].getValue());
	}
	softHand();	
	//	if (!softHand)
	//  System.out.println("your hand does not contain an ace");
	if(softHand){
	    softHandSum();
	}
	return sum;
    }
   
    public void softHand(){ //checks whether the hand contains an ace
	for (int s=0; s<((add+i)-2); s++)
	    if(hand[s].ace==true){
		softHand=true;
	    }
    }
    
    public int softHandSum(){ 
	if(sum>21){
	    alternateSum=sum-10; //only changes the value of ace, or sum, if the present sum is above 21.
	    System.out.println("You have either "+ sum + " or " + alternateSum);
	    sum=alternateSum;
	}
	else if(sum==21)
	    alternateSum=sum;;
	return sum;
    }

    // public void doubleBet(double bet){
	//	currentBet=currentBet*2;
    // }
    
    public void addBJ(double bet){ //adds the winnings of getting a BlackJack
	double BJbet=bet*1.5;
	addBalance(BJbet);
    }
    
    public void subtractBJ(double bet){
	double BJbet=bet*1.5;
	subtractBalance(BJbet);
    }
    
    public void addBalance(double x){ //add to balance
	balance=balance+x;
    }

    public void subtractBalance(double x){ //subtract balance
	balance=balance-x;
    }
    
    public void addHand (Card x){
	hand[add]=x;    
	add++;
    }

    public void reset(){
	add=0;
	i=2;
	currentSum=0;
    }

    public void Hit(Card x){
	hand[i]=x;
	i++;
	checkP();
    }
    
    public void split(Card[] x){
	hand1[0]=hand[0];
	hand2[0]=hand[1];
    }
    
    public void checkP(){ // check method, returns whatever is inside hand
	for (int j=0; j < (add+i)-2; j++){
	    toString(hand[j]);
	}
    }
    
    public String toString(Card x){
	System.out.println("In player, the hand contains: " + x.getSuit() + " Value: " + x.getValue() + " Face: " + x .getFace());
	  return "Suit: " + x.getSuit() + " Value: " + x.getValue() + " Face " + x.getFace();
    }
    
}



