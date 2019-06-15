
package com.unit;

public interface Flyable {

	void updateConditions();
	void registerTower(WeatherTower WeatherTower);

	String getLogName();

	String reactOnRain();
	String reactOnSun();
	String reactOnFog();
	String reactOnSnow();
}
