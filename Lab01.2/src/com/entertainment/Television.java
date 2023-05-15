package com.entertainment;

import java.util.Objects;

public class Television {
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