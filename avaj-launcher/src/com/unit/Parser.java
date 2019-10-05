
package com.unit;

import com.unit.exceptions.UnknownValueOfMD5Exception;
import com.unit.exceptions.WrongSimulationFileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {

    public static int Parse(String filename, WeatherTower wt, boolean isMD5) {

        Flyable flyable;
        BufferedReader reader;
        String line;
        SimulationLine simulationLine;
        int lineNo;
        int simulationCount;

        try {
            reader = new BufferedReader(new FileReader(filename));
            if ((line = reader.readLine()) == null)
                return 0;
            try { simulationCount = ParseSimulationCount(line, isMD5); }
            catch (Exception e) { throw new WrongSimulationFileFormatException(); }

            lineNo = 1;
            while ((line = reader.readLine()) != null) {
                ++lineNo;
                simulationLine = ParseLine(line, lineNo, isMD5);
                flyable = AircraftFactory.newAircraft(
                    simulationLine.aircraftType,
                    simulationLine.aircraftName,
                    simulationLine.longitude,
                    simulationLine.latitude,
                    simulationLine.height
                );
                flyable.registerTower(wt);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return 0;
        }

        return simulationCount;
    }

    private static int ParseSimulationCount(String line, boolean isMD5)
        throws WrongSimulationFileFormatException {

        if (isMD5) {
            try {
                return Integer.parseInt(MD5.getValueFromMD5(line));
            } catch (UnknownValueOfMD5Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        } else {
            return Integer.parseInt(line);
        }
        return 0;
    }

    private static SimulationLine ParseLine(String line, int lineNo, boolean isMD5)
        throws WrongSimulationFileFormatException {

        SimulationLine simulationLine = new SimulationLine();
        String[] params;

        params = line.split(" ");
        if (params.length != 5)
            throw new WrongSimulationFileFormatException();
        if (isMD5) {
            try {
                simulationLine = new SimulationLine(
                    MD5.getValueFromMD5(params[0]),
                    params[1],
                    Integer.parseInt(MD5.getValueFromMD5(params[2])),
                    Integer.parseInt(MD5.getValueFromMD5(params[3])),
                    Integer.parseInt(MD5.getValueFromMD5(params[4]))
                );
            } catch (UnknownValueOfMD5Exception e) {
                System.out.println("Line " + lineNo + ": " + e.getMessage());
                System.exit(-1);
            }
        } else {
            simulationLine = new SimulationLine(
                params[0],
                params[1],
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4])
            );
        }

        return simulationLine;
    }
}
