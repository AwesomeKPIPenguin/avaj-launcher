
package com.unit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)
		throws Exception {

		WeatherTower wt;
		BufferedReader reader;
		String line;
		String[] params;
		int simulationCount;
		boolean isMD5;

		isMD5 = args[0].equals("-md5");

		if (args.length != ((isMD5) ? 2 : 1))
			throw new WrongNumberOfParametersException();

		wt = new WeatherTower();
		simulationCount = 0;

		try {

			reader = new BufferedReader(new FileReader(args[0]));
			if ((line = reader.readLine()) == null)
				return;
			simulationCount = Integer.parseInt(line);
			while ((line = reader.readLine()) != null) {

				params = line.split(" ");
				wt.register(
					AircraftFactory.newAircraft(
						params[0],
						params[1],
						Integer.parseInt(params[2]),
						Integer.parseInt(params[3]),
						Integer.parseInt(params[4])
					)
				);
			}
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

		for (int i = 0; i < simulationCount; ++i)
			wt.changeWeather();
	}
}
