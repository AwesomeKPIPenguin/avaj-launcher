
package com.unit;

import javax.sound.midi.SysexMessage;

public class Parser {

    public static SimulationLine Parse(String line, int lineNo, boolean isMD5) {

        SimulationLine simulationLine = new SimulationLine();
        String[] params;

        params = line.split(" ");
//        if (params.length != 5)
//            throw WrongFormatException
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
