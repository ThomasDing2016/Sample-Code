//**********
// Card class 
//
//**********

public class Card{
    
    public String suit;
    public int value;
    public String face;
    public Boolean ace;

    public Card (String s, int v){       
	suit=s;
	value=v;
	face="";
	ace=false;
    }
    
    public String getSuit(){
	return suit;    
    }
    
    public int getValue(){
	return value;   
    }
    public String getFace(){
	return face;
    }

    public String toString(){
        System.out.println(" Value: " + getValue() + " Face: " + getFace());
        return " Value: " + getValue() + " Face " + getFace();
    }
}

