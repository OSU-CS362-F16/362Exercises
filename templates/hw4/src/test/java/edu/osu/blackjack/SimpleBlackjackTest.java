package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class SimpleBlackjackTest {
    @Test
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
