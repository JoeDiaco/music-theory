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

    public Chord[] getDiatonicChords() {
        Chord[] diatonicChords = new Chord[7];
        diatonicChords[0] = new Chord(tonic, mode.getTonicQuality());

        ChordQuality[] qualities = mode.getChordQualities();
        Interval[] intervals = mode.getIntervals();

        for (int i = 0; i < diatonicChords.length - 1; i++) {
            diatonicChords[i + 1] = new Chord(tonic.transpose(intervals[i]), qualities[i]);
        }

        return diatonicChords;
    }
}
