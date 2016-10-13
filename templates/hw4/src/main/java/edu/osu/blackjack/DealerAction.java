package edu.osu.blackjack;

public interface DealerAction extends CommonAction {

	public void shuffleDeck();
	public void dealCard(CommonAction dealer);
	public boolean isInsuranceAvailable();
	void compareHandAndSettle(PlayerAction p);
	
}
