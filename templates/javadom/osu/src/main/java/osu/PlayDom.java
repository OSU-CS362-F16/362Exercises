package osu;

public class PlayDom{

    public  static void main (int argc, char[] argv) {
	GameState G;
	App a = new App();
	int[] k = {App.CARD.adventurer.getValue(), App.CARD.gardens.getValue(), App.CARD.embargo.getValue(), App.CARD.village.getValue(),App.CARD.minion.getValue(), App.CARD.mine.getValue(), App.CARD.cutpurse.getValue(), 
		   App.CARD.sea_hag.getValue(), App.CARD.tribute.getValue(), App.CARD.smithy.getValue()};

	System.out.format ("Starting game.\n");
  
	a.initializeGame(2, k, Integer.parseInt(argv[1]), p);
  
	int money = 0;
	int smithyPos = -1;
	int adventurerPos = -1;
	int i=0;

	int numSmithies = 0;
	int numAdventurers = 0;

	while (!a.isGameOver(p)) {
	    money = 0;
	    smithyPos = -1;
	    adventurerPos = -1;
	    for (i = 0; i < a.numHandCards(p); i++) {
		if (a.handCard(i, p) == App.CARD.copper.getValue())
		    money++;
		else if (a.handCard(i, p) == App.CARD.silver.getValue())
		    money += 2;
		else if (a.handCard(i, p) == App.CARD.gold.getValue())
		    money += 3;
		else if (a.handCard(i, p) == App.CARD.smithy.getValue())
		    smithyPos = i;
		else if (a.handCard(i, p) == App.CARD.adventurer.getValue())
		    adventurerPos = i;
	    }
	}

	if (whoseTurn(p) == 0) {
	    if (smithyPos != -1) {
		printf("0: smithy played from position %d\n", smithyPos); 
		a.playCard(smithyPos, -1, -1, -1, p); 
		printf("smithy played.\n");
		money = 0;
		i=0;
		while(i<a.numHandCards(p)){
		    if (a.handCard(i, p) == copper){
			a.playCard(i, -1, -1, -1, p);
			money++;
		    }
		    else if (handCard(i, p) == silver){
			playCard(i, -1, -1, -1, p);
			money += 2;
		    }
		    else if (handCard(i, p) == gold){
			playCard(i, -1, -1, -1, p);
			money += 3;
		    }
		    i++;
		}
	    }

	    if (money >= 8) {
		printf("0: bought province\n"); 
		a.buyCard(province, p);
	    }
	    else if (money >= 6) {
		printf("0: bought gold\n"); 
		a.buyCard(gold, p);
	    }
	    else if ((money >= 4) && (numSmithies < 2)) {
		printf("0: bought smithy\n"); 
		a.buyCard(smithy, p);
		numSmithies++;
	    }
	    else if (money >= 3) {
		printf("0: bought silver\n"); 
		a.buyCard(silver, p);
	    }

	    printf("0: end turn\n");
	    endTurn(p);
	}
	else {
	    if (adventurerPos != -1) {
		printf("1: adventurer played from position %d\n", adventurerPos);
		a.playCard(adventurerPos, -1, -1, -1, p); 
		money = 0;
		i=0;
		while(i<a.numHandCards(p)){
		    if (a.handCard(i, p) == copper){
			playCard(i, -1, -1, -1, p);
			money++;         
		    }
		    else if (a.handCard(i, p) == silver){
			playCard(i, -1, -1, -1, p);
			money += 2;
		    }
		    else if (a.handCard(i, p) == gold){
			playCard(i, -1, -1, -1, p);
			money += 3;
		    }
		    i++;
		}
	    }

	    if (money >= 8) {
		printf("1: bought province\n");
		buyCard(province, p);
	    }
	    else if ((money >= 6) && (numAdventurers < 2)) {
		printf("1: bought adventurer\n");
		buyCard(adventurer, p);
		numAdventurers++;
	    }else if (money >= 6){
		printf("1: bought gold\n");
		buyCard(gold, p);
	    }
	    else if (money >= 3){
		printf("1: bought silver\n");
		buyCard(silver, p);
	    }
	    printf("1: endTurn\n");
      
	    endTurn(p);      
	}

	printf ("Player 0: %d\nPlayer 1: %d\n", scoreFor(0, p), scoreFor(1, p));
	    
    } // end of While

    printf ("Finished game.\n");
    printf ("Player 0: %d\nPlayer 1: %d\n", scoreFor(0, p), scoreFor(1, p));

    return 0;



}
