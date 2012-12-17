package edu.VirtualTour;

import edu.MapsCommon.Locations;
import edu.MapsCommon.location;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockMapActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.maps.*;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

import java.util.List;

// This MapActivity is the main Virtual Tour screen with the map. It shows the Google Map provided 
// map with the tour locations and the map navigation control at the bottom.
//
// The Locations interface is used to reference the constant array of location objects for each 
// location.
//
// XML layout file(s) used: tour.xml, tour_menu.xml for action bar

public class TourActivity extends SherlockMapActivity implements Locations {
    private MapView mapView; // Handle for MapView
    private MapController mapController; // Handle for MapController
    private List<Overlay> mapOverlays; // A list of the various map overlays
    private TourOverlay myOverlay; // Overlay used for the virtual tour
    private Projection projection; // Used to translate between x/y screen coordinates and lat/long geo coordinates
    private ImageButton leftArrow; // Left arrow button on navigation control
    private ImageButton rightArrow; // Right arrow button on navigation control
    private location currentTourLocation; // Current location on the tour
    private location[] tourLocations; // Array of all locations on the tour
    private int currentTourLocationIndex; // Index for the tourLocations array for accessing the current tour location
    private TextView tourNavBarText; // Contains text of current tour location

    private TourOverlay currentLocationOverlay; // Overlay for the current location marker


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Required call to superclass for app lifecycle management
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tour); // Use tour.xml as the UI layout

        // Enable the action bar's main icon (left-most icon) to go "up a level" when selected
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get handles on left and right arrow button Views in the navigation bar
        leftArrow = (ImageButton) findViewById(R.id.leftArrow);
        rightArrow = (ImageButton) findViewById(R.id.rightArrow);

        // Get handle on View for the tour navigation bar text
        tourNavBarText = (TextView) findViewById(R.id.tourNavBar);

        // Get a handle on the MapView for the map
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true); // Use the built-in zoom controls
        mapOverlays = mapView.getOverlays(); // Get the map overlays associated with the MapView
        mapView.setSatellite(true); // Use satellite view

        // Get the MapView's MapController
        mapController = mapView.getController();

        // Initialize current tour location, current location text, and current tour location 
        // zoom extent
        //
        // If the Activity was started with other (state) data (such as data that was saved when a screen 
        // orientation change occurred)
        if (savedInstanceState != null) {

            // If the map was in satellite view, set the map style to satellite view again
            if (savedInstanceState.getBoolean("currentMapInSatelliteView")) {
                mapView.setStreetView(false);
                mapView.setSatellite(true);
            } else { // Otherwise it was street view, so set it to that instead
                mapView.setSatellite(false);
                mapView.setStreetView(true);
            }

            // Get the array index for what was the current tour location for the tourLocations array that
            // holds the tour locations
            currentTourLocationIndex = savedInstanceState.getInt("currentTourLocationIndex");

            // Get what was the current zoom level
            mapController.setZoom(savedInstanceState.getInt("currentZoomLevel"));
        } else { // Otherwise the Activity wasn't started with any state data, so start fresh with default settings

            // Set the map style to satellite view
            mapView.setSatellite(true);

            currentTourLocationIndex = 0; // Set starting tour location to the first location in the tourLocations array
            mapController.setZoom(20); // Set the default zoom level to 20 (larger number == closer zoom)
        }


        // Get all the locations that are on the virtual tour
        tourLocations = InitializeTourLocationsList.getTourLocationsList();

        // Get the current tour location
        currentTourLocation = tourLocations[currentTourLocationIndex];
        // Set the navigation bar text to be the name of the current location
        tourNavBarText.setText(currentTourLocation.getLocationName());

        // Pan the map to the current tour location
        mapController.animateTo(currentTourLocation.getGeoPoint());


        // Set up map overlay for regular location markers using non-current location icon
        myOverlay = new TourOverlay(this.getResources().getDrawable(R.drawable.ico_vt_passive), this, this);

        // Make an OverlayItem for each tour location and add them to the non-current location TourOverlay
        for (int i = 0; i < tourLocations.length; i++) {

            myOverlay.addOverlay(new OverlayItem(tourLocations[i].getGeoPoint(), tourLocations[i].getLocationName(), tourLocations[i].getDescription()));
        }

        // Set up map overlay for current location marker using current location icon
        currentLocationOverlay = new TourOverlay(this.getResources().getDrawable(R.drawable.ico_vt_active), this, this);
        // Make an OverlayItem for the current tour location and add it to the current location TourOverlay
        currentLocationOverlay.addOverlay(new OverlayItem(currentTourLocation.getGeoPoint(), currentTourLocation.getLocationName(), currentTourLocation.getDescription()));

        // Set up and add overlay for lines connecting locations
        projection = mapView.getProjection();
        // Add the lines overlay to the overall map overlays
        mapOverlays.add(new LinesTourOverlay(projection));

        // Add overlay for non-current tour locations to the overall map overlays
        mapOverlays.add(myOverlay);

        // Add overlay for current tour location to the overall map overlays
        mapOverlays.add(currentLocationOverlay);
    }

    // Abstract method that must be implemented when subclassing a MapActivity

    protected boolean isRouteDisplayed() {
        return false;
    }

    // Click handler for pressing left and right arrows on navigation bar
    public void onClick(View v) {

        // If the left arrow was pressed
        if (v.getId() == leftArrow.getId()) {

            // Go to the previous campus location in the tourLocations array. Perform checks so
            // that array indexing stays in bounds
            if (currentTourLocationIndex > 0) {
                currentTourLocationIndex--;
            } else if (currentTourLocationIndex == 0) {
                currentTourLocationIndex = tourLocations.length - 1;
            }

        } else if (v.getId() == rightArrow.getId()) { // Otherwise if the right arrow was pressed

            // Go to the next campus location in the tourLocations array. Perform checks so
            // that array stays in bounds
            if (currentTourLocationIndex < tourLocations.length - 1) {
                currentTourLocationIndex++;
            } else if (currentTourLocationIndex == tourLocations.length - 1) {
                currentTourLocationIndex = 0;
            }

        }

        // Set the new current tour location
        currentTourLocation = tourLocations[currentTourLocationIndex];

        // Set then new current location's name in the navigation bar
        tourNavBarText.setText(currentTourLocation.getLocationName());

        // Remove the overlay that has the (now old) current tour location
        mapOverlays.remove(currentLocationOverlay);

        // Set up map overlay for current location marker using current location icon
        currentLocationOverlay = new TourOverlay(this.getResources().getDrawable(R.drawable.ico_vt_active), this, this);
        // Make an OverlayItem for the new current tour location and add it to the current location TourOverlay
        currentLocationOverlay.addOverlay(new OverlayItem(currentTourLocation.getGeoPoint(), currentTourLocation.getLocationName(), currentTourLocation.getDescription()));

        // Add overlay for new current tour location to the overall map overlays
        mapOverlays.add(currentLocationOverlay);

        // Pan the new current location into view
        mapController.animateTo(currentTourLocation.getGeoPoint());
    }

    // Getter method for getting the current tour location
    public location getCurrentTourLocation() {

        return currentTourLocation;
    }

    // This method saves the state data that would otherwise be lost if the Activity is killed. 
    // This is mainly used for preserving state upon device orientation change, which restarts the 
    // Activity.
    @Override
    protected void onSaveInstanceState(Bundle b) {

        // Preserve array index of current tour location, map style, and zoom level
        b.putInt("currentTourLocationIndex", currentTourLocationIndex);
        b.putBoolean("currentMapInSatelliteView", mapView.isSatellite());
        b.putInt("currentZoomLevel", mapView.getZoomLevel());

        super.onSaveInstanceState(b); // Required call to superclass for app lifecycle management
    }

    // Method required to create menu (used here for Actionbar Sherlock, which uses menu options 
    // for action bar options)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Reference the menu defined for virtual tour
        getSupportMenuInflater().inflate(R.menu.tour_menu, menu);

        return true;
    }

    // Method for what to do when menu options (in our case, action bar options) are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go "up a level" to the home screen
                //
                // Set the Intent to launch to be the Home screen
                Intent intent = new Intent(this, HomeScreen.class);
                // These flags are so if there's an instance of the home screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the home screen
                startActivity(intent);

                return true;

            // If the suggested zoom level icon was selected
            case R.id.zoom_level:
                // Set the zoom level to be the suggested/
                mapController.setZoom(20);

                return true;

            // If the map style icon was selected
            case R.id.map_style:
                // If the map was in satellite view, switch to street view
                if (mapView.isSatellite() == true) {
                    mapView.setSatellite(false);
                    mapView.setStreetView(true);
                } else { // Otherwise the map was in street view, so switch to satellite view
                    mapView.setStreetView(false);
                    mapView.setSatellite(true);
                }

                return true;

            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }

}