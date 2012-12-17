// Got some help from: http://developer.android.com/resources/tutorials/views/hello-listview.html

package edu.Majors;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;


// This Activity presents the list of majors at Loras College. Selecting one will take you to 
// a new screen/Activity of detailed information about the selected major.
//
// XML layout file(s) used: list_item.xml

public class LorasMajorsList extends SherlockListActivity implements MajorsData {

    private String[] majors; // Array to contain the titles of the majors


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // Required call to superclass for app lifecycle management

        // Enable the action bar's main icon (left-most icon) to go "up a level" when selected
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the length of the array to contain the titles of the majors to be the same size 
        // as the MajorsData array
        majors = new String[MajorsData.length];

        // Store the titles of the majors into the new array
        for (int i = 0; i < MajorsData.length; i++) {

            majors[i] = MajorsData[i].getTitle();
        }


        // Make the list using an array of strings (which strings are the titles of the majors)
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, majors));

        // Get the list of major titles
        ListView list = getListView();

        // Enable the list of major titles to be selectable
        list.setOnItemClickListener(new OnItemClickListener() {

            // When a major title is selected, do something
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Set the Intent to launch to be the majors details page
                Intent detailsIntent = new Intent(LorasMajorsList.this, LorasMajorsDetails.class);
                // Create a new Bundle
                Bundle detailsBundle = new Bundle();
                // Add the name of the selected major to the Bundle
                detailsBundle.putString("majorSelected", majors[(int) id]);
                // Put the Bundle in the Intent
                detailsIntent.putExtras(detailsBundle);
                // Launch the majors details page
                startActivity(detailsIntent);
            }
        });
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
