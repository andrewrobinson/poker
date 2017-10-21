package com.inclusivity.poker;

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
