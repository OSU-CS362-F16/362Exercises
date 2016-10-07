package edu.osu.blackjack;


public interface PlayerAction  extends CommonAction{

	public enum ActionType {HIT , DOUBLE, STAND};
	
	public int makeBet();
	public int doubleDownBet();
	public int makeInsuranceBet();
	public ActionType getAction();
	public int getCurrentBet();
	public void acceptMoney(int i);
	public void nextHand();


}
