package Enums;

import java.util.Comparator;

public enum CardRank {

    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (11),
    QUEEN (12),
    KING (13),
    ACE (14);

    public int getRank() {
        return rank;
    }

    private final int rank;

    CardRank(int rank){
        this.rank = rank;
    }


}
