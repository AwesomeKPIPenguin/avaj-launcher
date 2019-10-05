
package com.unit.exceptions;

public class WrongParametersException extends Exception {

    @Override
    public String getMessage() {
        return "Wrong parameters were passed";
    }
}
