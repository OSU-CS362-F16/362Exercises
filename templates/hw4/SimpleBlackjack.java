package edu.osu.blackjack;

public class SimpleBlackjack {

	private int numPlayers;

	public SimpleBlackjack(){
		this.numPlayers = 1;
	}
	
	public void play(){
		BlackjackStateMachine bsm = new BlackjackStateMachine(this.numPlayers);
		
		while(!bsm.getBlackjackState().isAnyoneBroke()){
			bsm.dealInitialHands();
			bsm.bet(0, 10);
			bsm.hit(0);
			bsm.stand(0);
			
		}

	}
}
