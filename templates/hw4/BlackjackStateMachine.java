package edu.osu.blackjack;

import java.util.*;

public class BlackjackStateMachine {
	BlackjackState cs;

	public BlackjackStateMachine(int nplayers){
		cs = new BlackjackState();

		for(int i=0;i<nplayers;i++)
			cs.playerState.add(new PlayerState());
	}
	
	public BlackjackState getBlackjackState() {
		return cs;
	}

	
	// Player 
	public void bet(int id, int amount) {
		PlayerState ps = cs.getPlayer(id);
		ps.moveMoneyToBet(amount);

		transitionPhase();
	}
	

	// dealer
	public void dealInitialHands(){
		
		for(int i =0;i<cs.playerState.size();i++){
			PlayerState s = cs.getPlayer(i);
			
	//		if(s.currentHand.size()>0) 
	//			throw new RuntimeException("Invalid state - player " + i + " has cards");
		}
		
		for(int cards = 0;cards<2;cards++){
			cs.dealerHand.add(dealCard(cards%2==1));
			
			for(int i =0;i<cs.playerState.size();i++){
				PlayerState s = cs.getPlayer(i);
				s.currentHand.add(dealCard(true));
			}
		}
		
		transitionPhase();
	}

	// dealer
	private Card dealCard(boolean b) {
		Card c = cs.deck.remove(0);
		c.setVisible(b);
		return c;
	}

	// player
	public void insurance(int id, int amount) {
		PlayerState ps = cs.getPlayer(id);
		ps.moveMoneyToInsurance(amount);
		transitionPhase();
	}

	//player
	public void stand(int id){
		PlayerState ps = cs.getPlayer(id);
		
		if(ps.currentActionStatus ==  PlayerState.ActionState.HIT ||
				ps.currentActionStatus ==  PlayerState.ActionState.START){
			ps.currentActionStatus = PlayerState.ActionState.DONE;
		}
		else
			throw new RuntimeException();
		
		transitionPhase();
	}

	public void hit(int id) {
		PlayerState ps = cs.getPlayer(id);
		if(ps.currentActionStatus ==  PlayerState.ActionState.HIT ||
				ps.currentActionStatus ==  PlayerState.ActionState.START){
			
			ps.currentActionStatus = PlayerState.ActionState.HIT;
			ps.currentHand.add(dealCard(true));
		}
		else
			throw new RuntimeException();
		
		transitionPhase();
	}
	
	public void doubleDown(int id){
		PlayerState ps = cs.getPlayer(id);
		
		if(cs.currentPhase != BlackjackState.Phase.AWAITING_ACTIONS)
		
		if(ps.currentActionStatus ==  PlayerState.ActionState.START){
			ps.currentActionStatus = PlayerState.ActionState.DONE;
		}
		else
			throw new RuntimeException();
		
		transitionPhase();
	}


	protected void transitionPhase(){
		this.cs.dump();
		switch(cs.currentPhase){
			case AWAITING_BETS:
				if(cs.playerState.stream().allMatch(u -> u.currentBet!=null))
 					cs.currentPhase = BlackjackState.Phase.BETS_COMPLETE;
				break;
				
			case BETS_COMPLETE:
				if(cs.isInsuranceAvailable()) 
					cs.currentPhase = BlackjackState.Phase.AWAITING_INSURANCE;
				else
					cs.currentPhase = BlackjackState.Phase.AWAITING_ACTIONS;
				break;
			case AWAITING_INSURANCE:
				if(cs.playerState.stream().allMatch(u -> u.currentInsurance != null)){
					cs.currentPhase = BlackjackState.Phase.AWAITING_ACTIONS;
				}
				break;
			case AWAITING_ACTIONS:
				if(cs.playerState.stream().allMatch(u -> u.currentActionStatus == PlayerState.ActionState.DONE)){
					
					
					cs.currentPhase = BlackjackState.Phase.TURN_OVER;
					resolveBetsAndReset();
					cs.currentPhase = BlackjackState.Phase.AWAITING_BETS;
				}
				break;
		}
	}


	private void resolveBetsAndReset() {
		int dealerScore = handScore(cs.dealerHand);
		for(PlayerState ps : cs.playerState){
			if(dealerScore<handScore(ps.currentHand)){
				ps.currentWallet += ps.currentBet*2;
			}
			else if(cs.isInsuranceAvailable() && dealerScore == 21){
				ps.currentWallet += ps.currentBet*3;
			}
			ps.currentBet = null;
			ps.currentInsurance = null;
			ps.currentActionStatus = PlayerState.ActionState.START;
			cs.deck.addAll(ps.currentHand);
			ps.currentHand.clear();
		}
		
		cs.deck.addAll(cs.dealerHand);
		cs.dealerHand.clear();
		
	}

	private int handScore(List<Card> currentHand) {
		int score = 0;
		for(Card c:currentHand){
			score += c.face.getValue();
			if(score > 21)
				return -1;
		}
		return score;
	}

}
