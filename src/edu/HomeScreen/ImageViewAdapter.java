// Based on example here: http://www.mkyong.com/android/android-gridview-example/

package edu.HomeScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.HomeScreen.R;


// This Adapter subclasses BaseAdapter and is used to insert data into a View.

public class ImageViewAdapter extends BaseAdapter {

    private Context context; // Interface to global info about application environment
    private String[] features; // Labels/names
    private int[] featureIcons;  // Images that are associated with the labels/names


    // Constructor that takes the context, labels/names, and images associated with the
    // labels/names
    public ImageViewAdapter(Context context, String[] features, int[] featureIcons) {

        this.context = context;
        this.features = features;
        this.featureIcons = featureIcons;
    }

    // Create a View hierarchy for the elements of the GridView and set their feature icon and
    // label values
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get a LayoutInflator
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView; // References the grid view

        if (convertView == null) {

            gridView = new View(context); // Instantiate the grid view

            // Use LayoutInflator to inflate a new view hierarchy from the dashboard_element.xml
            // file
            gridView = inflater.inflate(R.layout.dashboard_element, null);

            // Get a handle on the TextView used for the feature name/label
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);

            // Set the text to be the feature's name/label
            textView.setText(features[position]);

            // Get a handle to the ImageView used for the feature icon
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            // Set the icon to be the appropriate drawable/image
            imageView.setImageResource(featureIcons[position]);

            //imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }


    // The following are abstract methods that are required to be implemented

    @Override
    public int getCount() {

        return features.length;
    }

    @Override
    public Object getItem(int arg0) {

        return null;
    }

    @Override
    public long getItemId(int arg0) {

        return 0;
    }

}
