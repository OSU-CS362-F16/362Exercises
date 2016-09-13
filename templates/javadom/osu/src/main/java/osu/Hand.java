package osu;

public class Hand extends ArrayList<Card>{

    void discardCard(int handPos, int currentPlayer, GameState gs, int trashFlag){
	//if card is not trashed, added to Played pile 
	if (trashFlag < 1) {
	    //add card to played pile
	    gs.playedCards.add(this.get(handPos)); 
	}
	this.remove(handPos)
    }

    void gainCard(CardType t, GameState state, int toFlag, int player){
	//Note: supplyPos is enum of choosen card
	
	//check if supply pile is empty (0) or card is not used in game (-1)
	/*	if ( state.supplysupplyCount(supplyPos, state) < 1 )
	    {
		return -1;
	    }
	*/
	
	//added card for [whoseTurn] current player:
	// toFlag = 0 : add to discard
	// toFlag = 1 : add to deck
	// toFlag = 2 : add to hand

	if (toFlag == 1)
	    {
		state.deck[ player ].add(supplyPos.generateCard());
	    }
	else if (toFlag == 2)
	    {
		state.hand[ player ].add(supplyPos.generateCard());	
	    }
	else
	    {
		state.discard[ player ].add(supplyPos.generateCard());	
	    }
	
	//decrease number in supply pile
	state.supplyCount.set(supplyPos,sstate.supplyCount.get(supplyPos)-1))
	return 0;

    }

}

