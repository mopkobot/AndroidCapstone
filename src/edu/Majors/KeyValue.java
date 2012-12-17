package edu.Majors;

// Got some help from: http://en.wikipedia.org/wiki/Generics_in_Java#Generic_class_definitions
//
// This class is a generic key-value pair class that was created because Java apparently doesn't 
// have one.
// In the Loras College app this is used for containing the URL and URL text for the sample 
// four-year plans for the Majors feature (both of type String).

public class KeyValue<K, V> {

    private K key; // Key
    private V value; // Value associated with the key

    // Constructor
    public KeyValue(K key, V value) {

        this.key = key;
        this.value = value;
    }

    // Getter and setter methods for the key and the value

    public K getKey() {

        return key;
    }

    public void setKey(K key) {

        this.key = key;
    }

    public void setValue(V value) {

        this.value = value;
    }

    public V getValue() {

        return value;
    }

    // For printing out the values nicely
    public String toString() {

        return "(" + key + ", " + value + ")";
    }
}
