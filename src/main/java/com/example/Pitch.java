package com.example;

import java.util.Objects;

public class Pitch {
    private final PitchLetter letter;
    private final PitchModifier modifier;

    public Pitch(PitchLetter letter, PitchModifier modifier) {
        this.letter = letter;
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "%s%s".formatted(this.letter, this.modifier);
    }

    public PitchClass getPitchClass() {
        return new PitchClass(letter.getChromaticIndex() + modifier.getOffset());
    }

    public int getDiatonicIndex() {
        return letter.getDiatonicIndex();
    }

    public Pitch transpose(Interval interval) {
        PitchLetter returnLetter;
        PitchModifier returnModifier;

        returnLetter = PitchLetter
                .fromDiatonicIndex(Math.floorMod(interval.getDiatonicDistance() + getDiatonicIndex(), 7));

        int offset = (interval.getChromaticDistance() - (returnLetter.getChromaticIndex()
                - getPitchClass().getDistanceFromC())) % 12;
        returnModifier = PitchModifier.fromOffset(offset);
        return new Pitch(returnLetter, returnModifier);
    }

    public Interval intervalTo(Pitch other) throws InvalidIntervalException {
        return Interval.between(this, other);
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
        final Pitch other = (Pitch) obj;
        if (this.letter != other.letter) {
            return false;
        }
        return this.modifier == other.modifier;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.letter);
        hash = 71 * hash + Objects.hashCode(this.modifier);
        return hash;
    }
}
