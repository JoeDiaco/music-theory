package com.example;

public enum PitchLetter {
    C("C", 0, 0),
    D("D", 1, 2),
    E("E", 2, 4),
    F("F", 3, 5),
    G("G", 4, 7),
    A("A", 5, 9),
    B("B", 6, 11);

    private final String symbol;
    private final int diatonicIndex;
    private final int chromaticIndex;

    PitchLetter(String symbol, int diatonicIndex, int chromaticIndex) {
        this.symbol = symbol;
        this.diatonicIndex = diatonicIndex;
        this.chromaticIndex = chromaticIndex;
    }

    public int getDiatonicIndex() {
        return this.diatonicIndex;
    }

    public int getChromaticIndex() {
        return this.chromaticIndex;
    }

    public static PitchLetter fromDiatonicIndex(int index) {
        for (PitchLetter letter : PitchLetter.values()) {
            if (letter.diatonicIndex == index) {
                return letter;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

}
