package ca.ualberta.cs.lonelytwitter;

/*
 * CurrentMood Class
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

public abstract class CurrentMood {
    private String mood;
    private Date currentDate;

    // default date constructor
    public CurrentMood(String mood){
        this.mood = mood;
        this.currentDate = new Date();
    }

    // constructor that takes in date as an argument
    public CurrentMood(String mood, Date currentDate){
        this.mood = mood;
        this.currentDate = currentDate;
    }


    // mood setter
    public void setMood(String mood){
        this.mood = mood;
    }

    // mood getter
    public String getMood(){
        return this.mood;
    }

    // date setter
    public void setCurrentDate(Date currentDate){
        this.currentDate = currentDate;
    }

    // date getter
    public Date getDate(){
        return this.currentDate;
    }

    public abstract String moodKind();

}



