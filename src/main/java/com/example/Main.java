package com.example;

public class Main {
    public static void main(String[] args) {

        try {
            KeyParser keyParser = new KeyParser();

            Key key = keyParser.parse("C# minor");
            Chord[] diatonicChords = key.getDiatonicChords();
            for (Chord chord : diatonicChords) {
                System.out.println(chord);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}