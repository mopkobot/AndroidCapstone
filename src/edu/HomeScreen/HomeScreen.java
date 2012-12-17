// Based on example here: http://www.mkyong.com/android/android-gridview-example/

package edu.HomeScreen;

import edu.Calendar.MenuCalendar;
import edu.CheckList.SavedChecklist;
import edu.Directions.Directions;
import edu.Directory.campusDirectory;
import edu.Majors.LorasMajorsList;
import edu.MapExplorer.MapsActivity;
import edu.Organizations.ExpandableList1;
import edu.PhotoGallery.CoverFlowExample;
import edu.RequestInfo.requestInformation;
import edu.ScheduleVisit.Visit;
import edu.VirtualTour.TourActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


// This Activity is the dashboard-style home screen for the app. This page features the
// "launcher icons" for the various features of the app, as well as acces to the About page.
//
// XML layout file(s) used: home.xml (overall layout), dashboard_element.xml (for each feature's 
// icon and label), home_screen_menu.xml for action bar

public class HomeScreen extends SherlockActivity {


    GridView theGridView; // Feature icons and labels are elements of a GridView

    // Create an array containing the names of the features to be displayed
    //
    // For some reason, the app crashes at runtime when initializing an array with a strings.xml
    // value using getResources().getString(). Therefore, these are hardcoded here.
    final String[] features = new String[]{"Academic Calendar", "Campus Directory", "Checklist",
            "Directions", "Majors", "Map Explorer", "Photo Gallery", "Request Info",
            "Schedule a Visit", "Student Orgs", "Virtual Tour"};

    // This integer array associates icons with each feature label listed in the "features" array
    final int[] featureIcons = new int[]{R.drawable.hic_calendar, R.drawable.hic_directory, R.drawable.hic_checklist,
            R.drawable.hic_directions, R.drawable.hic_majors, R.drawable.hic_explorer, R.drawable.hic_gallery,
            R.drawable.hic_requestinfo, R.drawable.hic_visit, R.drawable.hic_orgs, R.drawable.hic_tour};


    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Required call to superclass for app lifecycle management
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home); // Use home.xml as the main UI layout

        // Get a handle to the GridView that will contain the feature icons/labels
        theGridView = (GridView) findViewById(R.id.gridView1);

        // Use an ImageViewAdapter on the GridView to display ImageViews in the GridView
        // elements (this custom implementation also displays the TextView for the labels)
        theGridView.setAdapter(new ImageViewAdapter(this, features, featureIcons));

        // Click handler for the GridView
        theGridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Given the position of the selected feature in the GridView, start the Activity
                // to launch that corresponding feature

                if (position == 0) {
                    // Academic Calendar
                    Intent myIntent = new Intent(view.getContext(), MenuCalendar.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 1) {
                    // Campus Directory
                    Intent myIntent = new Intent(view.getContext(), campusDirectory.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 2) {
                    // Student Checklist
                    Intent myIntent = new Intent(view.getContext(), SavedChecklist.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 3) {
                    // Directions
                    Intent myIntent = new Intent(view.getContext(), Directions.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 4) {
                    // Majors
                    Intent myIntent = new Intent(view.getContext(), LorasMajorsList.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 5) {
                    // Map Explorer
                    Intent myIntent = new Intent(view.getContext(), MapsActivity.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 6) {
                    // Photo Gallery
                    Intent myIntent = new Intent(view.getContext(), CoverFlowExample.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 7) {
                    // Request Information
                    Intent myIntent = new Intent(view.getContext(), requestInformation.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    // Schedule a Visit
                    Intent myIntent = new Intent(view.getContext(), Visit.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    // Student Organizations
                    Intent myIntent = new Intent(view.getContext(), ExpandableList1.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    // Virtual Tour
                    Intent myIntent = new Intent(view.getContext(), TourActivity.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }

    // Method required to create menu (used here for Actionbar Sherlock, which uses menu options
    // for action bar options)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Reference the menu defined for the home screen
        getSupportMenuInflater().inflate(R.menu.home_screen_menu, menu);

        return true;
    }

    // Method for what to do when menu options (in our case, action bar options) are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the about page icon was selected
            case R.id.about_page:
                // Set the Intent to launch to be the about page
                intent = new Intent(this, Information.class);
                // These flags are so if there's an instance of the about page Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the about page
                startActivity(intent);

                return true;

            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }

}