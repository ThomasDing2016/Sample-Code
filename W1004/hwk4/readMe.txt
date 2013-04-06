The player class has simple methods that allow the player to betm buy in (or they would if I had not run out of time), get the sum of each hand, hit, split (although I also did not have time to fully implement this) and add or subtract money from his account.
The game class has a main method, run, which access all the othe methods of the class. When a game is started, the first thing game will do is add two cards to the hand of each player (this is done within the Dealer class for the dealer, however, since the dealer deals his own cards), and immediately checks if any of the two players have a BlackJack, or twenty one. If so, the appropriate sum of money is added or subtracted from the balance of player 1 only since the dealer does not have a running balance. After checking for blackjack, the game will check to see if either player has busted with their initial sum, and if not, will ask the player if he wants to hit. If the human player has busted, the game will ask him or her if s/he wants to bet again and the game starts with a new hand (but the same balance). The game continues until the human player has busted after hitting, or until the player decides s/he does not want to hit. This is where the dealer comes in, and is allowed to hit continuously until his sum is or exceeds 17. Once this happens, the game will check whether either player or dealer have busted, and if neither has, the player with the highest sum of points is the winner. 
The Card and Deck classes, in turn, are fairly straightforward, with Card only returning its value, suit and face (the things associated with each card), and Deck initializing an orderly deck of cards, and immediately shuffling them before dealing one of them. The card at the top of the deck is dealt every time, and the top of the deck gets smaller, and smaller.

Some considerations: I did not have enough time to implement my split modes, or the doubling down (although the methods for each are there). For splitting, I had planned to change the methods that called upon a hand to make them require arguments (so where checkBJ() wouldn't require anything, I would make it so I fed into it the hand I wanted to use after splitting it using the method found in Player. I had already written the changes I would make to the Game and Player method to implement hand, and for all it's worth, I'll paste them here. With a couple more hours, I think I would have been able to implement it.
Thank you for reading!

Potential Splitting Methods:

changes within Game
------------------

public void splitRun(){
    Card x=d.deal();
    Card y=d.deal();
    p1.addHand1(x);
    p1.addHand2(y);
    checkBJ(hand1);
    checkBJ(hand2);
    checkBust(hand2);
    checkBust(hand2);
    if(again==1)
        hitMe();
}

public void checkBJ(Card[] x){
    p1.getSum(x);
    if(p1.sum==21){
        BJ=true;
        System.out.println("You got a Blackjack!");
        p1.addBJ(currentBet);
        betAgain();
    }
    else if(p1.sum>21){
        System.out.println("You bust!");
        p1.subtractBalance(currentBet);
        betAgain();
    }
    if(!BJ){
        System.out.println("Your points so far are "+ p1.sum);
    }
}

public void checkBust(Card[] x){
    if(Hitme==1){
        p1.getSum(x);
    }
    if ((p1.sum)>21){
        System.out.println("You bust!");
        p1.subtractBalance(currentBet);
        betAgain();
    }
    else if ((p1.sum)<21){
        System.out.println("after checking for bust, you have " + p1.sum + " points");
        hitMe();
    }
}

public void check(Card[] x){
    for (int i=0; i < ((p1.add+p1.i)-2); i++){
        toString(x.[i]);
    }
}

----
Changes to player                                                                                                                                                                                                
Note: In order to change getSum(), I would have changed the indexing (because add would be different for each hand I had split, since it only contains one card already). In order to do so, I would have created a Boolean, to which I would pass the "splitMode" variable from Game. With that Boolean as true, I would have hardcoded add to be 1, so the for loop in getSum() would have looked like: 
   public int getSum(Card[] x){
        sum=0;
if (Boolean=true)
        for (int k=0; k<((1+i)-2); k++){ // "split" indexing
            System.out.println("the k in getSum is "+ k);
            sum=sum+(x[k].getValue());
            System.out.println("The sum before going into softHand is " +sum);
        }
else{
        for (int k=0; k<((add+i)-2); k++){ // normal indexing
            System.out.println("the k in getSum is "+ k);
            sum=sum+(x[k].getValue());
            System.out.println("The sum before going into softHand is " +sum);
        }

public void softHand(Card[] x){
    for (int s=0; s<((add+i)-2); s++)
        if(x[s].ace==true){
            softHand=true;
        }
}

int addSplit=1;

public void addHandSpli (Card x, Card[] y){
    y[addSplit]=x;
    addSplit++;
    System.out.println("the add is " + add);
}

public void Hit(Card x, Card[] y){
    y[i]=x;
    i++;
    checkP();
}
 
