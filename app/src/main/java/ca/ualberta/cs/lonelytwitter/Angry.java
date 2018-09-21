package ca.ualberta.cs.lonelytwitter;

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
