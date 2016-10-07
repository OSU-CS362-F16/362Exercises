package edu.osu.cs362;
import static org.junit.Assert.*;
import org.junit.Test;
public class CardTestExample  {



    @Test 
    public void example(){
	CardCollection c = new CardCollection();
	Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
	c.add(c1);
	Card c2 = c.getCards().get(0);
	assertEquals(c1.suit,c2.suit);
	assertEquals(c2.face.getValue(),11);
    }

}
