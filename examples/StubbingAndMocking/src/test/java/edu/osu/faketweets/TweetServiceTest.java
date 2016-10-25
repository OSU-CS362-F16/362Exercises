package edu.osu.faketweets;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
import static org.mockito.Mockito.*;

public class TweetServiceTest{
    @Test
    public void trendingExampleStubTest(){
	TweetService ts = new TweetServiceStub();
	TweetMiner tm = new TweetMiner(ts);

	assertFalse(tm.isUserInTrendingTweets("John"));
	assertTrue(tm.isUserInTrendingTweets("Stan"));
    }

    @Test
    public void trendingExampleMockTest(){
	TweetService ts = mock(TweetService.class);
	TweetMiner tm = new TweetMiner(ts);

	when(ts.getTrendingTweets(anyInt())).thenReturn(new String[]{"HELLO WORLD"});
	when(ts.getLatestTweetByUser("Stan")).thenReturn("HELLO WORLD");


	
	assertFalse(tm.isUserInTrendingTweets("John"));
	assertTrue(tm.isUserInTrendingTweets("Stan"));
	
    }


    @Test
    public void trendingExampleMockTest2(){
	TweetService ts = mock(TweetService.class);
	TweetMiner tm = new TweetMiner(ts);

	when(ts.getTrendingTweets(anyInt())).thenReturn(new String[]{"HELLO WORLD"});
	when(ts.getLatestTweetByUser("Stan")).thenReturn("HELLO WORLD")
 	                                     .thenReturn("GOODBYE")
                                    	     .thenReturn("GOODBYE WORLD");

	assertTrue(tm.isUserInTrendingTweets("Stan"));
	assertFalse(tm.isUserInTrendingTweets("Stan"));
	assertFalse(tm.isUserInTrendingTweets("Stan"));
	
    }

}
