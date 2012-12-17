package edu.MapsCommon;

import com.google.android.maps.GeoPoint;

/*
 * This class defines all the information needed for a single building/location on the Loras campus. The Locations class uses 
 * this class to create a "location" and store information for that location. 
 * 
 * Programmer: Justin Steines
 */
public class location {
    private String locationName;         // name of the building/location
    private GeoPoint geoPoint;            // latitude and longitude coordinates of the location
    private String description;            // description of the location
    private String category;            // if the location is eat, sleep, study, have fun, or a combination of
    private int image;                    // the resource id of the image for the location
    private boolean onVirtualTour;        // determines if the location is included in the Virtual Tour feature
    private int tourOrder;                // determines the order in which the buildings are visited if they are in the Virtual Tour
    private String[] submenu;            // the sub menu that is displayed with the user taps on an icon on the map

    // get methods
    public String getLocationName() {
        return locationName;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }

    public boolean getOnVirtualTour() {
        return onVirtualTour;
    }

    public int getTourOrder() {
        return tourOrder;
    }

    public String[] getSubmenu() {
        return submenu;
    }

    // constructor that creates a new location
    public location(String locationName, GeoPoint geoPoint, String description, String category, int image, boolean onVirtualTour, int tourOrder, String[] submenu) {
        this.locationName = locationName;
        this.geoPoint = geoPoint;
        this.description = description;
        this.category = category;
        this.image = image;
        this.onVirtualTour = onVirtualTour;
        this.tourOrder = tourOrder;
        this.submenu = submenu;
    }
}
