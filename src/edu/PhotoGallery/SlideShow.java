/*
 * Name: Slide Show
 * Purpose: Creates an automated gallery from the images in the gallery view.
 */
//This Code was borrowed from: http://manisivapuram.blogspot.com/2011/06/slideshow-of-images-using-android.html
//As a developer I used this code because it provides a unique feature for the photo gallery.
//In this project I made few changes, such as I added a textView for exlanations, and I changed the duration.
package edu.PhotoGallery;
//Import all of the internal libraries we are using

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;


public class SlideShow extends SherlockActivity {


    //Initializing TextView and ImageView so we can use them later
    private TextView txtStatus;
    private ImageView imageView;

    int i = 0;
    //Initialize RefreshHandler necessary for slideshow
    RefreshHandler refreshHandler = new RefreshHandler();

    class RefreshHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //Updating slideshow
            SlideShow.this.updateUI();
        }

        public void sleep(long delayMillis) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }

    ;
    //Initializing imig array where we will store picture and expl array where we will store explanation for pictures
    int[] imgid;
    String[] expl;

    public void updateUI() {
        //We change pictures every 2 seconds
        refreshHandler.sleep(4000);
        if (i < imgid.length && i < expl.length) {
            //While there are pictures left, we display a new picture and explanation for that picture
            imageView.setImageResource(imgid[i]);
            imageView.setContentDescription(expl[i]);
            txtStatus.setText(expl[i]);
            i++;
        } else {
            //When the slide show is over, we notify the user
            txtStatus.setText("Slide show is done. Please click the back button");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //Once the slideshow class is opened we get the necessary information passed by the previous class
        Bundle b = getIntent().getExtras();
        if (b != null) {
            imgid = b.getIntArray("images");
            expl = b.getStringArray("explanation");
            super.onCreate(savedInstanceState);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setContentView(R.layout.slideshow);
            //Reference to elements on the xml layout
            txtStatus = (TextView) this.findViewById(R.id.textView1);
            imageView = (ImageView) this.findViewById(R.id.imageView1);

            //Updating the slideshow class
            updateUI();
        }
    }

    //Method that handles when the user clicks on the 'Back' button on the device
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action  
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //do whatever you want the 'Back' button to do  
            //as an example the 'Back' button is set to start a new Activity named 'NewActivity'  
            //this.startActivity(new Intent(this,CoverFlowExample.class));
            Intent intent = new Intent(this, CoverFlowExample.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }

    // Determine what to do when an action bar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Given the action bar icon that was selected, do something
        switch (item.getItemId()) {
            // If the main action bar icon (left-most icon) was selected
            case android.R.id.home:
                // Go to the activity categories screen
                //
                // Set the Intent to launch to be the activity categories screen
                Intent intent = new Intent(this, CoverFlowExample.class);
                // These flags are so if there's an instance of the activity categories screen Activity already
                // running, bring that instance on screen instead of starting a new instance
                // of it
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Launch the activity categories screen
                startActivity(intent);

                return true;
            default:
                // Call the super class version of the method with the selection
                return super.onOptionsItemSelected(item); // Required call to superclass for app lifecycle management
        }
    }

}
