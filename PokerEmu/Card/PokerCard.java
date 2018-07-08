package Card;

import Enums.CardRank;
import Enums.CardSuit;

import java.util.Comparator;

public class PokerCard extends AbstractCard implements Comparable<PokerCard>{

    private boolean isDrawn = false;

    private boolean isCommonCard = false;

    public boolean isCommonCard() {
        return isCommonCard;
    }

    public void setCommonCard(boolean commonCard) {
        isCommonCard = commonCard;
    }

    public PokerCard(CardRank rank, CardSuit suit) {
        super(rank, suit);
    }

    @Override
    public String toString() {
        return " |" + this.getCardRank().toString() + " : " + this.getCardSuit() + "| ";
    }

    public boolean isDrawn() {
        return isDrawn;
    }

    public void setDrawn(boolean drawn) {
        isDrawn = drawn;
    }

    public static Comparator<PokerCard> rankComparator = new Comparator<PokerCard>() {
        @Override
        public int compare(PokerCard o1, PokerCard o2) {
            return o1.compareTo(o2);
        }
    };

    @Override
    public int compareTo(PokerCard o) {
        return Integer.compare(this.getCardRank().getRank(),o.getCardRank().getRank());
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof PokerCard)){
            return false;
        }

        PokerCard otherCard = (PokerCard) o;

        //we must be very careful here
        //when compare 2 pocker cards:
        //1. For sorting, we only compare the cards' ranks
        //2. To say 2 cards are truly equal, we must compare their suits as well.

        return (this.compareTo(otherCard) == 0) && (this.getCardSuit().ordinal() == otherCard.getCardSuit().ordinal());
    }
}
