package osu;
import java.util.Random;
public class GameState {
    public static final int MAX_HAND = 500;
    public static final int MAX_DECK =  500;
    public static final int MAX_PLAYERS = 4;    

    public int numPlayers; //number of players
    public Map<CardType,Integer> supplyCount  = new HashMap<CardType,Integer>();
    public Map<CardType,Integer> embargoTokens  = new HashMap<CardType,Integer>();
    public int outpostPlayed;
    public int outpostTurn;
    public int whoseTurn;
    public int phase;
    public int numActions; /* Starts at 1 each turn */
    public int coins; /* Use as you see fit! */
    public int numBuys; /* Starts at 1 each turn */
    public Hand hand[]  = new Hand[MAX_PLAYERS];

    public Hand deck[]  = new Hand[MAX_PLAYERS];
    public Hand discard[]  = new Hand[MAX_PLAYERS];
    public Hand playedCards;

    public Random rand;


    
};

