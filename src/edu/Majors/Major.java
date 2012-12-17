package edu.Majors;

import java.util.ArrayList;


// This class represents an object for a Loras College major
public class Major {

    private String title; // Title/Name of the major
    private String description; // Description of the major


    // This ArrayList of key-value pairs of strings will hold the URL and URL text for sample
    // four-year plans for the major. An ArrayList is used for dynamic sizing of the number of
    // plans for the major
    private ArrayList<KeyValue<String, String>> plans = new ArrayList<KeyValue<String, String>>();

    // Major class constructor. Note the third argument is of type "KeyValue<String, String>...".
    // with Java 5 placing "..." after the type of the last argument in a method means that it
    // will accept 1 or more of that type of argument. This is used here to accept 1 or more
    // four-year plans' URL and URL text.
    public Major(String title, String description, KeyValue<String, String>... plans) {

        // On class instantiation, assign values to the title, description, and plan attributes
        this.title = title;
        this.description = description;

        // For every plan that is in the plans variable (which contains 1 or more
        // KeyValue<String, String> values)
        for (KeyValue<String, String> aPlan : plans) {

            this.plans.add(aPlan); // Add the plan to the ArrayList of plans for the major
        }
    }


    // Getter and setter methods for the title, description, and plan attributes
    //
    // The setter methods aren't currently used because the Major objects used are currently
    // stored in a constant array in the MajorsData interface.

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public ArrayList<KeyValue<String, String>> getPlans() {

        return plans;
    }

    public void addPlans(KeyValue<String, String>... newPlans) {

        // For every plan that is in the newPlans variable (which contains 1 or more
        // KeyValue<String, String> values)
        for (KeyValue<String, String> aPlan : newPlans) {

            this.plans.add(aPlan); // Add the plan to the ArrayList of plans for the major
        }
    }
}