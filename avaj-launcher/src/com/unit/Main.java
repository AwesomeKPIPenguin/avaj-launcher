
package com.unit;

import com.unit.exceptions.WrongSimulationFileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		WeatherTower wt;
		Flyable flyable;
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
			try { simulationCount = Integer.parseInt(line); }
			catch (Exception e) { throw new WrongSimulationFileFormatException(); }
			while ((line = reader.readLine()) != null) {

				params = line.split(" ");
				flyable = AircraftFactory.newAircraft(
					params[0],
					params[1],
					Integer.parseInt(params[2]),
					Integer.parseInt(params[3]),
					Integer.parseInt(params[4])
				);
				flyable.registerTower(wt);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return ;
		}

		for (int i = 0; i < simulationCount; ++i)
			wt.changeWeather();
	}
}
