package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Scared extends CurrentMood{
    public Scared(String mood){
        super(mood);
    }

    public Scared(String mood, Date currentDate){
        super(mood, currentDate);
    }

    public String moodKind(){
        return "Scared";
    }
}
