package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }

    public void testAddTweet(){
        //assertTrue(Boolean.FALSE);
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }


    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.add(tweet);
        assertEquals(1, tweets.getCount());
    }


    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.add(tweet);
        Tweet returnTweet = tweets.getTweet(0);
        assertEquals(returnTweet.getMessage(), tweet.getMessage());
        assertEquals(returnTweet.getDate(), tweet.getDate());

    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet tweet2 = new NormalTweet("tweet2");
        Tweet tweet3 = new NormalTweet("tweet3");
        tweets.add(tweet);
        tweets.add(tweet2);
        tweets.add(tweet3);
        tweets.getTweets();
    }
}















