package edu.osu.blackjack;

import java.util.List;

public interface CommonAction {
	void acceptCard(Card c);
	List<Card> getHand();
}


