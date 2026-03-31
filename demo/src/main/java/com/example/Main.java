package com.example;

public class Main {
    public static void main(String[] args) {

        try {
            ChordParser parser = new ChordParser();
            Chord chord = parser.parse("G dominant 7");
            System.out.println(chord);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}