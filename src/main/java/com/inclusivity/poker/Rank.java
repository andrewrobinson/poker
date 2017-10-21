package com.inclusivity.poker;

public enum Rank {

    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private String shortcode;

    Rank(String code) {
        this.shortcode = code;
    }

    public static Rank fromShortCode(String text) {
        for (Rank r : Rank.values()) {
            if (r.shortcode.equalsIgnoreCase(text)) {
                return r;
            }
        }
        return null;
    }
}
