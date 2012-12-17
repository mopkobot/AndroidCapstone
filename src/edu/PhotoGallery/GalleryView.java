/*
 * Name: Gallery View
 * Purpose: Display images in a gallery view, and when the user clicks on the image it is expanded on a image view. Also a possibility for a slide show.
 */
package edu.PhotoGallery;
//Import all of the internal libraries we are using

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.R;


public class GalleryView extends SherlockActivity {
    /* Called when the activity is first created. */
    //Initializing ImageView and the Array where we will store the images
    ImageView imView;
    int[] images;


    public void onCreate(Bundle icicle) {
        //We get the information passed by the previous class
        Bundle b = getIntent().getExtras();
        images = b.getIntArray("name");
        super.onCreate(icicle);
        //We set the xml layout as primary layout for this file
        setContentView(R.layout.photo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //We get the explanation information passed by previous activity
        final String[] explanation = b.getStringArray("explanation");
        //We get the title passed by previous activity
        String title_pass = b.getString("title");
        //Define and initialize objects from xml design and assign values to them
        TextView title = (TextView) findViewById(R.id.Title1);
        //We set the title to the title text box
        title.setText(title_pass);
        Context context = getApplicationContext();
        //Reference to gallery in xml layout
        final Gallery gallery = (Gallery) findViewById(R.id.Gallery01);
        //Set the spacing between picture to 2
        gallery.setSpacing(2);
        //Reference button on xml layout
        final Button slide = (Button) findViewById(R.id.SlideShow);
        //Initialize the gallery
        gallery.setAdapter(new ImageAdapter(context));
        //Reference imageView on xml layout
        imView = (ImageView) findViewById(R.id.imview);

        final TextView nameTV = (TextView) findViewById(R.id.galleryTextView);

        //When we click on a specific image from the gallery view, the image appears on the imageView, and a subtitle with an appropriate explanation is displayed
        gallery.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                    long arg3) {
                //Show the message with explanation of the building
                nameTV.setText(explanation[arg2]);

                //Set the imageView to the image selected in the gallery
                imView.setImageResource(images[arg2]);
                Context context = getApplicationContext();

            }

        });
        //When the slide show button is clicked, a new activity is started that goes through the pictures every 3 seconds. The pictures and their explanation is passed through a bundle
        slide.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Bundle b = new Bundle();
                //We pass the images and the explanation
                b.putIntArray("images", images);
                b.putStringArray("explanation", explanation);
                Intent intent = new Intent(GalleryView.this, SlideShow.class);
                intent.putExtras(b);
                //We start the activity
                startActivity(intent);
            }
        });

    }

    //The code below was borrowed from:http://developer.android.com/resources/tutorials/views/hello-gallery.html
    //The code provides a class that is used for the gallery.
    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;

        //Default constructor for the ImageAdapter
        public ImageAdapter(Context c) {
            mContext = c;

        }

        //Method that returns how many pictures are in the array
        public int getCount() {
            return images.length;
        }

        //Method that returns the position of an item
        public Object getItem(int position) {
            return position;
        }

        //Method that returns the ID of an item
        public long getItemId(int position) {
            return position;
        }

        //Method that takes the pictures and creates the library
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);

            imageView.setImageResource(images[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 100));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //imageView.setBackgroundResource(mGalleryItemBackground);

            return imageView;
        }


    }

    //Method that handles when the user clicks on the 'Back' button on the device
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action  
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //do whatever you want the 'Back' button to do  
            //as an example the 'Back' button is set to start a new Activity named 'NewActivity'  
            //this.startActivity(new Intent(GalleryView.this,CoverFlowExample.class)); 
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


