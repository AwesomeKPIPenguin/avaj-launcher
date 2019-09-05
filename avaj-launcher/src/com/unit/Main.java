
package com.unit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		WeatherTower wt;
		BufferedReader reader;
		String line;
		String[] params;
		int simulationCount;

		if (args.length != 1) {

			System.out.println("Number of parameters should be equal to 1");
			return;
		}

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

			e.printStackTrace();
		}

		for (int i = 0; i < simulationCount; ++i)
			wt.changeWeather();
	}
}
