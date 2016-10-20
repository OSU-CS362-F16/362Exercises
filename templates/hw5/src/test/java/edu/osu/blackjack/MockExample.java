package edu.osu.blackjack;


import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;

public class MockExample {
    @Test
    public void testMock(){
	// Does it run without errors for a simple case?
	DealerAction dt = mock(DealerAction.class);
	PlayerAction pa = mock(PlayerAction.class);

	//  This player is feeling charitiable....
	when(pa.getAction()).thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)
                            .thenReturn(PlayerAction.ActionType.HIT)	
	                    .thenReturn(PlayerAction.ActionType.HIT)	   
	                    .thenReturn(PlayerAction.ActionType.STAND);	                          
	SimpleBlackjack j = new SimpleBlackjack(dt,new PlayerAction[]{pa});
	j.playRound();
	verify(dt, times(9)).dealCard(pa);
    }
	
	
}
