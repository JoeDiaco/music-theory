package com.example;

public class Key {
    private final Pitch tonic;
    private final Mode mode;

    public Key(Pitch tonic, Mode mode) {
        this.tonic = tonic;
        this.mode = mode;
    }

    public Pitch getTonic() {
        return tonic;
    }

    public Mode getMode() {
        return mode;
    }

}
