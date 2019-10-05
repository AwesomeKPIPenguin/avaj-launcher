
package com.unit.exceptions;

public class WrongNumberOfParametersException extends Exception {

    @Override
    public String getMessage() {
        return "Wrong number of parameters were passed";
    }
}
