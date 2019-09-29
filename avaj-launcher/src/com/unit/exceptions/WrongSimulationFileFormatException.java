package com.unit.exceptions;

public class WrongSimulationFileFormatException extends Exception {

	@Override
	public String getMessage() {

		return "Wrong simulation file format";
	}
}
