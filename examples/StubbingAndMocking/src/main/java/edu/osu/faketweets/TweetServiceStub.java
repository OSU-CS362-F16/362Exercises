package edu.osu.faketweets;

public class TweetServiceStub implements TweetService{
    public static final String TRENDING_TWEET = "HELLO WORLD";

    public String getLatestTweetByUser(String username){
	if(username.equals("Stan")){
	    return TRENDING_TWEET;
	}
	return "GOODBYE";
    }
    public String[] getTrendingTweets(int count){
	return new String[]{ TRENDING_TWEET, "GOODBYE WORLD", "HELLO"};
    }
    public String[] getLatestTweetsByTopic(String topic){
	return null;
    }
}
