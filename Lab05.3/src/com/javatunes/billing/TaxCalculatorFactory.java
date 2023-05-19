package com.javatunes.billing;

/*
 * this is an all-static class, a factory for TaxCalculator instances
 */
public class TaxCalculatorFactory {
    /*
     * Optional Challenge:
     * Implement a simple cache of TaxCalculator objects.
     * -if the cache contains the desired TaxCalculotor, return it from the cache
     * -if not create new one, put it in the cache, and then return it.
     *
     * Implementation note:
     * you can use a Map<Location, TaxCalculator> for the cache
     */

    // prevent outside instantiation - this is an all static class
    private TaxCalculatorFactory() {

    }

    public static TaxCalculator getTaxCalculator(Location location) {
        TaxCalculator calc = null;

        switch (location) {
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        return calc;
    }
}