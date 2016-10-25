package edu.osu.faketweets;

public class TweetMiner{
    TweetService service;

    public TweetMiner(TweetService s){
	service = s;
    }

    public boolean isUserInTrendingTweets(String username){
	String[] tweets = service.getTrendingTweets(100);
	String target =  service.getLatestTweetByUser(username);

	for(String t: tweets){
	    if(t.equals(target))
		return true;
	}

	return false;
    }
}
