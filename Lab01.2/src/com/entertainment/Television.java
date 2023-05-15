package com.entertainment;

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

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // only proceed if "obj" is a reference
        if (obj instanceof Television) {
            // downcast 'obj' to more specific Television, so we can call Television methods.
            Television other = (Television) obj;
            // do the checks: business equality is defined
            result = this.getBrand().equals(other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [brand = " + getBrand() + ", volume = " + getVolume() +
                ", currentChannel=" + getCurrentChannel() + "]";
    }
}