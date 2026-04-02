package com.example;

public class KeyParser implements Parser<Key> {
    private PitchParser pitchParser;

    public KeyParser() {
        pitchParser = new PitchParser();
    }

    private Mode parseMode(String modeString) throws ParseException {
        for (Mode mode : Mode.values()) {
            if (mode.toString().equals(modeString)) {
                return mode;
            }
        }
        throw new ParseException(modeString.strip() + " is not a valid mode");
    }

    @Override
    public Key parse(String parseString) throws ParseException {
        Pitch tonic;
        Mode mode;

        String[] tokens = parseString.split(" ");
        tonic = pitchParser.parse(tokens[0]);
        mode = parseMode(tokens[1]);

        return new Key(tonic, mode);
    }
}
