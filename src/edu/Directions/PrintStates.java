package edu.Directions;

/* This class is used to link all of the TextViews up with the Directions.xml file. Once that is done, it uses the
 * State.java class methods to set each TextView to the correct state name, title, description, etc. for each state.
 * It also uses a bundle to get the state name. 
 * 
 * Sources Cited: 
 * http://www.codevdo.com/Mobile/Android_Apps/0/1
 * 
 * Coded by: Jake Pfohl
 */

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import edu.HomeScreen.R;


public class PrintStates extends SherlockActivity implements States {
    /**
     * Called when the activity is first created.
     */

    // Initializing the nine different TextViews used to display the text
    TextView display0, display1, display2, display3, display4, display5, display6, display7, display8;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets the ContentView to use "directions.xml"
        setContentView(R.layout.directions);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        String stateName = b.getString("stateName");

        // This links all of the java TextView variables to their appropriate IDs in the Directions.xml file

        display0 = (TextView) findViewById(R.id.tvDisplay0);
        display1 = (TextView) findViewById(R.id.tvDisplay1);
        display2 = (TextView) findViewById(R.id.tvDisplay2);
        display3 = (TextView) findViewById(R.id.tvDisplay3);
        display4 = (TextView) findViewById(R.id.tvDisplay4);
        display5 = (TextView) findViewById(R.id.tvDisplay5);
        display6 = (TextView) findViewById(R.id.tvDisplay6);
        display7 = (TextView) findViewById(R.id.tvDisplay7);
        display8 = (TextView) findViewById(R.id.tvDisplay8);

        for (int i = 0; i < states.length; i++) {
            // This goes through all the states in States.java and sets each TextView to the appropriate state name, titles,
            // and descriptions for each state. That is, the titles for each paragraph are bolded whereas the normal writing
            // for the directions is not, etc.
            if (stateName.equals(states[i].getStateName())) {
                // set text views
                display0.setText(states[i].getStateName());
                display1.setText(states[i].getTitle1());
                display2.setText(states[i].getDescription1());
                display3.setText(states[i].getTitle2());
                display4.setText(states[i].getDescription2());
                display5.setText(states[i].getTitle3());
                display6.setText(states[i].getDescription3());
                display7.setText(states[i].getTitle4());
                display8.setText(states[i].getDescription4());
            }

        }

    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to the location to start from screen
                //
                // Set the Intent to launch to be the location to start from screen
                Intent intent = new Intent(this, Directions.class);
                // These flags are so if there's an instance of the location to start from screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the location to start from screen
                startActivity(intent);

                return true;
            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }
}