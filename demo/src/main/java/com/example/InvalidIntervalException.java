package com.example;

public class InvalidIntervalException extends Exception {

    public InvalidIntervalException(IntervalQuality quality, IntervalNumber number) {
        super("%s %s is not a valid interval".formatted(quality, number));
    }

}
