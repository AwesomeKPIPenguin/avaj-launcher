
package com.unit;

import com.unit.exceptions.WrongParametersException;

public class Main {

	public static void main(String[] args)
		throws Exception {

		WeatherTower wt;
		int simulationCount;
		boolean isMD5;
		String filename;

		if (args.length == 1) {
			isMD5 = false;
			filename = args[0];
		} else if (args.length == 2 && args[0].equals("-md5")) {
			isMD5 = true;
			filename = args[1];
		} else {
			throw new WrongParametersException();
		}

		wt = new WeatherTower();
		simulationCount = Parser.Parse(filename, wt, isMD5);

		for (int i = 0; i < simulationCount; ++i)
			wt.changeWeather();
	}
}
