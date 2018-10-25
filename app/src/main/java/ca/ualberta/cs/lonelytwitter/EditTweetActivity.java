package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        TextView message = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String tweetToDisplay =intent.getStringExtra("tweetContent");
        message.setText(tweetToDisplay);
    }
}
