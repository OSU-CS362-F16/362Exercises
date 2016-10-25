package edu.osu.faketweets;

public interface TweetService{
    String getLatestTweetByUser(String username);
    String[] getTrendingTweets(int count);
    String[] getLatestTweetsByTopic(String topic);
}
