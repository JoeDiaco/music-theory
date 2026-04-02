package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class TestKeyF2P {
    private static final PitchParser pitchParser = new PitchParser();
    private static final ChordParser chordParser = new ChordParser();

    @Test
    void testKeyPrimaryScaleMajorType() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MAJOR;
            Key key = new Key(tonic, mode);
            assertEquals(ScaleType.MAJOR, key.getPrimaryScale().getType());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeyPrimaryScaleMinorType() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            assertEquals(ScaleType.HARMONIC_MINOR, key.getPrimaryScale().getType());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeySecondaryScaleMajor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MAJOR;
            Key key = new Key(tonic, mode);
            assertNull(key.getSecondaryScales());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeySecondaryScaleMinorArrayLength() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            assertTrue(key.getSecondaryScales().length == 2);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeySecondaryScaleMinorTonics() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            Scale[] secondaryScales = key.getSecondaryScales();
            boolean allScaleTonicsSameAsKeyTonic = true;
            for (Scale scale : secondaryScales) {
                if (!scale.getTonic().equals(tonic)) {
                    allScaleTonicsSameAsKeyTonic = false;
                    break;
                }
            }
            assertTrue(allScaleTonicsSameAsKeyTonic);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeySecondaryScaleMinorContainsNaturalMinor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            Scale[] secondaryScales = key.getSecondaryScales();
            boolean containsNaturalMinor = false;
            for (Scale scale : secondaryScales) {
                if (scale.getType() == ScaleType.NATURAL_MINOR) {
                    containsNaturalMinor = true;
                    break;
                }
            }
            assertTrue(containsNaturalMinor);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeySecondaryScaleMinorContainsMelodicMinor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            Scale[] secondaryScales = key.getSecondaryScales();
            boolean containsNaturalMinor = false;
            for (Scale scale : secondaryScales) {
                if (scale.getType() == ScaleType.MELODIC_MINOR) {
                    containsNaturalMinor = true;
                    break;
                }
            }
            assertTrue(containsNaturalMinor);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeyDiatonicChordsMinor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            Chord[] diatonicChords = key.getDiatonicChords();
            assertEquals(chordParser.parse("C minor"), diatonicChords[0]);
            assertEquals(chordParser.parse("D diminished"), diatonicChords[1]);
            assertEquals(chordParser.parse("Eb major"), diatonicChords[2]);
            assertEquals(chordParser.parse("F minor"), diatonicChords[3]);
            assertEquals(chordParser.parse("G major"), diatonicChords[4]);
            assertEquals(chordParser.parse("Ab major"), diatonicChords[5]);
            assertEquals(chordParser.parse("B diminished"), diatonicChords[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }
}
