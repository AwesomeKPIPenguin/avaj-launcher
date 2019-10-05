
package com.unit.exceptions;

public class UnknownValueOfMD5Exception extends Exception {

    @Override
    public String getMessage() {
        return "Unknown value of MD5 hash string";
    }
}
