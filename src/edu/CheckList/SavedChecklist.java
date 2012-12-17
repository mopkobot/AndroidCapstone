package edu.CheckList;

/* For my Checklist feature, it relies on a to-do list that was providing by the Admissions Department at Loras. 
 * It was an official list, and this feature should never be changed unless the Admissions Department decides they want to
 * add or delete a "to-do" item from the list. Also, the preferences (checked or unchecked) of each option are saved using
 * the SharedPreferences class. 
 * 
 * Sources Cited: 
 * http://www.codevdo.com/Mobile/Android_Apps/0/1
 * 
 * Coded by: Jake Pfohl
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

public class SavedChecklist extends SherlockActivity {
    public static final String PREFS_NAME = "SharedPrefsDemoPreferences";

    // Initializing strings for each checkbox so that a value can be stored in each one
    public static final String PREF_BOOL = "PrefBool";
    public static final String PREF_BOOL2 = "PrefBool2";
    public static final String PREF_BOOL3 = "PrefBool3";
    public static final String PREF_BOOL4 = "PrefBool4";
    public static final String PREF_BOOL5 = "PrefBool5";
    public static final String PREF_BOOL6 = "PrefBool6";
    public static final String PREF_BOOL7 = "PrefBool7";
    public static final String PREF_BOOL8 = "PrefBool8";

    // Initializing a SharedPreferences variable
    private SharedPreferences mPrefs;

    // Initializing the 9 checkboxes to be used for each option in the checklist
    private CheckBox mCheckBox, mCheckBox2, mCheckBox3, mCheckBox4, mCheckBox5,
            mCheckBox6, mCheckBox7, mCheckBox8;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.checkboxes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPrefs = getSharedPreferences(PREFS_NAME, 0);

        //  Assigning the checkboxes to their appropriate ID found in the checkboxes.xml file
        mCheckBox = (CheckBox) findViewById(R.id.cb1);
        mCheckBox2 = (CheckBox) findViewById(R.id.cb2);
        mCheckBox3 = (CheckBox) findViewById(R.id.cb3);
        mCheckBox4 = (CheckBox) findViewById(R.id.cb4);
        mCheckBox5 = (CheckBox) findViewById(R.id.cb5);
        mCheckBox6 = (CheckBox) findViewById(R.id.cb6);
        mCheckBox7 = (CheckBox) findViewById(R.id.cb7);
        mCheckBox8 = (CheckBox) findViewById(R.id.cb8);

        // Set the text of each checkbox to the different indexes of the CHOICES array (found below)
        mCheckBox.setText(CHOICES[0]);
        mCheckBox2.setText(CHOICES[1]);
        mCheckBox3.setText(CHOICES[2]);
        mCheckBox4.setText(CHOICES[3]);
        mCheckBox5.setText(CHOICES[4]);
        mCheckBox6.setText(CHOICES[5]);
        mCheckBox7.setText(CHOICES[6]);
        mCheckBox8.setText(CHOICES[7]);

    }

    @Override
    protected void onResume() {


        // When the app resumes (either from being killed, paused, etc.) the sharedPreferences variable (mPrefs) gets
        // the boolean from each checkbox -- either checked or unchecked and sets the checkbox to that state so that
        // the preferences are stored even after exiting the app. If it can't find the checkbox, it defaults to "false"
        mCheckBox.setChecked(mPrefs.getBoolean(PREF_BOOL, false));
        mCheckBox2.setChecked(mPrefs.getBoolean(PREF_BOOL2, false));
        mCheckBox3.setChecked(mPrefs.getBoolean(PREF_BOOL3, false));
        mCheckBox4.setChecked(mPrefs.getBoolean(PREF_BOOL4, false));
        mCheckBox5.setChecked(mPrefs.getBoolean(PREF_BOOL5, false));
        mCheckBox6.setChecked(mPrefs.getBoolean(PREF_BOOL6, false));
        mCheckBox7.setChecked(mPrefs.getBoolean(PREF_BOOL7, false));
        mCheckBox8.setChecked(mPrefs.getBoolean(PREF_BOOL8, false));
        super.onResume();
    }

    @Override
    protected void onPause() {

        // In order to save the state of each checkbox (either checked or unchecked), the sharedPreferences variable (mPrefs)
        // must be opened in order to edit it. After the editor is opened, the editor puts each boolean (checked or unchecked)
        // into the PREF_BOOL variable for each checkbox which saves the state of each checkbox to be retrieved once the
        // app is opened up again. After it does that, the editor has to commit the changes which is the last line
        Editor e = mPrefs.edit();
        e.putBoolean(PREF_BOOL, mCheckBox.isChecked());
        e.putBoolean(PREF_BOOL2, mCheckBox2.isChecked());
        e.putBoolean(PREF_BOOL3, mCheckBox3.isChecked());
        e.putBoolean(PREF_BOOL4, mCheckBox4.isChecked());
        e.putBoolean(PREF_BOOL5, mCheckBox5.isChecked());
        e.putBoolean(PREF_BOOL6, mCheckBox6.isChecked());
        e.putBoolean(PREF_BOOL7, mCheckBox7.isChecked());
        e.putBoolean(PREF_BOOL8, mCheckBox8.isChecked());
        e.commit();

        // Once the changes are committed (that is, the states are stored), the screen prints "Settings Saved."
        Toast.makeText(this, "Settings Saved.", Toast.LENGTH_SHORT).show();

        super.onPause();
    }

    // This is the array of choices that shows up in the checklist. If any of the options were to change on the checklist,
    // the words would be changed in this string to the new options.
    private static final String[] CHOICES = new String[]{
            "Apply to Loras College", "Send Official Transcripts and ACT or SAT Scores", "Visit Campus", "Complete the FAFSA After January 1st",
            "Complete Confirmation and Housing Forms", "Make $200 Confirmation Deposit, Refundable Until May 1st", "Register For New Student Orientation",
            "Pack for College"
    };


    // This method is called when the device is rotated (specified in the Manifest file).
    // This is so the Activity doesn't go the onPause portion of it's lifecycle, preventing
    // needless saving when rotation occurs.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        // Required call to superclass for app lifecycle management
        super.onConfigurationChanged(newConfig);

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