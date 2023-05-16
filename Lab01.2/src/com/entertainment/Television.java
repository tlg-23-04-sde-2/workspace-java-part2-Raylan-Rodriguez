package com.entertainment;

import java.util.Objects;

// Natural order is defined by brand(String)
// Note: be "Consistent with equals, "  Natural order must use the same properties
// that are used  in equals()
public class Television implements Comparable<Television> {
    private String brand;
    private int volume;
    private final Tuner tuner = new Tuner();

    //cosntructors
    public Television() {

    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //business methods
    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    //accessors


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int hashCode() {
        // poorly written hash function, because it easily yiedls "hash collision"
        // a "hash collision" is when different objects hash to the same value (dumb luck)
        //return getBrand().length() + getVolume();

        // delegate to Objects.hash(), which uses a "good" hash function to minimize collisions
        return Objects.hash(getBrand(), getVolume());
    }

    //natural order is defined by brand , then by volume
    // to be consistent with equals() and hashCode().
    @Override
    public int compareTo(Television other) {
       int result = this.getBrand().compareTo(other.getBrand());

       if(result == 0) { // tied on brand, break the tie by volume
           result = Integer.compare(this.getVolume(), other.getVolume());
       }
       return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // only proceed if "obj" is a reference
        if (obj instanceof Television) {
            // downcast 'obj' to more specific Television, so we can call Television methods.
            Television other = (Television) obj;
            // do the checks: business equality is defined
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  //null safe check
                    this.getVolume() == other.getVolume();    //primitives cant be null so we are safe
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand = " + getBrand() + ", volume = " + getVolume() +
                ", currentChannel=" + getCurrentChannel() + "]";
    }
}