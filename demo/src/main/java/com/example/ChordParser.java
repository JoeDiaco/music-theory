package com.example;

public class ChordParser implements Parser<Chord> {

    private ChordQuality parseChordQuality(String qualityString) throws ParseException {
        for (ChordQuality quality : ChordQuality.values()) {
            if (quality.toString().equals(qualityString.strip())) {
                return quality;
            }
        }
        throw new ParseException(qualityString.strip() + " is not a valid interval number");
    }

    @Override
    public Chord parse(String parseString) throws ParseException {
        Pitch root;
        ChordQuality quality;
        PitchParser pitchParser = new PitchParser();

        String[] tokens = parseString.split(" ");
        if (tokens.length > 2) {
            throw new ParseException(parseString + " is not a valid chord name");
        }
        root = pitchParser.parse(tokens[0]);
        if (tokens.length == 1) {
            quality = ChordQuality.MAJOR;
        } else {
            quality = parseChordQuality(tokens[1]);
        }

        return new Chord(root, quality);
    }
}
