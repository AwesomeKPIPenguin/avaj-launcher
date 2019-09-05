
package com.unit;

public class AircraftFactory {

	public AircraftFactory() { }

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Flyable aircraft;
		Coordinates coord;

		aircraft = null;
		coord = new Coordinates(longitude, latitude, height);
		type = type.toLowerCase();

		switch (type) {

			case "helicopter":	aircraft = new Helicopter(name, coord);
			case "jetplane":	aircraft = new JetPlane(name, coord);
			case "baloon":		aircraft = new Baloon(name, coord);
		}

		return aircraft;
	}
}
