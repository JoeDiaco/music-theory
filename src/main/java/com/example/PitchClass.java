package com.example;

public class PitchClass {
    private final int distanceFromC;

    public PitchClass(int distanceFromC) {
        this.distanceFromC = distanceFromC % 12;
    }

    public int getDistanceFromC() {
        return distanceFromC;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PitchClass pitchClass) {
            return pitchClass.getDistanceFromC() == this.getDistanceFromC();
        } else if (obj instanceof Integer integer) {
            return (integer % 12) == this.getDistanceFromC();
        } else
            return false;
    }

    @Override
    public String toString() {
        return Integer.toString(distanceFromC);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.distanceFromC;
        return hash;
    }

}
