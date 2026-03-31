package com.example;

public enum IntervalQuality {
    DOUBLY_AUGMENTED,
    AUGMENTED,
    MAJOR,
    PERFECT,
    MINOR,
    DIMINISHED,
    DOUBLY_DIMINISHED;

    public boolean isMajorOrMinor() {
        return this.equals(MAJOR) || this.equals(MINOR);
    }

    @Override
    public String toString() {
        return name().toLowerCase().replace('_', '-');
    }

}
