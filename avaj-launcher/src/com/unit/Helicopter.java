
package com.unit;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower WeatherTower;

	Helicopter(String name, Coordinates coordinates) {

		super(name, coordinates);
	}

	@Override
	public void updateConditions() {

		String weather = WeatherTower.getWeather(coordinates);

		System.out.print(getLogName() + ": ");
		switch (weather) {

			case "RAIN":	System.out.println(reactOnRain());	break;
			case "FOG":		System.out.println(reactOnFog());	break;
			case "SUN":		System.out.println(reactOnSun());	break;
			case "SNOW":	System.out.println(reactOnSnow());	break;
		}
	}

	@Override
	public String reactOnRain() {

		coordinates.setLongitude(coordinates.getLongitude() + 5);
		return "Forgot my umbrella! (LONG +5)";
	}

	@Override
	public String reactOnFog() {

		coordinates.setLongitude(coordinates.getLongitude() + 1);
		return "Gosh, I see nothing! (LONG +1)";
	}

	@Override
	public String reactOnSun() {

		coordinates.setLongitude(coordinates.getLongitude() + 10);
		coordinates.setHeight(coordinates.getHeight() + 2);
		return "Gonna put my glasses on. (LONG +10 H +2)";
	}

	@Override
	public String reactOnSnow() {

		coordinates.setHeight(coordinates.getHeight() - 12);
		return "Big white flakes around, going down. (H -12)";
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {

		WeatherTower.register(this);
		this.WeatherTower = WeatherTower;
		System.out.println("Tower says: " + getLogName() + " registered to weather tower.");
	}

	@Override
	public String getLogName() {

		return "Helicopter#" + name + "(" + id + ")";
	}
}
