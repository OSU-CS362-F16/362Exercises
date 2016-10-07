package edu.osu.cs362;
import static org.junit.Assert.*;
import org.junit.Test;


public class PartitionFITest  {

    /*
 Interface-based approach.

 Develop characteristics directly from individual input parameters.
          Just use properties of the domains without considering the
          actual function under test

    */
    // B1 - arr = null, toFind = *
    // B2 - arr = any array where toFind exists, toFind = *
    //    B2_1 - arr = any array where toFind == arr[0], toFind = *
    //       B2_2_1 - arr =  any array where toFind == arr[0], all are elements distinct 
    //       B2_2_1 - arr =  any array where toFind == arr[0], there are duplicates
    //    B2_2 - arr = any array where toFind == arr[arr.length - 1], toFind = *
    //    B2_3 - arr = any array where toFind == arr[i], i!=0 && i!=(arr.length - 1), toFind = *
    // B3 - arr = any array where toFind does not exist, toFind = *
    @Test
    public void testFindIntegerArrNull(){
	boolean hit = false;
	try{
	    WarmUp.findInteger(null, 27);
	}
	catch(NullPointerException e){
	    hit = true;
	}

	assertTrue("Expected an NullPointerException",hit);
    }
    
    @Test
    public void testFindIntegerToFindFirst(){
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	//	int result = WarmUp.findInteger(testArr,testArr[0]);
	//assertTrue(result == 0);
	assertEquals(0,result);
    }
    

    @Test
    public void testFindIntegerToFindLast(){
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,testArr[testArr.length-1]);
	assertEquals(testArr.length-1,result);
    }
    
    @Test
    public void testFindIntegerNotExists(){
	int[] testArr = new int[10];
	for(int i=0;i<10;i++){
	    testArr[i] = i;
	}
	int result = WarmUp.findInteger(testArr,47);
	assertEquals(-1,result);
    }
    

















    public void testWithBadSize(int n) {
	int[] a = new int[n];
	for(int i=0;i<n;i++){
	    a[i] = i;
	}
	CardCollection c = new CardCollection();
	c.add(Card.newDeck());
	c.permute(a);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooSmall() {
	testWithBadSize(1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTooLarge() {
	testWithBadSize(100);
    }

    /*
    @Test
    public void testCardRemoveWithDupe(){
	CardCollection c = new CardCollection();
	Card c1 = new Card(Card.Face.ACE,Card.Suit.HEART);
	Card c2 = new Card(Card.Face.TWO,Card.Suit.SPADE);
	Card c3 = new Card(Card.Face.ACE,Card.Suit.HEART);
	c.add(c1);
	c.add(c2);
	c.add(c3);
	c.discardCard(2);  // remove last card
	assertEquals(c1,c.getCards().get(0)); // should be Ace of hearts
	assertEquals(c2,c.getCards().get(1)); // should be Two of spade

    }

*/
}
