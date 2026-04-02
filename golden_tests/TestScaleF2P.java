package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class TestScaleF2P {

    private static final PitchParser pitchParser = new PitchParser();

    @Test
    void testScaleLength() {
        try {
            Pitch tonic = pitchParser.parse("C");
            ScaleType scaleType = ScaleType.MAJOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            assertEquals(7, cMajorScale.getPitches().length);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testScaleTonic() {
        try {
            Pitch tonic = pitchParser.parse("D");
            ScaleType scaleType = ScaleType.MAJOR;
            Scale dMajorScale = new Scale(tonic, scaleType);
            assertEquals(tonic, dMajorScale.getTonic());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testMajorScalePitches() {
        try {
            Pitch tonic = pitchParser.parse("C");
            ScaleType scaleType = ScaleType.MAJOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C"), scalePitches[0]);
            assertEquals(pitchParser.parse("D"), scalePitches[1]);
            assertEquals(pitchParser.parse("E"), scalePitches[2]);
            assertEquals(pitchParser.parse("F"), scalePitches[3]);
            assertEquals(pitchParser.parse("G"), scalePitches[4]);
            assertEquals(pitchParser.parse("A"), scalePitches[5]);
            assertEquals(pitchParser.parse("B"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testNaturalMinorScalePitches() {
        try {
            Pitch tonic = pitchParser.parse("C");
            ScaleType scaleType = ScaleType.NATURAL_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C"), scalePitches[0]);
            assertEquals(pitchParser.parse("D"), scalePitches[1]);
            assertEquals(pitchParser.parse("Eb"), scalePitches[2]);
            assertEquals(pitchParser.parse("F"), scalePitches[3]);
            assertEquals(pitchParser.parse("G"), scalePitches[4]);
            assertEquals(pitchParser.parse("Ab"), scalePitches[5]);
            assertEquals(pitchParser.parse("Bb"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testHarmonicMinorScalePitches() {
        try {
            Pitch tonic = pitchParser.parse("C");
            ScaleType scaleType = ScaleType.HARMONIC_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C"), scalePitches[0]);
            assertEquals(pitchParser.parse("D"), scalePitches[1]);
            assertEquals(pitchParser.parse("Eb"), scalePitches[2]);
            assertEquals(pitchParser.parse("F"), scalePitches[3]);
            assertEquals(pitchParser.parse("G"), scalePitches[4]);
            assertEquals(pitchParser.parse("Ab"), scalePitches[5]);
            assertEquals(pitchParser.parse("B"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testMelodicMinorScalePitches() {
        try {
            Pitch tonic = pitchParser.parse("C");
            ScaleType scaleType = ScaleType.MELODIC_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C"), scalePitches[0]);
            assertEquals(pitchParser.parse("D"), scalePitches[1]);
            assertEquals(pitchParser.parse("Eb"), scalePitches[2]);
            assertEquals(pitchParser.parse("F"), scalePitches[3]);
            assertEquals(pitchParser.parse("G"), scalePitches[4]);
            assertEquals(pitchParser.parse("A"), scalePitches[5]);
            assertEquals(pitchParser.parse("B"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testNaturalMinorScalePitchesSharpTonic() {
        try {
            Pitch tonic = pitchParser.parse("C#");
            ScaleType scaleType = ScaleType.NATURAL_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C#"), scalePitches[0]);
            assertEquals(pitchParser.parse("D#"), scalePitches[1]);
            assertEquals(pitchParser.parse("E"), scalePitches[2]);
            assertEquals(pitchParser.parse("F#"), scalePitches[3]);
            assertEquals(pitchParser.parse("G#"), scalePitches[4]);
            assertEquals(pitchParser.parse("A"), scalePitches[5]);
            assertEquals(pitchParser.parse("B"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testHarmonicMinorScalePitchesSharpTonic() {
        try {
            Pitch tonic = pitchParser.parse("C#");
            ScaleType scaleType = ScaleType.HARMONIC_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C#"), scalePitches[0]);
            assertEquals(pitchParser.parse("D#"), scalePitches[1]);
            assertEquals(pitchParser.parse("E"), scalePitches[2]);
            assertEquals(pitchParser.parse("F#"), scalePitches[3]);
            assertEquals(pitchParser.parse("G#"), scalePitches[4]);
            assertEquals(pitchParser.parse("A"), scalePitches[5]);
            assertEquals(pitchParser.parse("B#"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testMelodicMinorScalePitchesSharpTonic() {
        try {
            Pitch tonic = pitchParser.parse("C#");
            ScaleType scaleType = ScaleType.MELODIC_MINOR;
            Scale cMajorScale = new Scale(tonic, scaleType);
            Pitch[] scalePitches = cMajorScale.getPitches();
            assertEquals(pitchParser.parse("C#"), scalePitches[0]);
            assertEquals(pitchParser.parse("D#"), scalePitches[1]);
            assertEquals(pitchParser.parse("E"), scalePitches[2]);
            assertEquals(pitchParser.parse("F#"), scalePitches[3]);
            assertEquals(pitchParser.parse("G#"), scalePitches[4]);
            assertEquals(pitchParser.parse("A#"), scalePitches[5]);
            assertEquals(pitchParser.parse("B#"), scalePitches[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }
}
