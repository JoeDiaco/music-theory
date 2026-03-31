package com.example;

import java.util.Objects;

public class Interval {

    private final IntervalQuality quality;
    private final IntervalNumber number;

    public Interval(IntervalQuality quality, IntervalNumber number) throws InvalidIntervalException {
        if (isInvalidInterval(quality, number)) {
            throw new InvalidIntervalException(quality, number);
        }
        this.quality = quality;
        this.number = number;
    }

    private boolean isInvalidInterval(IntervalQuality quality, IntervalNumber number) {
        return isInvalidPerfect(quality, number) || isInvalidMajorOrMinor(quality, number);
    }

    private boolean isInvalidPerfect(IntervalQuality quality, IntervalNumber number) {
        return quality.equals(IntervalQuality.PERFECT) && !number.canBePerfect();
    }

    private boolean isInvalidMajorOrMinor(IntervalQuality quality, IntervalNumber number) {
        return number.canBePerfect() && quality.isMajorOrMinor();
    }

    public IntervalQuality getQuality() {
        return quality;
    }

    public IntervalNumber getNumber() {
        return number;
    }

    private int getQualityOffset() {
        switch (quality) {
            case DOUBLY_AUGMENTED -> {
                return 2;
            }
            case AUGMENTED -> {
                return 1;
            }
            case MAJOR -> {
                return 0;
            }
            case PERFECT -> {
                return 0;
            }
            case MINOR -> {
                return -1;
            }
            case DIMINISHED -> {
                return number.canBePerfect() ? -1 : -2;
            }
            case DOUBLY_DIMINISHED -> {
                return number.canBePerfect() ? -2 : -3;
            }
            default -> throw new AssertionError();
        }
    }

    private static IntervalQuality getQualityFromOffsetAndNumber(int offset, IntervalNumber number) {
        switch (offset) {
            case 2 -> {
                return IntervalQuality.DOUBLY_AUGMENTED;
            }
            case 1 -> {
                return IntervalQuality.AUGMENTED;
            }
            case 0 -> {
                return number.canBePerfect() ? IntervalQuality.PERFECT : IntervalQuality.MAJOR;
            }
            case -1 -> {
                return number.canBePerfect() ? IntervalQuality.DIMINISHED : IntervalQuality.MINOR;
            }
            case -2 -> {
                return number.canBePerfect() ? IntervalQuality.DOUBLY_DIMINISHED : IntervalQuality.DIMINISHED;
            }
            case -3 -> {
                return IntervalQuality.DOUBLY_DIMINISHED;
            }
            default -> throw new AssertionError();
        }
    }

    public int getChromaticDistance() {
        return Math.floorMod(number.getChromaticDistance() + getQualityOffset(), 12);
    }

    public int getDiatonicDistance() {
        return number.getDiatonicDistance();
    }

    public static Interval between(Pitch from, Pitch to) throws InvalidIntervalException {
        int diatonicDistance = Math.floorMod(to.getDiatonicIndex() - from.getDiatonicIndex(), 7);
        IntervalNumber returnNumber = IntervalNumber.fromDiatonicDistance(diatonicDistance);

        int actualPitchClassDistance = Math
                .floorMod(to.getPitchClass().getDistanceFromC() - from.getPitchClass().getDistanceFromC(), 12);
        int expectedPitchClassDistance = returnNumber.getChromaticDistance();
        IntervalQuality returnQuality = getQualityFromOffsetAndNumber(
                Math.min(actualPitchClassDistance - expectedPitchClassDistance,
                        12 - actualPitchClassDistance - expectedPitchClassDistance),
                returnNumber);

        return new Interval(returnQuality, returnNumber);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(quality, number);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.quality);
        hash = 53 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interval other = (Interval) obj;
        if (this.quality != other.quality) {
            return false;
        }
        return this.number == other.number;
    }

}
