package edu.Directory;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

public class campusDirectory extends SherlockListActivity {

    // string array with each division
    String classes[] = {"Behavioral Sciences", "Business Administration", "Communication and Fine Arts", "Education", "Language and Literature", "Mathematics, Engineering and Computer Science", "Molecular and Life Sciences", "Philosophy, Religion and Theology", "Physical Education and Sport Studies", "Social and Cultural Studies"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        LayoutInflater inflator = getLayoutInflater();  // used to add the header
        View header = inflator.inflate(R.layout.campus_directory_header, getListView(), false); // adds the campus_drectory_header layout as a header to the top of the list
        getListView().addHeaderView(header, false, true); // adds header
        setListAdapter(new ArrayAdapter<String>(campusDirectory.this, R.layout.list_item, classes)); // generates the listview from the string array classes

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for action bar
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        String item = classes[position - 1]; // gets the selected division and stores it in a string (position - 1 since header reads as position 0)

        Class ourClass;
        try {
            ourClass = Class.forName("Departments");
            Intent ourIntent = new Intent(campusDirectory.this, ourClass);

            Bundle params = new Bundle(); // store parameters
            params.putString("department", item); //store the selected department name
            ourIntent.putExtras(params);
            startActivity(ourIntent); // start activity to display the proper department list
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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

