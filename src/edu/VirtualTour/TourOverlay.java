package edu.VirtualTour;

import edu.MapsCommon.Locations;
import edu.MapsCommon.MapOverlay;
import edu.MapsCommon.location;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.OverlayItem;


// This Overlay extends from MapOverlay in the src_MapsCommon folder. The TourOverlay differs 
// from the superclass (which is also used by Map Explorer) in order to only allow the current 
// tour location to bring up a dialog to get to the locations detail page. This was a design 
// decision in order to focus users on learning about the current location only.
//
// The Locations interface is used to reference the constant array of location objects for each 
// location.

public class TourOverlay extends MapOverlay implements Locations {
    private location currentLocation; // Current tour location
    private TourActivity tourActivity; // Reference to the current TourActivity

    // Constructor accepts the icon to use for the type of location (current or non-current),
    // the context of the app, and the current TourActivity
    public TourOverlay(Drawable defaultMarker, Context context, TourActivity activity) {
        super(boundCenterBottom(defaultMarker)); // Set the bottom of the icon to be on the location's geo location
        populate(); // Update MapOverlay
        mContext = context;
        tourActivity = activity;
    }

    // Determines what happens when the user taps on an overlay item.
    //
    // This is the implementation of an abstract method from MapOverlay
    @Override
    protected boolean onTap(int index) {
        // Get the current tour location from the current TourActivity
        currentLocation = tourActivity.getCurrentTourLocation();

        // Get the OverlayItem of the location that was pressed
        final OverlayItem item = mOverlays.get(index);

        // If the location that was pressed was the current tour location
        if (item.getTitle() == currentLocation.getLocationName()) {

            // Present the dialog to get to the location details page
            tapLocationMoreInfoDialog(item);
        }

        return true;
    }

}
