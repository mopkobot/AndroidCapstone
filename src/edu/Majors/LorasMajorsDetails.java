package edu.Majors;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;

import java.util.ArrayList;

// This Activity is the details page of a given major at Loras College. The major's name, 
// description, and sample four year plans are presented. The four year plans are hyperlinks to 
// the PDF files on the http://www.loras.edu/ website.
// 
// The MajorsData interface is used to reference the constant array of Major objects for each 
// major.
//
// XML layout file(s) used: loras_majors_details.xml

public class LorasMajorsDetails extends SherlockActivity implements MajorsData {

    // Handles for the major title, description, and plan TextViews
    private TextView tvMajorTitle, tvMajorDescription, tvMajorPlans;

    private String majorName, majorDescription, majorPlans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // Required call to superclass for app lifecycle management

        // Get the Bundle that was packaged with the Intent
        Bundle b = getIntent().getExtras();

        // Get the name of the major that was selected from the Bundle
        majorName = b.getString("majorSelected");

        // Use the loras_majors_details.xml file for the UI layout
        setContentView(R.layout.loras_majors_details);

        // Enable the action bar's main icon (left-most icon) to go "up a level" when selected
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeViewValues();
    }

    private void initializeViewValues() {

        //String planURL, planURLText; // The URL and URL text for a given sample four year plan
        int majorNameIndex = 0;

        // Get the handles for the major title, description, and plan TextViews
        tvMajorTitle = (TextView) findViewById(R.id.majorTitle);
        tvMajorDescription = (TextView) findViewById(R.id.majorDescription);
        tvMajorPlans = (TextView) findViewById(R.id.majorPlans);

        // Display the major's name
        tvMajorTitle.setText(majorName);


        // Find the selected major in the MajorsData and save its position in the MajorsData
        // array
        for (int i = 0; i < MajorsData.length; i++) {
            if (majorName.equals(MajorsData[i].getTitle())) {
                majorNameIndex = i;
                i = MajorsData.length; // When the major is found, break out of the loop
            }
        }

        // Get the description for the major
        majorDescription = MajorsData[majorNameIndex].getDescription();

        // Build up the HTML string for displaying the four year plans as hyperlinks
        //
        // For each plan get the URL and URL text and build up an HTML string for the hyperlinks.
        // If there is more than 1 plan, use string concatenation to continue building the HTML
        // for displaying the plans.

        ArrayList<KeyValue<String, String>> plans = MajorsData[majorNameIndex].getPlans();

        for (int i = 0; i < plans.size(); i++) {

            if (i == 0) {
                majorPlans = "<a href=\"" + plans.get(i).getKey() + "\">" + plans.get(i).getValue() + "</a>";
            } else {
                majorPlans = majorPlans.concat("<br><br>" + "<a href=\"" + plans.get(i).getKey() + "\">" + plans.get(i).getValue() + "</a>");
            }
        }

        // Display the major's description
        tvMajorDescription.setText(majorDescription);

        // Display the major's sample four year plan(s) as hyperlink(s)
        tvMajorPlans.setText(Html.fromHtml(majorPlans));
        // Make the link(s) clickable
        tvMajorPlans.setMovementMethod(LinkMovementMethod.getInstance());
    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go "up a level" to the list of majors screen
                //
                // Set the Intent to launch to be the list of majors screen
                Intent intent = new Intent(this, LorasMajorsList.class);
                // These flags are so if there's an instance of the list of majors screen ListActivity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the list of majors screen
                startActivity(intent);

                return true;

            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }
}
