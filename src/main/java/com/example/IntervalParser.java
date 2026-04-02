package com.example;

public class IntervalParser implements Parser<Interval> {

    private IntervalNumber parseIntervalNumber(String numberString) throws ParseException {
        for (IntervalNumber number : IntervalNumber.values()) {
            if (number.toString().equals(numberString.strip())) {
                return number;
            }
        }
        throw new ParseException(numberString.strip() + " is not a valid interval number");
    }

    private IntervalQuality parseIntervalQuality(String qualityString) throws ParseException {
        for (IntervalQuality quality : IntervalQuality.values()) {
            if (quality.toString().equals(qualityString.strip())) {
                return quality;
            }
        }
        throw new ParseException(qualityString.strip() + " is not a valid accidental");
    }

    @Override
    public Interval parse(String parseString) throws ParseException {
        try {
            String[] tokens = parseString.split(" ");
            if (tokens.length != 2) {
                throw new ParseException("Incorrect number of parse string tokens: " + tokens.length);
            }
            IntervalQuality quality = parseIntervalQuality(tokens[0]);
            IntervalNumber number = parseIntervalNumber(tokens[1]);
            return new Interval(quality, number);
        } catch (InvalidIntervalException ex) {
            throw new ParseException(ex.getMessage());
        }
    }
}
