/*
 * Name: Organizations
 * Purpose: Displays the title and description of an organization
 * Programmer: Aleksandar Serafimoski
 */
package edu.Organizations;
//Import internal libraries that we are using

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;

public class Organization extends SherlockActivity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        setContentView(R.layout.organizations);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //We receive the information from the ExpandableList1 class
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String info = b.getString("info");
        //We reference elements from the xml layout
        final TextView title = (TextView) findViewById(R.id.txtTitle);
        final TextView content = (TextView) findViewById(R.id.txtContent);
        //ImageView img1 = (ImageView)findViewById(R.id.img1);
        //Based on the information we display appropriate picture, title and description of organization
        title.setText(name);
        //img1.setImageResource(R.drawable.dewey);
        content.setText(info);
    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to the list of organizations screen
                //
                // Set the Intent to launch to be the list of organizations screen
                Intent intent = new Intent(this, ExpandableList1.class);
                // These flags are so if there's an instance of the list of organizations screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the list of organizations screen
                startActivity(intent);

                return true;
            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }
}