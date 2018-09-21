package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {
    private String message;
    private Date date;


    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    // mood setter
    public void setMessage(String message) throws TooLongTweetException{
        if (message.length() > 140){
            throw new TooLongTweetException();
        }
        this.message = message;
    }

    // mood getter
    public String getMessage(){
        return this.message;
    }

    // date setter
    public void setDate(Date date){
        this.date = date;
    }

    // date getter
    public Date getDate(){
        return this.date;
    }

    // this is like the moodkind string that returns string
    public abstract Boolean isImportant();


}
