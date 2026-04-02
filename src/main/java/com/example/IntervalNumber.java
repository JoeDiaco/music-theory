package com.example;

import java.util.Arrays;

public enum IntervalNumber {
    UNISON(0, 0),
    SECOND(2, 1),
    THIRD(4, 2),
    FOURTH(5, 3),
    FIFTH(7, 4),
    SIXTH(9, 5),
    SEVENTH(11, 6);

    private final int chromaticDistance;
    private final int diatonicDistance;

    public static final IntervalNumber[] PERFECT_GROUP = { UNISON, FOURTH, FIFTH };

    IntervalNumber(int chromaticDistance, int diatonicDistance) {
        this.chromaticDistance = chromaticDistance;
        this.diatonicDistance = diatonicDistance;
    }

    public int getChromaticDistance() {
        return chromaticDistance;
    }

    public int getDiatonicDistance() {
        return diatonicDistance;
    }

    public static IntervalNumber fromDiatonicDistance(int distance) {
        for (IntervalNumber number : IntervalNumber.values()) {
            if (number.diatonicDistance == distance) {
                return number;
            }
        }
        return null;
    }

    public boolean canBePerfect() {
        return Arrays.asList(PERFECT_GROUP).contains(this);
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
