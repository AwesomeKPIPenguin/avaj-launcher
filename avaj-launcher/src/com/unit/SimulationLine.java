
package com.unit;

public class SimulationLine {

    public String aircraftType;
    public String aircraftName;
    public int longitude;
    public int latitude;
    public int height;

    public SimulationLine() { }

    public SimulationLine(String aircraftType, String aircraftName, int longitude, int latitude, int height) {

        this.aircraftType = aircraftType;
        this.aircraftName = aircraftName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
}
