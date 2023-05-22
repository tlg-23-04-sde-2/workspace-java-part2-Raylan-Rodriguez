package com.duckrace.client;

import com.duckrace.app.DuckRaceApp;

/*
 * gets the application going, and that is it.
 */
class Main {

    public static void main(String[] args) {
        //instantiate controller and say "go"
        DuckRaceApp app = new DuckRaceApp();
        app.execute();
    }
}