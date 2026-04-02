package com.example;

public class ParseException extends Exception {

    public ParseException(String message) {
        super("Parse error: " + message);
    }

}
