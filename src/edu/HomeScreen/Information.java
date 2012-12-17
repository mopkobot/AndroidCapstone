package edu.HomeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;


// This Activity is for the about page, which is a place to share information about the 
// developers of the app and cite resources utilized in the app (images, etc.). Do not delete 
// these citations as for some they are required by virtue of their license (including the Maps  
// Icons Collection logo).
//
// XML layout file(s) used: about.xml

public class Information extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Use about.xml as the UI layout
        setContentView(R.layout.about);

        // Enable the action bar's main icon (left-most icon) to go "up a level" when selected
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Define and initialize the elements declared in the xml layout
        TextView content = (TextView) findViewById(R.id.txtContent);
        ImageView orgimage = (ImageView) findViewById(R.id.aboutImg);
        orgimage.setImageResource(R.drawable.group_picture);
        //Set the info to the appropriate info sent from the main class
        content.setText("This app was developed as a 2012 Loras College Computer Science Senior Capstone project. The developers are (left to right): Katie Burke, Kevin Kelchen, Jacob Pfohl, Aleksandar Serafimoski, and Justin Steines.");

        // Display the resources used in the project needing citation/credit

        // Get handle on the TextView for the ActionBarSherlock body
        TextView absBody = (TextView) findViewById(R.id.absBody);
        // Get handle on the TextView for the ActionBarSherlock link
        TextView absLink = (TextView) findViewById(R.id.absLink);

        // Get handle on the TextView for the AndroidIcons body
        TextView aiBody = (TextView) findViewById(R.id.androidiconsBody);
        // Get handle on the TextView for the AndroidIcons link
        TextView aiLink = (TextView) findViewById(R.id.androidiconsLink);

        // Get handle on the TextView for the PICOL body
        TextView picolBody = (TextView) findViewById(R.id.picolBody);
        // Get handle on the TextView for the PICOL link
        TextView picolLink = (TextView) findViewById(R.id.picolLink);

        // Get handle on the TextView for the Map Icons Collection body
        TextView micBody = (TextView) findViewById(R.id.micBody);
        // Get handle on the TextView for the Map Icons Collection link
        TextView micLink = (TextView) findViewById(R.id.micLink);

        // Set the body and link text and linkify the URLs for:

        // ActionBarSherlock
        absBody.setText("Action bar implemented with notable thanks to ActionBarSherlock:");
        absLink.setText(Html.fromHtml("<a href=\"http://actionbarsherlock.com/\">http://actionbarsherlock.com/</a>"));
        absLink.setMovementMethod(LinkMovementMethod.getInstance());

        // AndroidIcons
        aiBody.setText("\nApp feature Home screen icons and action bar icons thanks to Android Icons:");
        aiLink.setText(Html.fromHtml("<a href=\"http://www.androidicons.org/\">http://www.androidicons.org/</a>"));
        aiLink.setMovementMethod(LinkMovementMethod.getInstance());

        // PICOL
        picolBody.setText("\nVirtual Tour navigation bar arrows thanks to PICOL:");
        picolLink.setText(Html.fromHtml("<a href=\"http://www.picol.org/\">http://www.picol.org/</a><br><a href=\"http://www.picol.org/about.php\">http://www.picol.org/about.php</a><br><a href=\"http://creativecommons.org/licenses/by-sa/3.0/\">http://creativecommons.org/licenses/by-sa/3.0/</a>"));
        picolLink.setMovementMethod(LinkMovementMethod.getInstance());

        // Map Icons Collection
        micBody.setText("\nMap location and Photo Gallery category icons thanks to Map Icons Collection:");
        micLink.setText(Html.fromHtml("<a href=\"http://mapicons.nicolasmollet.com/\">http://mapicons.nicolasmollet.com/</a><br><a href=\"http://mapicons.nicolasmollet.com/about/license/\">http://mapicons.nicolasmollet.com/about/license/</a><br><a href=\"http://creativecommons.org/licenses/by-sa/3.0/\">http://creativecommons.org/licenses/by-sa/3.0/</a>"));
        micLink.setMovementMethod(LinkMovementMethod.getInstance());

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
