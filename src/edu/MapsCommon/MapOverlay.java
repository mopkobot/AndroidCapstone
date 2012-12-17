package edu.MapsCommon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import edu.HomeScreen.R;

import java.util.ArrayList;

/*
 * This class defines adding and removing overlay items. It also defines what to do when the user taps on an overlay item.
 * 
 * Modified from: http://eagle.phys.utk.edu/guidry/android/mapOverlayDemo.html
 * 
 * Programmer: Justin Steines
 */

public abstract class MapOverlay extends ItemizedOverlay<OverlayItem> implements Locations {

    protected ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    protected Context mContext;
    protected String[] subMenu = null;


    public MapOverlay(Drawable defaultMarker) {
        super(defaultMarker);
        // TODO Auto-generated constructor stub
    }

    // add overlay item
    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }

    // Removes overlay item i
    public void removeItem(int i) {
        mOverlays.remove(i);
        populate();
    }

    @Override
    protected abstract boolean onTap(int index);

    // returns overlay item
    @Override
    protected OverlayItem createItem(int i) {
        return mOverlays.get(i);
    }

    // returns size
    @Override
    public int size() {
        return mOverlays.size();
    }

    /* Following code programmed by: Justin Steines */
    // determines what happens when the user taps on an overlay item
    protected void tapLocationMoreInfoDialog(final OverlayItem item) {

        // get the sub menu from the Locations class

        // get the length of the sub menu array from the Locations class and declare a new subMenu array with that length
        for (int i = 0; i < Locations.length; i++) {
            if (Locations[i].getLocationName().equals(item.getTitle())) {
                subMenu = new String[Locations[i].getSubmenu().length];
            }
        }

        // populate the local subMenu array with the sub menu array from the Locations class
        for (int i = 0; i < Locations.length; i++) {
            if (Locations[i].getLocationName().equals(item.getTitle())) {
                for (int j = 0; j < subMenu.length; j++) {
                    subMenu[j] = Locations[i].getSubmenu()[j];
                }
            }
        }

        // create alert dialog that displays when the user taps an overlay item
        AlertDialog.Builder popupBuilder = new AlertDialog.Builder(mContext);
        if (subMenu.length > 1) // if the sub menu has more than one option
        {
            popupBuilder.setTitle(item.getTitle());
            popupBuilder.setItems(subMenu, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent myIntent = new Intent(mContext, LocationInfoActivity.class); // open the LocationInfoActivity class
                    Bundle b = new Bundle();
                    b.putString("locationName", subMenu[which]); // pass the name of whatever item the user clicks on in the sub menu to the LocationInfoActivity class
                    myIntent.putExtras(b);
                    mContext.startActivity(myIntent);
                }
            });
        } else // if there is only one option for the sub menu, it will say, "Tap here for more info." as defined in the Locations class
        {
            popupBuilder.setTitle(item.getTitle());
            popupBuilder.setItems(subMenu, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent myIntent = new Intent(mContext, LocationInfoActivity.class); // open the LocationInfoActivity class
                    Bundle b = new Bundle();
                    b.putString("locationName", item.getTitle()); // pass the name of the location to the LocationInfoActivity class
                    myIntent.putExtras(b);
                    mContext.startActivity(myIntent);
                }
            });
        }

        // set icon for alert dialog popup
        for (int i = 0; i < Locations.length; i++) {
            if (Locations[i].getLocationName().equals(item.getTitle())) {
                if (Locations[i].getCategory().equals("eat")) {
                    popupBuilder.setIcon(R.drawable.ico_eat);
                }
                if (Locations[i].getCategory().equals("sleep")) {
                    popupBuilder.setIcon(R.drawable.ico_sleep);
                }
                if (Locations[i].getCategory().equals("study")) {
                    popupBuilder.setIcon(R.drawable.ico_study);
                }
                if (Locations[i].getCategory().equals("havefun")) {
                    popupBuilder.setIcon(R.drawable.ico_havefun);
                }
                if (Locations[i].getCategory().equals("eat_study_havefun")) {
                    popupBuilder.setIcon(R.drawable.ico_eat_study_havefun);
                }
                if (Locations[i].getCategory().equals("sleep_study")) {
                    popupBuilder.setIcon(R.drawable.ico_sleep_study);
                }
                if (Locations[i].getCategory().equals("study_havefun")) {
                    popupBuilder.setIcon(R.drawable.ico_study_havefun);
                }
            }
        }

        AlertDialog popupDialog = popupBuilder.create();
        popupDialog.show();

    }

}
