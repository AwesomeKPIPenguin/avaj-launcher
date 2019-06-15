
package com.unit;

import java.util.Random;

public class WeatherProvider {

	private static WeatherProvider WeatherProvider;

	private static String[] weather;
	private static Random rand;

	static {

		weather = new String[] { "RAIN", "FOG", "SUN", "SNOW" };
		rand = new Random();
	}

	private WeatherProvider() { }

	public static WeatherProvider getWeatherProvider() {

		if (WeatherProvider == null)
			WeatherProvider = new WeatherProvider();
		return WeatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {

		// some edge point (above clouds), where it is always SUN

		if (coordinates.getHeight() > 80)
			return weather[2];

		// random weather otherwise

		return weather[rand.nextInt(4)];
	}
}
