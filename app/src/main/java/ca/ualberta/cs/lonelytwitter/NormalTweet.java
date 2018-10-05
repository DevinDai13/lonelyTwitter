package ca.ualberta.cs.lonelytwitter;

/*
 * NormalTweet class
 * version Lab 4
 * 05/10/2018
 */

/*
 * The class represents a specific emotion and it extends the abstract class
 * Tweet. It represents an inheritance relation with the Tweet class
 * So it has access to all the methods and variable in CurrentMood and can have its own
 * unique methods
 */


import java.util.Date;

public class NormalTweet extends Tweet {

    NormalTweet() {
        super();
    }

    NormalTweet(String message) {

        super(message);
    }

    @Override
    public Boolean isImportant(){

        return false;
    }
}

