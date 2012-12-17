// Borrowed from: http://stackoverflow.com/questions/2176397/drawing-a-line-path-on-google-maps
// I added the Locations/tour locations aspect and virtually all comments.

package edu.VirtualTour;

import edu.MapsCommon.Locations;
import edu.MapsCommon.location;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;


// This Overlay is for drawing and containing the lines that go from one tour location to the 
// next.
//
// The Locations interface is used to reference the constant array of location objects for each 
// location.

public class LinesTourOverlay extends Overlay implements Locations {

    private Projection projection; // Used to translate between x/y screen coordinates and lat/long geo coordinates
    private location[] tourLocations; // Array of all locations on the tour

    // Constructor takes Projection of a View (in our case, the MapView we use)
    public LinesTourOverlay(Projection p) {

        projection = p;
    }

    // This method draws the lines from one tour location to another
    public void draw(Canvas canvas, MapView mapv, boolean shadow) {

        // Required call to superclass for app lifecycle management
        super.draw(canvas, mapv, shadow);

        Paint mPaint = new Paint(); // Holds style and color information of lines drawing
        mPaint.setDither(true); // Use dithering to reduce artifacting for colors higher precision than device
        mPaint.setColor(Color.argb(255, 255, 0, 255)); // Set color to magenta
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); // Set paint style to fill and stroke
        mPaint.setStrokeJoin(Paint.Join.ROUND); // Set paint's join. The outer edges of a join 
        // meet in a circular arc.

        mPaint.setStrokeCap(Paint.Cap.ROUND); // Set paint's line cap style to round. The stroke 
        // projects out as a semicircle, with the center at the end of the path.

        mPaint.setStrokeWidth(2); // Set paint's stroke width. Smaller value == smaller width.


        GeoPoint gP1; // Next GeoPoint to connect to
        GeoPoint gP2; // GeoPoint
        Point p1; // Next Point to connect to
        Point p2; // Point (holds two integer coordinates)
        Path path; // Contains multiple lines


        // Get the tour locations
        tourLocations = InitializeTourLocationsList.getTourLocationsList();


        // Pre-condition: Need more than 1 tour location
        // For all tour locations
        for (int i = 1; i < tourLocations.length; i++) {

            // Get the tour location and the next tour location's GeoPoint
            gP1 = tourLocations[i - 1].getGeoPoint();
            gP2 = tourLocations[i].getGeoPoint();

            p1 = new Point();
            p2 = new Point();
            path = new Path();

            // Map the GeoPoints for the tour location and the next tour location to pixels on
            // the screen
            projection.toPixels(gP1, p1);
            projection.toPixels(gP2, p2);

            // Set the point where the line is to be drawn from and the point where to draw the
            // line to
            path.moveTo(p2.x, p2.y);
            path.lineTo(p1.x, p1.y);

            // Draw line between points
            canvas.drawPath(path, mPaint);
        }

        // Same as in the for-loop right above, but connect first and last points

        gP1 = tourLocations[tourLocations.length - 1].getGeoPoint();
        gP2 = tourLocations[0].getGeoPoint();

        p1 = new Point();
        p2 = new Point();
        path = new Path();

        projection.toPixels(gP1, p1);
        projection.toPixels(gP2, p2);

        path.moveTo(p2.x, p2.y);
        path.lineTo(p1.x, p1.y);

        canvas.drawPath(path, mPaint);
    }

}
