package com.example;

public class PitchParser implements Parser<Pitch> {

    private PitchLetter parsePitchLetter(String pitchLetterString) throws ParseException {
        for (PitchLetter letter : PitchLetter.values()) {
            if (letter.toString().equals(pitchLetterString)) {
                return letter;
            }
        }
        throw new ParseException(pitchLetterString.strip() + " is not a valid pitch letter");
    }

    private PitchModifier parsePitchModifier(String pitchModifierString) throws ParseException {
        for (PitchModifier modifier : PitchModifier.values()) {
            if (modifier.toString().equals(pitchModifierString)) {
                return modifier;
            }
        }
        throw new ParseException(pitchModifierString.strip() + " is not a valid accidental");
    }

    @Override
    public Pitch parse(String parseString) throws ParseException {
        if (parseString.length() < 1) {
            throw new ParseException(parseString.strip() + " is not a valid pitch.");
        }
        String pitchLetterStr = parseString.substring(0, 1);
        String pitchModifierStr = parseString.length() == 1 ? "" : parseString.substring(1);

        PitchLetter letter = parsePitchLetter(pitchLetterStr);
        PitchModifier modifier = parsePitchModifier(pitchModifierStr);

        return new Pitch(letter, modifier);
    }

}
