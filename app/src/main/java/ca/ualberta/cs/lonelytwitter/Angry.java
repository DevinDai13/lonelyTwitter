package ca.ualberta.cs.lonelytwitter;

/*
 * Angry class
 * version Lab 4
 * 05/10/2018
 */

/*
 * The class represents a specific emotion and it extends the abstract class
 * CurrentMood. It represents an inheritance relation with the CurrentMood class
 * So it has access to all the methods and variable in CurrentMood and can have its own
 * unique methods
 */

import java.util.Date;

public class Angry extends CurrentMood{

    public Angry(String mood){
        super(mood);
    }

    public Angry(String mood, Date currentDate){
        super(mood, currentDate);
    }

    public String moodKind(){
        return "Angry";
    }
}
