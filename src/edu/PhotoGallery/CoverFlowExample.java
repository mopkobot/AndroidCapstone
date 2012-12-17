/*
 * Copyright (C) 2010 Neil Davies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code is base on the Android Gallery widget and was Created 
 * by Neil Davies neild001 'at' gmail dot com to be a Coverflow widget
 * 
 * @author Neil Davies
 */
//This Code was borrowed from: http://www.inter-fuser.com/2010/02/android-coverflow-widget-v2.html
//And it was developd by Neil Davies
//As a developer I used this code because it provides a unique feature for the photo gallery.
//In this code, I added the on click listener, so when the user clicks on an image it takes to the appropriate gallery.
package edu.PhotoGallery;
//Import the libraries needed for this project

import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import edu.HomeScreen.HomeScreen;
import edu.HomeScreen.R;

public class CoverFlowExample extends SherlockActivity {
    /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Create a new instance of the coverFlow class
        CoverFlow coverFlow;
        //Initialize the instance
        coverFlow = new CoverFlow(this);
        //Set the adapter in the instance to be an image adapter
        coverFlow.setAdapter(new ImageAdapter(this));
        //Initialize the coverImageAdapter
        ImageAdapter coverImageAdapter = new ImageAdapter(this);
        //Set the adapter of the coverFlow to the preveiously initialized adapter
        coverFlow.setAdapter(coverImageAdapter);
        //Set the spacing for the cover flow
        coverFlow.setSpacing(-25);
        //Set the selection for the cover flow
        coverFlow.setSelection(2, true);
        //Set the amination time
        coverFlow.setAnimationDuration(1000);
        //Set the view to the cover flow
        setContentView(coverFlow);

        //When we click on the image, a new activity opens
        coverFlow.setOnItemClickListener(new OnItemClickListener() {
            //Based on the input from the user the appropriate gallery title, gallery subtitles and gallery pictures are passed through the next activity using the bundle
            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                    long arg3) {
                Bundle b = new Bundle();
                switch (arg2) {
                    case 0:
                        final int[] eat = {R.drawable.cafe, R.drawable.pod_inside, R.drawable.pod_outside, R.drawable.duhawk_market_cropped, R.drawable.pub};
                        final String[] explanation_eat = {"Loras College Cafeteria", "Loras College Pod", "Loras College Pod", "Loras College Duhawk Market", "Loras College Pub"};
                        //b.putString("category", "eat");
                        b.putIntArray("name", eat);
                        b.putString("title", "Places where you can eat");
                        b.putStringArray("explanation", explanation_eat);
                        break;
                    case 1:
                        final int[] sleep = {R.drawable.beckman, R.drawable.rohlman, R.drawable.koinonia_house, R.drawable.lmac, R.drawable.byrne_oaks, R.drawable.smyth, R.drawable.belmont_house};
                        final String[] explanation_sleep = {"Beckman Hall", "Rohlman Hall", "Koinonia House", "Lynch Macarthy Apartments", "Byrne Oaks Apartments", "Smyth Hall", "Belmont House"};
                        //b.putString("category", "sleep");
                        b.putIntArray("name", sleep);
                        b.putString("title", "Places where you can sleep");
                        b.putStringArray("explanation", explanation_sleep);
                        break;
                    case 2:
                        final int[] study = {R.drawable.acc, R.drawable.arc, R.drawable.beckman, R.drawable.rohlman, R.drawable.koinonia_house, R.drawable.beckman, R.drawable.lmac, R.drawable.byrne_oaks, R.drawable.smyth, R.drawable.belmont_house, R.drawable.hoffmann, R.drawable.hennessy, R.drawable.science_hall};
                        final String[] explanation_study = {"Alumni Campus Center", "Academic Resource Center", "Beckman Hall", "Rohlman Hall", "Koinonia House", "Beckman Hall", "Lynch Macarthy Apartments", "Byrne Oaks Apartments", "Smyth Hall", "Belmont House", "Hoffmann Hall", "Hennessy Hall", "Science Hall"};
                        //b.putString("category", "study");
                        b.putIntArray("name", study);
                        b.putString("title", "Places where you can study");
                        b.putStringArray("explanation", explanation_study);
                        break;
                    case 3:
                        final int[] havefun = {R.drawable.acc, R.drawable.pub, R.drawable.belmont_house, R.drawable.koinonia_house, R.drawable.graber, R.drawable.awc, R.drawable.san_jose_pool, R.drawable.rock_bowl};
                        final String[] explanation_fun = {"Alumni Campus Center", "Pub", "Belmont House", "Koinonia House", "Graber Sport Arena", "Athletic Welness Center", "San Jose Swimming Pool", "Rock Bowl Field"};
                        //b.putString("category", "havefun");
                        b.putIntArray("name", havefun);
                        b.putString("title", "Places where you can have fun");
                        b.putStringArray("explanation", explanation_fun);
                        break;

                }
                //When the user selects an image, the gallery opens the gallery view which allows the user to view the images
                Intent myIntent = new Intent(v.getContext(), GalleryView.class);
                startActivityForResult(myIntent, 0);
                //Add the set of extended data to the intent and start it
                myIntent.putExtras(b);
                startActivity(myIntent);


            }

        });
    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackground;
        private Context mContext;
        //Images shown in the coverflow view
        private Integer[] mImageIds = {
                R.drawable.eat2,
                R.drawable.sleep2,
                R.drawable.study2,
                R.drawable.havefun2

        };
        //Define ImageView array
        private ImageView[] mImages;

        //Default constructor for the ImageAdapater Class
        public ImageAdapter(Context c) {
            mContext = c;
            mImages = new ImageView[mImageIds.length];
        }

        //Method that creates the cover flow images
        public boolean createReflectedImages() {
            //The gap we want between the reflection and the original image
            final int reflectionGap = 4;


            int index = 0;
            TextView textView = new TextView(mContext);
            textView.setText("Please click on one of the pictures in order to see the appropriate gallery!");
            for (int imageId = 0; imageId < mImageIds.length; imageId++) {
                Bitmap originalImage = BitmapFactory.decodeResource(getResources(),
                        imageId);
                int width = originalImage.getWidth();
                int height = originalImage.getHeight();


                //This will not scale but will flip on the Y axis
                Matrix matrix = new Matrix();
                matrix.preScale(1, -1);

                //Create a Bitmap with the flip matrix applied to it.
                //We only want the bottom half of the image
                Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0, height / 2, width, height / 2, matrix, false);


                //Create a new bitmap with same width but taller to fit reflection
                Bitmap bitmapWithReflection = Bitmap.createBitmap(width
                        , (height + height / 2), Config.ARGB_8888);

                //Create a new Canvas with the bitmap that's big enough for
                //the image plus gap plus reflection
                Canvas canvas = new Canvas(bitmapWithReflection);
                //Draw in the original image
                canvas.drawBitmap(originalImage, 0, 0, null);
                //Draw in the gap
                Paint deafaultPaint = new Paint();
                canvas.drawRect(0, height, width, height + reflectionGap, deafaultPaint);
                //Draw in the reflection
                canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

                //Create a shader that is a linear gradient that covers the reflection
                Paint paint = new Paint();
                LinearGradient shader = new LinearGradient(0, originalImage.getHeight(), 0,
                        bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff,
                        TileMode.CLAMP);
                //Set the paint to use this shader (linear gradient)
                paint.setShader(shader);
                //Set the Transfer mode to be porter duff and destination in
                paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                //Draw a rectangle using the paint with our linear gradient
                canvas.drawRect(0, height, width,
                        bitmapWithReflection.getHeight() + reflectionGap, paint);


                ImageView imageView = new ImageView(mContext);
                imageView.setImageBitmap(bitmapWithReflection);
                imageView.setLayoutParams(new CoverFlow.LayoutParams(120, 180));
                imageView.setScaleType(ScaleType.MATRIX);
                mImages[index++] = imageView;

            }
            return true;
        }

        //Method that counts the images in the array
        public int getCount() {
            return mImageIds.length;
        }

        //Method that returns position of an item
        public Object getItem(int position) {
            return position;
        }

        //Method that returns ID of an item
        public long getItemId(int position) {
            return position;
        }

        //Method that returns an ImageView
        public View getView(int position, View convertView, ViewGroup parent) {

            //Use this code if you want to load from resources
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new CoverFlow.LayoutParams(130, 130));
            i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            //Make sure we set anti-aliasing otherwise we get jaggies
            BitmapDrawable drawable = (BitmapDrawable) i.getDrawable();
            drawable.setAntiAlias(true);
            return i;

        }

        /**
         * Returns the size (0.0f to 1.0f) of the views
         * depending on the 'offset' to the center.
         */
        public float getScale(boolean focused, int offset) {
            /* Formula: 1 / (2 ^ offset) */
            return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
        }

    }

    //Method that handles when the user clicks the 'Back' button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action  
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //do whatever you want the 'Back' button to do  
            //as an example the 'Back' button is set to start a new Activity named 'NewActivity'  
            //this.startActivity(new Intent(this, HomeScreen.class));  
            Intent intent = new Intent(this, HomeScreen.class);
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