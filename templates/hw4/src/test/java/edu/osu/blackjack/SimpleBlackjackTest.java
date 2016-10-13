package edu.osu.blackjack;


import java.util.Random;



import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SimpleBlackjackTest extends TestCase{
	
    
    public static Test suite()
    {
	return new TestSuite( SimpleBlackjackTest.class );
    }

    public void testBasicFunctionality2(){
	Dealer dealer = new Dealer();
	dealer.shuffleDeck();
    }    
    public void testBasicFunctionality(){
	// Does it run without errors for a simple case?
	Dealer dealer = new Dealer();
	Player[] players  = new Player[1];
	players[0] = new Player(){
		@Override
		public int makeBet(){
		    this.currentBet = 1 + ((int)Math.random()*5);
		    return currentBet;
		}
	    };
	SimpleBlackjack j = new SimpleBlackjack(dealer,players);
	j.playRound();

    }
	
	
}
