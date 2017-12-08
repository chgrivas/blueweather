package com.blueweather.domain.enumeration;

/**
 * The enumeration of the supported places for weather info retrieval.
 *
 * @author cgrivas
 */
public enum Place {
    NEW_YORK("New_York");

    private String wundergroundName;

    Place(String wundergroundName) {
        this.wundergroundName = wundergroundName;
    }
    public String getWundergroundName() {
        return wundergroundName;
    }
}
