package edu.osu.blackjack;


import java.util.ArrayList;
import java.util.List;



public class PlayerState {
	public enum ActionState {START, HIT , DOUBLE, DONE};
	public Integer currentBet;
	public Integer currentWallet = 1000;
	public Integer currentInsurance;
	public ActionState currentActionStatus = ActionState.START;
	public List<Card> currentHand = new ArrayList<Card>();
	public void moveMoneyToInsurance(int amount) {
		if (currentWallet >= amount) {
			currentWallet = currentWallet - amount;
			currentInsurance = amount;
		} else
			throw new RuntimeException();
	}
	public void moveMoneyToBet(int amount) {
		if (currentWallet >= amount) {
			currentBet = amount;
			currentWallet -= amount;
		} else
			throw new RuntimeException();
	}
	public void resetRound() {
		currentBet = null;
		currentWallet = null;
		currentInsurance = null;
	}
	public void dump() {
		// TODO Auto-generated method stub
		System.out.println("Player: " + this.currentHand);
		System.out.println("w " +this.currentWallet + "b " + currentBet + "i " + currentInsurance);
		
	}
	
	
}
