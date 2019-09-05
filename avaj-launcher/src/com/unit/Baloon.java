
package com.unit;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower WeatherTower;

	Baloon(String name, Coordinates coordinates) {

		super(name, coordinates);
	}

	@Override
	public void updateConditions() {

		String weather = WeatherTower.getWeather(coordinates);

		System.out.println(getLogName() + ": ");
		switch (weather) {

			case "RAIN":	System.out.println(getLogName() + ": " + reactOnRain());	break;
			case "FOG":		System.out.println(getLogName() + ": " + reactOnFog());		break;
			case "SUN":		System.out.println(getLogName() + ": " + reactOnSun());		break;
			case "SNOW":	System.out.println(getLogName() + ": " + reactOnSnow());	break;
		}
	}

	@Override
	public String reactOnRain() {

		coordinates.setLongitude(coordinates.getLongitude() + 5);
		return "Dojd' blyat' (LONG +5)";
	}

	@Override
	public String reactOnFog() {

		coordinates.setLongitude(coordinates.getLongitude() + 1);
		return "YOU CAN'T SEE ME (LONG +1)";
	}

	@Override
	public String reactOnSun() {

		coordinates.setLongitude(coordinates.getLongitude() + 10);
		coordinates.setHeight(coordinates.getHeight() + 2);
		return "Zagaraem (LONG +10 H +2)";
	}

	@Override
	public String reactOnSnow() {

		coordinates.setHeight(coordinates.getHeight() - 12);
		return "Dubak suka (H -12)";
	}

	@Override
	public void registerTower(WeatherTower WeatherTower) {

		this.WeatherTower = WeatherTower;
		System.out.println("Tower says: " + getLogName() + " registered to weather tower.");
	}

	@Override
	public String getLogName() {

		return "Baloon#" + name + "(" + id + ")";
	}
}

