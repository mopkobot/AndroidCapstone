package edu.Directions;

/* For my directions feature, the direction from the four states used (Iowa, Minnesota, Wisconsin, and Illinois) were taken and
 * hard-coded from depts.loras.edu/hr/directions.html. Unless these change, or if more hard-coded directions want to be added
 * to the app, this feature should never have to change. The "From Current Location" option uses an intent to start up the
 * Google Maps app in order to allow the user to get turn-by-turn directions to the college. 
 * This class also implements the class "States.java" where it reads in the different state information. 
 * 
 * Sources Cited: 
 * http://stackoverflow.com/questions/2662531/launching-google-maps-directions-via-an-intent-on-android
 * http://www.codevdo.com/Mobile/Android_Apps/0/1
 * 
 * Coded by: Jake Pfohl
 */

import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.HomeScreen.HomeScreen;

public class Directions extends SherlockListActivity implements States {
    // Creates an array with a length of the states array + 1
    String ary[] = new String[states.length + 1];

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets the ListAdapter to simple_list_item_1 using the options from the array "ary" created above
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ary));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Sets a ListView to the variable "lv" and gets the ListView
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < states.length; i++) {
                    if (position == i) {
                        // Based on which item in the ListView is clicked, this will create an intent using this class
                        // and the PrintStates.java class. Once it finds that state name, based on the array, it starts the
                        // activity based on the intent created so that the right state comes up when clicked on
                        Intent myIntent = new Intent(Directions.this, PrintStates.class);
                        Bundle b = new Bundle();
                        b.putString("stateName", ary[i]);
                        myIntent.putExtras(b);
                        startActivity(myIntent);
                    }
                }

                if (position == states.length) {
                    // If the last option is clicked in the ListView "From Current Location", then this intent opens up the
                    // Google Maps/Directions application and sets the destination address automatically to "Loras College" in
                    // Dubuque. The source address is left blank so that the user can fill in their address in order to get
                    // turn by turn directions to the college.
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr=&daddr=Loras College, Dubuque, IA"));
                    startActivity(intent);
                }
            }
        });

        // list of items
        for (int i = 0; i < states.length; i++) {
            ary[i] = states[i].getStateName();
        }
        ary[states.length] = "From Current Location";

    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to the home screen
                //
                // Set the Intent to launch to be the home screen
                Intent intent = new Intent(this, HomeScreen.class);
                // These flags are so if there's an instance of the home screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the home screen
                startActivity(intent);

                return true;
            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }
}
