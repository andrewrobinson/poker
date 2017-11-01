package com.andrew.poker;

/**
 * An enum for card Suits, with a method to build them from a shortCode
 */
public enum Suit {

    HEARTS("H"), DIAMONDS("D"), CLUBS("C"), SPADES("S");

    private String shortcode;

    Suit(String code) {
        this.shortcode = code;
    }

    public static Suit fromShortCode(String text) {
        for (Suit s : Suit.values()) {
            if (s.shortcode.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }


}
