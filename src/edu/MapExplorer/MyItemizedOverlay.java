package edu.MapExplorer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.OverlayItem;
import edu.MapsCommon.Locations;
import edu.MapsCommon.MapOverlay;

/*
 * This class is used by the MapsActivity class to initialize map overlay items. 
 * 
 * Modified from: http://developer.android.com/resources/tutorials/views/hello-mapview.html
 */
public class MyItemizedOverlay extends MapOverlay implements Locations {
    public MyItemizedOverlay(Drawable defaultMarker, Context context) {
        super(boundCenterBottom(defaultMarker));
        populate();
        mContext = context;
    }

    @Override
    protected boolean onTap(int index) {
        final OverlayItem item = mOverlays.get(index);
        tapLocationMoreInfoDialog(item);
        return true;
    }
}
