package edu.MapExplorer;

import edu.MapsCommon.Locations;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.actionbarsherlock.app.SherlockMapActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.maps.*;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

import java.util.Arrays;
import java.util.List;

/* 
 * This class is the main Map Explorer screen. It shows a map of Loras College with icons (overlay items) over important 
 * campus locations. When an icon is clicked on, the MapOverlay class defines what to do. The Action Bar menu options 
 * for the Map Explorer are defined within this class. 
 * 
 * XML file: maps.xml
 * 
 * References Used:
 * http://developer.android.com/resources/tutorials/views/hello-mapview.html
 * http://developer.android.com/guide/topics/ui/dialogs.html
 * http://eagle.phys.utk.edu/guidry/android/mapOverlayDemo.html
 * http://code.google.com/android/add-ons/google-apis/reference/com/google/android/maps/MapController.html
 * 
 * Programmer: Justin Steines
 */

public class MapsActivity extends SherlockMapActivity implements Locations {
    // create a MapView and a MapController to interact with the map
    private MapView mapView;
    private MapController mapController;

    // declare an array for the icon overlays
    private List<Overlay> mapOverlays;

    // declare different types of icons for the map
    MyItemizedOverlay eatOverlay, sleepOverlay, studyOverlay, havefunOverlay, eat_study_havefun_multiOverlay, sleep_study_multiOverlay, study_havefun_multiOverlay;

    // declare dialog boxes for the Action Bar menu options
    AlertDialog layersDialog, locationsDialog, viewsDialog;

    // these variables are initialized to true because the layersDialog starts with all of these options checked
    private boolean isEatChecked = true, isSleepChecked = true, isStudyChecked = true, isHaveFunChecked = true;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // standard
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // create a map view
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapOverlays = mapView.getOverlays();

        // create a map controller
        mapController = mapView.getController();

        // initialize overlays
        eatOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_eat), this);
        sleepOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_sleep), this);
        studyOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_study), this);
        havefunOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_havefun), this);
        eat_study_havefun_multiOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_eat_study_havefun), this); // ACC, Hoffmann Hall
        sleep_study_multiOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_sleep_study), this);          // Vis, all resident halls
        study_havefun_multiOverlay = new MyItemizedOverlay(this.getResources().getDrawable(R.drawable.ico_study_havefun), this);      // K, Belmont house

        // create new overlays
        for (int i = 0; i < Locations.length; i++) {
            if (Locations[i].getCategory().equals("eat")) // if a location is categorized as only a place to eat, it will be added to eatOverlay
            {
                eatOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("sleep")) // if a location is categorized as only a place to sleep, it will be added to sleepOverlay
            {
                sleepOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("study")) // if a location is categorized as only a place to study, it will be added to the studyOverlay
            {
                studyOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("havefun")) // if a location is categorized as only a place to have fun, it will be added to havefunOverlay
            {
                havefunOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("eat_study_havefun")) // if a location is categorized as a place to eat, study, and have fun, it will be added to eat_study_havefun_multiOverlay
            {
                eat_study_havefun_multiOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("sleep_study")) // if a location is categorized as a place to sleep and study, it will be added to sleep_study_multiOverlay
            {
                sleep_study_multiOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
            if (Locations[i].getCategory().equals("study_havefun")) // if a location is categorized as a place to study and have fun, it will be added to the study_havefun_multiOverlay
            {
                study_havefun_multiOverlay.addOverlay(new OverlayItem(Locations[i].getGeoPoint(), Locations[i].getLocationName(), Locations[i].getDescription()));
            }
        }

        boolean[] checked = {false, false, false, false};

        // Activity life cycle?
        if (savedInstanceState != null) {
            if (savedInstanceState.getBooleanArray("overlayList")[0]) {
                mapOverlays.add(eatOverlay);
                checked[0] = true;
            }
            if (savedInstanceState.getBooleanArray("overlayList")[1]) {
                mapOverlays.add(sleepOverlay);
                checked[1] = true;
            }
            if (savedInstanceState.getBooleanArray("overlayList")[2]) {
                mapOverlays.add(studyOverlay);
                checked[2] = true;
            }
            if (savedInstanceState.getBooleanArray("overlayList")[3]) {
                mapOverlays.add(havefunOverlay);
                checked[3] = true;
            }
            if (savedInstanceState.getBooleanArray("overlayList")[4]) {
                mapOverlays.add(eat_study_havefun_multiOverlay);
            }
            if (savedInstanceState.getBooleanArray("overlayList")[5]) {
                mapOverlays.add(sleep_study_multiOverlay);
            }
            if (savedInstanceState.getBooleanArray("overlayList")[6]) {
                mapOverlays.add(study_havefun_multiOverlay);
            }

            if (savedInstanceState.getBoolean("currentMapInSatelliteView")) {
                mapView.setStreetView(false);
                mapView.setSatellite(true);
            } else {
                mapView.setSatellite(false);
                mapView.setStreetView(true);
            }

            int latitude = savedInstanceState.getInt("latitude");
            int longitude = savedInstanceState.getInt("longitude");

            mapController.animateTo(new GeoPoint(latitude, longitude));
            mapController.setZoom(savedInstanceState.getInt("currentZoomLevel"));
        } else {
            // display overlays on the map
            mapOverlays.add(eatOverlay);
            mapOverlays.add(sleepOverlay);
            mapOverlays.add(studyOverlay);
            mapOverlays.add(havefunOverlay);
            mapOverlays.add(eat_study_havefun_multiOverlay);
            mapOverlays.add(sleep_study_multiOverlay);
            mapOverlays.add(study_havefun_multiOverlay);

            // all the layers in the layersDialog are checked so the checked array is initialized to true
            checked[0] = true;
            checked[1] = true;
            checked[2] = true;
            checked[3] = true;

            mapView.setSatellite(true);

            // set the location and zoom level to display when the Activity is created
            //mapController.animateTo(new GeoPoint(42503860, -90679350));
            mapController.animateTo(new GeoPoint(42503670, -90679330));
            mapController.setZoom(18); // the larger the number, the closer the zoom
        }

        // CREATE A "LAYERS" ALERT DIALOG BOX
        // This is a menu option in the Action Bar that allows the user to remove certain overlay items from displaying on the map       
        final String[] layers = {"Eat", "Sleep", "Study", "Have Fun"}; // create a new string array and store the different layers (dialog options) in it
        AlertDialog.Builder layersDialogBuilder = new AlertDialog.Builder(this); // create a new MultiChoiceItems dialog that lists the layers as check boxes
        layersDialogBuilder.setTitle("Activity Layers"); // title of the dialog popup
        layersDialogBuilder.setMultiChoiceItems(layers, checked, new OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (layers[which].equals(layers[0]))         // if the selected item is "Eat"
                {
                    if (isChecked == true)                     // if the user selects "Eat", add all layers to the map that correspond to a place where students can eat
                    {
                        mapOverlays.add(eatOverlay);
                        mapOverlays.add(eat_study_havefun_multiOverlay);
                        isEatChecked = true;
                    }
                    if (isChecked == false)                    // if the user deselects "Eat", remove only the eat layer
                    {
                        mapOverlays.remove(eatOverlay);
                        isEatChecked = false;
                    }
                }
                if (layers[which].equals(layers[1]))         // if the selected item is "Sleep"
                {
                    if (isChecked == true)                    // if the user selects "Sleep", add all layers to the map that correspond to a place where students can sleep
                    {
                        mapOverlays.add(sleepOverlay);
                        mapOverlays.add(sleep_study_multiOverlay);
                        isSleepChecked = true;
                    }
                    if (isChecked == false)                    // if the user deselects "Sleep", remove only the sleep layer
                    {
                        mapOverlays.remove(sleepOverlay);
                        isSleepChecked = false;
                    }
                }
                if (layers[which].equals(layers[2]))         // if the selected item is "Study"
                {
                    if (isChecked == true)                    // if the user selects "Study", add all layers to the map that correspond to a place where students can study
                    {
                        mapOverlays.add(studyOverlay);
                        mapOverlays.add(eat_study_havefun_multiOverlay);
                        mapOverlays.add(sleep_study_multiOverlay);
                        mapOverlays.add(study_havefun_multiOverlay);
                        isStudyChecked = true;
                    }
                    if (isChecked == false)                    // if the user deselects "Study", remove only the study layer
                    {
                        mapOverlays.remove(studyOverlay);
                        isStudyChecked = false;
                    }
                }
                if (layers[which].equals(layers[3]))         // if the selected item is "Have Fun"
                {
                    if (isChecked == true) {
                        mapOverlays.add(havefunOverlay);    // if the user selects "Have Fun", add all layers to the map that correspond to a place where students can have fun
                        mapOverlays.add(eat_study_havefun_multiOverlay);
                        mapOverlays.add(study_havefun_multiOverlay);
                        isHaveFunChecked = true;
                    }
                    if (isChecked == false)                    // if the user deselects "Have Fun", remove only the have fun layer
                    {
                        mapOverlays.remove(havefunOverlay);
                        isHaveFunChecked = false;
                    }
                }
            }
        });
        layersDialogBuilder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
            /* When the user hits the "Apply" button, the following code checks to see which items are not checked in the
                * layersDialog. Depending on what is checked or not checked, appropriate multi icons are removed from the map.
                * For some reason, the multi icons would not always disappear the first time the user hit "Apply", so the code
                * is contained within a loop to make sure the icons disappear the first attempt like they are supposed to.
                */
            public void onClick(DialogInterface dialog, int id) {
                for (int i = 0; i < 5; i++) {
                    if (!isEatChecked && !isStudyChecked && !isHaveFunChecked) {
                        mapOverlays.remove(eat_study_havefun_multiOverlay);
                    }
                    if (!isSleepChecked && !isStudyChecked) {
                        mapOverlays.remove(sleep_study_multiOverlay);
                    }
                    if (!isStudyChecked && !isHaveFunChecked) {
                        mapOverlays.remove(study_havefun_multiOverlay);
                    }
                    mapView.postInvalidate(); // refresh the map view when the user hits "Apply"
                }
            }
        });
        layersDialog = layersDialogBuilder.create();

        // CREATE A "LOCATIONS" ALERT DIALOG BOX
        // This allows the user to view a list of all the locations on the map, in alphabetical order
        // create a new string array and store all the location names in it
        final String[] locationNames = new String[Locations.length];
        for (int i = 0; i < Locations.length; i++) {
            locationNames[i] = Locations[i].getLocationName();
        }
        Arrays.sort(locationNames); // sort the location names alphabetically
        // create a new dialog that lists all the locations
        AlertDialog.Builder locationsDialogBuilder = new AlertDialog.Builder(this);
        locationsDialogBuilder.setTitle("Campus Locations"); // title of the dialog popup
        locationsDialogBuilder.setItems(locationNames, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < Locations.length; i++) {
                    if (Locations[i].getLocationName().equals(locationNames[which])) {
                        // when a location is clicked on, animate to that location's geopoint and zoom in
                        mapController.animateTo(Locations[i].getGeoPoint());
                    }
                }
                // set the zoom level to 20
                mapController.setZoom(20);
            }
        });
        locationsDialog = locationsDialogBuilder.create();
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // get the menu layout from the xml file
        getSupportMenuInflater().inflate(R.menu.maps_menu, menu);
        return true;
    }

    // determine what to do when an action bar menu item is clicked on
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, HomeScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            case R.id.activity_layers:                 // if the layers icon is clicked on
                layersDialog.show();                 // call the layers alert dialog that was created in the OnCreate() method
                return true;
            case R.id.campus_locations:                 // if the locations icon is clicked on
                locationsDialog.show();             // call the locations alert dialog that was created in the OnCreate() method
                return true;
            case R.id.zoom_level_exp:                // if the zoom icon is clicked on
                mapController.setZoom(20);            // zoom to the recommended level
                return true;
            case R.id.map_style_exp:                // if the views menu is clicked on
                if (mapView.isSatellite() == true)   // switch to either satellite or map view
                {
                    mapView.setSatellite(false);
                    mapView.setStreetView(true);
                } else {
                    mapView.setStreetView(false);
                    mapView.setSatellite(true);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // This method saves the state data that would otherwise be lost if the Activity is killed. 
    // This is mainly used for preserving state upon device orientation change, which restarts the 
    // Activity.
    @Override
    protected void onSaveInstanceState(Bundle b) {
        // Preserve what's at the center of the map
        //
        // Get the GeoPoint that is at the center of the map
        GeoPoint currentPoint = mapView.getMapCenter();
        int latitude = currentPoint.getLatitudeE6(); // Get the map center's latitude
        int longitude = currentPoint.getLongitudeE6(); // Get the map center's longitude
        b.putInt("latitude", latitude); // Save the latitude
        b.putInt("longitude", longitude); // Save the longitude

        // Preserve the current map style
        b.putBoolean("currentMapInSatelliteView", mapView.isSatellite());
        // Preserve the current zoom level
        b.putInt("currentZoomLevel", mapView.getZoomLevel());

        // Preserve the overlays that are applied to the map
        //
        // Overlay mapping in overlayList: eat, sleep, study, havefun, eat_study_havefun, sleep_study, study_havefun
        boolean overlayList[] = {false, false, false, false, false, false, false};

        // Keep track of which overlays for student activities are currently on
        if (mapOverlays.contains(eatOverlay)) {
            overlayList[0] = true;
        }
        if (mapOverlays.contains(sleepOverlay)) {
            overlayList[1] = true;
        }
        if (mapOverlays.contains(studyOverlay)) {
            overlayList[2] = true;
        }
        if (mapOverlays.contains(havefunOverlay)) {
            overlayList[3] = true;
        }
        if (mapOverlays.contains(eat_study_havefun_multiOverlay)) {
            overlayList[4] = true;
        }
        if (mapOverlays.contains(sleep_study_multiOverlay)) {
            overlayList[5] = true;
        }
        if (mapOverlays.contains(study_havefun_multiOverlay)) {
            overlayList[6] = true;
        }

        // Save the state of the student activity overlays
        b.putBooleanArray("overlayList", overlayList);

        super.onSaveInstanceState(b); // Required call to superclass for app lifecycle management
    }

}