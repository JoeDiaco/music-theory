package com.example;

public enum Mode {
    MAJOR(ChordQuality.MAJOR),
    MINOR(ChordQuality.MAJOR);

    private ChordQuality tonicQuality;

    Mode(ChordQuality tonicQuality) {
        this.tonicQuality = tonicQuality;
    }

    public Interval[] getIntervals() {
        switch (this) {
            case MAJOR -> {
                try {
                    return new Interval[] {
                            new Interval(IntervalQuality.MAJOR, IntervalNumber.SECOND),
                            new Interval(IntervalQuality.MAJOR, IntervalNumber.THIRD),
                            new Interval(IntervalQuality.PERFECT, IntervalNumber.FOURTH),
                            new Interval(IntervalQuality.PERFECT, IntervalNumber.FIFTH),
                            new Interval(IntervalQuality.MAJOR, IntervalNumber.SIXTH),
                            new Interval(IntervalQuality.MAJOR, IntervalNumber.SEVENTH),
                    };
                } catch (InvalidIntervalException ex) {
                    return null;
                }
            }
            case MINOR -> {
                try {
                    return new Interval[] {
                            new Interval(IntervalQuality.MAJOR, IntervalNumber.SECOND),
                            new Interval(IntervalQuality.MINOR, IntervalNumber.THIRD),
                            new Interval(IntervalQuality.PERFECT, IntervalNumber.FOURTH),
                            new Interval(IntervalQuality.PERFECT, IntervalNumber.FIFTH),
                            new Interval(IntervalQuality.MINOR, IntervalNumber.SIXTH),
                            new Interval(IntervalQuality.MINOR, IntervalNumber.SEVENTH),
                    };
                } catch (InvalidIntervalException ex) {
                    return null;
                }
            }
            default -> throw new AssertionError();
        }
    }

    public ChordQuality getTonicQuality() {
        return tonicQuality;
    }

    public ChordQuality[] getChordQualities() {
        switch (this) {
            case MAJOR -> {
                return new ChordQuality[] {
                        ChordQuality.MINOR,
                        ChordQuality.MINOR,
                        ChordQuality.MAJOR,
                        ChordQuality.MAJOR,
                        ChordQuality.MINOR,
                        ChordQuality.DIMINISHED
                };
            }
            case MINOR -> {
                return new ChordQuality[] {
                        ChordQuality.DIMINISHED,
                        ChordQuality.MAJOR,
                        ChordQuality.MINOR,
                        ChordQuality.MINOR,
                        ChordQuality.MAJOR,
                        ChordQuality.MAJOR
                };
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
