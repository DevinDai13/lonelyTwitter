package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;


public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){

        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public int getCount() {
        return tweets.size();
    }

    public List<Tweet> getTweets() {
        List<Tweet> TweetList = new ArrayList<Tweet>();
        for (int i = 0; i<tweets.size(); i++){
            TweetList.add(tweets.get(i));
        }
        return TweetList;
    }


}