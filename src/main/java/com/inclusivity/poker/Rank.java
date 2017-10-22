package com.inclusivity.poker;

/**
 * An enum for card rank and an integer value for sort order /
 * when trying to determine if there is sequential rank
 */
public enum Rank {

    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13);

    private String shortcode;
    private int value;

    Rank(String code, int value) {

        this.shortcode = code;
        this.value = value;

    }

    public static Rank fromShortCode(String text) {
        for (Rank r : Rank.values()) {
            if (r.shortcode.equalsIgnoreCase(text)) {
                return r;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
