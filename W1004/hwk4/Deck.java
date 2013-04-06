//**********
//
// Deck class
//
//***********

import java.util.Scanner;
import java.util.Random;

public class Deck{
    private Card[] deck;
    private String s;
    public Boolean ace;
    private int value;
    private Random random;
    private int d;
    private int top;

    public Deck(){
	ace=false;
	value=0;
	d=0;
	top=0;
	random=new Random();
	deck=new Card[52];
	for (int i=0; i<4; i++){
	    if (i==0)
                s="Hearts";
            else if(i==1)
                s="Diamonds";
            else if(i==2)
                s="Spades";
            else if(i==3)
                s="Clubs";
   	    for (int j=1; j< 14; j++){
		if(j==1){
		    value=11;
		}
		else if((j==11)||(j==12)||(j==13)){
		    value=10;
		}
		else {
		    value=j;
     		}
		deck[d] = new Card(s,value);
		if (j==1){
		    deck[d].face="Ace";
		    deck[d].ace=true;
		}
		else if (j==11)
		    deck[d].face="Jack";
		else if (j==12)
		    deck[d].face="Queens";
		else if (j==13)
		    deck[d].face="King";
		d++;
	    }
	}
	shuffle();
    }
    
    public void shuffle(){
	for(int i=0; i<51; i++){ 
	    int rand=random.nextInt(51);
	    Card temp=deck[i];
	    deck[i]=deck[rand];
	    deck[rand]=temp;
	    top=0;
	}
    }

    public Card deal(){
	Card dealt=deck[top];
	if (top<40){
       	    dealt=deck[top];
	    top++;
	}
	else if (top==40){
	    shuffle();
	    deal();
	}
	return dealt;
    }
    

    public void check(){
	for (int i=0; i < 52; i++){
	    toString(deck[i]);
	}
    }

    public String toString(Card x){
	System.out.println("Suit: " + x.getSuit() + " Value: " + x.getValue() + " Face: " + x.getFace());
	return "Suit: " + x.getSuit() + " Value: " + x.getValue() + " Face " + x.getFace();
    }
}




