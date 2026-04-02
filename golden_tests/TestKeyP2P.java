package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.example.Mode;

import main.java.com.example.Chord;
import main.java.com.example.Pitch;

public class TestKeyP2P {
    @Test
    void testKeyTonic() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Key key = new Key(tonic, Mode.MAJOR);
            assertEquals(tonic, key.getTonic());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeyModeMajor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MAJOR;
            Key key = new Key(tonic, mode);
            assertEquals(mode, key.getMode());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeyModeMinor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MINOR;
            Key key = new Key(tonic, mode);
            assertEquals(mode, key.getMode());
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }

    @Test
    void testKeyDiatonicChordsMajor() {
        try {
            Pitch tonic = pitchParser.parse("C");
            Mode mode = Mode.MAJOR;
            Key key = new Key(tonic, mode);
            Chord[] diatonicChords = key.getDiatonicChords();
            assertEquals(chordParser.parse("C major"), diatonicChords[0]);
            assertEquals(chordParser.parse("D minor"), diatonicChords[1]);
            assertEquals(chordParser.parse("E minor"), diatonicChords[2]);
            assertEquals(chordParser.parse("F major"), diatonicChords[3]);
            assertEquals(chordParser.parse("G major"), diatonicChords[4]);
            assertEquals(chordParser.parse("A minor"), diatonicChords[5]);
            assertEquals(chordParser.parse("B diminished"), diatonicChords[6]);
        } catch (ParseException ex) {
            fail("Parse exception thrown: " + ex.getMessage());
        }
    }
}
