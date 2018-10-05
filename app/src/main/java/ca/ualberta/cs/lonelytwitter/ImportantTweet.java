package ca.ualberta.cs.lonelytwitter;

/*
 * ImportantTweet class
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

public class ImportantTweet extends Tweet{
    ImportantTweet() {

        super();
    }

    ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant(){

        return true;
    }
}
