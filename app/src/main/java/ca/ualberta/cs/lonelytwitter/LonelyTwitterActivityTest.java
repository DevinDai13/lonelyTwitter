package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(LonelyTwitterActivity.class);

    }

    @Override
    public void setUp(){
        solo = new Solo(getInstrumentation(), getActivity());

    }

    @Override
    public void tearDown(){
        solo.finishOpenedActivities();

    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong activity", "LonelyTwitterActivity");
    }

    public void testEqual(){
        assertEquals("Not equal", "5", "6");
    }

    public void testAddTweet(){
        solo.enterText((EditText) solo.getView(R.id.body), "New thing");  // enter new thing into the editext
        solo.clickOnButton("Save"); // "save" is the text on the button
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("New thing")); // to check if the New thing actually shows up.  is the save button working
    }


}








