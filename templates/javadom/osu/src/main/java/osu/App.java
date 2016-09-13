package osu;

import java.util.*;

/**
 * Hello world!
 *
 */

public class App 
{
    public static final boolean DEBUG = true;
    public static final int MAX_HAND = 500;
    public static final int MAX_DECK =  500;
    public static final int MAX_PLAYERS = 4;


    App(int numPlayers, List<Card> kingdomCards,Integer randomSeed) throws Exception {
	App(numPlayers,kingdomCards,randomSeed,new GameState())
    }
    
    App(int numPlayers, List<Card> kingdomCards, Integer randomSeed,
		       GameState state) throws Exception {

	int i;
	int j;
	int it;			

	//set up random number generator
	if(state.rand == null)
	    state.rand = new Random(randomSeed);
	else
	    state.rand.setSeed(randomSeed); 
  
	//check number of players
	if (numPlayers > MAX_PLAYERS || numPlayers < 2){
	    throw new Exception("Invalid number of players");
	}

	//set number of players
	state.numPlayers = numPlayers;

	//check selected kingdom cards are different
	for (i = 0; i < 10; i++)
	    {
		for (j = 0; j < 10; j++)
		    {
			if (j != i && kingdomCards.get(j).type == kingdomCards.get(i).type)
			    {
				throw new Exception("Duplicate Kingdom card discovered!");
			    }
		    }
	    }


	//initialize supply
	///////////////////////////////

	//set number of Curse cards
	if (numPlayers == 2)
	    {
		state.supplyCount.set(Card.curse,10);
	    }
	else if (numPlayers == 3)
	    {
		state.supplyCount.set(Card.curse,20);
	    }
	else
	    {
		state.supplyCount.set(Card.curse,30);
	    }

	//set number of Victory cards
	if (numPlayers == 2)
	    {
		state.supplyCount.set(Card.estate, 8);
		state.supplyCount.set(Card.duchy, 8);
		state.supplyCount.set(Card.province, 8);
	    }
	else
	    {
		state.supplyCount.set(Card.estate, 12);
		state.supplyCount.set(Card.duchy, 12);
		state.supplyCount.set(Card.province, 12);
	    }

	//set number of Treasure cards
	state.supplyCount.set(Card.copper, 6 - (7 * numPlayers));
	state.supplyCount.set(Card.silver, 40);
	state.supplyCount.set(Card.gold, 30);

	//set number of Kingdom cards
	for (Card ct : CardType.values()) {
	    if(!ct.isRegular())  continue;
	    for (j = 0; j < 10; j++){
		if (kingdomCards[j].type == ct){   
				//check if card is a 'Victory' Kingdom card
		    if (kingdomCards[j].type == Card.great_hall  || kingdomCards[j] == Card.gardens )
			{
			    if (numPlayers == 2){ 
				state.supplyCount.set(c, 8); 
			    }
			    else{ 
				state.supplyCount.set(c, 12); 
			    }
			}
		    else{
			state.supplyCount.set(i, 10);
		    }
		    break;
		}
		else    //card is not in the set choosen for the game
		    {
			state.supplyCount.set(i, -1);
		    }
	    }
	}
	////////////////////////
	//supply intilization complete

	//set player decks
	for (i = 0; i < numPlayers; i++){
	    for (j = 0; j < 3; j++){
		state.deck[i].add(Card.estate);
	    }
	    for (j = 3; j < 10; j++){
		state.deck[i].add( Card.copper);
	    }
	}

	//shuffle player decks
	for (i = 0; i < numPlayers; i++){
	    state[i].shuffle();
	}

	//set embargo tokens to 0 for all supply piles
	for (CardType ct : Card.values()) {
	    if(!ct.isRegular())
		state.embargoTokens.set(ct, 0);
	}

	//initialize first player's turn
	state.outpostPlayed = 0;
	state.phase = 0;
	state.numActions = 1;
	state.numBuys = 1;
	state.playedCardCount = 0;
	state.whoseTurn = 0;

	//int it; move to top

	//Moved draw cards to here, only drawing at the start of a turn
	for (it = 0; it < 5; it++){
	    drawCard(state.whoseTurn, state);
	}

	updateCoins(state.whoseTurn, state, 0);

	return 0;
    }


    int getCost(Card c)
    {
	switch( c.type.getId() ) 
	    {
	    case 0: //Card.curse.v:
		return 0;
	    case 1: //Card.estate.v:
		return 2;
	    case 2://Card.duchy.v:
		return 5;
	    case 3://ARD.province.v:
		return 8;
	    case 4://Card.copper.v:
		return 0;
	    case 5://Card.silver.v:
		return 3;
	    case 6://Card.gold.v:
		return 6;
	    case 7://Card.adventurer.v:
		return 6;
	    case 8://Card.council_room.v:
		return 5;
	    case 9://.Card.feast.v:
		return 4;
	    case 10://Card.gardens.v:
		return 4;
	    case 11://Card.mine.v:
		return 5;
	    case 12://Card.remodel.v:
		return 4;
	    case 13://Card.smithy.v:
		return 4;
	    case 14://Card.village.v:
		return 3;
	    case 15://Card.baron.v:
		return 4;
	    case 16://Card.great_hall.v:
		return 3;
	    case 17://Card.minion.v:
		return 5;
	    case 18://Card.steward.v:
		return 3;
	    case 19://Card.tribute.v:
		return 5;
	    case 20://Card.ambassador.v:
		return 3;
	    case 21://Card.cutpurse.v:
		return 4;
	    case 22://Card.embargo.v: 
		return 2;
	    case 23://Card.outpost.v:
		return 5;
	    case 24://Card.salvager.v:
		return 4;
	    case 25://Card.sea_hag.v:
		return 4;
	    case 26://Card.treasure_map.v:
		return 4;
	    }
	
	return -1;
    }

    Card handCard (int handPos ,GameState state){
	int currentPlayer = whoseTurn(state);
	return state.hand[currentPlayer].get(handPos);
    }

    int whoseTurn (GameState state){
	return state.whoseTurn;
    }

    int supplyCount(int k ,GameState state){
	return state.supply.length();
    }



    int isGameOver(GameState state)
    {
	int i;
	int j;
	
	//if stack of Province cards is empty, the game ends
	if (state.supplyCount[Card.province] == 0)
	    {
		return 1;
	    }

	//if three supply pile are at 0, the game ends
	j = 0;
	for (i = 0; i < 25; i++)
	    {
		if (state.supplyCount[i] == 0)
		    {
			j++;
		    }
	    }
	if ( j >= 3)
	    {
		return 1;
	    }

	return 0;

    }

    int cardEffect(int card, int choice1, int choice2, int choice3, GameState state, int handPos, int bonus) throws Exception{
	int i;
	int j;
	int k;
	int x;
	int index;
	int currentPlayer = state.whoseTurn;
	int nextPlayer = currentPlayer + 1;

	int tributeRevealedCards[]= {-1, -1};
	int temphand[] = new int[MAX_HAND];// moved above the if statement
	int drawntreasure=0;
	int cardDrawn;
	int z = 0;// this is the counter for the temp hand
	if (nextPlayer > (state.numPlayers - 1)){
	    nextPlayer = 0;
	}
  
	
	//uses switch to select card and perform actions
	switch( card ) 
	    {
	    case 7: //adventturer
		while(drawntreasure<2){
		    if (state.deckCount[currentPlayer] <1){//if the deck is empty we need to shuffle discard and add to deck
			shuffle(currentPlayer, state);
		    }
		    drawCard(currentPlayer, state);
		    cardDrawn = state.hand[currentPlayer][state.handCount[currentPlayer]-1];//top card of hand is most recently drawn card.
		    if (cardDrawn == Card.copper || cardDrawn == Card.silver || cardDrawn == Card.gold)
			drawntreasure++;
		    else{
			temphand[z]=cardDrawn;
			state.handCount[currentPlayer]--; //this should just remove the top card (the most recently drawn one).
			z++;
		    }
		}
		while(z-1>=0){
		    state.discard[currentPlayer][state.discardCount[currentPlayer]++]=temphand[z-1]; // discard all cards in play that have been drawn
		    z=z-1;
		}
		return 0;
			
	    case 8:
		//+4 Cards
		for (i = 0; i < 4; i++)
		    {
			drawCard(currentPlayer, state);
		    }
			
		//+1 Buy
		state.numBuys++;
			
		//Each other player draws a card
		for (i = 0; i < state.numPlayers; i++)
		    {
			if ( i != currentPlayer )
			    {
				drawCard(i, state);
			    }
		    }
			
		//put played card in played card pile
		discardCard(handPos, currentPlayer, state, 0);
			
		return 0;
			
	    case 9:
		//gain card with cost up to 5
		//Backup hand
		for (i = 0; i <= state.handCount[currentPlayer]; i++){
		    temphand[i] = state.hand[currentPlayer][i];//Backup card
		    state.hand[currentPlayer][i] = -1;//Set to nothing
		}
		//Backup hand

		//Update Coins for Buy
		updateCoins(currentPlayer, state, 5);
		x = 1;//Condition to loop on
		while( x == 1) {//Buy one card
		    if (supplyCount(choice1, state) <= 0){
			if (DEBUG)
			    System.out.format("None of that card left, sorry!\n");

			if (DEBUG){
			    System.out.format("Cards Left: %d\n", supplyCount(choice1, state));
			}
		    }
		    else if (state.coins < getCost(choice1)){
			System.out.format("That card is too expensive!\n");

			if (DEBUG){
			    System.out.format("Coins: %d < %d\n", state.coins, getCost(choice1));
			}
		    }
		    else{

			if (DEBUG){
			    System.out.format("Deck Count: %d\n", state.handCount[currentPlayer] + state.deckCount[currentPlayer] + state.discardCount[currentPlayer]);
			}

			gainCard(choice1, state, 0, currentPlayer);//Gain the card
			x = 0;//No more buying cards

			if (DEBUG){
			    System.out.format("Deck Count: %d\n", state.handCount[currentPlayer] + state.deckCount[currentPlayer] + state.discardCount[currentPlayer]);
			}

		    }
		}     

		//Reset Hand
		for (i = 0; i <= state.handCount[currentPlayer]; i++){
		    state.hand[currentPlayer][i] = temphand[i];
		    temphand[i] = -1;
		}
		//Reset Hand
      			
		return 0;
			
	    case 10:
		return -1;
			
	    case 11:
		j = state.hand[currentPlayer][choice1];  //store card we will trash

		if (state.hand[currentPlayer][choice1] < Card.copper || state.hand[currentPlayer][choice1] > Card.gold)
		    {
			return -1;
		    }
		
		if (choice2 > Card.treasure_map || choice2 < Card.curse)
		    {
			return -1;
		    }

		if ( (getCost(state.hand[currentPlayer][choice1]) + 3) > getCost(choice2) )
		    {
			return -1;
		    }

		gainCard(choice2, state, 2, currentPlayer);

		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);

		//discard trashed card
		for (i = 0; i < state.handCount[currentPlayer]; i++)
		    {
			if (state.hand[currentPlayer][i] == j)
			    {
				discardCard(i, currentPlayer, state, 0);			
				break;
			    }
		    }
			
		return 0;
			
	    case 12:
		j = state.hand[currentPlayer][choice1];  //store card we will trash

		if ( (getCost(state.hand[currentPlayer][choice1]) + 2) > getCost(choice2) )
		    {
			return -1;
		    }

		gainCard(choice2, state, 0, currentPlayer);

		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);

		//discard trashed card
		for (i = 0; i < state.handCount[currentPlayer]; i++)
		    {
			if (state.hand[currentPlayer][i] == j)
			    {
				discardCard(i, currentPlayer, state, 0);			
				break;
			    }
		    }


		return 0;
		
	    case 13:
		//+3 Cards
		for (i = 0; i < 3; i++)
		    {
			drawCard(currentPlayer, state);
		    }
			
		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 14:
		//+1 Card
		drawCard(currentPlayer, state);
			
		//+2 Actions
		state.numActions = state.numActions + 2;
			
		//discard played card from hand
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 15:
		state.numBuys++;//Increase buys by 1!
		if (choice1 > 0){//Boolean true or going to discard an estate
		    int p = 0;//Iterator for hand!
		    boolean card_not_discarded = true;//Flag for discard set!
		    while(card_not_discarded){
			if (state.hand[currentPlayer][p] == Card.estate){//Found an estate card!
			    state.coins += 4;//Add 4 coins to the amount of coins
			    state.discard[currentPlayer][state.discardCount[currentPlayer]] = state.hand[currentPlayer][p];
			    state.discardCount[currentPlayer]++;
			    for (;p < state.handCount[currentPlayer]; p++){
				state.hand[currentPlayer][p] = state.hand[currentPlayer][p+1];
			    }
			    state.hand[currentPlayer][state.handCount[currentPlayer]] = -1;
			    state.handCount[currentPlayer]--;
			    card_not_discarded = false;//Exit the loop
			}
			else if (p > state.handCount[currentPlayer]){
			    if(DEBUG) {
				System.out.format("No estate cards in your hand, invalid choice\n");
				System.out.format("Must gain an estate if there are any\n");
			    }
			    if (supplyCount(Card.estate, state) > 0){
				gainCard(Card.estate, state, 0, currentPlayer);
				state.supplyCount[Card.estate]--;//Decrement estates
				if (supplyCount(Card.estate, state) == 0){
				    isGameOver(state);
				}
			    }
			    card_not_discarded = false;//Exit the loop
			}
			    
			else{
			    p++;//Next card
			}
		    }
		}			    
		else{
		    if (supplyCount(Card.estate, state) > 0){
			gainCard(Card.estate, state, 0, currentPlayer);//Gain an estate
			state.supplyCount[Card.estate]--;//Decrement Estates
			if (supplyCount(Card.estate, state) == 0){
			    isGameOver(state);
			}
		    }
		}
	    
      
		return 0;
		
	    case 16:
		//+1 Card
		drawCard(currentPlayer, state);
			
		//+1 Actions
		state.numActions++;
			
		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 17:
		//+1 action
		state.numActions++;
			
		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);
			
		if (choice1>0)		//+2 coins
		    {
			state.coins = state.coins + 2;
		    }
			
		else if (choice2>0)		//discard hand, redraw 4, other players with 5+ cards discard hand and draw 4
		    {
			//discard hand
			while(state.handCount[state.whoseTurn] > 0)
			    {
				discardCard(handPos, currentPlayer, state, 0);
			    }
				
			//draw 4
			for (i = 0; i < 4; i++)
			    {
				drawCard(currentPlayer, state);
			    }
				
			//other players discard hand and redraw if hand size > 4
			for (i = 0; i < state.numPlayers; i++)
			    {
				if (i != currentPlayer)
				    {
					if ( state.handCount[i] > 4 )
					    {
						//discard hand
						while( state.handCount[i] > 0 )
						    {
							discardCard(handPos, i, state, 0);
						    }
							
						//draw 4
						for (j = 0; j < 4; j++)
						    {
							drawCard(i, state);
						    }
					    }
				    }
			    }
				
		    }
		return 0;
		
	    case 18:
		if (choice1 == 1)
		    {
			//+2 cards
			drawCard(currentPlayer, state);
			drawCard(currentPlayer, state);
		    }
		else if (choice1 == 2)
		    {
			//+2 coins
			state.coins = state.coins + 2;
		    }
		else
		    {
			//trash 2 cards in hand
			discardCard(choice2, currentPlayer, state, 1);
			discardCard(choice3, currentPlayer, state, 1);
		    }
			
		//discard card from hand
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 19:
		if ((state.discardCount[nextPlayer] + state.deckCount[nextPlayer]) <= 1){
		    if (state.deckCount[nextPlayer] > 0){
			tributeRevealedCards[0] = state.deck[nextPlayer][state.deckCount[nextPlayer]-1];
			state.deckCount[nextPlayer]--;
		    }
		    else if (state.discardCount[nextPlayer] > 0){
			tributeRevealedCards[0] = state.discard[nextPlayer][state.discardCount[nextPlayer]-1];
			state.discardCount[nextPlayer]--;
		    }
		    else{
			//No Card to Reveal
			if (DEBUG){
			    System.out.format("No cards to reveal\n");
			}
		    }
		}
	    
		else{
		    if (state.deckCount[nextPlayer] == 0){
			for (i = 0; i < state.discardCount[nextPlayer]; i++){
			    state.deck[nextPlayer][i] = state.discard[nextPlayer][i];//Move to deck
			    state.deckCount[nextPlayer]++;
			    state.discard[nextPlayer][i] = -1;
			    state.discardCount[nextPlayer]--;
			}
			    
			shuffle(nextPlayer,state);//Shuffle the deck
		    } 
		    tributeRevealedCards[0] = state.deck[nextPlayer][state.deckCount[nextPlayer]-1];
		    state.deck[nextPlayer][state.deckCount[nextPlayer]--] = -1;
		    state.deckCount[nextPlayer]--;
		    tributeRevealedCards[1] = state.deck[nextPlayer][state.deckCount[nextPlayer]-1];
		    state.deck[nextPlayer][state.deckCount[nextPlayer]--] = -1;
		    state.deckCount[nextPlayer]--;
		}    
		       
		if (tributeRevealedCards[0] == tributeRevealedCards[1]){//If we have a duplicate card, just drop one 
		    state.playedCards[state.playedCardCount] = tributeRevealedCards[1];
		    state.playedCardCount++;
		    tributeRevealedCards[1] = -1;
		}

		for (i = 0; i <= 2; i ++){
		    if (tributeRevealedCards[i] == Card.copper || tributeRevealedCards[i] == Card.silver || tributeRevealedCards[i] == Card.gold){//Treasure cards
			state.coins += 2;
		    }
		    
		    else if (tributeRevealedCards[i] == Card.estate || tributeRevealedCards[i] == Card.duchy || tributeRevealedCards[i] == Card.province || tributeRevealedCards[i] == Card.gardens || tributeRevealedCards[i] == Card.great_hall){//Victory Card Found
			drawCard(currentPlayer, state);
			drawCard(currentPlayer, state);
		    }
		    else{//Action Card
			state.numActions = state.numActions + 2;
		    }
		}
	    
		return 0;
		
	    case 20:
		j = 0;		//used to check if player has enough cards to discard

		if (choice2 > 2 || choice2 < 0)
		    {
			return -1;				
		    }

		if (choice1 == handPos)
		    {
			return -1;
		    }

		for (i = 0; i < state.handCount[currentPlayer]; i++)
		    {
			if (i != handPos && i == state.hand[currentPlayer][choice1] && i != choice1)
			    {
				j++;
			    }
		    }
		if (j < choice2)
		    {
			return -1;				
		    }

		if (DEBUG) 
		    System.out.format("Player %d reveals card number: %d\n", currentPlayer, state.hand[currentPlayer][choice1]);

		//increase supply count for choosen card by amount being discarded
		state.supplyCount[state.hand[currentPlayer][choice1]] += choice2;
			
		//each other player gains a copy of revealed card
		for (i = 0; i < state.numPlayers; i++)
		    {
			if (i != currentPlayer)
			    {
				gainCard(state.hand[currentPlayer][choice1], state, 0, i);
			    }
		    }

		//discard played card from hand
		discardCard(handPos, currentPlayer, state, 0);			

		//trash copies of cards returned to supply
		for (j = 0; j < choice2; j++)
		    {
			for (i = 0; i < state.handCount[currentPlayer]; i++)
			    {
				if (state.hand[currentPlayer][i] == state.hand[currentPlayer][choice1])
				    {
					discardCard(i, currentPlayer, state, 1);
					break;
				    }
			    }
		    }			

		return 0;
		
	    case 21:

		updateCoins(currentPlayer, state, 2);
		for (i = 0; i < state.numPlayers; i++)
		    {
			if (i != currentPlayer)
			    {
				for (j = 0; j < state.handCount[i]; j++)
				    {
					if (state.hand[i][j] == Card.copper)
					    {
						discardCard(j, i, state, 0);
						break;
					    }
					if (j == state.handCount[i])
					    {
						for (k = 0; k < state.handCount[i]; k++)
						    {
							if (DEBUG)
							    System.out.format("Player %d reveals card number %d\n", i, state.hand[i][k]);
						    }	
						break;
					    }		
				    }
					
			    }
				
		    }				

		//discard played card from hand
		discardCard(handPos, currentPlayer, state, 0);			

		return 0;

		
	    case 22:
		//+2 Coins
		state.coins = state.coins + 2;
			
		//see if selected pile is in play
		if ( state.supplyCount[choice1] == -1 )
		    {
			return -1;
		    }
			
		//add embargo token to selected supply pile
		state.embargoTokens[choice1]++;
			
		//trash card
		discardCard(handPos, currentPlayer, state, 1);		
		return 0;
		
	    case 23:
		//set outpost flag
		state.outpostPlayed++;
			
		//discard card
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 24:
		//+1 buy
		state.numBuys++;
			
		if (choice1>0)
		    {
			//gain coins equal to trashed card
			state.coins = state.coins + getCost( handCard(choice1, state) );
			//trash card
			discardCard(choice1, currentPlayer, state, 1);	
		    }
			
		//discard card
		discardCard(handPos, currentPlayer, state, 0);
		return 0;
		
	    case 25:
		for (i = 0; i < state.numPlayers; i++){
		    if (i != currentPlayer){
			state.discard[i][state.discardCount[i]] = state.deck[i][state.deckCount[i]--];			    state.deckCount[i]--;
			state.discardCount[i]++;
			state.deck[i][state.deckCount[i]--] = Card.curse;//Top card now a curse
		    }
		}
		return 0;
		
	    case 26:
		//search hand for another treasure_map
		index = -1;
		for (i = 0; i < state.handCount[currentPlayer]; i++)
		    {
			if (state.hand[currentPlayer][i] == Card.treasure_map && i != handPos)
			    {
				index = i;
				break;
			    }
		    }
		if (index > -1)
		    {
			//trash both treasure cards
			discardCard(handPos, currentPlayer, state, 1);
			discardCard(index, currentPlayer, state, 1);

			//gain 4 Gold cards
			for (i = 0; i < 4; i++)
			    {
				gainCard(Card.gold, state, 1, currentPlayer);
			    }
				
			//return success
			return 1;
		    }
			
		//no second treasure_map found in hand
		return -1;
	    }
	
	return -1;
    }


    void drawCard(int player, GameState state) throws Exception
    {	int count;
	int deckCounter;
	if (state.deckCount[player] <= 0){//Deck is empty
    
	    //Step 1 Shuffle the discard pile back into a deck
	    int i;
	    //Move discard to deck
	    for (i = 0; i < state.discardCount[player];i++){
		state.deck[player][i] = state.discard[player][i];
		state.discard[player][i] = -1;
	    }

	    state.deckCount[player] = state.discardCount[player];
	    state.discardCount[player] = 0;//Reset discard

	    //Shufffle the deck
	    shuffle(player, state);//Shuffle the deck up and make it so that we can draw
   
	    //    if (DEBUG){//Debug statements
	    //      System.out.format("Deck count now: %d\n", state.deckCount[player]);
	    //    }
    
	    state.discardCount[player] = 0;

	    //Step 2 Draw Card
	    count = state.handCount[player];//Get current player's hand count
    
	    ///    if (DEBUG){//Debug statements
	    //	System.out.format("Current hand count: %d\n", count);
	    //    }
    
	    deckCounter = state.deckCount[player];//Create a holder for the deck count

	    if (deckCounter == 0)
		throw new Exception("Deck empty");

	    state.hand[player][count] = state.deck[player][deckCounter - 1];//Add card to hand
	    state.deckCount[player]--;
	    state.handCount[player]++;//Increment hand count
	}

	else{
	    count = state.handCount[player];//Get current hand count for player
    
	    //    if (DEBUG){//Debug statements
	    //      System.out.format("Current hand count: %d\n", count);
	    //    }

	    deckCounter = state.deckCount[player];//Create holder for the deck count
	    state.hand[player][count] = state.deck[player][deckCounter - 1];//Add card to the hand
	    state.deckCount[player]--;
	    state.handCount[player]++;//Increment hand count
	}


    }

    void shuffle(int player, GameState state) {
 
	int newDeck[] = new int[MAX_HAND];
	int newDeckPos = 0;

	Arrays.sort(state.deck[player],0, state.deckCount[player]);
	/* SORT CardS IN DECK TO ENSURE DETERMINISM! */
  
	while (state.deckCount[player] > 0) {
	    int card = ((int)state.rand.nextFloat() * state.deckCount[player]);
	    newDeck[newDeckPos] = state.deck[player][card];
	    newDeckPos++;
	    for (int i = card; i < state.deckCount[player]-1; i++) {
		state.deck[player][i] = state.deck[player][i+1];
	    }
	    state.deckCount[player]--;
	}
	for (int i = 0; i < newDeckPos; i++) {
	    state.deck[player][i] = newDeck[i];
	    state.deckCount[player]++;
	}


    }    

    int updateCoins(int player, GameState state, int bonus)
    {
	int i;
	
	//reset coin count
	state.coins = 0;

	//add coins for each Treasure card in player's hand
	for (i = 0; i < state.handCount[player]; i++)
	    {
		if (state.hand[player][i] == Card.copper)
		    {
			state.coins += 1;
		    }
		else if (state.hand[player][i] == Card.silver)
		    {
			state.coins += 2;
		    }
		else if (state.hand[player][i] == Card.gold)
		    {
			state.coins += 3;
		    }	
	    }	

	//add bonus
	state.coins += bonus;

	return 0;
    }

    public static void main( String[] args )
    {
        System.out.format( "Hello World!" );
    }
}

