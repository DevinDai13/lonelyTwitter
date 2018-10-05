package ca.ualberta.cs.lonelytwitter;

/*
 * Tweet Class
 * Lab 4 version
 *
 * 05/10/2018
 *
 */

/*
 * Tweet class holds the various setters and getters for various attributes of a particular tweet
 * It is an abstract class that implements the interface Tweetable
 */
import java.util.Date;

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    //Empty argument constructor with default values
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
    }

    //Overloading: so that we can specify the tweet content
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    // returns the message associated with a particular tweet
    public String getMessage() {

        return this.message;
    }

    // set the message associated with a tweet and also error check the length
    public void setMessage(String message) throws TooLongTweetException {
        if (message.length() <= this.MAX_CHARS) {
            this.message = message;
        } else {
            throw new TooLongTweetException();
        }
    }

    // returns the date of a tweet
    public Date getDate() {
        return this.date;
    }

    // returns the diaplay of a tweet
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }


    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();
}
