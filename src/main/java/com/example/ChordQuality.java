package com.example;

public enum ChordQuality {

    MAJOR,
    MINOR,
    AUGMENTED,
    DIMINISHED,
    HALF_DIMINISHED,
    DIMINISHED_7,
    MAJOR_7,
    MINOR_7,
    DOMINANT_7;

    private static Interval MAJOR_THIRD;
    private static Interval MINOR_THIRD;
    private static Interval PERFECT_FIFTH;
    private static Interval AUGMENTED_FIFTH;
    private static Interval DIMINISHED_FIFTH;
    private static Interval MAJOR_SEVENTH;
    private static Interval MINOR_SEVENTH;
    private static Interval DIMINISHED_SEVENTH;

    static {
        try {
            MAJOR_THIRD = new Interval(IntervalQuality.MAJOR, IntervalNumber.THIRD);
            MINOR_THIRD = new Interval(IntervalQuality.MINOR, IntervalNumber.THIRD);
            PERFECT_FIFTH = new Interval(IntervalQuality.PERFECT, IntervalNumber.FIFTH);
            AUGMENTED_FIFTH = new Interval(IntervalQuality.AUGMENTED, IntervalNumber.FIFTH);
            DIMINISHED_FIFTH = new Interval(IntervalQuality.DIMINISHED, IntervalNumber.FIFTH);
            MAJOR_SEVENTH = new Interval(IntervalQuality.MAJOR, IntervalNumber.SEVENTH);
            MINOR_SEVENTH = new Interval(IntervalQuality.MINOR, IntervalNumber.SEVENTH);
            DIMINISHED_SEVENTH = new Interval(IntervalQuality.DIMINISHED, IntervalNumber.SEVENTH);
        } catch (InvalidIntervalException e) {
            throw new RuntimeException("Failed to initialize interval");
        }
    }

    public Interval[] getIntervals() {
        switch (this) {
            case MAJOR -> {
                return new Interval[] { MAJOR_THIRD, PERFECT_FIFTH };
            }
            case MINOR -> {
                return new Interval[] { MINOR_THIRD, PERFECT_FIFTH };
            }
            case AUGMENTED -> {
                return new Interval[] { MAJOR_THIRD, AUGMENTED_FIFTH };
            }
            case DIMINISHED -> {
                return new Interval[] { MINOR_THIRD, DIMINISHED_FIFTH };
            }
            case MAJOR_7 -> {
                return new Interval[] { MAJOR_THIRD, PERFECT_FIFTH, MAJOR_SEVENTH };
            }
            case MINOR_7 -> {
                return new Interval[] { MINOR_THIRD, PERFECT_FIFTH, MINOR_SEVENTH };
            }
            case DOMINANT_7 -> {
                return new Interval[] { MAJOR_THIRD, PERFECT_FIFTH, MINOR_SEVENTH };
            }
            case HALF_DIMINISHED -> {
                return new Interval[] { MINOR_THIRD, DIMINISHED_FIFTH, MINOR_SEVENTH };
            }
            case DIMINISHED_7 -> {
                return new Interval[] { MINOR_THIRD, DIMINISHED_FIFTH, DIMINISHED_SEVENTH };
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }

}
