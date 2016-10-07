package edu.osu.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlackjackState {
	
	enum Phase  { AWAITING_BETS, BETS_COMPLETE, AWAITING_INSURANCE, AWAITING_ACTIONS, TURN_OVER }
	
	public List<PlayerState> playerState;
	public List<Card> dealerHand;
	public List<Card> deck;
	public Phase currentPhase;

	public BlackjackState(){
		reset();
	}
	
	public void reset(){
		this.playerState = new ArrayList<PlayerState>();
		this.dealerHand = new ArrayList<Card>();
		this.deck = new ArrayList<Card>();
		this.currentPhase = Phase.AWAITING_BETS;
		this.setDeck(Card.newDeck());
	}
	
	public void setDeck(List<Card> c){
		this.deck = c;
	}
	
	public PlayerState getPlayer(int k) {
		return playerState.get(k);
	}

	public boolean isInsuranceAvailable() {
		for(Card c: dealerHand){
			if(c.face == Card.Face.ACE && c.isVisible()){
				return true;
			}
		}
		return false;
	}

	public boolean isAnyoneBroke() {
		for(PlayerState p : playerState){
			if(p.currentWallet != null && p.currentWallet < 0)
				return true;
		}
		return false;
	}
	
	public static void dumpDeck(List<Card> c){
		System.out.print("Deck:");
		for(Card z : c) System.out.print(c.toString() + ";");
		System.out.println("");
	}
	
	public void dump(){
		System.out.println("Phase:" + this.currentPhase);
		System.out.println("Dealer:" + this.dealerHand);
		System.out.println("Deck:" + this.deck);
	
		for(PlayerState p: playerState){
			p.dump();
		}

		System.out.println("");
	}

	
}

