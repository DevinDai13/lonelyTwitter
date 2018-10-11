package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;
import java.util.List;

import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;


/**
 * Created by romansky on 10/20/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client = null;

    // TODO we need a function which adds tweets to elastic search
    public static class AddTweetsTask extends AsyncTask<Tweet, Void, Void> {

        @Override
        protected Void doInBackground(Tweet... tweets) {
            setClient();
            Tweet tweet = tweets[0];

            Index index = new Index.Builder(tweet).index("testing").type("tweet").build();

            try {
                // where is the client?
                DocumentResult result = client.execute(index);
                if (result.isSucceeded()){
                    tweet.setTweetId(result.getId());
                }
            }
            catch (Exception e) {
                Log.i("Error", "The application failed to build and send the tweets");
            }


            return null;
        }
    }

    // TODO we need a function which gets tweets from elastic search
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String... search_parameters) {
            setClient();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            // TODO Build the query

            Search search = new Search.Builder(search_parameters[0])
                    .addIndex(search_parameters[0])
                    .addType("tweet")
                    .build();

            try {
               // TODO get the results of the query
                JestResult result = client.execute(search);
                if (result.isSucceeded()) {
                    List<Tweet> foundTweets = result.getSourceAsObjectList(Tweet.class);
                    tweets.addAll(foundTweets);
            } else {
                    Log.i("Error", "The search query failed");}
            }

            catch (Exception e) {
                Log.i("Error", "Something went wrong when we tried to communicate with the elasticsearch server!");
            }

            return tweets;
        }
    }

    public static void setClient() {
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}