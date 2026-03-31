package com.example;

public enum PitchModifier {
    TRIPLE_SHARP("###", 3),
    DOUBLE_SHARP("##", 2),
    SHARP("#", 1),
    NATURAL("", 0),
    FLAT("b", -1),
    DOUBLE_FLAT("bb", -2),
    TRIPLE_FLAT("bbb", -3);

    private final String symbol;
    private final int offset;

    PitchModifier(String symbol, int offset) {
        this.symbol = symbol;
        this.offset = offset;
    }

    public static PitchModifier fromOffset(int offset) {
        for (PitchModifier modifier : PitchModifier.values()) {
            if (modifier.offset == offset) {
                return modifier;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public int getOffset() {
        return this.offset;
    }

}
