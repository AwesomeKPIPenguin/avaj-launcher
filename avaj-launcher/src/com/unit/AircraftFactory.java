
package com.unit;

import com.unit.exceptions.UnknownAircraftNameException;

public class AircraftFactory {

	public AircraftFactory() { }

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
		throws UnknownAircraftNameException {

		Flyable aircraft;
		Coordinates coord;

		aircraft = null;
		coord = new Coordinates(longitude, latitude, height);
		type = type.toLowerCase();

		switch (type) {

			case "helicopter":	aircraft = new Helicopter(name, coord);	break;
			case "jetplane":	aircraft = new JetPlane(name, coord);	break;
			case "baloon":		aircraft = new Baloon(name, coord);		break;

			default: throw new UnknownAircraftNameException();
		}

		return aircraft;
	}
}
