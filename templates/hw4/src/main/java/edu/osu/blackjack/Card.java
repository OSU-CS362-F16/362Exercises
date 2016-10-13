package edu.osu.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Card {
	  
	  public final Face face;
	  public final Suit suit;
	  private boolean visible;

	  public enum Face {
	        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
	                9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

	        private int value;

	        Face(int value) {
	            this.value = value;
	        }

	        public int getValue() {
	            return this.value;
	        }
	  }

	  public enum Suit {
		  CLUB, DIAMOND, HEART, SPADE;
	  }

	  public Card(Face face, Suit suit){
		  this.face = face;
		  this.suit = suit;
	  }

	  public String toString(){
		  return this.face.name() + this.suit.name();
	  
	  }

	  private static final List<Card> protoDeck = new ArrayList<Card>();
	  static {
		  for (Suit suit : Suit.values())
			  for (Face face : Face.values())
				  protoDeck.add(new Card(face, suit));
	  }

	  public static ArrayList<Card> newDeck() {
		  return new ArrayList<Card>(protoDeck); 
	  }

	  public boolean isVisible() {
		  return this.visible;
	  }
		
	  public void setVisible(boolean b){
			this.visible = b;
		}
		
}
