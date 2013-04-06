//************
//
// A Dealer class, very similar to player
//
//************

public class Dealer{

    public Card[] hand;
    private Deck deck;
    public int sum;
    public int alternateSum;
    public int currentSum;
    private Boolean softHand;
    private Boolean BJ;
    public int add;
    public int i;

    public Dealer(){
        currentSum=0;
	sum=0;
	alternateSum=0;
	add=0;
	i=2;
        softHand=false;
	BJ=false;
	deck=new Deck();
        hand=new Card[6];
    }
    public void run(){
	hand=new Card[6];
	addHand(deck.deal());
        addHand(deck.deal());
	checkDealerBJ();
        if(!BJ){
	    getSum(hand);
            while (sum<17){ // the dealer will hit as long as he is below 17
		addHand(deck.deal());
		getSum(hand);
		checkBust();
	    }
	}
    }

    public void checkBust(){ 
	getSum(hand);
        if ((sum)>21){
            System.out.println("The dealer busts!");
	}
        else if ((sum)<21){
            System.out.println("The dealer did not bust, s/he dealer has " + sum + " points");
	}
    }

    public void checkDealerBJ(){
        getSum(hand);                                                                                                                            
	if(currentSum==21){
            BJ=true;
            System.out.println("The dealer got a Blackjack!");
        }
    }

    public int getSum(Card[] x){
	sum=0;
	for (int k=0; k<((add)-1); k++){
            sum=sum+(x[k].getValue());
	}
        softHand();
        if (!softHand)
            System.out.println("The dealer's points are " + sum);
        else{
            softHandSum();
            alternateSum=sum;
        }
        return sum;
    }
    
    public void softHand(){
        for (int s=0; s<((add)-1); s++)
            if(hand[s].ace==true){
                softHand=true;
            }
    }
    
    public int softHandSum(){
        if(sum>21){
            alternateSum=sum-10;
            System.out.println("The dealer has either "+ sum + " or " + alternateSum);
	    return alternateSum;
	}
	else if(sum==21)
	    alternateSum=sum;
	return alternateSum;
    }
    
    public void addHand (Card x){
        hand[add]=x;
        add++;
    }
    
    public void reset(){
        add=0;
        i=2;
    }
}

   


