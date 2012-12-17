package edu.MapsCommon;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;

/*
 * This class shows the information screen for a particular location. The information includes a picture and description of the
 * location. To get to the information screen, the user has to tap on an icon on the map from either the Map Explorer feature 
 * or the Virtual Tour feature. 
 * 
 * XML Layout: location_info.xml
 * 
 * Programmer: Justin Steines
 */

public class LocationInfoActivity extends SherlockActivity implements Locations {

    TextView locationName;
    TextView locationDescription;
    ImageView locationImage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // the MapOverlay class passes the name of the location the user tapped on to this class
        // this information is used to display the appropriate information
        Bundle b = getIntent().getExtras();
        String Title = b.getString("locationName");

        // link java variables to XML
        locationName = (TextView) findViewById(R.id.locationName);
        locationDescription = (TextView) findViewById(R.id.locationDescription);
        locationImage = (ImageView) findViewById(R.id.locationImage);

        // set title (the name of the location, which was passed from the MapOverlay class)
        locationName.setText(Title);

        // search the Locations array for the location name that was passed and display that location's information
        for (int i = 0; i < Locations.length; i++) {
            if (Title.equals(Locations[i].getLocationName())) {
                // set description (uses HTML in case hyper-links need to be inserted into the description)
                locationDescription.setText(Html.fromHtml(Locations[i].getDescription()));
                locationDescription.setMovementMethod(LinkMovementMethod.getInstance());
                // set image
                locationImage.setImageResource(Locations[i].getImage());
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
                // Go to the previous screen
                super.onBackPressed();

                return true;

            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }

}
