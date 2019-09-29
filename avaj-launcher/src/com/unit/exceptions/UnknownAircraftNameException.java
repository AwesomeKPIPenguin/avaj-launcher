package com.unit.exceptions;

public class UnknownAircraftNameException extends Exception {

	@Override
	public String getMessage() {

		return "Unknown aircraft name";
	}
}
