package edu.osu.blackjack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
	BlackjackStateMachine bsm = new BlackjackStateMachine(1);
		
		while(!bsm.getBlackjackState().isAnyoneBroke()){
			bsm.dealInitialHands();
			bsm.bet(0, 10);
			bsm.hit(0);
			bsm.stand(0);
			
		}
    }
}
