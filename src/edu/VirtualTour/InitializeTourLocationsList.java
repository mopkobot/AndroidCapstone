package edu.VirtualTour;

// This class simply gets and returns an array of location objects for all locations that are 
// on the virtual tour and preserves their order in that list.
//
// The Locations interface is used to reference the constant array of location objects for each 
// location.

import edu.MapsCommon.Locations;
import edu.MapsCommon.location;

public class InitializeTourLocationsList implements Locations {

    // Default constructor private for class non-instantiability (a static class)
    private InitializeTourLocationsList() {

    }

    // Helper method for initializing and returning the list of tour locations listed in their
    // explicit order
    public static location[] getTourLocationsList() {

        int count = 0;

        for (int i = 0; i < Locations.length; i++) {

            // Count how many locations are on the virtual tour
            if (Locations[i].getOnVirtualTour() == true) {

                count++;
            }
        }

        // Use the previous count of locations on the virtual tour to initialize the array size 
        // for the array of tour locations
        location[] tourLocations = new location[count];

        for (int i = 0; i < Locations.length; i++) {

            // If the location is on the virtual tour, add it to the array of tour locations
            if (Locations[i].getOnVirtualTour() == true) {

                // Preserve the order of the tour locations and produce no "gaps" in the array
                tourLocations[Locations[i].getTourOrder() - 1] = Locations[i];
            }
        }

        return tourLocations; // Return the array of tour locations
    }

}
