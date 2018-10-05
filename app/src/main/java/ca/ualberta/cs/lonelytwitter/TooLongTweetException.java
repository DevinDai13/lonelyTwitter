package ca.ualberta.cs.lonelytwitter;

/*
 * TooLongTweetException class
 * version Lab 4
 * 05/10/2018
 */

/*
 * Exception class with a error message
 */

public class TooLongTweetException extends Exception{
    TooLongTweetException() {
        super("The message is too long! Please keep your tweets within 140 characters.");
    }
}
