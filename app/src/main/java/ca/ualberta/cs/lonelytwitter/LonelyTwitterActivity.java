package ca.ualberta.cs.lonelytwitter;

/*
 * LonelyTwitterActivity class
 * Lab 4 version
 * 05/10/2018
 */
/*
 * This class is for controlling the main page that the user sees
 * It has control over the button clicks, listvew displays and the
 * saving and loading of the data from the list view
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.util.JsonToken.NULL;

public class LonelyTwitterActivity extends Activity {

	// Initialize all variables used in the class
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		Button clearButton = (Button) findViewById(R.id.clear);


		// save button action
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				NormalTweet newTweet = new NormalTweet();

				tweetList.add(newTweet);

				adapter.notifyDataSetChanged();

				saveInFile();
				//finish();

			}
		});



		// clear button action
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//setResult(RESULT_OK);

				tweetList.clear();

				adapter.notifyDataSetChanged();

				saveInFile();
				//finish();

			}
		});
	}


	// loads the data from the file
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	// loads the data form the file
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	// save the data to the file
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}
