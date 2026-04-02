package com.example;

public class Chord {
    private final Pitch root;
    private final ChordQuality quality;

    public Chord(Pitch root, ChordQuality quality) {
        this.root = root;
        this.quality = quality;
    }

    public Pitch getRoot() {
        return root;
    }

    public ChordQuality getQuality() {
        return quality;
    }

    public Pitch[] getChordPitches() {
        Interval[] intervals = quality.getIntervals();
        Pitch[] pitches = new Pitch[intervals.length + 1];
        pitches[0] = root;
        for (int i = 0; i < intervals.length; i++) {
            pitches[i + 1] = root.transpose(intervals[i]);
        }

        return pitches;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(root, quality);
    }

}
